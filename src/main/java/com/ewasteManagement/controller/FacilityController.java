package com.ewasteManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ewasteManagement.dto.Message;
import com.ewasteManagement.model.EwasteData;
import com.ewasteManagement.model.Facility;
import com.ewasteManagement.service.FacilityService;

@RestController
public class FacilityController {
	
	@Autowired
	FacilityService facilityService;
	
	@PostMapping("facility/register")
	public ResponseEntity<?> register(@RequestBody Facility facility) {
		
		try {
			facilityService.register(facility);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e) {
			Message message = new Message(e.getMessage());
			return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("facility/login")
	public ResponseEntity<?> login(@RequestBody Facility facility)
	{
		Facility response;
		try {
			response=facilityService.login(facility.getEmail(),facility.getPassword());
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
		catch(Exception e) {
			Message message = new Message(e.getMessage());
			return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("facility/showAll")
	public ResponseEntity<?> showAll(){
		try {
			List<Facility> facilities = facilityService.viewAllFacilities();
			return new ResponseEntity<>(facilities,HttpStatus.OK);
		}
		catch(Exception e) {
			Message message = new Message(e.getMessage());
			return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PostMapping("facility/response")
	public ResponseEntity<?> facilityResponse(@RequestBody EwasteData data) {
		
		try {
			facilityService.response(data.getUid(),data.getFid(),data.getStatus());
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e) {
			Message message = new Message(e.getMessage());
			return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
		}
	}

}
