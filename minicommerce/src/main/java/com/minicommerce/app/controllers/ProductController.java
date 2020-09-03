package com.minicommerce.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.minicommerce.app.helpers.ECommerceHelper;
import com.minicommerce.app.models.dtos.ProductDto;
import com.minicommerce.app.models.entity.Product;
import com.minicommerce.app.models.service.IProductService;
import com.minicommerce.app.util.ModelMapperUtil;

@Controller
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private IProductService productService;
	
	@Secured("ROLE_EMPLEADO")
	@GetMapping("/findAll")
	public ResponseEntity findAllProducts() {
		ResponseEntity responseEntity;
		HttpHeaders header = new HttpHeaders();
		header.add("Cache-Control", "no-cache, no-store, must-revalidate");
		header.add("Pragma", "no-cache");
		header.add("Expires", "0");
		
		try {
			List<Product> lstProduct = productService.findAll();
			responseEntity = ResponseEntity.ok().headers(header)
					.contentType(MediaType.parseMediaType("application/json")).body(ModelMapperUtil.mapColletion(lstProduct, ProductDto.class));
		} catch (Exception exception) {
			responseEntity = ECommerceHelper.createErrorEntity(HttpStatus.BAD_REQUEST, exception.getMessage());
		}
		
		return responseEntity;
	}
	
	@PostMapping("/createProduct")
	public ResponseEntity createProduct(@RequestBody ProductDto productDto) {
		ResponseEntity responseEntity;
		HttpHeaders header = new HttpHeaders();
		header.add("Cache-Control", "no-cache, no-store, must-revalidate");
		header.add("Pragma", "no-cache");
		header.add("Expires", "0");

		try {
			productService.save(ModelMapperUtil.map(productDto, Product.class));
			responseEntity = ResponseEntity.ok().build();
		} catch (Exception exception) {
			responseEntity = ECommerceHelper.createErrorEntity(HttpStatus.BAD_REQUEST, exception.getMessage());
		}

		return responseEntity;
	}
	
	@PostMapping("/editProduct")
	public ResponseEntity editProduct(@RequestBody ProductDto productDto) {
		ResponseEntity responseEntity;
		HttpHeaders header = new HttpHeaders();
		header.add("Cache-Control", "no-cache, no-store, must-revalidate");
		header.add("Pragma", "no-cache");
		header.add("Expires", "0");

		try {
			productService.save(ModelMapperUtil.map(productDto, Product.class));
			responseEntity = ResponseEntity.ok().build();
		} catch (Exception exception) {
			responseEntity = ECommerceHelper.createErrorEntity(HttpStatus.BAD_REQUEST, exception.getMessage());
		}

		return responseEntity;
	}
	
}
