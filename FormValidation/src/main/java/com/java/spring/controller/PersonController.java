package com.java.spring.controller;

import java.util.Iterator;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
	
	@RequestMapping(value = "/personsave", method = RequestMethod.POST)
	public String saveEmployeeAction(
			@Valid Customer customer,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			Iterator<FieldError> itr = bindingResult.getFieldErrors().iterator();
			while(itr.hasNext()){
				FieldError er = itr.next();
				String field = er.getField();
				String code = er.getCode();
				System.out.println("Error in field : "+field+" code : "+code);
			}
			
			System.out.println("Returning priceincrease.jsp page");
			return "person_form";
		}
		return "success";
	}
	
}
