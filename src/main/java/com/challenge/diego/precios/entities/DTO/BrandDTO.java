package com.challenge.diego.precios.entities.DTO;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BrandDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3214254038891601253L;
	private Long id;
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
