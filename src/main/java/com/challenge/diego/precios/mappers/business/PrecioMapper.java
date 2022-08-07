package com.challenge.diego.precios.mappers.business;

import java.util.List;

import org.mapstruct.Mapper;

import com.challenge.diego.precios.entities.business.Precio;
import com.challenge.diego.precios.entities.persistence.PrecioEntity;

@Mapper(componentModel = "spring", uses = { BrandMapper.class, CurrencyMapper.class, ProductMapper.class })
public interface PrecioMapper {

	Precio map(PrecioEntity param);

	PrecioEntity map(Precio param);

	List<Precio> mapList(List<PrecioEntity> list);

}
