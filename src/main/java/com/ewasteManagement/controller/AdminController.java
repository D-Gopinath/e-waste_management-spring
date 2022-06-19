package com.ewasteManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ewasteManagement.dto.Message;
import com.ewasteManagement.model.Facility;
import com.ewasteManagement.model.User;
import com.ewasteManagement.service.AdminService;

@RestController
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@PostMapping("admin/login")
	public ResponseEntity<?> login(@RequestBody User user)
	{
		User response;
		try {
			response=adminService.adminLogin(user.getEmail(),user.getPassword());
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
		catch(Exception e) {
			Message message = new Message(e.getMessage());
			return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("admin/userslist")
	public ResponseEntity<?> viewUsers() {
		try {
			List<User> userList = adminService.showUsers();
			return new ResponseEntity<>(userList,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("admin/facilitylist")
	public ResponseEntity<?> viewFacilities() {
		try {
			List<Facility> facilityList = adminService.showFacility();
			return new ResponseEntity<>(facilityList,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@DeleteMapping("admin/deleteuser/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Integer id) {
		try {
		adminService.removeUser(id);
		System.out.println("User Deleted");
		return new ResponseEntity<String>("User deleted",HttpStatus.OK);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<String>("Unable to delete User",HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("admin/deletefacility/{id}")
	public ResponseEntity<String> deleteFacility(@PathVariable("id") Integer id) {
		try {
		adminService.removeFacility(id);
		System.out.println("User Deleted");
		return new ResponseEntity<String>("User deleted",HttpStatus.OK);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<String>("Unable to delete User",HttpStatus.BAD_REQUEST);
		}
	}

}
