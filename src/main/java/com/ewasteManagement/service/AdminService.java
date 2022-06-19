package com.ewasteManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.ewasteManagement.dao.AdminRepository;
import com.ewasteManagement.model.Facility;
import com.ewasteManagement.model.User;
import com.ewasteManagement.validation.AdminValidation;

@RestController
public class AdminService {
	
	@Autowired
	AdminRepository adminRepository;
	
		public User adminLogin(String email,String password) throws Exception {
		AdminValidation.validateAdminLoginData(email, password);
		User user = null;
		try {
			user = adminRepository.findByEmail(email);
			if(user == null) {
				System.out.println("Unregistered User");
				throw new Exception("Access Denied");
			}
			else if(user.getPassword().equals(password)) {
				System.out.println(user.getName()+"Access Granted");
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

	public List<User> showUsers() throws Exception{
		try {
			List<User> usersList = adminRepository.findAll();
			return usersList;
		}
		catch (Exception e) {
			throw new Exception(e.getMessage());
			
		}
	}
	
	public List<Facility> showFacility() throws Exception{
		try {
			List<Facility> facilityList = adminRepository.findAllFacility();
			return facilityList;
		}
		catch (Exception e) {
			throw new Exception(e.getMessage());
			
		}
	}
	
	public void removeFacility(Integer id) throws Exception {
		try {
			adminRepository.deleteFacilityById(id);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void removeUser(Integer id) throws Exception {
		try {
			adminRepository.deleteById(id);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
