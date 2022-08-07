package com.challenge.diego.precios.mappers;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.challenge.diego.precios.entities.DTO.BrandDTO;
import com.challenge.diego.precios.entities.DTO.CurrencyDTO;
import com.challenge.diego.precios.entities.DTO.PrecioDTO;
import com.challenge.diego.precios.entities.DTO.PreciosFilterDTO;
import com.challenge.diego.precios.entities.DTO.ProductDTO;
import com.challenge.diego.precios.entities.DTO.ResponseChallengeDTO;
import com.challenge.diego.precios.entities.business.Brand;
import com.challenge.diego.precios.entities.business.Currency;
import com.challenge.diego.precios.entities.business.Precio;
import com.challenge.diego.precios.entities.business.PreciosFilter;
import com.challenge.diego.precios.entities.business.Product;
import com.challenge.diego.precios.mappers.DTO.PrecioDTOMapper;

@SpringBootTest
public class PreciosDTOMapperTest {

	@Autowired
	private PrecioDTOMapper mapper;

	/*
	 *
	 * 
	 * @Mapping(target = "productId", source = "productId.id")
	 * 
	 * @Mapping(target = "brandId", source = "brand.id") ResponseChallengeDTO
	 * mapToChallenge(Precio entity);
	 * 
	 * List<ResponseChallengeDTO> mapListChallenge(List<Precio> list);
	 * 
	 **/

	@Test
	public void testChallengeResponse() {
		Precio precio = getPrecio();
		ResponseChallengeDTO response = mapper.mapToChallenge(precio);
		Assertions.assertThat(response).isNotNull();
		Assertions.assertThat(response.getEndDate().equals(precio.getEndDate()));
		Assertions.assertThat(response.getStartDate().equals(precio.getStartDate()));
		Assertions.assertThat(response.getProductId().equals(precio.getProductId().getId()));
		Assertions.assertThat(response.getBrandId().equals(precio.getBrand().getId()));
		Assertions.assertThat(response.getPrice().equals(precio.getPrice()));
		Assertions.assertThat(response.getPriceList().equals(precio.getPriceList()));
	}

	@Test
	public void testChallengeList() {
		List<Precio> precioList = new ArrayList<>();
		precioList.add(getPrecio());
		precioList.add(getPrecio());
		List<ResponseChallengeDTO> response = mapper.mapListChallenge(precioList);
		Assertions.assertThat(response).isNotNull();
		Assertions.assertThat(response).isNotEmpty();
		Assertions.assertThat(response.size()).isEqualTo(2);

	}

	@Test
	public void testFilter() {

		PreciosFilterDTO filterDto = new PreciosFilterDTO();
		filterDto.setBrandId(1L);
		filterDto.setFecha(LocalDateTime.now());
		filterDto.setProductId(54L);
		PreciosFilter response = mapper.filterMap(filterDto);
		Assertions.assertThat(response.getBrandId().equals(filterDto.getBrandId()));
		Assertions.assertThat(response.getFecha().equals(filterDto.getFecha()));
		Assertions.assertThat(response.getProductId().equals(filterDto.getProductId()));

	}

	@Test
	public void testMapper() {

		PrecioDTO precio = getPrecioDTO();
		Precio response = mapper.map(precio);
		Assertions.assertThat(response).isNotNull();
		Assertions.assertThat(response.getEndDate().equals(precio.getEndDate()));
		Assertions.assertThat(response.getStartDate().equals(precio.getStartDate()));

		Assertions.assertThat(response.getId().equals(precio.getId()));
		Assertions.assertThat(response.getPrice().equals(precio.getPrice()));
		Assertions.assertThat(response.getPriceList().equals(precio.getPriceList()));
		Assertions.assertThat(response.getPriority().equals(precio.getPriority()));
		Assertions.assertThat(response.getBrand().getId().equals(precio.getBrand().getId()));
		Assertions.assertThat(response.getBrand().getDescription().equals(precio.getBrand().getDescription()));
		Assertions.assertThat(response.getCurrency().getCurrencyCode().equals(precio.getCurrency().getCurrencyCode()));
		Assertions.assertThat(response.getCurrency().getId().equals(precio.getCurrency().getId()));
		Assertions.assertThat(response.getProductId().getId().equals(precio.getProductId().getId()));
		Assertions.assertThat(response.getProductId().getDescription().equals(precio.getProductId().getDescription()));
		Assertions.assertThat(response.getEndDate().equals(precio.getEndDate()));

	}

