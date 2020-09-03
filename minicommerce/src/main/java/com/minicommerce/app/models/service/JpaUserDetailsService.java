package com.minicommerce.app.models.service;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minicommerce.app.models.dao.IUserDao;
import com.minicommerce.app.models.entity.User;
import com.minicommerce.app.util.UserDetailsImpl;

@Service("jpaUserDetailsService")
public class JpaUserDetailsService implements UserDetailsService {

	private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(JpaUserDetailsService.class);
	
	@Autowired
	private IUserDao userDao;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		LOGGER.info("Usuario: " + username);
		
		User user = userDao.findUserByUserName(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("Usuario: " + username + " no existe en el sistema");
		}
		
		if(user.getState() == false) {
			LOGGER.info("Entra aqui :: ");
			 throw new UsernameNotFoundException("User Not Found with username: " + username);
		}
		

		return UserDetailsImpl.build(user);
	}

}
