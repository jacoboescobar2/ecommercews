package com.minicommerce.app.models.dtos;

import com.minicommerce.app.models.enums.StatusProduct;

public class ProductDto {

	private Integer productid;
	private String name;
	private String description;
	private Double baseprice;
	private Double taxrate;
	private StatusProduct productstatus;
	private Integer inventoryquantity;
	
	public Integer getProductid() {
		return productid;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getBaseprice() {
		return baseprice;
	}
	public void setBaseprice(Double baseprice) {
		this.baseprice = baseprice;
	}
	public Double getTaxrate() {
		return taxrate;
	}
	public void setTaxrate(Double taxrate) {
		this.taxrate = taxrate;
	}
	public StatusProduct getProductstatus() {
		return productstatus;
	}
	public void setProductstatus(StatusProduct productstatus) {
		this.productstatus = productstatus;
	}
	public Integer getInventoryquantity() {
		return inventoryquantity;
	}
	public void setInventoryquantity(Integer inventoryquantity) {
		this.inventoryquantity = inventoryquantity;
	}
	
	

}
