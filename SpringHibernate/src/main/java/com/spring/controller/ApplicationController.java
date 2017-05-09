package com.spring.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.model.Person;
import com.spring.model.Employee;
import com.spring.service.EmployeeService;
import com.spring.service.PersonService;

@Controller
@RequestMapping("/")
public class ApplicationController {
	
	
    @Autowired
    EmployeeService service;
    
    @Autowired
    PersonService personService;
     
    @Autowired
    MessageSource messageSource;
     
     // This method will list all existing employees.    
    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public String listEmployees(ModelMap model) {
        List<Employee> employees = service.findAllEmployees();
        System.out.println("employees  :  "+employees.size());
        model.addAttribute("employees", employees);
        return "allemployees";
    }
     
    // This method will provide the medium to add a new employee.     
    @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
    public String newEmployee(ModelMap model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        model.addAttribute("edit", false);
        return "registration";
    }
     
     // This method will be called on form submission, handling POST request for
     // saving employee in database. It also validates the user input     
    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public String saveEmployee(@Valid Employee employee, BindingResult result,
            ModelMap model) {
 
        if (result.hasErrors()) {
            return "registration";
        }  
      
        if(!service.isEmployeeSsnUnique(employee.getId(), employee.getSsn())){
            FieldError ssnError =new FieldError("employee","ssn",messageSource.getMessage("non.unique.ssn", new String[]{employee.getSsn()}, Locale.getDefault()));
            result.addError(ssnError);
            return "registration";
        }
         
        service.saveEmployee(employee);
 
        model.addAttribute("success", "Employee " + employee.getName() + " registered successfully");
        return "success";
    }
     
     // This method will provide the medium to update an existing employee.     
    @RequestMapping(value = { "/edit-{ssn}-employee" }, method = RequestMethod.GET)
    public String editEmployee(@PathVariable String ssn, ModelMap model) {
        Employee employee = service.findEmployeeBySsn(ssn);
        model.addAttribute("employee", employee);
        model.addAttribute("edit", true);
        return "registration";
    }
     
   
     // This method will be called on form submission, handling POST request for
     // updating employee in database. It also validates the user input
    
    @RequestMapping(value = { "/edit-{ssn}-employee" }, method = RequestMethod.POST)
    public String updateEmployee(@Valid Employee employee, BindingResult result,
            ModelMap model, @PathVariable String ssn) {
 
        if (result.hasErrors()) {
            return "registration";
        }
 
        if(!service.isEmployeeSsnUnique(employee.getId(), employee.getSsn())){
            FieldError ssnError =new FieldError("employee","ssn",messageSource.getMessage("non.unique.ssn", new String[]{employee.getSsn()}, Locale.getDefault()));
            result.addError(ssnError);
            return "registration";
        }
 
        service.updateEmployee(employee);
 
        model.addAttribute("success", "Employee " + employee.getName()  + " updated successfully");
        return "success";
    }
         
     // This method will delete an employee by it's SSN value.     
    @RequestMapping(value = { "/delete-{ssn}-employee" }, method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable String ssn) {
        service.deleteEmployeeBySsn(ssn);
        return "redirect:/list";
    }
    
    @RequestMapping(value = "/newperson", method = RequestMethod.GET)
    public String formRequest(Model model) {
		System.out.println("Arup Test In PersonController form.");
		model.addAttribute("person", new Person());
		return "person_form";
    }
	
	@RequestMapping(value = "/newperson", method = RequestMethod.POST)
	public String savePerosn(
			@Valid Person person,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			System.out.println("Returning priceincrease.jsp page");
			return "person_form";
		}
		personService.savePerson(person);
		return "success";
	}
	 // This method will list all existing employees.    
    @RequestMapping(value = { "/listPerson" }, method = RequestMethod.GET)
    public String listPersons(ModelMap model) {
        List<Person> persons = personService.findAllPerson();
        System.out.println("persons  :  "+ persons.size());
        model.addAttribute("persons", persons);
        return "allperson";
    }

}
