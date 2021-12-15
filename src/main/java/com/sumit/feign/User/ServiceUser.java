package com.sumit.feign.User;

import java.io.IOException;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sumit.feign.dto.ApiDto;
import com.sumit.feign.dto.Devicedto;
import com.sumit.feign.dto.Devicereturn;


@FeignClient(name="feign", url="http://localhost:9095/UserManagement1/use")
public interface ServiceUser {
	

	@PostMapping("/user")
    String devicedetails(ApiDto name) ;
}						
