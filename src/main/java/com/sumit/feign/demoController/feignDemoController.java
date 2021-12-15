package com.sumit.feign.demoController;

import java.io.IOException;

import com.sumit.feign.valedations.Withdrawvalidation;
import java.util.List;

import javax.validation.Valid;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sumit.feign.Token.TokenGeneration;
import com.sumit.feign.User.ServiceUser;
//import com.sumit.feign.Util.feignServiceUtil;

import com.sumit.feign.dto.Customer;
import com.sumit.feign.dto.DepositDto;
import com.sumit.feign.dto.AmountTransferDTO;
import com.sumit.feign.dto.ApiDto;
import com.sumit.feign.dto.DevicedetailsDto;
import com.sumit.feign.dto.Devicedto;
import com.sumit.feign.dto.Devicereturn;
import com.sumit.feign.dto.LogDataDTO;

import com.sumit.feign.dto.RegestrationDTO;
import com.sumit.feign.dto.TokenChecking;
import com.sumit.feign.dto.TransactionModel;
import com.sumit.feign.dto.WithdrawDto;

//import com.sumit.feign.login.RegestrationClient;
//import com.sumit.feign.login.ClientServicelog;
import com.sumit.feign.login.Clientlogin;
import com.sumit.feign.service.ApiService;
import com.sumit.feign.service.Serviceclas;
import com.sumit.feign.valedations.emailvalied;
import com.sumit.feign.valedations.Loginvalidate;
import com.sumit.feign.valedations.updatevalidations;
import com.sumit.feign.valedations.valedations;
import com.sumit.feign.User.TokenClient;

import io.jsonwebtoken.Claims;
import com.sumit.feign.User.DepositeClient;
import com.sumit.feign.valedations.DepositeValidation;
import com.sumit.feign.Util.RegestrationClient;

@RestController
@RequestMapping("/demo")
public class feignDemoController {

	@Autowired
	private RegestrationClient clientregestration;

	@Autowired
	private Clientlogin clientService;

	@Autowired
	private ServiceUser clientUserupdate;
	 
	@Autowired
	private DepositeClient DepositeClient;

	@Autowired
	valedations Customervalidations;

	@Autowired
	emailvalied Emailvalidation;

	@Autowired
	Loginvalidate Loginvalidations;

	@Autowired
	TokenGeneration Tokengeneration;

	@Autowired
	updatevalidations updatevalidation;

	@Autowired
	ApiService ServiceImplementation;

	@Autowired
	DepositeValidation DepositeValidation;

	@Autowired
	Withdrawvalidation Withdrawvalidation;

	@Autowired
	TokenClient TokenClient;

	String status = "";
	String message = "";

	JSONObject jsonobject = new JSONObject();

	Logger logger = LoggerFactory.getLogger(feignDemoController.class);

	@PostMapping(path = "/signup", produces = "application/json")
	private String add(@Valid @RequestBody RegestrationDTO username) {

		String RegestrationValidation = Emailvalidation.validat(username);

		logger.debug("FID=add  TEXT=BEGAIN_SIGNUP_CANTROLLER");

		if (RegestrationValidation.contains("{}")) {
			return clientregestration.add(username);
		}
		return RegestrationValidation;
	}

	@PostMapping(path = "/Otp", produces = "application/json")
	private String otp(@RequestBody Customer validat) {

		logger.debug("FID=otp  TEXT=BEGAIN_OTP_CANTROLLER");				
		
		String Otpvalidation = Customervalidations.validat(validat);
		System.out.println(Otpvalidation);

		if (Otpvalidation.contains("{}")) {
			return clientregestration.otpvaledate(validat);
		}

		return Otpvalidation;
	}

	@PostMapping(path = "/login", produces = "application/json")
	public String login(@RequestBody LogDataDTO validat) {
		String Loginvalidat = Loginvalidations.logvalid(validat);

		logger.debug("FID=login  TEXT=BEGAIN_LOGIN_CANTROLLER");

		if (Loginvalidat.contains("{}")) {
			return clientService.login(validat);
		}
		return Loginvalidat;
	}

	@PostMapping(path = "/userupdate/api", produces = "application/json")
	private String devicedata(@RequestHeader("Authentication") String tokengeting, @RequestBody Devicedto name) {
		logger.debug("FID=devicedata  TEXT=BEGAIN_USER_UPDATE_CANTROLLER");

		String tokenoccer = tokengeting.substring(7);
		TokenChecking tokenchecking = new TokenChecking();
		tokenchecking.setToken(tokenoccer);

		String tokenstatus = TokenClient.tokenchecking(tokenchecking);
		if (tokenstatus.equals("1005")) {

			JSONObject jsonResponse = new JSONObject();
			String userupdatevalidat = updatevalidation.updatvalid(name);

			if (userupdatevalidat.contains("{}")) {
				String returnvalue = ServiceImplementation.Updateservice(tokengeting, name, userupdatevalidat);
				return returnvalue;
			}

			return userupdatevalidat;

		}
		
		else {

			status = "1004";
			message = "Token is Not Present or invalied Token";

			logger.debug("FID=depositservice ERCD={} TEXT=TOKEN_IS_INVALIED", status);
			jsonobject.put("message", message);
			jsonobject.put("status", status);
			
			return jsonobject.toString();
		}
	}

