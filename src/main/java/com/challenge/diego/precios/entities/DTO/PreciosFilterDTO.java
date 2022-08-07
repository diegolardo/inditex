package com.challenge.diego.precios.entities.DTO;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PreciosFilterDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6242546294751075046L;
	private LocalDateTime fecha;
	private Long productId;
	private Long brandId;

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

}
