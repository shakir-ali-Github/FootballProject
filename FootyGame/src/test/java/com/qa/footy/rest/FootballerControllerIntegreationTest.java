package com.qa.footy.rest;

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
"classpath:footballer-data.sql" }, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class FootballerControllerIntegreationTest {
	
	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testCreate() throws Exception {
		Footballer testFootballer = new Footballer("Shak", "CDM", "shak@email.com", 24);
		String testFootballerAsJSON = this.mapper.writeValueAsString(testFootballer);
		RequestBuilder req = post("/createFootballer").content(testFootballerAsJSON).contentType(MediaType.APPLICATION_JSON);

		ResultMatcher checkStatus = MockMvcResultMatchers.status().is(201);
		Footballer createdFootballer = new Footballer(2, "Shak", "CDM", "shak@email.com", 24);
		String createdFootballerAsJSON = this.mapper.writeValueAsString(createdFootballer);
		ResultMatcher checkBody = MockMvcResultMatchers.content().json(createdFootballerAsJSON);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testRead() throws Exception {
		List<Footballer> footballers = List.of(new Footballer(1, "Scott", "CentreMid", "Scott@email.com", 23));
		this.mvc.perform(get("/getFootballers")).andExpect(status().isOk())
				.andExpect(content().json(this.mapper.writeValueAsString(footballers)));
	}

	@Test
	void testUpdate() throws Exception {
		Footballer updated = new Footballer(1, "James", "CentreMid", "James@email.com", 21);
		this.mvc.perform(patch("/updateFootballer/1?name=James&position=CentreMid&email=James@email.com&age=21")).andExpect(status().isOk())
				.andExpect(content().json(this.mapper.writeValueAsString(updated)));
	}

	@Test
	void testDelete() throws Exception {
		this.mvc.perform(delete("/removeFootballer/1")).andExpect(status().isNoContent());
	}


}
