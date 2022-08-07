package com.challenge.diego.precios.mappers.business;

import org.mapstruct.Mapper;

import com.challenge.diego.precios.entities.business.Brand;
import com.challenge.diego.precios.entities.persistence.BrandEntity;

@Mapper(componentModel = "spring")
public interface BrandMapper {

	BrandEntity map(Brand entity);

	Brand map(BrandEntity entity);
}
