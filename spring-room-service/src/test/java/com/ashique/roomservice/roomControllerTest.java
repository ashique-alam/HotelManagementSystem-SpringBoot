package com.ashique.roomservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.RequestBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ashique.roomservice.controller.RoomController;
import com.ashique.roomservice.entity.Room;
import com.ashique.roomservice.service.RoomService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebMvcTest(value = RoomController.class)
public class roomControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private RoomService roomService;
	
//	ObjectMapper om=new ObjectMapper();
	
	@Test
	public void saveRoomTest() throws Exception {
		Room mockRoom=new Room();
		mockRoom.setCheckIn("");
		mockRoom.setCheckOut("");
		mockRoom.setPrice("800");
		mockRoom.setRoomFloor("First-Floor");
		mockRoom.setRoomId("12rm");
		mockRoom.setRoomName("Single-Bed");
		mockRoom.setRoomNo("126");
		mockRoom.setStatus("vacant");
		
		String jsonRequest=this.mapToJson(mockRoom);
		String URI="/rooms/";
		
		Mockito.when(roomService.saveRoom(Mockito.any(Room.class))).thenReturn(mockRoom);
		
		MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders
				.post(URI)
				.accept(MediaType.APPLICATION_JSON).content(jsonRequest)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result=mockMvc.perform(requestBuilder).andReturn();
		String outputInJson=result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(jsonRequest);
		assertEquals(org.springframework.http.HttpStatus.OK.value(), result.getResponse().getStatus());
	}
	
	@Test
	public void findRoomtByRoomIdTest() throws Exception {
		Room mockRoom=new Room();
		mockRoom.setCheckIn("");
		mockRoom.setCheckOut("");
		mockRoom.setPrice("800");
		mockRoom.setRoomFloor("First-Floor");
		mockRoom.setRoomId("12rm");
		mockRoom.setRoomName("Single-Bed");
		mockRoom.setRoomNo("126");
		mockRoom.setStatus("vacant");
		
		String URI="/rooms/12rm";
		
		Mockito.when(roomService.findByRoomNo(Mockito.anyString())).thenReturn(mockRoom);
		
		MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders
				.get(URI)
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result=mockMvc.perform(requestBuilder).andReturn();
		String expectedJson=this.mapToJson(mockRoom);
		String outputInJson=result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}
	
	@Test
	public void findAllRoomTest() throws Exception {
		Room mockRoom=new Room();
		mockRoom.setCheckIn("");
		mockRoom.setCheckOut("");
		mockRoom.setPrice("800");
		mockRoom.setRoomFloor("First-Floor");
		mockRoom.setRoomId("12rm");
		mockRoom.setRoomName("Single-Bed");
		mockRoom.setRoomNo("126");
		mockRoom.setStatus("vacant");
		
		Room mockRoom1=new Room();
		mockRoom1.setCheckIn("");
		mockRoom1.setCheckOut("");
		mockRoom1.setPrice("1800");
		mockRoom1.setRoomFloor("Second-Floor");
		mockRoom1.setRoomId("13rm");
		mockRoom1.setRoomName("Double-Bed");
		mockRoom1.setRoomNo("127");
		mockRoom1.setStatus("vacant");
		
		String URI="/rooms/all";
		
		List<Room> roomList=new ArrayList<>();
		roomList.add(mockRoom);
		roomList.add(mockRoom1);
		
		Mockito.when(roomService.findAllRoom()).thenReturn(roomList);
		
		MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders
				.get(URI)
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result=mockMvc.perform(requestBuilder).andReturn();
		
		String expectedJson=this.mapToJson(roomList);
		String outputInJson=result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}
	
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper=new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
}
