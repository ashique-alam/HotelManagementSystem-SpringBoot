package com.ashique.department;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

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

import com.ashique.department.controller.DepartmentController;
import com.ashique.department.entity.Department;
import com.ashique.department.service.DepartmentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebMvcTest(value = DepartmentController.class)
public class DepartmentControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private DepartmentService departmentService;
	
//	ObjectMapper om=new ObjectMapper();
	
	@Test
	public void saveDepartmentTest() throws Exception {
		Department mockDepartment=new Department();
		mockDepartment.setDepartmentId(123l);
		mockDepartment.setDepartmentName("Bar");
		mockDepartment.setDepartmentAddress("Ground-Floor");
		mockDepartment.setDepartmentCode("BR-100");
		mockDepartment.setDepartmentManager("Ashique");
		
		String jsonRequest=this.mapToJson(mockDepartment);
		String URI="/departments/";
		
		Mockito.when(departmentService.saveDepartment(Mockito.any(Department.class))).thenReturn(mockDepartment);
		
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
		Department mockDepartment=new Department();
		mockDepartment.setDepartmentId(123);
		mockDepartment.setDepartmentName("Bar");
		mockDepartment.setDepartmentAddress("Ground-Floor");
		mockDepartment.setDepartmentCode("BR-100");
		mockDepartment.setDepartmentManager("Ashique");
		
		String URI="/departments/123";
		
		Mockito.when(departmentService.findByDepartmentId(Mockito.anyLong())).thenReturn(mockDepartment);
		
		MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders
				.get(URI)
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result=mockMvc.perform(requestBuilder).andReturn();
		String expectedJson=this.mapToJson(mockDepartment);
		String outputInJson=result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}
	
	@Test
	public void findAllDepartmentTest() throws Exception {
		Department mockDepartment1=new Department();
		mockDepartment1.setDepartmentId(123);
		mockDepartment1.setDepartmentName("Bar");
		mockDepartment1.setDepartmentAddress("Ground-Floor");
		mockDepartment1.setDepartmentCode("BR-100");
		mockDepartment1.setDepartmentManager("Ashique");
		
		Department mockDepartment2=new Department();
		mockDepartment2.setDepartmentId(124);
		mockDepartment2.setDepartmentName("Restaurant");
		mockDepartment2.setDepartmentAddress("First-Floor");
		mockDepartment2.setDepartmentCode("RT-100");
		mockDepartment2.setDepartmentManager("Ashwini");
		
		String URI="/departments/all";
		
		List<Department> departmentList=new ArrayList<>();
		departmentList.add(mockDepartment1);
		departmentList.add(mockDepartment2);
		
		Mockito.when(departmentService.findAllDepartment()).thenReturn(departmentList);
		
		MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders
				.get(URI)
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result=mockMvc.perform(requestBuilder).andReturn();
		
		String expectedJson=this.mapToJson(departmentList);
		String outputInJson=result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}
	
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper=new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
}
