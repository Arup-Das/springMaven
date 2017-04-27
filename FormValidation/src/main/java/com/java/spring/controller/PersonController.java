package com.java.spring.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.spring.bean.Customer;


@Controller
public class PersonController {
	@RequestMapping(value = "/personform", method = RequestMethod.GET)
    public String formRequest(Model model) {
		System.out.println("Arup Test In PersonController form.");
		model.addAttribute("customer", new Customer());
		return "person_form";
    }
	
	@RequestMapping(value = "/personform", method = RequestMethod.POST)
	public String saveEmployeeAction(
			@Valid Customer customer,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			System.out.println("Returning priceincrease.jsp page");
			return "person_form";
		}
		return "success";
	}
	
}
