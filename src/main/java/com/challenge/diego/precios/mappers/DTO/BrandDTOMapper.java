package com.challenge.diego.precios.mappers.DTO;

import org.mapstruct.Mapper;

import com.challenge.diego.precios.entities.DTO.BrandDTO;
import com.challenge.diego.precios.entities.business.Brand;

@Mapper(componentModel = "spring")
public interface BrandDTOMapper {

	BrandDTO map(Brand entity);

	Brand map(BrandDTO entity);
}
