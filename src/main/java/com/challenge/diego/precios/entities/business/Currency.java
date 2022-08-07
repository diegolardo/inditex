package com.challenge.diego.precios.entities.business;

import java.io.Serializable;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Currency implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8131749652987794623L;

	private Long id;

	private String shortDesc;

	private String currencyCode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

}
