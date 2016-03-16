package com.codebhatti.kinbech.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class Cart {
	private Map<Long,CartItem> cartItems;
	
	public Cart() {
		cartItems=new HashMap<>();
	}
	
	public void initialize() {
		cartItems=new HashMap<>();
	}

	public Map<Long, CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Map<Long, CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	
	public void addToCart(CartItem cartItem) {
		this.cartItems.put(cartItem.getProductId(), cartItem);
	}
	
	public void removeFromCart(Long productId) {
		this.cartItems.remove(productId);
	}
	
	public boolean containsCartItem(Long productId) {
		return this.cartItems.containsKey(productId);
	}
}
