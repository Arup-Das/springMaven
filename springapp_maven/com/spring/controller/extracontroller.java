package spring.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.domain.ProductManager;

@Controller
@RequestMapping("/hello")
public class extracontroller {
	
	@Autowired
	private ProductManager productManager;
	
	@RequestMapping(method = RequestMethod.GET)
    public ModelAndView helloWorld() {
		System.out.println("Arup Test In extra controller.");
		String now = (new java.util.Date()).toString();

        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        myModel.put("products", this.productManager.getProducts());
        return new ModelAndView("hello", "model", myModel);
    }

}
