package com.codebhatti.kinbech.service;

import java.util.List;

import com.codebhatti.kinbech.domain.Cart;
import com.codebhatti.kinbech.domain.Order;
import com.codebhatti.kinbech.domain.User;
import com.codebhatti.kinbech.exception.BusinessException;

/**
 * @author Tek Ale
 *
 */
public interface OrderService {
	/**
	 * @param user the user whose cart is being updated
	 * @param cart the cart object created for the user
	 * @return returns the list of 
	 * @throws BusinessException
	 */
	public List<Order> createOrder(User user, Cart cart) throws BusinessException;
	/**
	 * @param user the user whose cart is to be processed
	 * @param cart the cart of the user that is to be processed
	 * @return the true/false acknowledgement after processing 
	 * @throws BusinessException
	 */
	public boolean processOrder(User user, Cart cart) throws BusinessException;
	/**
	 * @param user the user whose order is to be checked for validity
	 * @param order the order which is to be checked for validity
	 * @return true/false value
	 */
	public boolean isOrderValid(User user, Order order);
}
