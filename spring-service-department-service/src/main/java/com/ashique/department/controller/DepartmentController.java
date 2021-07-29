package com.ashique.department.controller;

import java.util.List;

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

import com.ashique.department.entity.Department;
import com.ashique.department.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@RestController
@RequestMapping("/departments")
@CrossOrigin(origins = "*")
@Slf4j
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	final Logger logger = LoggerFactory.getLogger(DepartmentController.class);
	
	@CrossOrigin(origins = "*")
	@PostMapping("/")
	public Department saveDepartment(@RequestBody Department department) {
		logger.info("Inside saveDepartment method of DepartmentController");
		return departmentService.saveDepartment(department);
		
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/{id}")
	public Department findDepartmentById(@PathVariable("id") Long departmentId) {
		logger.info("Inside findDepartmentById method of DepartmentController");
		return departmentService.findByDepartmentId(departmentId);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/all")
	public List<Department> findAllDepartment(){
		logger.info("Inside findAllDepartment method of DepartmentController");
		return departmentService.findAllDepartment();
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/delete/{id}")
	public String removeDepartmentById(@PathVariable("id") Long id) {
		logger.info("Inside removeDepartmentById method of DepartmentController");
		departmentService.removeDepartmentById(id);
		return "Staff removed from the department with Id: "+id;
	}
	
	@CrossOrigin(origins = "*")
	@PutMapping("/updateDepartment")
	public Department updateDepartment(@RequestBody Department updatedDepartment) {
		logger.info("Inside updateDepartment method of DepartmentController");
		
		return departmentService.updateDepartment(updatedDepartment);
	}
}
