package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.model.Person;

public interface PersonDAO {
	
	int insertPerson(UUID id, Person person); //posso chamar o metodo passando o ID ou não
	
	default int insertPerson(Person person) { // dessa foram o ID será automatico
		UUID id = UUID.randomUUID();
		return insertPerson(id, person);
	}
	
	List<Person> selectAllPeople();
	
	Optional<Person> selectPersonById(UUID id);
	
	int deletePersonById(UUID id);
	
	int updatePersonById(UUID id, Person person);
}
