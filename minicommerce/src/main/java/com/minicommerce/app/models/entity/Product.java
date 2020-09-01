package com.minicommerce.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.minicommerce.app.models.enums.StatusProduct;
import com.sun.istack.NotNull;

@Entity
@Table(name = "products")
public class Product implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productid;
	
	@NotNull
	@Size(min = 1, max = 100)
	private String name;
	
	@NotNull
	@Size(min = 1, max = 280)
	private String description;
	
	@NotNull
	@Min(value = 1)
	private Double baseprice;
	
	@NotNull
	@Min(value = 0)
	@Max(value = 1)
	private Double taxrate;
	
	@Enumerated(EnumType.STRING)
	private StatusProduct productstatus;
	
	@NotNull
	@Min(value = 0)
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;

}
