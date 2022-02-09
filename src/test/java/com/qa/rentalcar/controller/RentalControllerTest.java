package com.qa.rentalcar.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.rentalcar.domain.Rental;

@SpringBootTest
@AutoConfigureMockMvc 
@Sql(scripts = {"classpath:rental-schema.sql", "classpath:rental-data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class RentalControllerTest {

	
	@Autowired
	private MockMvc mock; //To mock the requests
	
	@Autowired
	private ObjectMapper map; //Interprets JSON
	
	
	@Test
	void testCreateCont () throws Exception {
		//----request (set up to send to DB)
		//create a duck
		Rental newR = new Rental(10, 15, "Richard", "luxury", "Tesla", 10, false, 850.60F);
		//Convert into JSON string
		String newRJSON = this.map.writeValueAsString(newR);
		//Build the Mock request
		RequestBuilder mockRequest = post("/rental/create").contentType(MediaType.APPLICATION_JSON).content(newRJSON);
		
		///---response (returned)
		Rental savedR = new Rental(2, 10, 15, "Richard", "luxury", "Tesla", 10, false, 850.60F);//already inserted one recored on line 21
		//Convert to JSON
		String savedRJSON = this.map.writeValueAsString(savedR);
		
		//---test response (status + body)
		//test status = 201-CREATED
		ResultMatcher matchStatus = status().isCreated();
		//test response body
		ResultMatcher matchBody = content().json(savedRJSON);
		
		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);

		
		
	}
	
	@Test
	void readTest() throws Exception {
		Rental readR = new Rental(1, 13, 18, "Joe", "luxury", "BMW", 5, false, 500.5F);
		List<Rental> allRental = List.of(readR);
		String readRentalJSON = this.map.writeValueAsString(allRental);

		RequestBuilder mockReq = get("/rental/getAll");

		ResultMatcher status = status().isFound();
		ResultMatcher body = content().json(readRentalJSON);

		this.mock.perform(mockReq).andExpect(status).andExpect(body);

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


















