package com.codebhatti.kinbech.service;

import java.util.List;

import com.codebhatti.kinbech.domain.User;

public interface UserService {
	
	public void addUser(User user);
	
	public User findByUserName(String userName);
	
	public List<User> findAllUser();
	
}
