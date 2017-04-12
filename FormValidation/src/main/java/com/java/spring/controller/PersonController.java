package com.java.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.spring.bean.Person;


@Controller
public class PersonController {
	
	@RequestMapping(value = "/personform", method = RequestMethod.GET)
    public String formRequest(Model model) {
		System.out.println("Arup Test In PersonController form.");
		Person person = new Person();
		model.addAttribute("person", person);
		return "person_form";
    }

}
