package com.sumit.feign.dto;

public class DevicedetailsDto {
	
	
	private String deviceid;
	private String devicename;
	private String deviceversion;
	private String devicetype;
	private String mail;
	
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
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
	@Override
	public String toString() {
		return "Devicedetails [deviceid=" + deviceid + ", devicename=" + devicename + ", deviceversion=" + deviceversion
				+ ", devicetype=" + devicetype + "]";
	}
	
	public DevicedetailsDto(String deviceid, String devicename, String deviceversion, String devicetype, String mail) {
		super();
		this.deviceid = deviceid;
		this.devicename = devicename;
		this.deviceversion = deviceversion;
		this.devicetype = devicetype;
		this.mail = mail;
	}
	public DevicedetailsDto() {
		super();
		
	}
	
}
