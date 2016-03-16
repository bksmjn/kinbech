package com.codebhatti.kinbech.validationimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codebhatti.kinbech.domain.User;
import com.codebhatti.kinbech.service.AccountService;
import com.codebhatti.kinbech.validation.AccountValidator;

@Component
public class AccountValidatorImpl implements AccountValidator {
	private final Double MAX_TOPUP_BALANCE = 3000.0;
	
	@Autowired
	private AccountService accountService;

	@Override
	public boolean isBalanceSufficient(User user, Double amount) {
		return accountService.hasSufficientBalance(user.getAccount().getAccountId(), amount);
	}

	@Override
	public boolean validateAddBalance(User user, Double amount) {
		return amount <= MAX_TOPUP_BALANCE;
	}

	@Override
	public boolean isAccountActive(User user) {
		return accountService.isAccountActive(user.getAccount().getAccountId());
	}
}
