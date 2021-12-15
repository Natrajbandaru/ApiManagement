package com.sumit.feign.dto;

public class RegestrationDTO{
	
	private String firstname;
	private String lastname;
	private String mobileno;
	private String age;
	private String gender;
	private String password;
	
	private String devicename;
	private String deviceversion;
	private String devicetype;
	private String email;
	
	
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public RegestrationDTO(String firstname, String lastname, String mobileno, String age, String gender, String password,
			String devicename, String deviceversion, String devicetype, String email) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.mobileno = mobileno;
		this.age = age;
		this.gender = gender;
		this.password = password;
		this.devicename = devicename;
		this.deviceversion = deviceversion;
		this.devicetype = devicetype;
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Regest [firstname=" + firstname + ", lastname=" + lastname + ", mobileno=" + mobileno + ", age=" + age
				+ ", gender=" + gender + ", password=" + password + ", devicename=" + devicename + ", deviceversion="
				+ deviceversion + ", devicetype=" + devicetype + ", email=" + email + "]";
	}

	public RegestrationDTO() {
		super();

	}
}
