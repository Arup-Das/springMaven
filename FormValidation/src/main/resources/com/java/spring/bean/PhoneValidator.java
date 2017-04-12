package com.java.spring.bean;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone,String>{

	@Override
	public void initialize(Phone arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return false;
	}

}
