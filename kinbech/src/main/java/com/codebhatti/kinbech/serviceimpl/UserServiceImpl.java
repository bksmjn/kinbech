package com.codebhatti.kinbech.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.codebhatti.kinbech.domain.User;
import com.codebhatti.kinbech.repository.UserRepository;
import com.codebhatti.kinbech.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	
	
}
