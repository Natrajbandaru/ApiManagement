package com.sumit.feign.valedations;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.sumit.feign.dto.LogDataDTO;

@Component
public class Loginvalidate {
	JSONObject jsonobject=new JSONObject();

	
	public String logvalid(LogDataDTO validatenames) {
		
		String status="{}";
		String messages="";

				
		if(validatenames.getEmailid().isBlank()) {
			status="2003";
			messages="Mail is Blank";
			
	        jsonobject.put("message", messages);
			jsonobject.put("status", status);
		}
			
		if(!validatenames.getEmailid().isEmpty()){
			
			String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z-]+\\.)+[a-zA-Z]{2,6}$";
			Pattern q = Pattern.compile(regex);

			Matcher m = q.matcher(validatenames.getEmailid());
			if(m.matches()) {

			}
			else {
				status="2003";
				messages="Mail is Not Invalied";
				
		        jsonobject.put("message", messages);
				jsonobject.put("status", status);

			}
	    }
	    //***********************
		
		//***********************
	    if(validatenames.getPassword().isBlank()) {
	    	status="2006";
			messages="Password is Blank";
			
	        jsonobject.put("message", messages);
			jsonobject.put("status", status);
			
		}
	    
	    
		 if(!validatenames.getPassword().isEmpty()) {
				String regex =  "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*<>_=+-]).{8,12}$";
				Pattern q=Pattern.compile(regex);
				Matcher m=q.matcher(validatenames.getPassword());

				if(m.matches()) {

				}
				else {
					status="2006";
					messages="Password is Invalied";
					
			        jsonobject.put("message", messages);
					jsonobject.put("status", status);
					
				}
			}
		 

		return jsonobject.toString();
		}

}
