package com.codebhatti.kinbech.service;

import com.codebhatti.kinbech.domain.Order;
import com.codebhatti.kinbech.domain.User;
import com.codebhatti.kinbech.exception.BusinessException;

public interface OrderService {
	public Order makeOrder(User user, Order order) throws BusinessException;
	
	public boolean isOrderValid(User user, Order order);
}
