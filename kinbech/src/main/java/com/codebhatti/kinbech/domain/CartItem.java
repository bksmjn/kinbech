package com.codebhatti.kinbech.domain;

public class CartItem {
	private Long productId;
	private Integer quantity;
	
	public CartItem() {}
	
	public CartItem(Long productId, Integer quantity) {
		this.productId = productId;
		this.quantity = quantity;
	}

	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartItem [productId=" + productId + ", quantity=" + quantity + "]";
	}
}
