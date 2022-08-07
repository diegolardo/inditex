package com.challenge.diego.precios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.diego.precios.entities.business.Precio;
import com.challenge.diego.precios.entities.business.PreciosFilter;
import com.challenge.diego.precios.entities.persistence.specification.PreciosSpecification;
import com.challenge.diego.precios.mappers.business.PrecioMapper;
import com.challenge.diego.precios.repository.PrecioRepository;

@Service
public class PrecioService {

	@Autowired
	private PrecioRepository repository;

	@Autowired
	private PrecioMapper mapper;

	@Autowired
	private PreciosSpecification spec;

	public List<Precio> findByFilter(PreciosFilter filter) {
		return mapper.mapList(repository.findAll(spec.getPreciosByFilter(filter)));

	}

}
