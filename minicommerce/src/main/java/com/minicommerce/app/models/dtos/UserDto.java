package com.minicommerce.app.models.dtos;

import java.util.List;

import com.minicommerce.app.models.enums.StatusRol;

public class UserDto {
	
	private Integer id;
	private String name;
	private String lastname;
	private String user;
	private String password;
	private Boolean state;
	private StatusRol rol;
	private List<OrderDto> orders;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getState() {
		return state;
	}
	public void setState(Boolean state) {
		this.state = state;
	}
	public StatusRol getRol() {
		return rol;
	}
	public void setRol(StatusRol rol) {
		this.rol = rol;
	}
	public List<OrderDto> getOrders() {
		return orders;
	}
	public void setOrders(List<OrderDto> orders) {
		this.orders = orders;
	}

}
