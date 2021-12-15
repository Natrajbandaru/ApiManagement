package com.sumit.feign.service;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sumit.feign.Token.TokenGeneration;
import com.sumit.feign.User.DepositeClient;
import com.sumit.feign.User.ServiceUser;
import com.sumit.feign.User.TokenClient;
import com.sumit.feign.Util.RegestrationClient;
import com.sumit.feign.dto.AmountTransferDTO;
import com.sumit.feign.dto.ApiDto;
import com.sumit.feign.dto.DepositDto;
import com.sumit.feign.dto.Devicedto;
import com.sumit.feign.dto.TokenChecking;
import com.sumit.feign.dto.WithdrawDto;
import com.sumit.feign.login.Clientlogin;


import com.sumit.feign.valedations.emailvalied;
import com.sumit.feign.valedations.Loginvalidate;
import com.sumit.feign.valedations.updatevalidations;
import com.sumit.feign.valedations.valedations;


import io.jsonwebtoken.Claims;


@Component
public class Serviceclas implements ApiService {


	@Autowired
	private RegestrationClient feignServiceUtil;

	@Autowired
	private Clientlogin feignServicelogin;

	@Autowired
	private ServiceUser fignServiceUser;

	@Autowired
	TokenClient TokenClient;

	@Autowired
	TokenGeneration tokegeneration;

	@Autowired
	updatevalidations updatvalidations;


	@Autowired
	private DepositeClient DepositClient;


	Logger logger=LoggerFactory.getLogger(Serviceclas.class);

	String status="";
	String message="";


	@Override
	public String Updateservice(String tokenfromuser, Devicedto name,String validat) {


		status="0";
		logger.debug("FID=Updateservice ERCD={} TEXT=BEGAIN_UPDATEUSER_SERVICE",status);

		JSONObject jsonobject=new JSONObject();
		String Regestationvalidations=updatvalidations.updatvalid(name);
		System.out.println(Regestationvalidations);

		if(Regestationvalidations.contains("{}")) {
			try {			
				//System.out.println("request coming in api "+device+" request "+name);

				String tokenoccer=tokenfromuser.substring(7);
				System.out.println(tokenoccer+" token ");


				Claims extractAllClaims = tokegeneration.extractAllClaims(tokenoccer);
				

				//System.out.println(extractAllClaims+" claims from token");

				String custId=(String) extractAllClaims.get("customerId");
				String mail=(String) extractAllClaims.get("custmerMail");
				String devId=(String) extractAllClaims.get("deviceId");


				ApiDto alldetails=new ApiDto();
				
				alldetails.setTokencustomerId(custId);
				alldetails.setTokenemail(mail);
				alldetails.setTokendeviceId(devId);

				alldetails.setDeviceid(name.getDeviceid());
				alldetails.setFirstname(name.getFirstname());
				alldetails.setLastname(name.getLastname());
				alldetails.setMobileno(name.getMobileno());
				alldetails.setAge(name.getAge());
				alldetails.setPassword(name.getPassword());
				alldetails.setGender(name.getGender());
				alldetails.setToken(tokenoccer);

				return fignServiceUser.devicedetails(alldetails);

			}

			catch(RuntimeException e) {
				status="1004";
				message="Token is invalied";

				logger.debug("FID=Updateservice ERCD={} TEXT=TOKEN_IS_INVALIED",status);


				jsonobject.put("message", message);
				jsonobject.put("status", status);

			}

			
		}

		return jsonobject.toString();
	}


