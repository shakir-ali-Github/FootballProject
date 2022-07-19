package com.qa.footy.service;

import java.util.List;

import com.qa.footy.entity.Footballer;


public interface FootballerService {
	
	Footballer getById(int id);

	List<Footballer> getAll();

	Footballer findByName(String name);

	Footballer create(Footballer footballer);

	Footballer update(int id, String name, String position, String email, Integer age);

	void delete(int id);

}
