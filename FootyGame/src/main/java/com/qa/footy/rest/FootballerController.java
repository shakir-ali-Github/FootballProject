package com.qa.footy.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.footy.entity.Footballer;
import com.qa.footy.service.FootballerService;

@CrossOrigin
@RestController
public class FootballerController {
	
	@Autowired
	private FootballerService service; // dependency


	@GetMapping("/demoFootballer")
	public Footballer getDemoFootballer() {
		return new Footballer("Shak", "Ali", Integer.MAX_VALUE, "CDM", Long.MAX_VALUE);
	}

	@GetMapping("/getFootballer/{id}")
	public Footballer getById(@PathVariable int id) {
		return this.service.getById(id);
	}

	@GetMapping("/getFootballers")
	public List<Footballer> getAll() {
		return this.service.getAll();
	}

	@GetMapping("/getFootballerByName/{firstname}")
	public Footballer getFootballerByName(@PathVariable String firstname) {
		return this.service.findByName(firstname);
	}

	@PostMapping("/createFootballer")
	public ResponseEntity<Footballer> create(@RequestBody Footballer baller) {
		System.out.println("Created: " + baller);
		Footballer created = this.service.create(baller);

		return new ResponseEntity<Footballer>(created, HttpStatus.CREATED);
	}

	@PatchMapping("/updateFootballer/{id}")
	public Footballer update(@PathVariable("id") int id, @PathParam("firstname") String firstname,
			@PathParam("surname") String surname, @PathParam("age") Integer age, @PathParam("position") String position, @PathParam("phonenumber") Long phonenumber) {
		return this.service.update(id, firstname, surname, age, position, phonenumber);
	}

	// id = 4494
	@DeleteMapping("/removeFootballer/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		this.service.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}


}
