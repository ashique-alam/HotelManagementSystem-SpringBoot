package com.ashique.staff.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashique.staff.entity.Staff;
import com.ashique.staff.repository.StaffRepository;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
@Slf4j
public class StaffService {

	@Autowired
	private StaffRepository staffRepository;
	
	final Logger logger = LoggerFactory.getLogger(StaffService.class);

	public Staff addStaff(Staff staff) {
		logger.info("Inside addStaff of StaffService");
		return staffRepository.save(staff);
	}

	public List<Staff> findAllStaff() {
		logger.info("Inside findAllStaff of StaffService");
		return staffRepository.findAll();
	}

	public void removeStaffById(String id) {
		logger.info("Inside removeStaffById of StaffService");
		staffRepository.deleteById(id);
		
	}

	public Staff findByStaffId(String staffId) {
		logger.info("Inside findByStaffId of StaffService");
		return staffRepository.findById(staffId).orElse(null);
	}

	public Staff updateStaff(Staff updatedStaff) {
		logger.info("Inside updateStaff of StaffService");
		
		Staff staff=staffRepository.findById(updatedStaff.getStaffId()).orElse(null);
		staff.setStaffFirstName(updatedStaff.getStaffFirstName());
		staff.setStaffLastName(updatedStaff.getStaffLastName());
		staff.setStaffEmail(updatedStaff.getStaffEmail());
		staff.setStaffContactNo(updatedStaff.getStaffContactNo());
		staff.setStaffAge(updatedStaff.getStaffAge());
		staff.setStaffsalary(updatedStaff.getStaffsalary());
		staff.setStaffOccupation(updatedStaff.getStaffOccupation());
		staff.setStaffAddress(updatedStaff.getStaffAddress());
		
		staffRepository.save(staff);
		return staff;
	}
}
