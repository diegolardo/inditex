package com.challenge.diego.precios.entities.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the "product" database table.
 * 
 */
@Entity
@Table(name = "PRODUCT")
@NoArgsConstructor
public class ProductEntity implements Serializable {
	
	private static final long serialVersionUID = 2117226560506443985L;

	@Column(name = "ID")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "DESCRIPTION")
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