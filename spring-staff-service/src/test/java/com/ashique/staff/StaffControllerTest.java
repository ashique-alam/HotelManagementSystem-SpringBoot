package com.ashique.staff;

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


import com.ashique.staff.controller.StaffController;
import com.ashique.staff.entity.Staff;
import com.ashique.staff.service.StaffService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebMvcTest(value = StaffController.class)
public class StaffControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private StaffService staffService;
	
//	ObjectMapper om=new ObjectMapper();
	
	@Test
	public void saveDepartmentTest() throws Exception {
		Staff mockStaff=new Staff();
		mockStaff.setStaffId("123");
		mockStaff.setStaffFirstName("Ashique");
		mockStaff.setStaffLastName("Alam");
		mockStaff.setStaffEmail("ashiq@gmail.com");
		mockStaff.setStaffContactNo("1234567890");
		mockStaff.setStaffAge("28");
		mockStaff.setStaffOccupation("Manager");
		mockStaff.setStaffsalary("12000");
		mockStaff.setStaffAddress("Maner");
		
		String jsonRequest=this.mapToJson(mockStaff);
		String URI="/staffs/";
		
		Mockito.when(staffService.addStaff(Mockito.any(Staff.class))).thenReturn(mockStaff);
		
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
	public void findDepartmentByIdTest() throws Exception {
		Staff mockStaff=new Staff();
		mockStaff.setStaffId("123");
		mockStaff.setStaffFirstName("Ashique");
		mockStaff.setStaffLastName("Alam");
		mockStaff.setStaffEmail("ashiq@gmail.com");
		mockStaff.setStaffContactNo("1234567890");
		mockStaff.setStaffAge("28");
		mockStaff.setStaffOccupation("Manager");
		mockStaff.setStaffsalary("12000");
		mockStaff.setStaffAddress("Maner");
		
		String URI="/staffs/123";
		
		Mockito.when(staffService.findByStaffId(Mockito.anyString())).thenReturn(mockStaff);
		
		MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders
				.get(URI)
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result=mockMvc.perform(requestBuilder).andReturn();
		String expectedJson=this.mapToJson(mockStaff);
		String outputInJson=result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}
	
	@Test
	public void findAllDepartmentTest() throws Exception {
		Staff mockStaff=new Staff();
		mockStaff.setStaffId("123");
		mockStaff.setStaffFirstName("Ashique");
		mockStaff.setStaffLastName("Alam");
		mockStaff.setStaffEmail("ashiq@gmail.com");
		mockStaff.setStaffContactNo("1234567890");
		mockStaff.setStaffAge("28");
		mockStaff.setStaffOccupation("Manager");
		mockStaff.setStaffsalary("12000");
		mockStaff.setStaffAddress("Maner");
		
		Staff mockStaff1=new Staff();
		mockStaff1.setStaffId("124");
		mockStaff1.setStaffFirstName("Ashwini");
		mockStaff1.setStaffLastName("Kumar");
		mockStaff1.setStaffEmail("ashwini@gmail.com");
		mockStaff1.setStaffContactNo("0987654123");
		mockStaff1.setStaffAge("26");
		mockStaff1.setStaffOccupation("Receptionist");
		mockStaff1.setStaffsalary("10000");
		mockStaff1.setStaffAddress("Maner");
		
		String URI="/staffs/all";
		
		List<Staff> staffList=new ArrayList<>();
		staffList.add(mockStaff);
		staffList.add(mockStaff1);
		
		Mockito.when(staffService.findAllStaff()).thenReturn(staffList);
		
		MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders
				.get(URI)
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result=mockMvc.perform(requestBuilder).andReturn();
		
		String expectedJson=this.mapToJson(staffList);
		String outputInJson=result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}
	
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper=new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
}
