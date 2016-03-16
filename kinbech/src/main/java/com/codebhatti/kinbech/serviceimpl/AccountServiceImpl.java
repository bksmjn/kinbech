package com.codebhatti.kinbech.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codebhatti.kinbech.domain.Account;
import com.codebhatti.kinbech.repository.AccountRepository;
import com.codebhatti.kinbech.service.AccountService;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Account deductBalance(Account account, Double amount) {
		return null;
	}

	@Override
	public Account addBalance(Account account, Double amount) {
		return null;
	}

	@Override
	public Account findAccountById(Long id) {
		return accountRepository.findOne(id);
	}

	@Override
	public boolean isAccountActive(Long id) {
		return findAccountById(id).isActive();
	}

	@Override
	public boolean hasSufficientBalance(Long id, Double amount) {
		return ((findAccountById(id).getBalance() - amount) >= 0);
	}
}
