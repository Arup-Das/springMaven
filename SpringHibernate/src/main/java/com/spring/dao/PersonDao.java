package com.spring.dao;

import java.util.List;

import com.spring.model.Person;

public interface PersonDao {
	
	Person findById(int id);
	 
    void savePerson(Person person);
     
    void deletePerson(int id);
     
    List<Person> findAllPerson();
}
