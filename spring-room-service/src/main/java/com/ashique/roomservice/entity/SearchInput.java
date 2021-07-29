package com.ashique.roomservice.entity;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;

public class SearchInput {

	@Id
	private String id;
	@NotBlank
	private String inputCheckIn;
	private String inputRoomsRequired;
	private String inputGuestNumber;
	/**
	 * 
	 */
	public SearchInput() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param inputCheckIn
	 * @param inputCheckOut
	 * @param inputRoomsRequired
	 * @param inputGuestNumber
	 */
	public SearchInput(String id, String inputCheckIn, String inputRoomsRequired,
			String inputGuestNumber) {
		super();
		this.id = id;
		this.inputCheckIn = inputCheckIn;
		this.inputRoomsRequired = inputRoomsRequired;
		this.inputGuestNumber = inputGuestNumber;
	}
	public String getId() {
		return id;
	}
	public String getInputCheckIn() {
		return inputCheckIn;
	}
	
	public String getInputRoomsRequired() {
		return inputRoomsRequired;
	}
	public String getInputGuestNumber() {
		return inputGuestNumber;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setInputCheckIn(String inputCheckIn) {
		this.inputCheckIn = inputCheckIn;
	}
	
	public void setInputRoomsRequired(String inputRoomsRequired) {
		this.inputRoomsRequired = inputRoomsRequired;
	}
	public void setInputGuestNumber(String inputGuestNumber) {
		this.inputGuestNumber = inputGuestNumber;
	}
	
	
}
