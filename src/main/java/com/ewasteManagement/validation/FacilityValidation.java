package com.ewasteManagement.validation;

import com.ewasteManagement.exception.ValidationException;
import com.ewasteManagement.model.Facility;

public class FacilityValidation {
	
	public static void validateRegistrationData(Facility facility) throws ValidationException {

		if (facility.getName().isBlank() || facility.getName().isEmpty()) {
			throw new ValidationException("Name cannot be Empty");
		}
		
		if(facility.getAddress().isBlank()|| facility.getAddress().isEmpty()) {
			throw new ValidationException("Address Cannot be empty");
		}

		if (facility.getContactNo().length() != 10) {
			throw new ValidationException("Invalid phone Number");
		}
		for (int i = 0; i < facility.getContactNo().length(); i++) {
			char ch = facility.getContactNo().charAt(i);
			if (!Character.isDigit(ch)) {
				throw new ValidationException("Invalid number!!! Only numbers are allowed");
			}
		}

		if ((!facility.getEmail().contains("@")) || (!facility.getEmail().endsWith(".com"))) {
			throw new ValidationException("Invalid Email");
		}

		if (facility.getPassword().length() < 8 || facility.getPassword().length() > 16) {
			throw new ValidationException("Invalid Password");
		}

	}
	
	public static void validateLoginData(String email,String password)throws ValidationException {
		if ((!email.contains("@")) || (!email.endsWith(".com"))) {
			throw new ValidationException("Invalid Email");
		}

		if (password.length() < 8 || password.length() > 16) {
			throw new ValidationException("Invalid Password");
		}
	}

}
