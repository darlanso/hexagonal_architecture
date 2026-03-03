package com.darlanso.hexagonal_architecture;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;


import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(Controller.class)
public class ControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void shouldCheckinSuccessfully() throws Exception {
		ParkedCarInputDTO input = new ParkedCarInputDTO("AAA-9999", "2022-03-01T10:00:00-03:00");
		mockMvc.perform(post("/checkin").contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(input)))
				.andExpect(status().isOk())
				.andExpect(content().string("Success!"));
	}

	@Test
	void shouldReturnParkedCars() throws Exception {


		ParkedCarInputDTO input = new ParkedCarInputDTO("AAA-9999", "2022-03-01T10:00:00-03:00");

		mockMvc.perform(post("/checkin").
						contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(input)))
				.andExpect(status().isOk());


		mockMvc.perform(get("/parked_cars")).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].plate").value("AAA-9999"));
	}

	@Test
	void shouldReturnCheckout() throws Exception {
		CheckoutInputDTO input = new CheckoutInputDTO("AAA-9999", "2022-03-01T12:00-03:00");
		mockMvc.perform(post("/checkout").contentType(MediaType.APPLICATION_JSON).
						content(objectMapper.writeValueAsString(input)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price").value(20))
				.andExpect(jsonPath("$.period").value(2));

	}
}
