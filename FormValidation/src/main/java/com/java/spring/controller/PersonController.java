package com.java.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.spring.bean.Person;


@Controller
public class PersonController {
	@Autowired
	@Qualifier("personFormValidator")
	private Validator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder){
		binder.setValidator(validator);
	}
	
	@ModelAttribute("person")
	public Person CreatePersonModel(){
		return new Person();
	}
	
	
	@RequestMapping(value = "/personform", method = RequestMethod.GET)
    public String formRequest(Model model) {
		System.out.println("Arup Test In PersonController form.");
		Person person = new Person();
		model.addAttribute("person", person);
		return "person_form";
    }
	
	@RequestMapping(value = "/personsave", method = RequestMethod.POST)
	public String saveEmployeeAction(
			@ModelAttribute("price") @Validated Person person,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			System.out.println("Returning priceincrease.jsp page");
			return "person_form";
		}
		return "success";
	}
}
