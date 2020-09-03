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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.minicommerce.app.helpers.ECommerceHelper;
import com.minicommerce.app.models.dtos.ProductDto;
import com.minicommerce.app.models.entity.Product;
import com.minicommerce.app.models.enums.StatusProduct;
import com.minicommerce.app.models.service.IProductService;
import com.minicommerce.app.util.ModelMapperUtil;

@Controller
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private IProductService productService;
	
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
	
	@Secured({"ROLE_ADMINISTRADOR","ROLE_EMPLEADO"})
	@GetMapping("/findById/{id}")
	public ResponseEntity findById(@PathVariable(value = "id") Integer id) {
		ResponseEntity responseEntity;
		HttpHeaders header = new HttpHeaders();
		header.add("Cache-Control", "no-cache, no-store, must-revalidate");
		header.add("Pragma", "no-cache");
		header.add("Expires", "0");
		
		try {
			Product product = productService.findById(id);
			responseEntity = ResponseEntity.ok().headers(header)
					.contentType(MediaType.parseMediaType("application/json")).body(ModelMapperUtil.map(product, ProductDto.class));
		} catch (Exception exception) {
			responseEntity = ECommerceHelper.createErrorEntity(HttpStatus.BAD_REQUEST, exception.getMessage());
		}
		
		return responseEntity;
	}
	
	@GetMapping("/findById")
	public ResponseEntity findByName(@RequestParam(value = "name") String name) {
		ResponseEntity responseEntity;
		HttpHeaders header = new HttpHeaders();
		header.add("Cache-Control", "no-cache, no-store, must-revalidate");
		header.add("Pragma", "no-cache");
		header.add("Expires", "0");
		
		try {
			List<Product> lstProduct = productService.findProducByName(name);
			responseEntity = ResponseEntity.ok().headers(header)
					.contentType(MediaType.parseMediaType("application/json")).body(ModelMapperUtil.mapColletion(lstProduct, ProductDto.class));
		} catch (Exception exception) {
			responseEntity = ECommerceHelper.createErrorEntity(HttpStatus.BAD_REQUEST, exception.getMessage());
		}
		
		return responseEntity;
	}
	
	@Secured({"ROLE_ADMINISTRADOR","ROLE_EMPLEADO"})
	@PostMapping("/createProduct")
	public ResponseEntity createProduct(@RequestBody ProductDto productDto) {
		ResponseEntity responseEntity;
		HttpHeaders header = new HttpHeaders();
		header.add("Cache-Control", "no-cache, no-store, must-revalidate");
		header.add("Pragma", "no-cache");
		header.add("Expires", "0");

		try {
			productDto.setProductstatus(StatusProduct.PUBLICADO);
			productService.save(ModelMapperUtil.map(productDto, Product.class));
			responseEntity = ResponseEntity.ok().build();
		} catch (Exception exception) {
			responseEntity = ECommerceHelper.createErrorEntity(HttpStatus.BAD_REQUEST, exception.getMessage());
		}

		return responseEntity;
	}
	
	@Secured({"ROLE_ADMINISTRADOR","ROLE_EMPLEADO"})
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
	
	@Secured({"ROLE_ADMINISTRADOR","ROLE_EMPLEADO"})
	@PostMapping("/deleteProduct")
	public ResponseEntity deleteProduct(@RequestBody ProductDto productDto) {
		ResponseEntity responseEntity;
		HttpHeaders header = new HttpHeaders();
		header.add("Cache-Control", "no-cache, no-store, must-revalidate");
		header.add("Pragma", "no-cache");
		header.add("Expires", "0");

		try {
			productService.delete(ModelMapperUtil.map(productDto, Product.class));
			responseEntity = ResponseEntity.ok().build();
		} catch (Exception exception) {
			responseEntity = ECommerceHelper.createErrorEntity(HttpStatus.BAD_REQUEST, exception.getMessage());
		}

		return responseEntity;
	}
	
}
