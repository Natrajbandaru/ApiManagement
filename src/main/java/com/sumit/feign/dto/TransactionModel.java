package com.sumit.feign.dto;

import java.time.LocalDateTime;




public class TransactionModel {
	
	public String transactionId;
	public String walletId;
	public String amount;
	public String type;
	public LocalDateTime createAt;
	public LocalDateTime updateAt;
	
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getWalletId() {
		return walletId;
	}
	public void setWalletId(String walletId) {
		this.walletId = walletId;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public LocalDateTime getCreateAt() {
		return createAt;
	}
	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}
	public LocalDateTime getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}
	public TransactionModel(String transactionId, String walletId, String amount, String type, LocalDateTime createAt,
			LocalDateTime updateAt) {
		
		this.transactionId = transactionId;
		this.walletId = walletId;
		this.amount = amount;
		this.type = type;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}
	public TransactionModel() {
		super();
		
	}

}
