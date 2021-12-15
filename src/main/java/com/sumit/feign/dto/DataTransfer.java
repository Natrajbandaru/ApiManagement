package com.sumit.feign.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.boot.convert.DataSizeUnit;

public class DataTransfer {

	private int customerId;

	@NotNull(message="First Name cannot be null")
	private String firstname;

	@NotNull(message="last Name cannot be null")
	private String lastname;

	@NotNull(message="email cannot be null")
	@Email
	private String email;

	@NotNull(message="Mobile Number cannot be null")
	private String mobileno;

	@NotNull(message="age cannot be null")
	private String age;

	@NotNull(message="gender cannot be null")
	private String gender;

	@NotNull(message="password cannot be null")
	@Size(min=6,max=20, message="password must be more than 6")
	private String password;

	@NotNull(message="device Name cannot be null")
	private String devicename;
	
	@NotNull(message="device Version cannot be null")
	private String deviceversion;
	
	@NotNull(message="Device Type cannot be null")
	private String devicetype;

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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



	public DataTransfer(int customerId, @NotNull(message = "First Name cannot be null") String firstname,
			@NotNull(message = "First Name cannot be null") String lastname,
			@NotNull(message = "First Name cannot be null") @Email String email,
			@NotNull(message = "First Name cannot be null") String mobileno,
			@NotNull(message = "First Name cannot be null") String age,
			@NotNull(message = "First Name cannot be null") String gender,
			@NotNull(message = "First Name cannot be null") @Size(min = 6, max = 20, message = "password must be more than 6") String password,
			String devicename, String deviceversion, String devicetype) {
		super();
		this.customerId = customerId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.mobileno = mobileno;
		this.age = age;
		this.gender = gender;
		this.password = password;
		this.devicename = devicename;
		this.deviceversion = deviceversion;
		this.devicetype = devicetype;
	}
	public DataTransfer() {
		super();
	}
	
	@Override
	public String toString() {
		return "DataTransfer [customerId=" + customerId + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", mobileno=" + mobileno + ", age=" + age + ", gender=" + gender + ", password="
				+ password + ", devicename=" + devicename + ", deviceversion=" + deviceversion + ", devicetype="
				+ devicetype + "]";
	}

	

}
