package com.ashique.staff.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "staff")
public class Staff {

	@Id
	private String staffId;
	private String staffFirstName;
	private String staffLastName;
	private String staffEmail;
	private String staffContactNo;
	private String staffAge;
	private String staffsalary;
	private String staffOccupation;
	private String staffAddress;
	/**
	 * 
	 */
	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param staffId
	 * @param staffFirstName
	 * @param staffLastName
	 * @param staffEmail
	 * @param staffContactNo
	 * @param staffAge
	 * @param staffsalary
	 * @param staffOccupation
	 * @param staffAddress
	 */
	public Staff(String staffId, String staffFirstName, String staffLastName, String staffEmail, String staffContactNo,
			String staffAge, String staffsalary, String staffOccupation, String staffAddress) {
		super();
		this.staffId = staffId;
		this.staffFirstName = staffFirstName;
		this.staffLastName = staffLastName;
		this.staffEmail = staffEmail;
		this.staffContactNo = staffContactNo;
		this.staffAge = staffAge;
		this.staffsalary = staffsalary;
		this.staffOccupation = staffOccupation;
		this.staffAddress = staffAddress;
	}
	public String getStaffId() {
		return staffId;
	}
	public String getStaffFirstName() {
		return staffFirstName;
	}
	public String getStaffLastName() {
		return staffLastName;
	}
	public String getStaffEmail() {
		return staffEmail;
	}
	public String getStaffContactNo() {
		return staffContactNo;
	}
	public String getStaffAge() {
		return staffAge;
	}
	public String getStaffsalary() {
		return staffsalary;
	}
	public String getStaffOccupation() {
		return staffOccupation;
	}
	public String getStaffAddress() {
		return staffAddress;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	public void setStaffFirstName(String staffFirstName) {
		this.staffFirstName = staffFirstName;
	}
	public void setStaffLastName(String staffLastName) {
		this.staffLastName = staffLastName;
	}
	public void setStaffEmail(String staffEmail) {
		this.staffEmail = staffEmail;
	}
	public void setStaffContactNo(String staffContactNo) {
		this.staffContactNo = staffContactNo;
	}
	public void setStaffAge(String staffAge) {
		this.staffAge = staffAge;
	}
	public void setStaffsalary(String staffsalary) {
		this.staffsalary = staffsalary;
	}
	public void setStaffOccupation(String staffOccupation) {
		this.staffOccupation = staffOccupation;
	}
	public void setStaffAddress(String staffAddress) {
		this.staffAddress = staffAddress;
	}
	
	

	
}
