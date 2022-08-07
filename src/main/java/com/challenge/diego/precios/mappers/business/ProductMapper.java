package com.challenge.diego.precios.mappers.business;

import org.mapstruct.Mapper;

import com.challenge.diego.precios.entities.business.Product;
import com.challenge.diego.precios.entities.persistence.ProductEntity;

@Mapper(componentModel = "spring")
public interface ProductMapper {

	ProductEntity map(Product entity);

	Product map(ProductEntity entity);
}
