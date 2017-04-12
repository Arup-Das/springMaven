package com.java.spring.bean;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PersonFormValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		return Person.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Person person = (Person) obj;
		if(person == null){
			errors.rejectValue("empty", "error.not-specified", null, "Value required.");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "phone.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "gender.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birthday", "birthday.required");
	}

}
