package com.codebhatti.kinbech.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERKINBECH")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ORDER_ID")
	private Long id;

	@Column(name = "BUYER")
	@JoinColumn(name = "username")
	private String buyer;

	@Column(name = "SELLER")
	@JoinColumn(name = "username")
	private String seller;

	@Column(name = "PRODUCT_COPY")
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable
	private List<ProductCopy> productCopy;

	@Column(name = "QUANTITY")
	private Integer quantity;

	@Column(name = "AMOUNT")
	private Double amount;

	public Order() {
		productCopy = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public List<ProductCopy> getProductCopy() {
		return productCopy;
	}

	public void setProductCopy(List<ProductCopy> productCopy) {
		this.productCopy = productCopy;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
}
