package com.qa.footy.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.footy.entity.Footballer;

public interface FootballerRepo extends JpaRepository<Footballer, Integer>{
	
	Footballer findByNameStartingWithIgnoreCase(String firstname);

}
