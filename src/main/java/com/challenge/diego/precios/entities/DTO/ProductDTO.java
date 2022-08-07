package com.challenge.diego.precios.entities.DTO;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ProductDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2714526336814190155L;
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
