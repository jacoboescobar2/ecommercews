package com.minicommerce.app.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.minicommerce.app.models.entity.User;


public interface IUserDao extends CrudRepository<User, Integer> {

	@Query(value = "SELECT * FROM users WHERE user = :username", nativeQuery = true)
	User findUserByUserName(@Param("username") String username);
	
	@Query(value = "UPDATE users SET state = false WHERE user = :username", nativeQuery = true)
	void blockUser(@Param("username") String username);
	
	@Query(value = "UPDATE users SET state = true WHERE user = :username", nativeQuery = true)
	void unBlockUser(@Param("username") String username);
	
	@Query(value = "UPDATE users SET password = :password WHERE user = :username", nativeQuery = true)
	void changePassword(@Param("password") String password, @Param("username") String username);
	
}
