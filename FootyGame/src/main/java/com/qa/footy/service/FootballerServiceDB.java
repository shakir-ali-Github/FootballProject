package com.qa.footy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.qa.footy.entity.Footballer;
import com.qa.footy.repo.FootballerRepo;

@Service
@Primary
public class FootballerServiceDB implements FootballerService {
	
	@Autowired
	private FootballerRepo repo;

	@Override
	public Footballer getById(int id) {
		return this.repo.findById(id).get();
	}

	@Override
	public List<Footballer> getAll() {
		return this.repo.findAll();
	}

	@Override
	public Footballer create(Footballer footballer) {
		return this.repo.save(footballer);
	}

	@Override
	public Footballer update(int id, String name, String position, String email, Integer age) {
		Footballer toUpdate = this.getById(id);
		if (name != null)
			toUpdate.setName(name);
		if (position != null)
			toUpdate.setPosition(position);
		if (email != null)
			toUpdate.setEmail(email);
		if (age != null)
			toUpdate.setAge(age);
		return this.repo.save(toUpdate);
	}

	@Override
	public void delete(int id) {
		this.repo.deleteById(id);
	}

	@Override
	public Footballer findByName(String name) {
		return this.repo.findByNameStartingWithIgnoreCase(name);
	}

}
