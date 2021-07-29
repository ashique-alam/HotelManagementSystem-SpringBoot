package com.ashique.department.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashique.department.entity.Department;
import com.ashique.department.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Service
@Slf4j
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	final Logger logger = LoggerFactory.getLogger(DepartmentService.class);
	

	public Department saveDepartment(Department department) {
		logger.info("Inside saveDepartment of DepartmentService");
		return departmentRepository.save(department);
	}

	public Department findByDepartmentId(Long departmentId) {
		logger.info("Inside findByDepartmentId of DepartmentService");
		return departmentRepository.findByDepartmentId(departmentId);
	}

	public List<Department> findAllDepartment() {
		logger.info("Inside findAllDepartment of DepartmentService");
		return departmentRepository.findAll();
	}

	public void removeDepartmentById(Long id) {
		logger.info("Inside removeDepartmentById of DepartmentService");
		departmentRepository.deleteById(id);
		
	}

	public Department updateDepartment(Department updatedDepartment) {
		logger.info("Inside updateDepartment of DepartmentService");
		
		Department department=departmentRepository.findByDepartmentId(updatedDepartment.getDepartmentId());
		department.setDepartmentName(updatedDepartment.getDepartmentName());
		department.setDepartmentCode(updatedDepartment.getDepartmentCode());
		department.setDepartmentAddress(updatedDepartment.getDepartmentAddress());
		department.setDepartmentManager(updatedDepartment.getDepartmentManager());
		
		departmentRepository.save(department);
		return department;
	}
}
