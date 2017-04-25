package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.model.Employee;
import com.spring.service.EmployeeService;

@Controller
public class ApplicationController {
		      
	@Autowired
	MessageSource messageSource;
	
	@RequestMapping(value = { "/" })
    public String homePage() {
		System.out.println("Home page");
        return "home";
    }

}
