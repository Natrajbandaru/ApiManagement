package com.sumit.feign.User;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sumit.feign.dto.TokenChecking;



@FeignClient(name="feignservice", url="http://localhost:9095/TokenManagement")
public interface TokenClient {
	
	
	@PostMapping("/tokenstatus")
	public String tokenchecking(@RequestBody TokenChecking tokenchecking);


}
