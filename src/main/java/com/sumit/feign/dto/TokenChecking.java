package com.sumit.feign.dto;

public class TokenChecking {
	
	public String token;
	public String status;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "TokenChecking [token=" + token + ", status=" + status + "]";
	}
	public TokenChecking(String token, String status) {
		super();
		this.token = token;
		this.status = status;
	}
	public TokenChecking() {
		super();

	}
	

}
