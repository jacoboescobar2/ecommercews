package com.minicommerce.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.minicommerce.app.models.entity.Product;

public interface IProductDao extends CrudRepository<Product, Integer>{

	@Query(value = "SELECT * FROM products WHERE name LIKE %:username%", nativeQuery = true)
	List<Product> findProducByName(@Param("name") String name);
}
