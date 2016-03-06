package com.codebhatti.kinbech.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.codebhatti.kinbech.dao.UserDao;
import com.codebhatti.kinbech.domain.User;


@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public UserDaoImpl(){
		
	}

	@Override
	public void addUser(User user) {
		if(user==null || user.getUserName().equals("")){
			throw new IllegalArgumentException("User is Null");
		}
		this.sessionFactory.getCurrentSession().persist(user);
		
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

	@Override
	public void editUser(User user) {
		if(user==null||this.findByUserName(user.getUserName())==null){
			throw new IllegalArgumentException("User is Null");
		}
		this.sessionFactory.getCurrentSession().merge(user);
		
	}

}
