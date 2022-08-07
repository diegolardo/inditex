package com.challenge.diego.precios.mappers.DTO;

import org.mapstruct.Mapper;

import com.challenge.diego.precios.entities.DTO.ProductDTO;
import com.challenge.diego.precios.entities.business.Product;

@Mapper(componentModel = "spring")
public interface ProductDTOMapper {

	ProductDTO map(Product entity);

	Product map(ProductDTO entity);
}
