package com.challenge.diego.precios.controller;

import java.time.LocalDateTime;
import java.time.Month;

import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.challenge.diego.precios.entities.DTO.PreciosFilterDTO;
import com.challenge.diego.precios.mappers.DTO.PrecioDTOMapper;
import com.challenge.diego.precios.service.PrecioService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PreciosControllerTest {

	@Autowired
	private PrecioService service;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private PrecioDTOMapper mapper;

	@Test
	public void prueba1() throws JsonProcessingException, Exception {
		PreciosFilterDTO filterDTO = new PreciosFilterDTO();
		filterDTO.setBrandId(1L);
		filterDTO.setProductId(35455L);
		filterDTO.setFecha(LocalDateTime.of(2020, Month.JUNE, 14, 10, 0, 0, 0));

		MvcResult response = mockMvc
				.perform(MockMvcRequestBuilders.post("/api/precios/findByFilter")
						.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(filterDTO)))
				.andReturn();
		String expected = "[ { \"productId\": 35455, \"brandId\": 1, \"priceList\": 1, \"startDate\": \"2020-06-14T00:00:00\", \"endDate\": \"2020-12-31T23:59:59\", \"price\": 36 }]";
		System.out.print(response.getResponse().getContentAsString());
		JSONAssert.assertEquals(expected, response.getResponse().getContentAsString(), false);

	}
	
	@Test
	public void prueba2() throws JsonProcessingException, Exception {
		PreciosFilterDTO filterDTO = new PreciosFilterDTO();
		filterDTO.setBrandId(1L);
		filterDTO.setProductId(35455L);
		filterDTO.setFecha(LocalDateTime.of(2020, Month.JUNE, 14, 16, 0, 0, 0));

		MvcResult response = mockMvc
				.perform(MockMvcRequestBuilders.post("/api/precios/findByFilter")
						.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(filterDTO)))
				.andReturn();
		String expected = "[ { \"productId\": 35455, \"brandId\": 1, \"priceList\": 1, \"startDate\": \"2020-06-14T00:00:00\", \"endDate\": \"2020-12-31T23:59:59\", \"price\": 36 }, { \"productId\": 35455, \"brandId\": 1, \"priceList\": 2, \"startDate\": \"2020-06-14T15:00:00\", \"endDate\": \"2020-06-14T18:30:00\", \"price\": 25 } ]";
		System.out.print(response.getResponse().getContentAsString());
		JSONAssert.assertEquals(expected, response.getResponse().getContentAsString(), false);

	}
	@Test
	public void prueba3() throws JsonProcessingException, Exception {
		PreciosFilterDTO filterDTO = new PreciosFilterDTO();
		filterDTO.setBrandId(1L);
		filterDTO.setProductId(35455L);
		filterDTO.setFecha(LocalDateTime.of(2020, Month.JUNE, 14, 21, 0, 0, 0));

		MvcResult response = mockMvc
				.perform(MockMvcRequestBuilders.post("/api/precios/findByFilter")
						.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(filterDTO)))
				.andReturn();
		String expected = "[ { \"productId\": 35455, \"brandId\": 1, \"priceList\": 1, \"startDate\": \"2020-06-14T00:00:00\", \"endDate\": \"2020-12-31T23:59:59\", \"price\": 36 } ]";
		System.out.print(response.getResponse().getContentAsString());
		JSONAssert.assertEquals(expected, response.getResponse().getContentAsString(), false);

	}
	@Test
	public void prueba4() throws JsonProcessingException, Exception {
		PreciosFilterDTO filterDTO = new PreciosFilterDTO();
		filterDTO.setBrandId(1L);
		filterDTO.setProductId(35455L);
		filterDTO.setFecha(LocalDateTime.of(2020, Month.JUNE, 15, 10, 0, 0, 0));

		MvcResult response = mockMvc
				.perform(MockMvcRequestBuilders.post("/api/precios/findByFilter")
						.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(filterDTO)))
				.andReturn();
		String expected = "[ { \"productId\": 35455, \"brandId\": 1, \"priceList\": 1, \"startDate\": \"2020-06-14T00:00:00\", \"endDate\": \"2020-12-31T23:59:59\", \"price\": 36 }, { \"productId\": 35455, \"brandId\": 1, \"priceList\": 3, \"startDate\": \"2020-06-15T00:00:00\", \"endDate\": \"2020-06-15T11:00:00\", \"price\": 31 } ]";
		System.out.print(response.getResponse().getContentAsString());
		JSONAssert.assertEquals(expected, response.getResponse().getContentAsString(), false);

	}

	@Test
	public void prueba5() throws JsonProcessingException, Exception {
		PreciosFilterDTO filterDTO = new PreciosFilterDTO();
		filterDTO.setBrandId(1L);
		filterDTO.setProductId(35455L);
		filterDTO.setFecha(LocalDateTime.of(2020, Month.JUNE, 16, 21, 0, 0, 0));

		MvcResult response = mockMvc
				.perform(MockMvcRequestBuilders.post("/api/precios/findByFilter")
						.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(filterDTO)))
				.andReturn();
		String expected = "[ { \"productId\": 35455, \"brandId\": 1, \"priceList\": 1, \"startDate\": \"2020-06-14T00:00:00\", \"endDate\": \"2020-12-31T23:59:59\", \"price\": 36 }, { \"productId\": 35455, \"brandId\": 1, \"priceList\": 4, \"startDate\": \"2020-06-15T16:00:00\", \"endDate\": \"2020-12-31T23:59:59\", \"price\": 39 } ]";
		System.out.print(response.getResponse().getContentAsString());
		JSONAssert.assertEquals(expected, response.getResponse().getContentAsString(), false);

	}
	
}
