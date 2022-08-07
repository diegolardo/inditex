package com.challenge.diego.precios.mappers.business;

import org.mapstruct.Mapper;

import com.challenge.diego.precios.entities.business.Currency;
import com.challenge.diego.precios.entities.persistence.CurrencyEntity;

@Mapper(componentModel = "spring")
public interface CurrencyMapper {

	CurrencyEntity map(Currency entity);

	Currency map(CurrencyEntity entity);
}
