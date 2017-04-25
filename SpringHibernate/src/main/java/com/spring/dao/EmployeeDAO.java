package com.spring.dao;

import java.util.List;

import com.spring.model.Employee;

public interface EmployeeDAO {

	Employee findById(int id);
	 
    void saveEmployee(Employee employee);
     
    void deleteEmployeeBySsn(String ssn);
     
    List findAllEmployees();
 
    Employee findEmployeeBySsn(String ssn);
}

