package com.ashique.guest.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "guest")
public class Guest {

	@Id
	private String memberCode;
	private String guestName;
	private String guestPhoneNumber;
	private String guestEmail;
	private String guestGender;
	private String guestAddress;
	/**
	 * 
	 */
	public Guest() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param memberCode
	 * @param guestName
	 * @param guestPhoneNumber
	 * @param guestEmail
	 * @param guestGender
	 * @param guestAddress
	 */
	public Guest(String memberCode, String guestName, String guestPhoneNumber, String guestEmail, String guestGender,
			String guestAddress) {
		super();
		this.memberCode = memberCode;
		this.guestName = guestName;
		this.guestPhoneNumber = guestPhoneNumber;
		this.guestEmail = guestEmail;
		this.guestGender = guestGender;
		this.guestAddress = guestAddress;
	}
	public String getMemberCode() {
		return memberCode;
	}
	public String getGuestName() {
		return guestName;
	}
	public String getGuestPhoneNumber() {
		return guestPhoneNumber;
	}
	public String getGuestEmail() {
		return guestEmail;
	}
	public String getGuestGender() {
		return guestGender;
	}
	public String getGuestAddress() {
		return guestAddress;
	}
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public void setGuestPhoneNumber(String guestPhoneNumber) {
		this.guestPhoneNumber = guestPhoneNumber;
	}
	public void setGuestEmail(String guestEmail) {
		this.guestEmail = guestEmail;
	}
	public void setGuestGender(String guestGender) {
		this.guestGender = guestGender;
	}
	public void setGuestAddress(String guestAddress) {
		this.guestAddress = guestAddress;
	}
	
	
}
