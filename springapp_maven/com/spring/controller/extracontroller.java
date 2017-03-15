package spring.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class extracontroller {
	@RequestMapping(method = RequestMethod.GET)
    public ModelAndView helloWorld() {
		System.out.println("Arup Test In extra controller.");
		String now = (new java.util.Date()).toString();

        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        return new ModelAndView("hello", "model", myModel);
    }

}
