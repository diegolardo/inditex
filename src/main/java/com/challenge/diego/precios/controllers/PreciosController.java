/**
 * 
 */
package com.challenge.diego.precios.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.diego.precios.entities.DTO.PreciosFilterDTO;
import com.challenge.diego.precios.entities.DTO.ResponseChallengeDTO;
import com.challenge.diego.precios.mappers.DTO.PrecioDTOMapper;
import com.challenge.diego.precios.service.PrecioService;

/**
 * @author diego
 *
 */
@RestController
@RequestMapping("/api/precios")
public class PreciosController {

	@Autowired
	private PrecioService service;

	@Autowired
	private PrecioDTOMapper mapper;

	@PostMapping(path = "/findByFilter")
	@ResponseStatus(HttpStatus.OK)
	public List<ResponseChallengeDTO> findByFilter(@RequestBody PreciosFilterDTO filter) {
		return mapper.mapListChallenge(service.findByFilter(mapper.filterMap(filter)));
	}

}
