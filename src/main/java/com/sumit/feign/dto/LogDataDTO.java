package com.sumit.feign.dto;

public class LogDataDTO {
	
	private String emailid;
	private String password;
	
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "dto [emailid=" + emailid + ", password=" + password + "]";
	}
	public LogDataDTO(String emailid, String password) {
		super();
		this.emailid = emailid;
		this.password = password;
	}
	public LogDataDTO() {
		super();
	}
	
}
