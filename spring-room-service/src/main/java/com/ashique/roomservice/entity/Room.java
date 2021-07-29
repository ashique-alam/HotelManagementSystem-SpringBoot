package com.ashique.roomservice.entity;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="Room")
public class Room {

	@Id
	private String roomId;
	
	@NotBlank(message = "Room name must be required")
	private String roomName;
	
	@NotBlank(message = "Room No. must be defined")
	private String roomNo;
	
	@NotBlank(message = "Room floor must be given")
	private String roomFloor;
	private String checkIn;
	private String checkOut;
	
	@NotBlank(message = "Room Status must be given")
	private String status;
	
	@NotBlank(message = "Room Price must be define")
	private String price;
	/**
	 * 
	 */
	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param roomId
	 * @param roomName
	 * @param roomNo
	 * @param roomFloor
	 * @param checkIn
	 * @param checkOut
	 * @param status
	 * @param price
	 */
	public Room(String roomId, String roomName, String roomNo, String roomFloor, String checkIn, String checkOut,
			String status, String price) {
		super();
		this.roomId = roomId;
		this.roomName = roomName;
		this.roomNo = roomNo;
		this.roomFloor = roomFloor;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.status = status;
		this.price = price;
	}
	public String getRoomId() {
		return roomId;
	}
	public String getRoomName() {
		return roomName;
	}
	public String getRoomNo() {
		return roomNo;
	}
	public String getRoomFloor() {
		return roomFloor;
	}
	public String getCheckIn() {
		return checkIn;
	}
	public String getCheckOut() {
		return checkOut;
	}
	public String getStatus() {
		return status;
	}
	public String getPrice() {
		return price;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public void setRoomFloor(String roomFloor) {
		this.roomFloor = roomFloor;
	}
	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}
	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
}
