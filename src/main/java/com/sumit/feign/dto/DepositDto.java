package com.sumit.feign.dto;

public class DepositDto {

	public double deposit;
	public String CustomerId;
	public String token;
	
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(String customerId) {
		CustomerId = customerId;
	}

	public double getDeposit() {
		return deposit;
	}

	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}

	public DepositDto() {
		super();

	}

	public DepositDto(double deposit, String customerId, String token) {
		super();
		this.deposit = deposit;
		CustomerId = customerId;
		this.token = token;
	}

	@Override
	public String toString() {
		return "DepositDto [deposit=" + deposit + ", CustomerId=" + CustomerId + "]";
	}

}
