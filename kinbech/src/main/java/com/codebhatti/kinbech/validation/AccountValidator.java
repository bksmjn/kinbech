package com.codebhatti.kinbech.validation;

import com.codebhatti.kinbech.domain.User;

public interface AccountValidator {
	public boolean isBalanceSufficient(User user, Double amount);
	public boolean validateAddBalance(User user, Double amount);
	public boolean isAccountActive(User user);
}
