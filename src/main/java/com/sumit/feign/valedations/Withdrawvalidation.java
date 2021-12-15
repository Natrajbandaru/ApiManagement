package com.sumit.feign.valedations;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.sumit.feign.dto.DepositDto;
import com.sumit.feign.dto.WithdrawDto;

@Component
public class Withdrawvalidation {
	
	public String validate(WithdrawDto deposit) {
		
		double amount=deposit.getWithdraw();
		JSONObject jsonobject=new JSONObject();
		
		String status="{}";
		String message="";
		
		String amount2=String.valueOf(amount);
		
		if(amount2.isBlank()) {
			status="2006";
			message="Amount should be not blank";
			
			
			jsonobject.put("status", status);	
			jsonobject.put("message", message);

			
		}
		if(!amount2.isEmpty()) {

			double amount1=amount;
			//int s=Integer.parseInt(l);

			if(amount1>=100 && amount1<=50000) {
				

			}
			else {
				status="2006";
				message="Invalied, Should be 100 to 50000";
				
		        
				jsonobject.put("status", status);	
				jsonobject.put("message", message);
			}
		}

		
		jsonobject.put("status", status);

		System.out.println("Status "+status);
		return jsonobject.toString();
		
	}


}
