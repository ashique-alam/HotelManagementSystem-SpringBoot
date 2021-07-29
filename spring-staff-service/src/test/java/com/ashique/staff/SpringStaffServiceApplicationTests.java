package com.ashique.staff;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ashique.staff.entity.Staff;
import com.ashique.staff.repository.StaffRepository;
import com.ashique.staff.service.StaffService;

@SpringBootTest
class SpringStaffServiceApplicationTests {

	@Autowired
	private StaffService service;
	
	@MockBean
	private StaffRepository repository;
	
	@Test
	public void addStaffTest() {
		Staff staff=new Staff("dons67b", "ashwini", "kumar", "aswini@mail", "1234567890", "23", "15000", "manager", "maner");
		when(repository.save(staff)).thenReturn(staff);
		assertEquals(staff, service.addStaff(staff));
	}
	
	@Test
	public void findAllStaffTest() {
		when(repository.findAll()).thenReturn(Stream.of(new Staff("dons66b", "ashiq", "alam", "ashiq@mail", "0123456789", "22", "12000", "receptionist", "maner"),
				new Staff("dons68b", "sumit", "kumar", "sumit@mail", "0123456789", "22", "11000", "technician", "maner")).collect(Collectors.toList()));
		assertEquals(2, service.findAllStaff().size());
	}
}
