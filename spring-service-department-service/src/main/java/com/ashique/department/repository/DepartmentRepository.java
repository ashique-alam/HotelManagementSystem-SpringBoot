package com.ashique.department.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ashique.department.entity.Department;

public interface DepartmentRepository extends MongoRepository<Department, Long>{

	Department findByDepartmentId(Long departmentId);


}
