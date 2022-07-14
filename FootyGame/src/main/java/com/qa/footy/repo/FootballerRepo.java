package com.qa.footy.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.footy.entity.Footballer;

@Repository
public interface FootballerRepo extends JpaRepository<Footballer, Integer>{
	
	 Footballer findByNameStartingWithIgnoreCase(String firstname);

}
