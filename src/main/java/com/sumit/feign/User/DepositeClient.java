package com.sumit.feign.User;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sumit.feign.dto.AmountTransferDTO;
import com.sumit.feign.dto.DepositDto;
import com.sumit.feign.dto.TransactionModel;
import com.sumit.feign.dto.WithdrawDto;
//import com.sumit.feign.model.TransactionModel;

@FeignClient(name="deposite", url="http://localhost:9095/UserManagement1/use")
public interface DepositeClient {
	
	@PostMapping("/deposit")
    String  depositdetails(DepositDto DepositDto);
	
	
	@PostMapping("/withdra")
    String  withdraw(WithdrawDto withdrawDto);
	
	
	@PostMapping(path="/gettransaction",produces="application/json")
	public String gettransaction(String walletid);
	
	
   @PostMapping(path="/amount")
   public String acounttoacount(AmountTransferDTO amounttransfer);
   
}
