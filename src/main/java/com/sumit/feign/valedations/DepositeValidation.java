package com.sumit.feign.valedations;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.sumit.feign.dto.DepositDto;

@Component
public class DepositeValidation {
	
public String validate(DepositDto deposit) {
	double amount = deposit.getDeposit();
	JSONObject jsonobject=new JSONObject();
	String messages=null;
	
	String status=null;;
	
	String valueOf = String.valueOf(amount);
	
	if(StringUtils.isEmpty(valueOf)) {
		status="2004";
		messages="amount should not be empty";
	}else if(!(amount>=1 && amount<=50000)){
		
		status="2005";
		messages="Invalied, amount Should be 1 to 50000";
	}
	else {
		status="1005";
		messages="success";
	}
	
	jsonobject.put("status", status);
	jsonobject.put("messages", messages);

	//System.out.println("Status "+status);
	return jsonobject.toString();
	
}

}
