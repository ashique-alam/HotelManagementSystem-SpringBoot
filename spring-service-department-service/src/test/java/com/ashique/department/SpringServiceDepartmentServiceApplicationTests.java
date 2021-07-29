package com.ashique.department;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ashique.department.entity.Department;
import com.ashique.department.repository.DepartmentRepository;
import com.ashique.department.service.DepartmentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.net.MediaType;



@SpringBootTest
class SpringServiceDepartmentServiceApplicationTests {
	


	@Autowired
	private DepartmentService service;
	
	@MockBean
	private DepartmentRepository repository;
	

	
	@Test
	public void findAllDepartmentTest() {
		when(repository.findAll()).thenReturn(Stream.of(new Department(126l, "Inventory Department", "Ground Floor", "HT-2015", "Sumit"),
				new Department(127l, "Chef Department", "Kitchen", "HT-2020", "Murli")).collect(Collectors.toList()));
		
		assertEquals(2, service.findAllDepartment().size());
	}

	@Test
	public void saveDepartmentTest() {
		Department department=new Department(125l, "Restaurant Department", "New Building", "HT-2010", "Ashwini");
		when(repository.save(department)).thenReturn(department);
		assertEquals(department, service.saveDepartment(department));
	}
	
	@Test
	public void findDepartmentByIdTest() {
		Department department=new Department(123l, "Restaurant Department", "New Building", "HT-2010", "Ashwini");
		repository.save(department);
		Long id=123l;
		when(repository.findByDepartmentId(id))
		.thenReturn(department);
		assertEquals(department, service.findByDepartmentId(id));
	}
	

}
