package com.sumit.feign.dto;

public class TokenDataDTO {
	
	private String mail;
	private String custmerId;
	private String deviceId;
	
	
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getCustmerId() {
		return custmerId;
	}
	public void setCustmerId(String custmerId) {
		this.custmerId = custmerId;
	}
	@Override
	public String toString() {
		return "TokenDatatrans [mail=" + mail + ", custmerId=" + custmerId + ", deviceId=" + deviceId + "]";
	}
	public TokenDataDTO(String mail, String custmerId, String deviceId) {
		super();
		this.mail = mail;
		this.custmerId = custmerId;
		this.deviceId = deviceId;
	}
	public TokenDataDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
