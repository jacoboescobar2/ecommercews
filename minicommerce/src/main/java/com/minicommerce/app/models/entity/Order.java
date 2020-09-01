package com.minicommerce.app.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.minicommerce.app.models.enums.StatusOrder;

@Entity
@Table(name = "orders")
public class Order implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	
	private Double discount;
	
	@Enumerated(EnumType.STRING)
	private StatusOrder statusOrder;
	
	@OneToMany(fetch= FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="order_id")
	private List<ItemOrder> items;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<ItemOrder> getItems() {
		return items;
	}

	public void setItems(List<ItemOrder> items) {
		this.items = items;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public StatusOrder getStatusOrder() {
		return statusOrder;
	}

	public void setStatusOrder(StatusOrder statusOrder) {
		this.statusOrder = statusOrder;
	}


	private static final long serialVersionUID = 1L;
}
