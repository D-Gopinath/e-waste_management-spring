package com.ewasteManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.ewasteManagement.dao.EwasteRepository;
import com.ewasteManagement.model.EwasteData;

@RestController
public class EwasteService {
	
	@Autowired
	EwasteRepository ewasteRepository;
	
	public void storeDetails(EwasteData data) throws Exception {
		try {
			ewasteRepository.save(data);
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<EwasteData> viewUserData(Integer uid) throws Exception{
		try {
			List<EwasteData> userDetails = ewasteRepository.viewByUserId(uid); 
			return userDetails;
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<EwasteData> viewfacilityData(Integer fid) throws Exception{
		try {
			List<EwasteData> facilityDetails = ewasteRepository.viewByFacilityId(fid); 
			return facilityDetails;
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
