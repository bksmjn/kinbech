package com.codebhatti.kinbech.service;

import com.codebhatti.kinbech.domain.Account;

public interface AccountService {
	public Account deductBalance(Account account, Double amount);
	public Account addBalance(Account account, Double amount);
	public Account findAccountById(Long id);
	public boolean isAccountActive(Long id);
	public boolean hasSufficientBalance(Long id, Double amount);
}
