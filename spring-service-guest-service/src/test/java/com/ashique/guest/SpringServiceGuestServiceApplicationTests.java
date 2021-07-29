package com.ashique.guest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ashique.guest.entity.Guest;
import com.ashique.guest.repository.GuestRepository;
import com.ashique.guest.service.GuestService;



@SpringBootTest
class SpringServiceGuestServiceApplicationTests {

	@Autowired
	private GuestService guestService;
	
	@MockBean
	private GuestRepository guestRepository;
	
	@Test
	public void findAllGuestTest() {
		when(guestRepository.findAll()).thenReturn(Stream.of(new Guest("ahs15dhsj", "Ashique", "12345678", "ashiq@gmail", "male", "maner"),
				new Guest("ahs16dhsj", "Ashwini", "123455678", "ashwini@gmail", "male", "maner")).collect(Collectors.toList()));
		
		assertEquals(2, guestService.findAllGuest().size());
	}
	
	@Test
	public void addGuestTest() {
		Guest guest=new Guest("ahs17dhsj", "Avinash", "1234556789", "avinash@gmail", "male", "gopalganj");
		when(guestRepository.save(guest)).thenReturn(guest);
		assertEquals(guest, guestService.addGuest(guest));
	}
}
