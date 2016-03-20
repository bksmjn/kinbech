package com.codebhatti.kinbech.service;

import com.codebhatti.kinbech.domain.Account;

public interface AccountService {
	/**
	 * @param account This is the account id that the deduction is going to be made on
	 * @param amount This is the amount to be deducted
	 * @return Returns the account on which deduction was made
	 */
	public Account deductBalance(Account account, Double amount);
	
	/**
	 * @param account This is the account id ,the increment is going to be made
	 * @param amount The amount that will be added to account
	 * @return Returns the account on which addition was made
	 */
	public Account addBalance(Account account, Double amount);
	
	/**
	 * @param id The id of the account
	 * @return Returns the Account associated with Id
	 */
	public Account findAccountById(Long id);
	
	/**
	 * @param id The id of account which is going to be checked if Active or not
	 * @return Returns true if the account is active else false
	 */
	public boolean isAccountActive(Long id);
	
	/**
	 * @param id The id of the account which if going to be checked for balance sufficiency
	 * @param amount The amount which is being checked on the account
	 * @return returns true if the account associated with id has the more than or equal balance than the amount supplied
	 */
	public boolean hasSufficientBalance(Long id, Double amount);
}
