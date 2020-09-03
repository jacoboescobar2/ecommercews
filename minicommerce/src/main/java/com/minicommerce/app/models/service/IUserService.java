package com.minicommerce.app.models.service;

import java.util.List;

import com.minicommerce.app.models.entity.User;

public interface IUserService {

	public List<User> findAll();
	
	public User findUserByUserName(String username);
	
	public void save(User user);
	
	public void blockUser(String username);
	
	public void unBlockUser(String username);
	
	public void changePassword(String password, String username);
	
	public User findById(Integer id);
}
