package com.sumit.feign.dto;

public class WithdrawDto {
	
	public double withdraw;
	public String CustomerId;
	public String token;
	
	
	public double getWithdraw() {
		return withdraw;
	}
	public void setWithdraw(double withdraw) {
		this.withdraw = withdraw;
	}
	public String getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(String customerId) {
		CustomerId = customerId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public WithdrawDto(double withdraw, String customerId, String token) {
		super();
		this.withdraw = withdraw;
		CustomerId = customerId;
		this.token = token;
	}
	public WithdrawDto() {
		super();
	}
	@Override
	public String toString() {
		return "WithdrawDto [withdraw=" + withdraw + ", CustomerId=" + CustomerId + ", token=" + token + "]";
	}
	
}