	@Test
	public void testEntityMapper() {

		Precio precio = getPrecio();
		PrecioDTO response = mapper.map(precio);
		Assertions.assertThat(response).isNotNull();
		Assertions.assertThat(response.getEndDate().equals(precio.getEndDate()));
		Assertions.assertThat(response.getStartDate().equals(precio.getStartDate()));

		Assertions.assertThat(response.getId().equals(precio.getId()));
		Assertions.assertThat(response.getPrice().equals(precio.getPrice()));
		Assertions.assertThat(response.getPriceList().equals(precio.getPriceList()));
		Assertions.assertThat(response.getPriority().equals(precio.getPriority()));
		Assertions.assertThat(response.getBrand().getId().equals(precio.getBrand().getId()));
		Assertions.assertThat(response.getBrand().getDescription().equals(precio.getBrand().getDescription()));
		Assertions.assertThat(response.getCurrency().getCurrencyCode().equals(precio.getCurrency().getCurrencyCode()));
		Assertions.assertThat(response.getCurrency().getId().equals(precio.getCurrency().getId()));
		Assertions.assertThat(response.getProductId().getId().equals(precio.getProductId().getId()));
		Assertions.assertThat(response.getProductId().getDescription().equals(precio.getProductId().getDescription()));
		Assertions.assertThat(response.getEndDate().equals(precio.getEndDate()));

	}

	@Test
	public void testListMapper() {
		List<Precio> list = new ArrayList<>();
		list.add(getPrecio());
		list.add(getPrecio());
		List<PrecioDTO> response = mapper.mapList(list);
		Assertions.assertThat(response).isNotNull();
		Assertions.assertThat(response).isNotEmpty();
		Assertions.assertThat(response.size()).isEqualTo(2);
	}

	private Precio getPrecio() {
		Precio precio = new Precio();
		precio.setBrand(getBrand());
		precio.setCurrency(getCurrency());
		precio.setEndDate(LocalDateTime.now());
		precio.setId(1231231L);
		precio.setPrice(new BigDecimal(11.52));
		precio.setPriceList(1);
		precio.setPriority(1);
		precio.setProductId(getProduct());
		precio.setStartDate(LocalDateTime.now());
		return precio;
	}

	private PrecioDTO getPrecioDTO() {
		PrecioDTO precio = new PrecioDTO();
		precio.setBrand(getBrandDTO());
		precio.setCurrency(getCurrencyDTO());
		precio.setEndDate(LocalDateTime.now());
		precio.setId(1231231L);
		precio.setPrice(new BigDecimal(11.52));
		precio.setPriceList(1);
		precio.setPriority(1);
		precio.setProductId(getProductDTO());
		precio.setStartDate(LocalDateTime.now());
		return precio;
	}

	private Brand getBrand() {
		Brand brand = new Brand();
		brand.setDescription("ZARA");
		brand.setId(1L);
		return brand;
	}

	private Currency getCurrency() {
		Currency currency = new Currency();
		currency.setCurrencyCode("€");
		currency.setId(1L);
		currency.setShortDesc("Euro");

		return currency;
	}

	private Product getProduct() {
		Product product = new Product();
		product.setDescription("Camiseta");
		product.setId(13L);
		return product;
	}

	private BrandDTO getBrandDTO() {
		BrandDTO brand = new BrandDTO();
		brand.setDescription("ZARA");
		brand.setId(1L);
		return brand;
	}

	private CurrencyDTO getCurrencyDTO() {
		CurrencyDTO currency = new CurrencyDTO();
		currency.setCurrencyCode("€");
		currency.setId(1L);
		currency.setShortDesc("Euro");

		return currency;
	}

	private ProductDTO getProductDTO() {
		ProductDTO product = new ProductDTO();
		product.setDescription("Camiseta");
		product.setId(13L);
		return product;
	}
}
