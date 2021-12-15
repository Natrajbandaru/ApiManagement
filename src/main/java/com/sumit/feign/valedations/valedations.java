package com.sumit.feign.valedations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.sumit.feign.dto.Customer;
import com.sumit.feign.dto.RegestrationDTO;


@Component
public class valedations {


	//	@Autowired
	//	valedationss ss;

	public String validat(Customer username) {

		JSONObject jsonobject=new JSONObject();
		String messages="";
		String status="{}";
		

		if(username.getFirstname().isBlank()) {

			status="2001";
			messages="First name is blank";
			
	        jsonobject.put("message", messages);
			jsonobject.put("status", status);
		}

		if(!username.getFirstname().isEmpty()){

			String regex =  "^[A-Za-z]{3,30}$";
			Pattern q = Pattern.compile(regex);

			Matcher m = q.matcher(username.getFirstname());

			if(m.matches()) {

			}
			else {
				status="2001";
				messages="Enterd First name is not correct";
				
		        jsonobject.put("message", messages);
				jsonobject.put("status", status);

			}


		}

		if(username.getLastname().isEmpty()) {
			status="2002";
			messages="lastname is Blank";
			
	        jsonobject.put("message", messages);
			jsonobject.put("status", status);



		}
		if(!username.getLastname().isEmpty()) {
			String regex = "^[A-Za-z]{3,30}$";
			Pattern q=Pattern.compile(regex);
			Matcher m=q.matcher(username.getLastname());

			if(m.matches()) {

			}
			else {
				status="2002";
				messages="Enterd First name is not correct";
				
		        jsonobject.put("message", messages);
				jsonobject.put("status", status);

			}
		}


		if(username.getEmail().isBlank()) {
			status="2003";
			messages="Mail is Blank";
			
	        jsonobject.put("message", messages);
			jsonobject.put("status", status);

		}

		if(!username.getEmail().isEmpty()){
			String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z-]+\\.)+[a-zA-Z]{2,6}$";
			Pattern q = Pattern.compile(regex);

