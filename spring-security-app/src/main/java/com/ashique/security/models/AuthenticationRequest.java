package com.ashique.security.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AuthenticationRequest {
	@NotBlank
	private String username;
	
	@NotBlank
	@Size(min = 6,message = "password must be greater than 5 character")
	private String password;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String role;
	
	@NotBlank
	@Size(min = 10,message = "Phone no. must be of 10 character")
	private String phoneNo;
	
	@NotBlank
	private String dob;
	
	public AuthenticationRequest() {
		
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public String getRole() {
		return role;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public String getDob() {
		return dob;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	

}
