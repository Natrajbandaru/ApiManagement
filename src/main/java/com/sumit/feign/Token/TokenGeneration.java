package com.sumit.feign.Token;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.sumit.feign.dto.TokenDataDTO;
import ch.qos.logback.core.util.TimeUtil;
import java.sql.Time;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

@Component
public class TokenGeneration {

	private static final long serialVersionUID = 234234523523L;
	private String SECRET_KEY = "secret";

	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}

	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}
	
	public <T> T extractClaim(String token, Function<Claims,T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}
	public Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	}
	
	private Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}
	
	public String generateToken(TokenDataDTO userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims, userDetails);
	}
	
	private String createToken(Map<String, Object> claims,TokenDataDTO subject) {
		claims.put("customerId", subject.getCustmerId());
		claims.put("custmerMail", subject.getMail());
		claims.put("deviceId", subject.getDeviceId());
		
		
    	return Jwts.builder().setClaims(claims).setSubject("Mapping").setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
	}		
	
	public Boolean validateToken(String token, String userDetails) {
		final String username = extractUsername(token);
		return (username.equals(userDetails) && !isTokenExpired(token));
	}
}
