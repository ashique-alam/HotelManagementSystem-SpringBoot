package com.ashique.roomservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.ashique.roomservice.entity.Room;
import com.ashique.roomservice.repository.RoomRepository;
import com.ashique.roomservice.service.RoomService;

@SpringBootTest
class RoomServiceApplicationTests {

	@Autowired
	private RoomService service;
	
	@MockBean
	private RoomRepository repository;
	
	@Test
	public void findAllRoomTest() {
		when(repository.findAll()).thenReturn(Stream.of(new Room("room2547", "double-bed", "103", "First Floor", "", "", "vacant", "1000"),
				new Room("room2548", "family-room", "104", "First Floor", "", "", "vacant", "1200")).collect(Collectors.toList()));
		
		assertEquals(2, service.findAllRoom().size());
	}

	@Test
	public void saveRoomTest() {
		Room room=new Room("room2546", "single-bed", "102", "First Floor", "", "", "vacant", "800");
		when(repository.save(room)).thenReturn(room);
		assertEquals(room, service.saveRoom(room));
	}
}