	@Override
	public String depositservice(String token, DepositDto depositdto) {

		status="0";
		logger.debug("FID=depositservice ERCD={} TEXT=BEGAIN_DEPOSITE_SERVICE",status);

		JSONObject jsonobject=new JSONObject();

		String status="";
		String message="";

		String tokenoccer=token.substring(7);
		System.out.println(tokenoccer+" token ");

		TokenChecking tokenchecking=new TokenChecking();
		tokenchecking.setToken(tokenoccer);
		

		String tokenstatus=TokenClient.tokenchecking(tokenchecking);		
		if(tokenstatus.equals("1005")) {

			try {

				Claims extractAllClaims = tokegeneration.extractAllClaims(tokenoccer);
				String customerId=(String) extractAllClaims.get("customerId");

				DepositDto DepositDto=new DepositDto();
				DepositDto.setCustomerId(customerId);
				DepositDto.setDeposit(depositdto.getDeposit());
				DepositDto.setToken(tokenoccer);

				System.out.println("Comeing heare");

				return  DepositClient.depositdetails(DepositDto);	
			}
			catch(Exception e) {
				status="1004";
				message="Token is invalied";

				logger.debug("FID=depositservice ERCD={} TEXT=TOKEN_IS_INVALIED",status);

				jsonobject.put("message", message);
				jsonobject.put("status", status);

			}      
		}
		else {

			status="1004";
			message="Token is Not Present or invalied Token";

			logger.debug("FID=depositservice ERCD={} TEXT=TOKEN_IS_INVALIED",status);

			jsonobject.put("message", message);
			jsonobject.put("status", status);
		}
		return jsonobject.toString();


	}

	@Override
	public String withdraw(String token, WithdrawDto WithdrawDto) {

		status="0";
		logger.debug("FID=withdraw ERCD={} TEXT=BEGAIN_WITHDRAW_SERVICE",status);




		JSONObject jsonobject=new JSONObject();
		String status="";
		String message="";


		String tokenoccer=token.substring(7);
		System.out.println(tokenoccer+" token ");

		TokenChecking tokenchecking=new TokenChecking();
		tokenchecking.setToken(tokenoccer);

		//Token Client
		String tokenstatus=TokenClient.tokenchecking(tokenchecking);

		if(tokenstatus.equals("1005")) {

			try {

				Claims extractAllClaims = tokegeneration.extractAllClaims(tokenoccer);
				String customerId=(String) extractAllClaims.get("customerId");

				WithdrawDto withdraw=new WithdrawDto();

				withdraw.setCustomerId(customerId);
				withdraw.setWithdraw(WithdrawDto.getWithdraw());
				withdraw.setToken(tokenoccer);

				System.out.println(withdraw.toString());

				return DepositClient.withdraw(withdraw);


			}

			catch(Exception e) {
				System.out.println("It is Present");

				status="1004";
				message="Token is Not Present";

				logger.debug("FID=depositservice ERCD={} TEXT=TOKEN_IS_NOT_PRESENT",status);


				jsonobject.put("message", message);
				jsonobject.put("status", status);
			}			
		}

		else {

			status="1004";
			message="Token is Not Present";

			logger.debug("FID=depositservice ERCD={} TEXT=TOKEN_IS_NOT_PRESENT",status);


			jsonobject.put("message", message);
			jsonobject.put("status", status);
		}

		return jsonobject.toString();


	}


	@Override
	public String transaction(String token) {

		status="0";
		logger.debug("FID=transaction ERCD={} TEXT=BEGAIN_TRANSACTION_SERVICE",status);


		JSONObject jsonobject=new JSONObject();
		String status="";
		String message="";


		String tokenwithoutbearer=token.substring(7);
		System.out.println(tokenwithoutbearer+" token ");

		TokenChecking tokenchecking=new TokenChecking();
		tokenchecking.setToken(tokenwithoutbearer);

		//TokenClient
		String tokenstatus=TokenClient.tokenchecking(tokenchecking);

		if(tokenstatus.equals("1005")) {

			Claims extractAllClaims = tokegeneration.extractAllClaims(tokenwithoutbearer);
			String customerId=(String) extractAllClaims.get("customerId");

			System.out.println(customerId +"customer");

			return DepositClient.gettransaction(customerId);
		}

		else {

			status="1004";
			message="Token is Not Present";

			logger.debug("FID=depositservice ERCD={} TEXT=TOKEN_IS_NOT_PRESENT",status);

			jsonobject.put("message", message);
			jsonobject.put("status", status);

		}

		return jsonobject.toString();
	}


	@Override
	public String accounttoaccount(String token,AmountTransferDTO amountdetails) {
		
		Claims extractAllClaims = tokegeneration.extractAllClaims(token);
		String customeridtransferfrom=(String) extractAllClaims.get("customerId");
		amountdetails.setTokencoustomerid(customeridtransferfrom);
		
		return null;
	}
}
