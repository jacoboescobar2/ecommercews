package com.minicommerce.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minicommerce.app.models.dao.IProductDao;
import com.minicommerce.app.models.entity.Product;

@Service
public class ProductServiceImpl implements IProductService{

	@Autowired
	private IProductDao productDao;

	@Override
	@Transactional(readOnly=true)
	public List<Product> findAll() {
		return (List<Product>) productDao.findAll();
	}

	@Override
	@Transactional
	public void save(Product product) {
		productDao.save(product);
	}
}
