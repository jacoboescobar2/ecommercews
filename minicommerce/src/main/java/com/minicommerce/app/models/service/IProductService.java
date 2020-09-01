package com.minicommerce.app.models.service;

import java.util.List;

import com.minicommerce.app.models.entity.Product;

public interface IProductService {

	public List<Product> findAll();
	
	public void save(Product product);
}
