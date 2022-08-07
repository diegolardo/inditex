package com.challenge.diego.precios.entities.persistence;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PRECIOS")
@NoArgsConstructor
public class PrecioEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6900763488519500699L;

	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "ID_BRAND")
	private BrandEntity brand;

	@Column(name = "START_DATE")
	private LocalDateTime startDate;

	@Column(name = "END_DATE")
	private LocalDateTime endDate;

	@Column(name = "PRICE_LIST")
	private Integer priceList;

	@JoinColumn(name = "ID_PRODUCT")
	@ManyToOne
	private ProductEntity productId;

	@Column(name = "PRIORITY")
	private Integer priority;

	@Column(name = "PRICE")
	private BigDecimal price;

	@ManyToOne
	@JoinColumn(name = "ID_CURRENCY")
	private CurrencyEntity currency;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BrandEntity getBrand() {
		return brand;
	}

	public void setBrand(BrandEntity brand) {
		this.brand = brand;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public Integer getPriceList() {
		return priceList;
	}

	public void setPriceList(Integer priceList) {
		this.priceList = priceList;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public CurrencyEntity getCurrency() {
		return currency;
	}

	public void setCurrency(CurrencyEntity currency) {
		this.currency = currency;
	}

	public ProductEntity getProductId() {
		return productId;
	}

	public void setProductId(ProductEntity productId) {
		this.productId = productId;
	}

}
