package com.codebhatti.kinbech.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codebhatti.kinbech.domain.User;
import com.codebhatti.kinbech.repository.UserRepository;
import com.codebhatti.kinbech.service.UserService;
import com.codebhatti.kinbech.validation.UserValidator;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserValidator userValidator;

	@Override
	public void addUser(User user) {
		try{
			this.userRepository.save(user);
		}catch(IllegalArgumentException ex){
			throw new IllegalArgumentException(ex.getMessage());
		}
		
		
	}

	@Override
	public User findByUserName(String userName) {
		return this.userRepository.findOne(userName);
	}

	@Override
	public List<User> findAllUser() {
		return (List<User>)this.userRepository.findAll();
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User deductBalance(User user, Double balance) {
		return null;
	}

	@Override
	public User addBalance(User user, Double balance) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
