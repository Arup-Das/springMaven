package com.java.spring.bean;

import java.lang.annotation.Documented;

import javax.validation.Constraint;

@Documented
@Constraint(validatedBy = PhoneValidator.class)
public @interface Phone {

}
