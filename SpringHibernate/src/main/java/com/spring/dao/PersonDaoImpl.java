package com.spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.spring.model.Person;

@Repository
public class PersonDaoImpl extends AbstractDao<Integer, Person> implements PersonDao {

	@Override
	public Person findById(int id) {
		return getByKey(id);
	}

	@Override
	public void savePerson(Person person) {
		persist(person);
	}

	@Override
	public void deletePerson(int id) {
		Query query = getSession().createSQLQuery("delete from Employee where id = :id");
        query.setLong("id", id);
        query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> findAllPerson() {
		Criteria criteria = createEntityCriteria();
		return (List<Person>) criteria.list();
	}

}
