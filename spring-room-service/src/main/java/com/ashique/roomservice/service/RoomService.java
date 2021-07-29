package com.ashique.roomservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashique.roomservice.entity.Room;
import com.ashique.roomservice.repository.RoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@Slf4j
public class RoomService {

	@Autowired
	private RoomRepository roomRepository;
	
	final Logger logger = LoggerFactory.getLogger(RoomService.class);

	public Room saveRoom(Room room) {
		logger.info("Inside saveRoom of RoomService");
		return roomRepository.save(room);
	}

	public Room findByRoomNo(String id) {
		logger.info("Inside findByRoomNo of RoomService");
		return roomRepository.findById(id).orElse(null);
	}

	public List<Room> findAllRoom() {
		logger.info("Inside findAllRoom of RoomService");
		return roomRepository.findAll();
	}

	public void deleteById(String id) {
		logger.info("Inside deleteById of RoomService");
		roomRepository.deleteById(id);
		
	}

	public Room updateRoom(Room updatedRoom) {
		logger.info("Inside updateRoom of RoomService");
		Room room = roomRepository.findById(updatedRoom.getRoomId()).orElse(null);
		room.setRoomName(updatedRoom.getRoomName());
		room.setRoomNo(updatedRoom.getRoomNo());
		room.setRoomFloor(updatedRoom.getRoomFloor());
		room.setCheckIn(updatedRoom.getCheckIn());
		room.setCheckOut(updatedRoom.getCheckOut());
		room.setStatus(updatedRoom.getStatus());
		room.setPrice(updatedRoom.getPrice());
		
		roomRepository.save(room);
		return room;
	}
	
	
}
