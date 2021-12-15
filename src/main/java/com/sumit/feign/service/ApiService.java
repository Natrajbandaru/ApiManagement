package com.sumit.feign.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.sumit.feign.Token.TokenGeneration;
import com.sumit.feign.dto.AmountTransferDTO;
import com.sumit.feign.dto.DepositDto;
import com.sumit.feign.dto.Devicedto;
import com.sumit.feign.dto.TokenChecking;
import com.sumit.feign.dto.WithdrawDto;


@Component
public interface ApiService {
	
	public String Updateservice(String device, Devicedto name,String validat);
	
	public String depositservice(String token,DepositDto depositdto);
	
	public String withdraw(String token,WithdrawDto WithdrawDto);
	
	public String transaction(String token);
	
	public String accounttoaccount(String  token,AmountTransferDTO amountdetails);
	
}
