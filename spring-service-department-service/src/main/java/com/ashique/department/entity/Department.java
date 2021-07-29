package com.ashique.department.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "department")
public class Department {

	@Id
	private long departmentId;
	private String departmentName;
	private String departmentAddress;
	private String departmentCode;
	private String departmentManager;
	/**
	 * 
	 */
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param departmentId
	 * @param departmentName
	 * @param departmentAddress
	 * @param departmentCode
	 * @param departmentManager
	 */
	public Department(long departmentId, String departmentName, String departmentAddress, String departmentCode,
			String departmentManager) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.departmentAddress = departmentAddress;
		this.departmentCode = departmentCode;
		this.departmentManager = departmentManager;
	}


	public long getDepartmentId() {
		return departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public String getDepartmentAddress() {
		return departmentAddress;
	}
	public String getDepartmentCode() {
		return departmentCode;
	}
	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public void setDepartmentAddress(String departmentAddress) {
		this.departmentAddress = departmentAddress;
	}
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getDepartmentManager() {
		return departmentManager;
	}

	public void setDepartmentManager(String departmentManager) {
		this.departmentManager = departmentManager;
	}
	
	
	
}
