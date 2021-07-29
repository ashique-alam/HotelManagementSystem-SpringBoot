package com.ashique.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashique.security.models.AuthenticationRequest;
import com.ashique.security.models.AuthenticationResponse;
import com.ashique.security.models.UserModel;
import com.ashique.security.models.UserRespository;
import com.ashique.security.services.UserService;
import com.ashique.security.util.JwtUtil;

import lombok.extern.slf4j.Slf4j;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@Slf4j
public class AuthController {
	@Autowired
	private UserRespository userRespository;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserService userService;
	@Autowired
	private JwtUtil jwtUtil;
	
	final Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	@CrossOrigin(origins = "*")
	@GetMapping("/home")
	private String testingToken() {
		return "Welcome to our Home page";
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/subs")
	private ResponseEntity<?>subscribeClient(@Valid @RequestBody AuthenticationRequest authenticationRequest){
		
		logger.info("Inside subscribeClient method of AuthController");
		
		String username= authenticationRequest.getUsername();
		String password= authenticationRequest.getPassword();
		String name= authenticationRequest.getName();
		String role=authenticationRequest.getRole();
		String phoneNo=authenticationRequest.getPhoneNo();
		String dob=authenticationRequest.getDob();
		
		UserModel userModel=new UserModel();
		userModel.setUsername(username);
		userModel.setPassword(password);
		userModel.setName(name);
		userModel.setRole(role);
		userModel.setPhoneNo(phoneNo);
		userModel.setDob(dob);
		
		try {
		userRespository.save(userModel);
		}catch(Exception e) {
			return ResponseEntity.ok(new AuthenticationResponse("Error during client subscription"+ username));	
		}
		return ResponseEntity.ok(new AuthenticationResponse("successful subscription for client"+ username));
		
		
		
	}

	@CrossOrigin(origins = "*")
	@PostMapping("/auth")
	private ResponseEntity<?>authenticateClient(@RequestBody AuthenticationRequest authenticationRequest){
		
		logger.info("Inside authenticateClient method of AuthController");
		
		String username= authenticationRequest.getUsername();
		String password= authenticationRequest.getPassword();
		try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));}
		catch(Exception e) {
			return ResponseEntity.ok(new AuthenticationResponse("error during client authenticatin"+ username));
		}
		
		UserDetails loadedUser=userService.loadUserByUsername(username);
		String generatedToken=jwtUtil.generateToken(loadedUser);
		
		UserModel foundedUser= userRespository.findByUsername(username);
		String role=foundedUser.getRole();
		System.out.println(role);
		
		return ResponseEntity.ok(new AuthenticationResponse(generatedToken,role));
	}
}
