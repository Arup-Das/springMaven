package com.spring.service;

import java.util.List;

import com.spring.model.Employee;

public interface EmployeeService {
	
	Employee findById(int id);
    
    void saveEmployee(Employee employee);
     
    void updateEmployee(Employee employee);
     
    void deleteEmployeeBySsn(String ssn);
 
    List findAllEmployees(); 
     
    Employee findEmployeeBySsn(String ssn);
 
    boolean isEmployeeSsnUnique(Integer id, String ssn);

}


