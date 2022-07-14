package com.example.demo.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.footy.entity.Footballer;

@SpringBootTest
@AutoConfigureMockMvc // sets up the testing class
@Sql(scripts = { "classpath:footballer-schema.sql",
"classpath:footballer-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class FootballerControllerIntegreationTest {
	
	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testCreate() throws Exception {
		Footballer testFootballer = new Footballer("Shak", "Ali", 24, "CDM", 987654321);
		String testFootballerAsJSON = this.mapper.writeValueAsString(testFootballer);
		RequestBuilder req = post("/createFootballer").content(testFootballerAsJSON).contentType(MediaType.APPLICATION_JSON);

		ResultMatcher checkStatus = MockMvcResultMatchers.status().is(201);
		Footballer createdFootballer = new Footballer(2, "Shak", "Ali", 24, "CDM", 987654321);
		String createdFootballerAsJSON = this.mapper.writeValueAsString(createdFootballer);
		ResultMatcher checkBody = MockMvcResultMatchers.content().json(createdFootballerAsJSON);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testRead() throws Exception {
		List<Footballer> footballers = List.of(new Footballer(1, "Scott", "McSauce", 23, "Centre mid", 123456789));
		this.mvc.perform(get("/getFootballers")).andExpect(status().isOk())
				.andExpect(content().json(this.mapper.writeValueAsString(footballers)));
	}

	@Test
	void testUpdate() throws Exception {
		Footballer updated = new Footballer(1, "James", "Garner", 21, "CentreMid", 123456789);
		this.mvc.perform(patch("/updateFootballer/1?firstname=James&surname=Garner&age=21&position=CentreMid&phonenumber=4494")).andExpect(status().isOk())
				.andExpect(content().json(this.mapper.writeValueAsString(updated)));
	}

	@Test
	void testDelete() throws Exception {
		this.mvc.perform(delete("/removeFootballer/1")).andExpect(status().isNoContent());
	}


}
