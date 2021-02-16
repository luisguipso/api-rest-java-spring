package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PersonDAO;
import com.example.demo.model.Person;

@Service
public class PersonService {
	
	private final PersonDAO personDAO;
	
	@Autowired
	public PersonService(@Qualifier("fakeDAO") PersonDAO personDAO) { //Qualifier serve pra varias implementações, como varios daos para varios tipos de bancos por exemplo
		this.personDAO = personDAO;
	}
	
	public int addperson(Person person) {
		return personDAO.insertPerson(person);
	}
	
	public List<Person> getAllPeople(){
		return personDAO.selectAllPeople();
	}
	
	public Optional<Person> getPersonById(UUID id){
		return personDAO.selectPersonById(id);
	}
	
	public int deletePerson(UUID id) {
		return personDAO.deletePersonById(id);
	}
	
	public int updatePerson(UUID id, Person newPerson) {
		return personDAO.updatePersonById(id, newPerson);
	}
}