package com.qa.footy.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Footballer {
	
	@Id // PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AI
	private Integer id;
	
	@Column(name = "footballerName", nullable = false, unique = true)
	private String firstname;
	
	private String surname;

	private int age;
	
	private String position;
	
	private long phonenumber;

	public Footballer() {
		super();
	}
	
	public Footballer(String firstname, String surname, int age, String position, long phonenumber) {
		super();
		this.firstname = firstname;
		this.surname = surname;
		this.age = age;
		this.position = position;
		this.phonenumber = phonenumber;
	}
	
	public Footballer(Integer id, String firstname, String surname, int age, String position, long phonenumber) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.surname = surname;
		this.age = age;
		this.position = position;
		this.phonenumber = phonenumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, firstname, id, phonenumber, position, surname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Footballer other = (Footballer) obj;
		return age == other.age && Objects.equals(firstname, other.firstname) && Objects.equals(id, other.id)
				&& phonenumber == other.phonenumber && Objects.equals(position, other.position)
				&& Objects.equals(surname, other.surname);
	}

	@Override
	public String toString() {
		return "Footballer [id=" + id + ", firstname=" + firstname + ", surname=" + surname + ", age=" + age
				+ ", position=" + position + ", phonenumber=" + phonenumber + "]";
	}


}
