package spring.controller;

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
import spring.domain.ProductManager;
import spring.service.PriceIncrease;

@Controller
public class formController {
	
	@Autowired
	private ProductManager productManager;
	
	@Autowired
	@Qualifier("priceIncreaseValidator")
	private Validator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@ModelAttribute("price")
	public PriceIncrease createPriceModel() {
		return new PriceIncrease();
	}

	@RequestMapping(value = "/priceincrease", method = RequestMethod.POST)
	public String saveEmployeeAction(
			@ModelAttribute("price") @Validated PriceIncrease priceincrease,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			System.out.println("Returning priceincrease.jsp page");
			return "priceincrease";
		}
		return "priceincreaseSuccess";
	}}
