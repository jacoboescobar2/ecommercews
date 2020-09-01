package com.minicommerce.app.models.dtos;

public class ItemOrderDto {

	private Integer id;
	private Integer quantity;
	private ProductDto producto;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public ProductDto getProducto() {
		return producto;
	}
	public void setProducto(ProductDto producto) {
		this.producto = producto;
	}
}
