package com.ashique.staff.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ashique.staff.entity.Staff;

public interface StaffRepository extends MongoRepository<Staff, String>{


}
