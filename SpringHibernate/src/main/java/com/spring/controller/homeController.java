package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homeController {
	@RequestMapping(value = { "/" })
    public String homePage() {
		System.out.println("Home page");
        return "home";
    }

}
