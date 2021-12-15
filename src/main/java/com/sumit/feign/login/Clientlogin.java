package com.sumit.feign.login;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sumit.feign.dto.LogDataDTO;


@FeignClient(name="feignDemos", url="http://localhost:9095/AuthManagement/log")
public interface Clientlogin {

	@PostMapping("/login")
	String login(@RequestBody LogDataDTO ns);

}
