package com.sumit.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableFeignClients
public class ApiManagement1Application {

	public static void main(String[] args) {
		SpringApplication.run(ApiManagement1Application.class, args);
	}
	
}
