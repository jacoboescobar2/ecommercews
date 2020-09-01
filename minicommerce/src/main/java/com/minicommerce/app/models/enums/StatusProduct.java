package com.minicommerce.app.models.enums;

public enum StatusProduct {

	BORRADOR("BORRADOR"), PUBLICADO("PUBLICADO");
	
	private String rol;

	private StatusProduct(String rol) {
		this.rol = rol;
	}

	public String getRol() {
		return rol;
	}
	
	
}
