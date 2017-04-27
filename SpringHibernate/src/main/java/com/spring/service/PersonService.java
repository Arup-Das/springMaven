package com.spring.service;

import java.util.List;

import com.spring.model.Person;


public interface PersonService {
	Person findById(int id);
    
    void savePerson(Person person);
     
    void updateEmployee(Person person);
     
    void deletePerson(int id);
 
    List<Person> findAllPerson(); 

}
