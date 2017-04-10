package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.service.PriceIncrease;

@Controller
@RequestMapping("/priceForm")
public class priceIncreaseController {
	
	@RequestMapping(method = RequestMethod.GET)
    public String helloWorld(Model model) {
		System.out.println("Arup Test In priceIncrease controller.");
		PriceIncrease price = new PriceIncrease();
		model.addAttribute("price", price);
        return "priceincrease";
    }

}
