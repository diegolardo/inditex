package com.challenge.diego.precios.service;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.challenge.diego.precios.entities.business.Precio;
import com.challenge.diego.precios.entities.business.PreciosFilter;
import com.challenge.diego.precios.entities.persistence.PrecioEntity;
import com.challenge.diego.precios.entities.persistence.specification.PreciosSpecification;
import com.challenge.diego.precios.mappers.business.PrecioMapper;
import com.challenge.diego.precios.repository.PrecioRepository;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PreciosServiceTest {

	@Autowired
	private PrecioService service;

	@Mock
	private PrecioRepository repository;

	@Mock
	private PrecioMapper mapper;

	@Mock
	private PreciosSpecification spec;

	@Test
	public void testService() {

		// Mock
		Mockito.when(repository.findAll(spec.getPreciosByFilter(getFilter()))).thenReturn(getListPreciosEntity());
		Mockito.when(mapper.mapList(getListPreciosEntity())).thenReturn(getListPrecios());
		List<Precio> response = service.findByFilter(getFilter());
		Assertions.assertThat(response).isNotNull();
		Assertions.assertThat(response).isNotEmpty();
	}

	private List<PrecioEntity> getListPreciosEntity() {
		List<PrecioEntity> response = new ArrayList<>();
		response.add(new PrecioEntity());
		return response;
	}

	private List<Precio> getListPrecios() {
		List<Precio> response = new ArrayList<>();
		response.add(new Precio());
		return response;
	}

	public PreciosFilter getFilter() {
		PreciosFilter precioFilter = new PreciosFilter();
		precioFilter.setBrandId(1L);
		precioFilter.setProductId(35455L);
		precioFilter.setFecha(LocalDateTime.of(2020, Month.JUNE, 14, 10, 0, 0, 0));
		return precioFilter;

	}
}
