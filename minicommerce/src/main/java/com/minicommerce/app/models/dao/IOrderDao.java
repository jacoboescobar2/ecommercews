package com.minicommerce.app.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.minicommerce.app.models.entity.Order;

public interface IOrderDao extends CrudRepository<Order, Integer>{

	@Query(value = "SELECT COUNT(*) FROM orders WHERE user_id = :idUser", nativeQuery = true)
	int countOrdersByIdUser(@Param("idUser") Integer idUser);
}
