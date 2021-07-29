package com.ashique.security.models;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection= "users")
public class UserModel {
	@Id
	private String id;
	@NotNull(message = "Username cannot be null")
	private String username;
	private String password;
	private String name;
	private String role;
	private String phoneNo;
	private String dob;
	
	public String getId() {
		return id;
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
	public UserModel() {
		
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
