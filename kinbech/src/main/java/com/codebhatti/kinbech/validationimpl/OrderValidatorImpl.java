package com.codebhatti.kinbech.validationimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codebhatti.kinbech.domain.Order;
import com.codebhatti.kinbech.domain.User;
import com.codebhatti.kinbech.service.AccountService;
import com.codebhatti.kinbech.service.OrderService;
import com.codebhatti.kinbech.service.ProductCopyService;
import com.codebhatti.kinbech.validation.OrderValidator;

@Component
public class OrderValidatorImpl implements OrderValidator {

	@Autowired
	private AccountService accountService;

	@Autowired
	private ProductCopyService productCopyService;

	@Override
	public boolean validateQuantity(Order order) {
		return productCopyService.getTotalAvailableQuantity(
				order.getProductCopy().get(0).getProduct()) >= order.getQuantity();
	}

	@Override
	public boolean validateUserAccountBalance(User user, Order order) {
		return accountService.hasSufficientBalance(user.getAccount().getAccountId(), order.getAmount());
	}

	@Override
	public boolean validateUserStatus(User user) {
		return accountService.isAccountActive(user.getAccount().getAccountId());
	}
}
