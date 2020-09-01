package com.minicommerce.app.models.dtos;

import java.util.Date;
import java.util.List;

import com.minicommerce.app.models.entity.User;
import com.minicommerce.app.models.enums.StatusOrder;

public class OrderDto {
	
	private Integer id;
	private Date createAt;
	private User user;
	private Double discount;
	private StatusOrder statusOrder;
	private List<ItemOrderDto> items;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public StatusOrder getStatusOrder() {
		return statusOrder;
	}
	public void setStatusOrder(StatusOrder statusOrder) {
		this.statusOrder = statusOrder;
	}
	public List<ItemOrderDto> getItems() {
		return items;
	}
	public void setItems(List<ItemOrderDto> items) {
		this.items = items;
	}
}
