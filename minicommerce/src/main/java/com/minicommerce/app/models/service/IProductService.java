package com.minicommerce.app.models.service;

import java.util.List;

import com.minicommerce.app.models.entity.Product;

public interface IProductService {

	public List<Product> findAll();
	
	public Product findById(Integer id);
	
	public void save(Product product);
	
	public void delete(Product id);
	
	public List<Product> findProducByName(String name);
}
