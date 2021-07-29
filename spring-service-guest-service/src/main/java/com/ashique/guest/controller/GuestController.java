package com.ashique.guest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashique.guest.entity.Guest;
import com.ashique.guest.service.GuestService;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/guests")
@Slf4j
public class GuestController {

	@Autowired
	private GuestService guestService;
	
	final Logger logger = LoggerFactory.getLogger(GuestController.class);
	
	@CrossOrigin(origins = "*")
	@PostMapping("/")
	public Guest addGuest(@RequestBody Guest guest) {
		logger.info("Inside addGuest method of GuestController");
		return guestService.addGuest(guest);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/{id}")
	public Optional<Guest> findGuestById(@PathVariable("id") String id) {
		logger.info("Inside findGuestById method of GuestController");
		return guestService.findGuestById(id);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/all")
	public List<Guest> findAllGuest() {
		logger.info("Inside findAllGuest method of GuestController");
		return guestService.findAllGuest();
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/delete/{id}")
	public String removeGuestById(@PathVariable("id") String id) {
		logger.info("Inside removeGuestById method of GuestController");
		guestService.removeGuestById(id);
		return "Guest removed from the database successfully with id : "+id;
	}
	
	@CrossOrigin(origins = "*")
	@PutMapping("/updateGuest")
	public Guest updateGuest(@RequestBody Guest updatedGuest) {
		logger.info("Inside updateGuest method of GuestController");
		return guestService.updateGuest(updatedGuest);
	}
}
