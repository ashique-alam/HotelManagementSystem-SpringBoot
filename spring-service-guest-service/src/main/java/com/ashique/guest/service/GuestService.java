package com.ashique.guest.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashique.guest.entity.Guest;
import com.ashique.guest.repository.GuestRepository;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
@Slf4j
public class GuestService {
	
	@Autowired
	private GuestRepository guestRepository;
	
	final Logger logger = LoggerFactory.getLogger(GuestService.class);

	public Guest addGuest(Guest guest) {
		logger.info("Inside addGuest of GuestService");
		return guestRepository.save(guest);
	}

	public Optional<Guest> findGuestById(String id) {
		logger.info("Inside findGuestById of GuestService");
		return guestRepository.findById(id);
	}

	public List<Guest> findAllGuest() {
		logger.info("Inside findAllGuest of GuestService");
		return guestRepository.findAll();
	}

	public void removeGuestById(String id) {
		logger.info("Inside removeGuestById of GuestService");
		guestRepository.deleteById(id);
	}

	public Guest updateGuest(Guest updatedGuest) {
		logger.info("Inside updateGuest of GuestService");
		Guest oldGuest=guestRepository.findById(updatedGuest.getMemberCode()).orElse(null);
		oldGuest.setGuestName(updatedGuest.getGuestName());
		oldGuest.setGuestEmail(updatedGuest.getGuestEmail());
		oldGuest.setGuestPhoneNumber(updatedGuest.getGuestPhoneNumber());
		oldGuest.setGuestGender(updatedGuest.getGuestGender());
		oldGuest.setGuestAddress(updatedGuest.getGuestAddress());
		
		guestRepository.save(oldGuest);
		
		return oldGuest;
	}


}
