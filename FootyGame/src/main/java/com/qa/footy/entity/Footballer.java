package com.qa.footy.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Footballer {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer id;
	
	private String name;
	
	private String position;
	
	private String email;
	
	private int age;

	public Footballer() {
		super();
	}
	
	public Footballer(String name, String position, String email, int age) {
		super();
		this.name = name;
		this.position = position;
		this.email = email;
		this.age = age;
	}
	
	public Footballer(Integer id, String name, String position, String email, int age) {
		super();
		this.id = id;
		this.name = name;
		this.position = position;
		this.email = email;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	@Override
	public String toString() {
		return "Footballer [id=" + id + ", name=" + name + ", position=" + position + ", email=" + email + ", age="
				+ age + "]";
	}

	

}
