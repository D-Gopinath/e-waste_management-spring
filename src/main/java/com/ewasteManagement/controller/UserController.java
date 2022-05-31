package com.ewasteManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ewasteManagement.dto.Message;
import com.ewasteManagement.model.User;
import com.ewasteManagement.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("users/register")
	public ResponseEntity<?> register(@RequestBody User user) {
		
		try {
			userService.register(user);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e) {
			Message message = new Message(e.getMessage());
			return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("users/login")
	public ResponseEntity<?> login(@RequestBody User user)
	{
		User response;
		try {
			response=userService.login(user.getEmail(),user.getPassword());
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
		catch(Exception e) {
			Message message = new Message(e.getMessage());
			return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
		}
	}

}
