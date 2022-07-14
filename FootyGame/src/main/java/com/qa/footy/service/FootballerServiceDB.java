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
	public Footballer create(Footballer baller) {
		return this.repo.save(baller);
	}

	@Override
	public Footballer update(int id, String firstname, String surname, Integer age, String position, Long phonenumber) {
		Footballer toUpdate = this.getById(id);
		if (firstname != null)
			toUpdate.setFirstname(firstname);
		if (surname != null)
			toUpdate.setSurname(surname);
		if (age != null)
			toUpdate.setAge(age);
		if (position != null)
			toUpdate.setPosition(position);
		if (phonenumber != null)
			toUpdate.setPhonenumber(phonenumber);
		return this.repo.save(toUpdate);
	}

	@Override
	public void delete(int id) {
		this.repo.deleteById(id);
	}

	@Override
	public Footballer findByName(String firstname) {
		return this.repo.findByNameStartingWithIgnoreCase(firstname);
	}

}
