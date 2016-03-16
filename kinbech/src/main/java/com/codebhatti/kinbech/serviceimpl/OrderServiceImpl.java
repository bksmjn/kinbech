package com.codebhatti.kinbech.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codebhatti.kinbech.domain.Order;
import com.codebhatti.kinbech.domain.User;
import com.codebhatti.kinbech.exception.BusinessException;
import com.codebhatti.kinbech.repository.OrderRepository;
import com.codebhatti.kinbech.service.AccountService;
import com.codebhatti.kinbech.service.OrderService;
import com.codebhatti.kinbech.validation.OrderValidator;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private OrderValidator orderValidator;
	
	@Override
	public Order makeOrder(User user, Order order) throws BusinessException {
		if(isOrderValid(user, order))
			return orderRepository.save(order);
		else 
			throw new BusinessException("Order details is not valid");
	}

	@Override
	public boolean isOrderValid(User user, Order order) {
		return (orderValidator.validateQuantity(order) && 
				orderValidator.validateUserAccountBalance(user, order) &&
				orderValidator.validateUserStatus(user));
	}	
}
