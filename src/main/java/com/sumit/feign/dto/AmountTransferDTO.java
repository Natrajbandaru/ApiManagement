package com.sumit.feign.dto;

public class AmountTransferDTO {
	
	public String customerid;
	public String amount;
	
	public String tokencoustomerid;
	
	
	
	public String getTokencoustomerid() {
		return tokencoustomerid;
	}
	public void setTokencoustomerid(String tokencoustomerid) {
		this.tokencoustomerid = tokencoustomerid;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "AmountTransfer [customerid=" + customerid + ", amount=" + amount + "]";
	}
	public AmountTransferDTO() {
		
	}
	public AmountTransferDTO(String customerid, String amount,String tokencoustomerid) {
		this.customerid = customerid;
		this.amount = amount;
		this.tokencoustomerid=tokencoustomerid;
	}
}
