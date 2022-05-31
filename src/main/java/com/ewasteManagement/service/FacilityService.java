package com.ewasteManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.RestController;

import com.ewasteManagement.dao.FacilityRepository;
import com.ewasteManagement.exception.ValidationException;
import com.ewasteManagement.model.Facility;
import com.ewasteManagement.validation.FacilityValidation;

@RestController
public class FacilityService {

	@Autowired
	FacilityRepository facilityRepository;

	public void register(Facility facility) throws ValidationException, Exception {
		try {
			FacilityValidation.validateRegistrationData(facility);
			Facility userCheck = facilityRepository.findByEmail(facility.getEmail());
			if (userCheck == null) {
				facilityRepository.save(facility);
			} else {
				throw new ValidationException("Already Registered");
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public Facility login(String email, String password) throws Exception {
		FacilityValidation.validateLoginData(email, password);
		Facility facility = null;
		try {
			facility = facilityRepository.findByEmail(email);
			if (facility == null) {
				System.out.println("Unregistered ");
				throw new Exception("Not a Registered Yet...");
			} else if (facility.getPassword().equals(password)) {
				System.out.println(facility.getName() + " LoggedIn sucessfully");
				return facility;
			} else {
				throw new Exception("Invalid credentials");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Facility> viewAllFacilities() throws Exception{
		try {
			List<Facility> facilities = facilityRepository.findAll();
			return facilities;
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void response(Integer uid,Integer fid,String status) throws Exception {
		try {
			facilityRepository.updateStatus(uid, fid, status);
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}