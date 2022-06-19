package com.ewasteManagement.validation;

import com.ewasteManagement.exception.ValidationException;

public class AdminValidation {
	
	public static void validateAdminLoginData(String email,String password)throws ValidationException {
		if ((!email.contains("@")) || (!email.endsWith(".com"))) {
			throw new ValidationException("Invalid Email");
		}

		if (password.length() < 8 || password.length() > 16) {
			throw new ValidationException("Invalid Password");
		}
	}

}
