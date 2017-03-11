package spring.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.domain.ProductManager;
import spring.domain.Unit;
import spring.service.PriceIncreaseValidator;

/**
 * 
 * @author Arup
 *
 */
@Controller
@RequestMapping("/priceincrease.htm") 
public class PriceIncreaseFormController {
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	private ProductManager productManager;
	
	@Autowired
	PriceIncreaseValidator priceIncreaseValidator;
	
	//Set a form validator
		@InitBinder
		protected void initBinder(WebDataBinder binder) {
			binder.setValidator(priceIncreaseValidator);
		}
		
		@RequestMapping(value="/priceIncrease",method = RequestMethod.POST)  
		public ModelAndView show(@ModelAttribute("unit") Unit unit){
			int increase = unit.getIncrease();
			logger.info("Increasing prices by " + increase + "%.");

	        productManager.increasePrice(increase);

			return null;
		}

		public ProductManager getProductManager() {
			return productManager;
		}

		public void setProductManager(ProductManager productManager) {
			this.productManager = productManager;
		}


}