	@PostMapping(path = "/deposite", produces = "application/json")
	private String Deposite(@RequestHeader("Authentication") String tokengeting, @RequestBody DepositDto depositedata) {

		logger.debug("FID=Deposite  TEXT=BEGAIN_USER_DEPOSITE_CANTROLLER");
		String tokenoccer = tokengeting.substring(7);

		TokenChecking tokenchecking = new TokenChecking();
		tokenchecking.setToken(tokenoccer);

		String tokenstatus = TokenClient.tokenchecking(tokenchecking);
		JSONObject jsonObject2 = new JSONObject();
		if (tokenstatus.equals("1005")) {

			
			String depositevalidate = DepositeValidation.validate(depositedata);
			JSONObject jsonObject = new JSONObject(depositevalidate);

			String status = jsonObject.getString("status");
			String messages = jsonObject.getString("messages");

			if (status.equals("1005")) {                       
				return ServiceImplementation.depositservice(tokengeting, depositedata);
			} else {
				jsonObject2.put("status", status);
				jsonObject2.put("messages", messages);
			}
			
		} else {                                
			status = "1004";
			message = "Token is Not Present or invalied Token";

			logger.debug("FID=depositservice ERCD={} TEXT=TOKEN_IS_INVALIED", status);
//			jsonobject.put("message", message);
//			jsonobject.put("status", status);
			jsonObject2.put("status", status);
			jsonObject2.put("messages", message);
		}
		
		return jsonObject2.toString();
	}

	@PostMapping(path = "/withdraw", produces = "application/json")
	private String Deposite(@RequestHeader("Authentication") String tokengeting, @RequestBody WithdrawDto WithdrawDto) {

		logger.debug("FID=Deposite  TEXT=BEGAIN_USER_WITHDRAW_CANTROLLER");
		String tokenoccer = tokengeting.substring(7);
		TokenChecking tokenchecking = new TokenChecking();
		tokenchecking.setToken(tokenoccer);

		String tokenstatus = TokenClient.tokenchecking(tokenchecking);

		if (tokenstatus.equals("1005")) {
			String withdrawvalidate = Withdrawvalidation.validate(WithdrawDto);
						
			if (withdrawvalidate.contains("{}")) {
				return ServiceImplementation.withdraw(tokengeting, WithdrawDto);
			}
			return withdrawvalidate;
		} else{

			status = "1004";
			message = "Token is Not Present or invalied Token";	
			logger.debug("FID=depositservice ERCD={} TEXT=TOKEN_IS_INVALIED", status);

            jsonobject.put("message", message);
			jsonobject.put("status", status);
                                                                   
			return jsonobject.toString();
		}
	}
	
	@PostMapping(path = "/transaction", produces = "application/json")
	private String tokengeting(@RequestHeader("Authentication") String tokengeting) {

		String tokenoccer = tokengeting.substring(7);
		TokenChecking tokenchecking = new TokenChecking();
		tokenchecking.setToken(tokenoccer);

		String tokenstatus = TokenClient.tokenchecking(tokenchecking);

		if (tokenstatus.equals("1005")) {
			logger.debug("FID=tokengeting  TEXT=BEGAIN_TRANSACTION_CANTROLLER");

			return ServiceImplementation.transaction(tokengeting);
		} 
		else {
			status = "1004";
			message = "Token is Not Present or invalied Token";
																								
			logger.debug("FID=depositservice ERCD={} TEXT=TOKEN_IS_INVALIED", status);
			jsonobject.put("message", message);
			jsonobject.put("status", status);

			return jsonobject.toString();	
		}
	}
	
	@PostMapping(path="/amounttoamount",produces="application/json")
	public String acounttoaccount(@RequestHeader("Authorization") String token, @RequestBody AmountTransferDTO amountdetails){
		
		String tokenoccer = token.substring(7);
		TokenChecking tokenchecking = new TokenChecking();
		tokenchecking.setToken(tokenoccer);
		
		String tokenchecking2 = TokenClient.tokenchecking(tokenchecking);
		
		if(tokenchecking2.equals("1005")) {
			
			return ServiceImplementation.accounttoaccount(tokenoccer,amountdetails);
		}
		else {
			
			
		}
		
		return null;
	}
	
}
