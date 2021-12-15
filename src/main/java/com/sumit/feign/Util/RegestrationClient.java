package com.sumit.feign.Util;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sumit.feign.dto.Customer;

import com.sumit.feign.dto.DevicedetailsDto;

import com.sumit.feign.dto.RegestrationDTO;



@FeignClient(name="feignDemo", url="http://localhost:9095/RegestrationManagement/reg")
public interface RegestrationClient {
	
	
	@PostMapping("/signup")
	String add(@RequestBody RegestrationDTO username);
	
	
	@PostMapping("/Otp")
    String otpvaledate(@RequestBody Customer cast);
	

}