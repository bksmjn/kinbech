package com.codebhatti.kinbech.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.codebhatti.kinbech.domain.User;
import com.codebhatti.kinbech.service.UserService;

@Controller
@RequestMapping(value="/users")
public class UserController {
	
	@Autowired
	private UserService  userService;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String getUserAddForm(@ModelAttribute("user")User user){
		return "login";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public void addUser(@ModelAttribute("user")User user,BindingResult result){
		try{
			this.userService.addUser(user);
		}catch(IllegalArgumentException ex){
			throw new IllegalArgumentException(ex.getMessage());
		}
		
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	

}
