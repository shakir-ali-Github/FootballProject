package com.qa.footy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.footy.entity.Footballer;

@Service

public class FootballerServiceList implements FootballerService {
	
	private List<Footballer> ballers = new ArrayList<>();
	
	@Override
	public Footballer getById(int id) {
		return this.ballers.get(id);
	}

	@Override
	public List<Footballer> getAll() {
		return this.ballers;
	}

	@Override
	public Footballer create(Footballer baller) {
		this.ballers.add(baller);
		return this.ballers.get(this.ballers.size() - 1);

	}

	@Override
	public Footballer update(int id, String firstname, String surname, Integer age, String position, Long phonenumber) {
		Footballer toUpdate = this.ballers.get(id);
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
		return toUpdate;
	}

	@Override
	public void delete(int id) {
		this.ballers.remove(id);
	}

	@Override
	public Footballer findByName(String firstname) {
		return null;
	}

}
