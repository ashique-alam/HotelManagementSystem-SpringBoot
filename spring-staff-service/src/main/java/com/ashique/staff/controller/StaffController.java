package com.ashique.staff.controller;

import java.util.List;
import java.util.Optional;

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

import com.ashique.staff.entity.Staff;
import com.ashique.staff.service.StaffService;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/staffs")
@Slf4j
public class StaffController {

	@Autowired
	private StaffService staffService;
	
	final Logger logger = LoggerFactory.getLogger(StaffController.class);
	
	@CrossOrigin(origins = "*")
	@PostMapping("/")
	public Staff addStaff(@RequestBody Staff staff) {
		logger.info("Inside addStaff method of StaffController");
		return staffService.addStaff(staff);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/{id}")
	public Staff findStaffById(@PathVariable("id") String id) {
		logger.info("Inside findStaffById method of StaffController");
		return staffService.findByStaffId(id);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/all")
	public List<Staff> findAllStaff(){
		logger.info("Inside findAllStaff method of StaffController");
		return staffService.findAllStaff();
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/delete/{id}")
	public String removeStaffById(@PathVariable("id") String id) {
		logger.info("Inside removeStaffById method of StaffController");
		staffService.removeStaffById(id);
		return "Staff removed from the department with Id: "+id;
	}
	
	@CrossOrigin(origins = "*")
	@PutMapping("/updateStaff")
	public Staff updateStaff(@RequestBody Staff updatedStaff) {
		logger.info("Inside updateStaff method of StaffController");
		return staffService.updateStaff(updatedStaff);
	}
}
