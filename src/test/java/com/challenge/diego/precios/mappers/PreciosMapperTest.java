package com.challenge.diego.precios.mappers;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.challenge.diego.precios.entities.business.Brand;
import com.challenge.diego.precios.entities.business.Currency;
import com.challenge.diego.precios.entities.business.Precio;
import com.challenge.diego.precios.entities.business.Product;
import com.challenge.diego.precios.entities.persistence.BrandEntity;
import com.challenge.diego.precios.entities.persistence.CurrencyEntity;
import com.challenge.diego.precios.entities.persistence.PrecioEntity;
import com.challenge.diego.precios.entities.persistence.ProductEntity;
import com.challenge.diego.precios.mappers.business.PrecioMapper;

@SpringBootTest
public class PreciosMapperTest {

	@Autowired
	private PrecioMapper mapper;

	@Test
	public void testMapper() {

		Precio precio = getPrecio();
		PrecioEntity response = mapper.map(precio);
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

		PrecioEntity precio = getPrecioEntity();
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
	public void testListMapper() {
		List<PrecioEntity> list = new ArrayList<>();
		list.add(getPrecioEntity());
		list.add(getPrecioEntity());
		List<Precio> response = mapper.mapList(list);
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
		precio.setPrice(new BigDecimal(10.89));
		precio.setPriceList(1);
		precio.setPriority(1);
		precio.setProductId(getProduct());
		precio.setStartDate(LocalDateTime.now());
		return precio;
	}

	private PrecioEntity getPrecioEntity() {
		PrecioEntity precio = new PrecioEntity();
		precio.setBrand(getBrandEntity());
		precio.setCurrency(getCurrencyEntity());
		precio.setEndDate(LocalDateTime.now());
		precio.setId(1231231L);
		precio.setPrice(new BigDecimal(10.89));
		precio.setPriceList(1);
		precio.setPriority(1);
		precio.setProductId(getProductEntity());
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

	private BrandEntity getBrandEntity() {
		BrandEntity brand = new BrandEntity();
		brand.setDescription("ZARA");
		brand.setId(1L);
		return brand;
	}

	private CurrencyEntity getCurrencyEntity() {
		CurrencyEntity currency = new CurrencyEntity();
		currency.setCurrencyCode("€");
		currency.setId(1L);
		currency.setShortDesc("Euro");

		return currency;
	}

	private ProductEntity getProductEntity() {
		ProductEntity product = new ProductEntity();
		product.setDescription("Camiseta");
		product.setId(13L);
		return product;
	}
}
