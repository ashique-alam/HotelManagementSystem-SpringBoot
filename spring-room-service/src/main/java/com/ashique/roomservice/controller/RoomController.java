package com.ashique.roomservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashique.roomservice.entity.Room;
import com.ashique.roomservice.service.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/rooms")
@CrossOrigin(origins = "*")
@Slf4j
public class RoomController {

	@Autowired
	private RoomService roomService;
	
	final Logger logger = LoggerFactory.getLogger(RoomController.class);
	
	@CrossOrigin(origins = "*")
	@PostMapping("/")
	public Room saveRoom(@Valid @RequestBody Room room) {
		logger.info("Inside saveRoom method of RoomController");
		return roomService.saveRoom(room);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/{id}")
	public Room findRoomByRoomId(@PathVariable String id) {
		logger.info("Inside findRoomByRoomId method of RoomController");
		return roomService.findByRoomNo(id);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/all")
	public List<Room> findAllRoom() {
		logger.info("Inside findAllRoom method of RoomController");
		return roomService.findAllRoom();
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/delete/{id}")
	public String deleteRoom(@PathVariable String id) {
		logger.info("Inside deleteRoom method of RoomController");
		roomService.deleteById(id);
		return "Room deleted with RoomNo : "+id;
	}
	
	@CrossOrigin(origins = "*")
	@PutMapping("/updateRoom")
	public Room updateRoom(@RequestBody Room updatedRoom) {
		logger.info("Inside updateRoom method of RoomController");
		return roomService.updateRoom(updatedRoom);
	}
}
