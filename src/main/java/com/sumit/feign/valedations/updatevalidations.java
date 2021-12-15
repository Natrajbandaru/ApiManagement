package com.sumit.feign.valedations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.sumit.feign.dto.Devicedto;


@Component
public class updatevalidations {

	public String updatvalid(Devicedto updvs) {

	JSONObject jsonobject=new JSONObject();
		
	//	System.out.println("email validation request coming "+username);

		String status="{}";
		String messages="";


		if(updvs.getFirstname().isBlank()) {

			status="2001";
			messages="First name is blank";
			
	        jsonobject.put("message", messages);
			jsonobject.put("status", status);

		}
		
		
		if(!updvs.getFirstname().isEmpty()){

			String regex =  "^[A-Za-z]{3,30}$";
			Pattern q = Pattern.compile(regex);

			Matcher m = q.matcher(updvs.getFirstname());

			if(m.matches()) {

			}
			else {
				status="2001";
				messages="First name is Invalied";
				
		        jsonobject.put("message", messages);
				jsonobject.put("status", status);
			}


		}

		if(updvs.getLastname().isEmpty()) {
			status="2002";
			messages="Last name is blank";
			
	        jsonobject.put("message", messages);
			jsonobject.put("status", status);
			
			System.out.println("last name is empty in else if condition");


		}
		 if(!updvs.getLastname().isEmpty()) {
			String regex = "^[A-Za-z]{3,30}$";
			Pattern q=Pattern.compile(regex);
			Matcher m=q.matcher(updvs.getLastname());

			if(m.matches()) {

			}
			else {
				status="2002";
				messages="Last Name is Invalied";
				
		        jsonobject.put("message", messages);
				jsonobject.put("status", status);

			}


		}


	 
		//*******
 
	 
		//*********	

		if(updvs.getPassword().isBlank()) {
			status="2006";
			messages="Password is Blank";
			
	        jsonobject.put("message", messages);
			jsonobject.put("status", status);
		}
		 if(!updvs.getPassword().isEmpty()) {
			String regex =  "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*<>_=+-]).{8,12}$";
			Pattern q=Pattern.compile(regex);
			Matcher m=q.matcher(updvs.getPassword());

			if(m.matches()) {

			}
			else {
				status="2006";
				messages="Password is Invalied";
				
		        jsonobject.put("message", messages);
				jsonobject.put("status", status);			}
		}

		//*******	

		 if(updvs.getAge().isBlank()) {
			 status="2005";
				messages="age is Blank";
				
		        jsonobject.put("message", messages);
				jsonobject.put("status", status);
		}
		if(!updvs.getAge().isEmpty()) {

			String l=updvs.getAge();
			int s=Integer.parseInt(l);

			if(s>=18 && s<=40) {

			}
			else {
				status="2005";
				messages="Age should be 18-40";
				
		        jsonobject.put("message", messages);
				jsonobject.put("status", status);
			}
		}

		//*****		


		 if(updvs.getGender().isBlank()) {
			 status="2007";
				messages="Gender is Blank";
				
		        jsonobject.put("message", messages);
				jsonobject.put("status", status);
		}
		if(!updvs.getGender().isEmpty()) {
			String regex = "^[A-Za-z]{3,30}$";
			Pattern q=Pattern.compile(regex);
			Matcher m=q.matcher(updvs.getGender());

			if(m.matches()) {

			}
			else {
				status="2007";
				messages="Gender is Invalied";
				
		        jsonobject.put("message", messages);
				jsonobject.put("status", status);
			}
		}

		//*******


	 if(updvs.getPassword().isBlank()) {
		 status="2006";
			messages="Password is Blank";
			
	        jsonobject.put("message", messages);
			jsonobject.put("status", status);
		}
	
		

		if(updvs.getMobileno().isBlank()) {
			status="2006";
			messages="Password is Invalied";
			
	        jsonobject.put("message", messages);
			jsonobject.put("status", status);

		}

		String mobilenumber=updvs.getMobileno();

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
							jsonobject.put("status", status);						}
					}else {
						status="2004";
						messages="PhoneNumber Should Contain more than 12 Numbers";
						
				        jsonobject.put("message", messages);
						jsonobject.put("status", status);					}
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

		//jsonObject.put("status", status);

		//System.out.println("Status "+status);
		return jsonobject.toString();
	}
}
