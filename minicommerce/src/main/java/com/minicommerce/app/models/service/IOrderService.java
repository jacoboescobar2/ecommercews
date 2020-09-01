package com.minicommerce.app.models.service;

import java.util.List;

import com.minicommerce.app.models.entity.Order;

public interface IOrderService {

	public List<Order> findAll();
	
	public void save(Order order);
	
	public int countOrdersByIdUser(Integer idUser);
}
