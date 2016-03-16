package com.codebhatti.kinbech.service;

import java.util.List;

import com.codebhatti.kinbech.domain.Cart;
import com.codebhatti.kinbech.domain.Order;
import com.codebhatti.kinbech.domain.User;
import com.codebhatti.kinbech.exception.BusinessException;

public interface OrderService {
	public List<Order> createOrder(User user, Cart cart) throws BusinessException;
	public boolean processOrder(User user, Cart cart) throws BusinessException;
	public boolean isOrderValid(User user, Order order);
}
