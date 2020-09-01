package com.minicommerce.app.models.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minicommerce.app.models.dao.IUserDao;
import com.minicommerce.app.models.entity.User;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserDao userDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<User> findAll(){
		return (List<User>) userDao.findAll();
	}
	
	@Override
	@Transactional
	public void save(User user) {
		userDao.save(user);
	}

	@Override
	@Transactional
	public void blockUser(String username) {
		userDao.blockUser(username);
		
	}

	@Override
	@Transactional
	public void unBlockUser(String username) {
		userDao.unBlockUser(username);	
	}

	@Override
	@Transactional(readOnly=true)
	public User findUserByUserName(String username) {
		return userDao.findUserByUserName(username);
	}

	@Override
	@Transactional
	public void changePassword(String password, String username) {
		userDao.changePassword(password, username);
		
	}
}
