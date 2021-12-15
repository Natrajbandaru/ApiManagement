package com.sumit.feign.dto;

public class ApiDto {

	private String deviceid;
	private String firstname;
	private String lastname;
	private String mobileno;
	private String age;
	private String gender;
	private String password;
	
	public String tokendeviceId;
	public String tokencustomerId;
	public String tokenemail;
	public String token;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getDeviceid() {
		return deviceid;
	}
	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
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
	public String getTokendeviceId() {
		return tokendeviceId;
	}
	public void setTokendeviceId(String tokendeviceId) {
		this.tokendeviceId = tokendeviceId;
	}
	public String getTokencustomerId() {
		return tokencustomerId;
	}
	public void setTokencustomerId(String tokencustomerId) {
		this.tokencustomerId = tokencustomerId;
	}
	public String getTokenemail() {
		return tokenemail;
	}
	public void setTokenemail(String tokenemail) {
		this.tokenemail = tokenemail;
	}
	
	
	public ApiDto(String deviceid, String firstname, String lastname, String mobileno, String age, String gender,
			String password, String tokendeviceId, String tokencustomerId, String tokenemail, String token) {
		super();
		this.deviceid = deviceid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.mobileno = mobileno;
		this.age = age;
		this.gender = gender;
		this.password = password;
		this.tokendeviceId = tokendeviceId;
		this.tokencustomerId = tokencustomerId;
		this.tokenemail = tokenemail;
		this.token = token;
	}
	public ApiDto() {

	}

	@Override
	public String toString() {
		return "Decodet [deviceid=" + deviceid + ", firstname=" + firstname + ", lastname=" + lastname + ", mobileno="
				+ mobileno + ", age=" + age + ", gender=" + gender + ", password=" + password + ", tokendeviceId="
				+ tokendeviceId + ", tokencustomerId=" + tokencustomerId + ", tokenemail=" + tokenemail + "]";
	}
	
}
