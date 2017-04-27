package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.PersonDao;
import com.spring.model.Person;

@Service("personService")
@Transactional
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonDao dao;
	@Override
	public Person findById(int id) {
		return dao.findById(id);
	}

	@Override
	public void savePerson(Person person) {
		dao.savePerson(person);
	}

	@Override
	public void updateEmployee(Person person) {
		Person cus = dao.findById(person.getId());
		if(cus != null ){
			cus.setName(person.getName());
			cus.setEmail(person.getEmail());
			cus.setPhone(person.getPhone());
			cus.setBirthday(person.getBirthday());
			cus.setGender(person.getGender());
		}
	}

	@Override
	public void deletePerson(int id) {
		dao.deletePerson(id);
	}

	@Override
	public List<Person> findAllPerson() {
		return dao.findAllPerson();
	}

}
