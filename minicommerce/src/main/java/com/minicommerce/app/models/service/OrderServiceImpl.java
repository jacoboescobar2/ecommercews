package com.minicommerce.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minicommerce.app.models.dao.IOrderDao;
import com.minicommerce.app.models.entity.Order;

@Service
public class OrderServiceImpl implements IOrderService{

	@Autowired
	private IOrderDao orderDao;

	@Override
	@Transactional(readOnly=true)
	public List<Order> findAll() {
		return (List<Order>) orderDao.findAll();
	}

	@Override
	@Transactional
	public void save(Order order) {
		orderDao.save(order);
	}

	@Override
	@Transactional(readOnly=true)
	public int countOrdersByIdUser(Integer idUser) {
		return orderDao.countOrdersByIdUser(idUser);
	}
	
	
	
	
}
