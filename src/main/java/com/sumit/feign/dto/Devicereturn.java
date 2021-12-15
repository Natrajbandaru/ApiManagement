package com.sumit.feign.dto;

public class Devicereturn {
	private String deviceid;
	private String devicename;
	private String deviceversion;
	private String devicetype;
	private String mail;
	private String costemerId;
	private String status;
	public String getDeviceid() {
		return deviceid;
	}
	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}
	public String getDevicename() {
		return devicename;
	}
	public void setDevicename(String devicename) {
		this.devicename = devicename;
	}
	public String getDeviceversion() {
		return deviceversion;
	}
	public void setDeviceversion(String deviceversion) {
		this.deviceversion = deviceversion;
	}
	public String getDevicetype() {
		return devicetype;
	}
	public void setDevicetype(String devicetype) {
		this.devicetype = devicetype;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getCostemerId() {
		return costemerId;
	}
	public void setCostemerId(String costemerId) {
		this.costemerId = costemerId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Devicereturn [deviceid=" + deviceid + ", devicename=" + devicename + ", deviceversion=" + deviceversion
				+ ", devicetype=" + devicetype + ", mail=" + mail + ", costemerId=" + costemerId + ", status=" + status
				+ "]";
	}


	public Devicereturn(String deviceid, String devicename, String deviceversion, String devicetype, String mail,
			String costemerId, String status) {
		
		this.deviceid = deviceid;
		this.devicename = devicename;
		this.deviceversion = deviceversion;
		this.devicetype = devicetype;
		this.mail = mail;
		this.costemerId = costemerId;
		this.status = status;
	}
	
	public Devicereturn() {
		 
	}

}
