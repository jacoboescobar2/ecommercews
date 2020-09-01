package com.minicommerce.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.minicommerce.app.helpers.ECommerceHelper;
import com.minicommerce.app.models.dtos.OrderDto;
import com.minicommerce.app.models.entity.Order;
import com.minicommerce.app.models.service.IOrderService;
import com.minicommerce.app.util.ModelMapperUtil;

@Controller
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private IOrderService orderService;
	
	@PostMapping("/createOrder")
	public ResponseEntity createOrder(@RequestBody OrderDto orderDto) {
		ResponseEntity responseEntity;
		HttpHeaders header = new HttpHeaders();
		header.add("Cache-Control", "no-cache, no-store, must-revalidate");
		header.add("Pragma", "no-cache");
		header.add("Expires", "0");

		try {
			OrderDto newOrder = new OrderDto();
			newOrder.setItems(orderDto.getItems());
			newOrder.setStatusOrder(orderDto.getStatusOrder());
			newOrder.setUser(orderDto.getUser());
			boolean discount = false;
			int countOrder = orderService.countOrdersByIdUser(orderDto.getUser().getId());
			if(countOrder > 0) {
				discount = applyDiscount(countOrder);
			}
			if(discount) {
				newOrder.setDiscount(0.10);
			}else {
				newOrder.setDiscount(0.0);
			}
			orderService.save(ModelMapperUtil.map(newOrder, Order.class));
			responseEntity = ResponseEntity.ok().build();
		} catch (Exception exception) {
			responseEntity = ECommerceHelper.createErrorEntity(HttpStatus.BAD_REQUEST, exception.getMessage());
		}

		return responseEntity;
	}
	
	private boolean applyDiscount(int count) {
		int discount = count%3;
		if(discount == 0) {
			return true;
		}
		return false;
	}
	
	
}
