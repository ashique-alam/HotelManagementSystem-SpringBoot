package com.ashique.security.services;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ashique.security.models.UserModel;
import com.ashique.security.models.UserRespository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@Slf4j
public class UserService implements UserDetailsService {
	@Autowired
	private UserRespository userRespository;
	
	final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("Inside loadUserByUsername method of UserService");
		UserModel foundedUser= userRespository.findByUsername(username);
		if(foundedUser==null) return null;
		String name=foundedUser.getUsername();
		String pwd=foundedUser.getPassword();
		return new User(name, pwd, new ArrayList<>()); 
	}

}
