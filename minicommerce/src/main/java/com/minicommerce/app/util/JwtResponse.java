package com.minicommerce.app.util;

import java.util.List;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private Integer id;
	private String username;
	private List<String> rol;

	public JwtResponse(String accessToken, Integer id, String username, List<String> rol) {
		this.token = accessToken;
		this.id = id;
		this.username = username;
		this.rol = rol;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getRol() {
		return rol;
	}

	public void setRol(List<String> rol) {
		this.rol = rol;
	}


}