			Matcher m = q.matcher(username.getEmail());
			if(m.matches()) {

			}
			else {
				status="2003";
				messages="Enterd Mail is Not Correct";
				
		        jsonobject.put("message", messages);
				jsonobject.put("status", status);
			}


		}

		if(username.getPassword().isBlank()) {
			System.out.println("");
			status="2004";
			messages="Password is Blank";
			
	        jsonobject.put("message", messages);
			jsonobject.put("status", status);
		}
		if(!username.getPassword().isEmpty()) {
			String regex =  "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*<>_=+-]).{8,12}$";
			Pattern q=Pattern.compile(regex);
			Matcher m=q.matcher(username.getPassword());

			if(m.matches()) {

			}
			else {
				status="2004";
				messages="Enterd password is not correct";
				
		        jsonobject.put("message", messages);
				jsonobject.put("status", status);
			}
		}

		//*******	

		if(username.getAge().isBlank()) {
			status="2005";
			messages="Age is Blank";
			
	        jsonobject.put("message", messages);
			jsonobject.put("status", status);

		}
		if(!username.getAge().isEmpty()) {

			String l=username.getAge();
			int s=Integer.parseInt(l);

			if(s>=18 && s<=40) {

			}
			else {
				status="2005";
				messages="Enterd Age  is not correct";
				
		        jsonobject.put("message", messages);
				jsonobject.put("status", status);

			}
		}

		//*****		

		if(username.getGender().isBlank()) {
			status="2006";
			messages="Gender is Blank";
			
	        jsonobject.put("message", messages);
			jsonobject.put("status", status);
		}
		if(!username.getGender().isEmpty()) {
			String regex = "^[A-Za-z]{3,30}$";
			Pattern q=Pattern.compile(regex);
			Matcher m=q.matcher(username.getGender());

			if(m.matches()) {

			}
			else {
				status="2006";
				messages="Enterd Gender  is not correct";
				
		        jsonobject.put("message", messages);
				jsonobject.put("status", status);
			}
		}

		//*******

		if(username.getPassword().isBlank()) {
			status="2007";
			messages="Pasword is Blank";
			
	        jsonobject.put("message", messages);
			jsonobject.put("status", status);
		}

		//*********
		if(username.getDevicename().isBlank()) {
			status="2008";
			messages="Divice name is Blank";
			
	        jsonobject.put("message", messages);
			jsonobject.put("status", status);
		}
		
		if(!username.getDevicename().isEmpty()) {
			String regex = "^[A-Za-z]{3,30}$";
			Pattern q=Pattern.compile(regex);
			Matcher m=q.matcher(username.getDevicename());

			if(m.matches()) {

			}
			else {
				status="2008";
				messages="Enterd Divice name is not correct";
				
		        jsonobject.put("message", messages);
				jsonobject.put("status", status);
			}
		}
		//********************

		if(username.getDevicetype().isBlank()) {
			status="2009";
			messages="Divice Type is Blank";
			
	        jsonobject.put("message", messages);
			jsonobject.put("status", status);
		}
		
		if(!username.getDevicetype().isEmpty()) {
			String regex = "^[A-Za-z]{3,30}$";
			Pattern q=Pattern.compile(regex);
			Matcher m=q.matcher(username.getDevicetype());

			if(m.matches()) {

			}
			else {
				status="2009";
				messages="Enterd Divicetype is not correct";
				
		        jsonobject.put("message", messages);
				jsonobject.put("status", status);
			}
		}


		//*******************

		if(username.getDeviceversion().isBlank()) {
			status="20010";
			messages="Diviceversion is blank";
			
	        jsonobject.put("message", messages);
			jsonobject.put("status", status);

		}
		//********

		if(username.getMobileno().isBlank()) {
			status="2010";
			messages="Enterd FDiviceversion is not correct";
			
	        jsonobject.put("message", messages);
			jsonobject.put("status", status);

		}

		String mobilenumber=username.getMobileno();

		boolean mobilevalid=true;
		//  String mobilenumber=username.getMobileno();

		if(!(StringUtils.isBlank(mobilenumber))) {
			if(!(StringUtils.isEmpty(mobilenumber))) {
				if(StringUtils.isNumeric(mobilenumber)) {
					if(mobilenumber.length()==12) {
						String Substring=mobilenumber.substring(0, 4);		
						if(Substring.equals("9665")) {
							PhoneNumberUtil numberUtil=PhoneNumberUtil.getInstance();
							try {
								String number="+" +mobilenumber;
								PhoneNumber num=numberUtil.parse(number, "");
								//System.out.println(num);
								String isnumbervalid=(numberUtil.isValidNumber(num)==mobilevalid?"valid":"invalid");

								if(!(StringUtils.isEmpty(isnumbervalid) && isnumbervalid.equals("invalid"))) {


								}else {
									status="2004";
									messages="Invalied PhoneNumber";
									
							        jsonobject.put("message", messages);
									jsonobject.put("status", status);
								}

							}catch(Exception e){
								return "nndj";
							}

						}else {
							status="2004";
							messages="PhoneNumber Should Start with 9665";
							
					        jsonobject.put("message", messages);
							jsonobject.put("status", status);
						}
					}else {
						status="2004";
						messages="PhoneNumber Should Contain more than 12 Numbers";
						
				        jsonobject.put("message", messages);
						jsonobject.put("status", status);
					}
				}else {
					//jsonObject.put("mobilenumber", "mobilenumber should be start with 9665");
					status="2004";
					//return 	jsonObject.toString();
				}

			}else {
				//return "kkd";
			}
		}else {
			//return "jd";
		}

	
        jsonobject.put("message", messages);
		jsonobject.put("status", status);
		return jsonobject.toString();
	}

}
