package com.codebhatti.kinbech.validation;

import com.codebhatti.kinbech.domain.Order;
import com.codebhatti.kinbech.domain.User;

public interface OrderValidator {
	public boolean validateQuantity(Order order);
	public boolean validateUserAccountBalance(User user, Order order);
	public boolean validateUserStatus(User user);
}
