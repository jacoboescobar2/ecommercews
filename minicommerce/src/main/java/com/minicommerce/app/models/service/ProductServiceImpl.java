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

	@Override
	@Transactional
	public void delete(Product pro) {
		productDao.delete(pro);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Product findById(Integer id) {
		return productDao.findById(id).orElse(null);
	}

	@Override
	public List<Product> findProducByName(String name) {
		return productDao.findProducByName(name);
	}
	
}
