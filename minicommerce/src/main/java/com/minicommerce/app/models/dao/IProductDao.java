package com.minicommerce.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.minicommerce.app.models.entity.Product;

public interface IProductDao extends CrudRepository<Product, Integer>{

}
