package com.challenge.diego.precios.mappers.DTO;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.challenge.diego.precios.entities.DTO.PrecioDTO;
import com.challenge.diego.precios.entities.DTO.PreciosFilterDTO;
import com.challenge.diego.precios.entities.DTO.ResponseChallengeDTO;
import com.challenge.diego.precios.entities.business.Precio;
import com.challenge.diego.precios.entities.business.PreciosFilter;

@Mapper(componentModel = "spring", uses = { BrandDTOMapper.class, CurrencyDTOMapper.class, ProductDTOMapper.class })
public interface PrecioDTOMapper {

	Precio map(PrecioDTO param);

	PrecioDTO map(Precio param);

	List<PrecioDTO> mapList(List<Precio> list);

	@Mapping(target = "fecha", source = "fecha")
	@Mapping(target = "productId", source = "productId")
	@Mapping(target = "brandId", source = "brandId")
	PreciosFilter filterMap(PreciosFilterDTO filterDto);

	@Mapping(target = "productId", source = "productId.id")
	@Mapping(target = "brandId", source = "brand.id")
	ResponseChallengeDTO mapToChallenge(Precio entity);

	List<ResponseChallengeDTO> mapListChallenge(List<Precio> list);

}
