package com.ewasteManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.RestController;
import com.ewasteManagement.dao.UserRepository;
import com.ewasteManagement.exception.ValidationException;
import com.ewasteManagement.model.User;
import com.ewasteManagement.validation.UserValidation;

@RestController
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public void register(User user) throws ValidationException,Exception  {
		try {
			UserValidation.validateRegistrationData(user);
			User userCheck = userRepository.findByEmail(user.getEmail());
			if(userCheck==null){
				userRepository.save(user);
			}
			else {
				throw new ValidationException("Already Registered");
			}
		}catch (DataAccessException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public User login(String email, String password) throws Exception {
		UserValidation.validateLoginData(email, password);
		User user = null;
		try {
			user = userRepository.findByEmail(email);
			if(user == null) {
				System.out.println("Unregistered User");
				throw new Exception("Not a Registered User");
			}
			else if(user.getPassword().equals(password)) {
				System.out.println(user.getName()+" LoggedIn sucessfully");
				return user;
			}
			else {
				throw new Exception("Invalid credentials");
			}
		}
		catch (Exception e) 
		{
			throw new Exception(e.getMessage());
		}
	}

}
