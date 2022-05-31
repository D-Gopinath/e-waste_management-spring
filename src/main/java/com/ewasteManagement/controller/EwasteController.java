package com.ewasteManagement.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.ewasteManagement.dto.Message;
import com.ewasteManagement.model.EwasteData;
import com.ewasteManagement.service.EwasteService;

@RestController
public class EwasteController {

	@Autowired
	EwasteService ewasteService;

	@PostMapping("ewaste/details")
	public ResponseEntity<?> saveData(@RequestBody EwasteData data) {
		data.setDate(LocalDate.now());
		data.setStatus("pending");
		try {
			ewasteService.storeDetails(data);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			Message message = new Message(e.getMessage());
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("ewaste/viewbyuser/{uid}")
	public ResponseEntity<?> viewByUserId(@PathVariable("uid") Integer uid){
		try {
			List<EwasteData> userDetails = ewasteService.viewUserData(uid);
			return new ResponseEntity<>(userDetails,HttpStatus.OK);
		}
		catch(Exception e) {
			Message message = new Message(e.getMessage());
			return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("ewaste/viewbyfacility/{fid}")
	public ResponseEntity<?> viewByFacilityId(@PathVariable("fid") Integer fid){
		try {
			List<EwasteData> facilityDetails = ewasteService.viewUserData(fid);
			return new ResponseEntity<>(facilityDetails,HttpStatus.OK);
		}
		catch(Exception e) {
			Message message = new Message(e.getMessage());
			return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
		}
	}

}
