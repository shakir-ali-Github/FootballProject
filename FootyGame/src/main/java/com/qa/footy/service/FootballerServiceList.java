package com.qa.footy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.footy.entity.Footballer;

@Service

public class FootballerServiceList implements FootballerService {
	
	private List<Footballer> footballers = new ArrayList<>();
	
	@Override
	public Footballer getById(int id) {
		return this.footballers.get(id);
	}

	@Override
	public List<Footballer> getAll() {
		return this.footballers;
	}

	@Override
	public Footballer create(Footballer footballer) {
		this.footballers.add(footballer);
		return this.footballers.get(this.footballers.size() - 1);

	}

	@Override
	public Footballer update(int id, String name, String position, String email, Integer age) {
		Footballer toUpdate = this.footballers.get(id);
		if (name != null)
			toUpdate.setName(name);
		if (position != null)
			toUpdate.setPosition(position);
		if (email != null)
			toUpdate.setEmail(email);
		if (age != null)
			toUpdate.setAge(age);
		return toUpdate;
	}

	@Override
	public void delete(int id) {
		this.footballers.remove(id);
	}

	@Override
	public Footballer findByName(String name) {
		return null;
	}

}
