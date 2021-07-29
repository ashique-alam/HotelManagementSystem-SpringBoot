package com.ashique.roomservice.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashique.roomservice.entity.Room;
import com.ashique.roomservice.entity.SearchInput;
import com.ashique.roomservice.repository.RoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/search")
@CrossOrigin(origins = "*")
@Slf4j
public class SearchController {

	@Autowired
	private RoomRepository roomRepository;
	
	final Logger logger = LoggerFactory.getLogger(SearchController.class);
	
	@PostMapping("/room")
	public List<Room> searchRoom(@Valid @RequestBody SearchInput searchInput){
		logger.info("Inside searchRoom method of SearchController");
		List<Room> searchedRoom=new ArrayList<>();
		
		for(Room room : roomRepository.findAll()) {

			if((room.getCheckIn().equals(searchInput.getInputCheckIn()) && room.getStatus().equals("vacant")) || 
					(room.getCheckIn().isEmpty() && room.getStatus().equals("vacant"))) {
				searchedRoom.add(room);
			}
		}
		
		return searchedRoom;
	}
}
