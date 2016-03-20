package com.codebhatti.kinbech.service;

import java.util.List;

import com.codebhatti.kinbech.domain.User;

/**
 * @author Bikesh Maharjan
 *
 */
public interface UserService {
	
	/**
	 * @param user The user that is to be added 
	 */
	public void addUser(User user);
	
	/**
	 * @param userName The username which is being searched
	 * @return The user object associated with username
	 */
	public User findByUserName(String userName);
	
	/**
	 * @return returns list of all users in the system
	 */
	public List<User> findAllUser();
	
	/**
	 * @param user The user from which balance is going to be deducted from
	 * @param balance The amount that is going to be deducted
	 * @return The user object on which deduction is made
	 */
	public User deductBalance(User user, Double balance);
	/**
	 * @param user The user on which balance is going to be added
	 * @param balance The amount that is going to be added
	 * @return The user object on which addition is made
	 */
	public User addBalance(User user, Double balance);
}
