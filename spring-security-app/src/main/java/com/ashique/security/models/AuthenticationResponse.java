package com.ashique.security.models;

public class AuthenticationResponse {
	private String response;
	private String role;
	public String getResponse() {
		return response;
	}
	public String getRole() {
		return role;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * @param response
	 * @param role
	 */
	public AuthenticationResponse(String response, String role) {
		super();
		this.response = response;
		this.role = role;
	}
	/**
	 * 
	 */
	public AuthenticationResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param response
	 */
	public AuthenticationResponse(String response) {
		super();
		this.response = response;
	}

	
	

}
