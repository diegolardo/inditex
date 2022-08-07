package com.challenge.diego.precios.mappers.DTO;

import org.mapstruct.Mapper;

import com.challenge.diego.precios.entities.DTO.CurrencyDTO;
import com.challenge.diego.precios.entities.business.Currency;

@Mapper(componentModel = "spring")
public interface CurrencyDTOMapper {

	CurrencyDTO map(Currency entity);

	Currency map(CurrencyDTO entity);
}
