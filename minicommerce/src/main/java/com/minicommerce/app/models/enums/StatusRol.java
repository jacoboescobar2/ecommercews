package com.minicommerce.app.models.enums;

public enum StatusRol {
	
	ADMINISTRADOR("ADMINISTRADOR"), EMPLEADO("EMPLEADO"), CLIENTE("CLIENTE");
	
	private String rol;

	private StatusRol(String rol) {
		this.rol = rol;
	}

	public String getRol() {
		return rol;
	}
	
}
