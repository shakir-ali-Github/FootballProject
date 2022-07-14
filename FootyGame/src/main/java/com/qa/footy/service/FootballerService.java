package com.qa.footy.service;

import java.util.List;

import com.qa.footy.entity.Footballer;


public interface FootballerService {
	
	Footballer getById(int id);

	List<Footballer> getAll();

	Footballer findByName(String firstname);

	Footballer create(Footballer baller);

	Footballer update(int id, String firstname, String surname, Integer age, String position, Long phonenumber);

	void delete(int id);

}
