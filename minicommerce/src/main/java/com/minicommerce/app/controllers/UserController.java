package com.minicommerce.app.controllers;

import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.minicommerce.app.helpers.ECommerceHelper;
import com.minicommerce.app.models.dtos.UserDto;
import com.minicommerce.app.models.entity.User;
import com.minicommerce.app.models.enums.StatusRol;
import com.minicommerce.app.models.service.IUserService;
import com.minicommerce.app.util.ModelMapperUtil;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("/user")
public class UserController {
	
	private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(UserController.class);

	@Autowired
	private IUserService userService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Secured("ROLE_ADMINISTRADOR")
	@GetMapping("/findAll")
	public ResponseEntity findAllUsers() {
		ResponseEntity responseEntity;
		HttpHeaders header = new HttpHeaders();
		header.add("Cache-Control", "no-cache, no-store, must-revalidate");
		header.add("Pragma", "no-cache");
		header.add("Expires", "0");
		
		try {
			List<User> lstUser = userService.findAll();
			responseEntity = ResponseEntity.ok().headers(header)
					.contentType(MediaType.parseMediaType("application/json")).body(ModelMapperUtil.mapColletion(lstUser, UserDto.class));
		} catch (Exception exception) {
			responseEntity = ECommerceHelper.createErrorEntity(HttpStatus.BAD_REQUEST, exception.getMessage());
		}
		
		return responseEntity;
	}
	
	@PostMapping("/createUser")
	public ResponseEntity creteUser(@RequestBody UserDto userDto) {
		ResponseEntity responseEntity;
		HttpHeaders header = new HttpHeaders();
		header.add("Cache-Control", "no-cache, no-store, must-revalidate");
		header.add("Pragma", "no-cache");
		header.add("Expires", "0");

		try {
			UserDto dto = new UserDto();
			dto.setName(userDto.getName());
			dto.setLastname(userDto.getLastname());
			dto.setPassword(passwordEncoder.encode(userDto.getPassword()));
			LOGGER.info("USer password :: " + dto.getPassword());
			dto.setUser(userDto.getUser());
			dto.setState(true);
			dto.setRol(StatusRol.CLIENTE);
			dto.setCash(userDto.getCash());
			userService.save(ModelMapperUtil.map(dto, User.class));
			responseEntity = ResponseEntity.ok().build();
		} catch (Exception exception) {
			responseEntity = ECommerceHelper.createErrorEntity(HttpStatus.BAD_REQUEST, exception.getMessage());
		}

		return responseEntity;
	}
	
	@PostMapping("/changePassword")
	public ResponseEntity changePassword(@RequestBody UserDto userDto) {
		ResponseEntity responseEntity;
		HttpHeaders header = new HttpHeaders();
		header.add("Cache-Control", "no-cache, no-store, must-revalidate");
		header.add("Pragma", "no-cache");
		header.add("Expires", "0");

		try {
			UserDto dto = new UserDto();
			dto.setPassword(passwordEncoder.encode(userDto.getPassword()));
			dto.setUser(userDto.getUser());
			User usr = userService.findUserByUserName(userDto.getUser());
			if(usr != null) {
				userService.changePassword(passwordEncoder.encode(userDto.getPassword()),userDto.getUser());
			}
			responseEntity = ResponseEntity.ok().build();
		} catch (Exception exception) {
			responseEntity = ECommerceHelper.createErrorEntity(HttpStatus.BAD_REQUEST, exception.getMessage());
		}

		return responseEntity;
	}
	
	@Secured("ROLE_ADMINISTRADOR")
	@GetMapping("/blockUser/{username}")
	public ResponseEntity blockUserByUsername(@PathVariable(value = "username") String username) {
		ResponseEntity responseEntity;
		HttpHeaders header = new HttpHeaders();
		header.add("Cache-Control", "no-cache, no-store, must-revalidate");
		header.add("Pragma", "no-cache");
		header.add("Expires", "0");
		
		try {
			userService.blockUser(username);
			responseEntity = ResponseEntity.ok().build();
		} catch (Exception exception) {
			responseEntity = ECommerceHelper.createErrorEntity(HttpStatus.BAD_REQUEST, exception.getMessage());
		}
		
		return responseEntity;
	}
	
	@Secured("ROLE_ADMINISTRADOR")
	@GetMapping("/unBlockUser/{username}")
	public ResponseEntity unBlockUserByUsername(@PathVariable(value = "username") String username) {
		ResponseEntity responseEntity;
		HttpHeaders header = new HttpHeaders();
		header.add("Cache-Control", "no-cache, no-store, must-revalidate");
		header.add("Pragma", "no-cache");
		header.add("Expires", "0");
		
		try {
			userService.unBlockUser(username);
			responseEntity = ResponseEntity.ok().build();
		} catch (Exception exception) {
			responseEntity = ECommerceHelper.createErrorEntity(HttpStatus.BAD_REQUEST, exception.getMessage());
		}
		
		return responseEntity;
	}
	
	@Secured("ROLE_ADMINISTRADOR")
	@GetMapping("/findById/{id}")
	public ResponseEntity findById(@PathVariable(value = "id") Integer id) {
		ResponseEntity responseEntity;
		HttpHeaders header = new HttpHeaders();
		header.add("Cache-Control", "no-cache, no-store, must-revalidate");
		header.add("Pragma", "no-cache");
		header.add("Expires", "0");
		
		try {
			User user = userService.findById(id);
			responseEntity = ResponseEntity.ok().headers(header)
					.contentType(MediaType.parseMediaType("application/json")).body(ModelMapperUtil.map(user, UserDto.class));
		} catch (Exception exception) {
			responseEntity = ECommerceHelper.createErrorEntity(HttpStatus.BAD_REQUEST, exception.getMessage());
		}
		
		return responseEntity;
	}
	
	@Secured("ROLE_ADMINISTRADOR")
	@PostMapping("/changeUser")
	public ResponseEntity changeUser(@RequestBody UserDto userDto) {
		ResponseEntity responseEntity;
		HttpHeaders header = new HttpHeaders();
		header.add("Cache-Control", "no-cache, no-store, must-revalidate");
		header.add("Pragma", "no-cache");
		header.add("Expires", "0");

		try {
			userService.save(ModelMapperUtil.map(userDto, User.class));
			responseEntity = ResponseEntity.ok().build();
		} catch (Exception exception) {
			responseEntity = ECommerceHelper.createErrorEntity(HttpStatus.BAD_REQUEST, exception.getMessage());
		}

		return responseEntity;
	}
	
	@PostMapping("/loadMoney")
	public ResponseEntity loadMoney(@RequestBody UserDto userDto) {
		ResponseEntity responseEntity;
		HttpHeaders header = new HttpHeaders();
		header.add("Cache-Control", "no-cache, no-store, must-revalidate");
		header.add("Pragma", "no-cache");
		header.add("Expires", "0");

		try {
			userService.save(ModelMapperUtil.map(userDto, User.class));
			responseEntity = ResponseEntity.ok().build();
		} catch (Exception exception) {
			responseEntity = ECommerceHelper.createErrorEntity(HttpStatus.BAD_REQUEST, exception.getMessage());
		}

		return responseEntity;
	}
}
