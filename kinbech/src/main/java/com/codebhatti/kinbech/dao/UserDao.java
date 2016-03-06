package com.codebhatti.kinbech.dao;

import java.util.List;

import com.codebhatti.kinbech.domain.User;

public interface UserDao {

	public void addUser(User user);
	public User findByUserName(String userName);
	public List<User> findAllUser();
	public void editUser(User user);
}
