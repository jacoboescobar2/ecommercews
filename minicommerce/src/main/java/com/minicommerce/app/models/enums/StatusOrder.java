package com.minicommerce.app.models.enums;

public enum StatusOrder {

	REGISTRADA("REGISTRADA"), PAGADA("PAGADA"), ENTREGADA("ENTREGADA");
	
	private String rol;

	private StatusOrder(String rol) {
		this.rol = rol;
	}

	public String getRol() {
		return rol;
	}

	
}
