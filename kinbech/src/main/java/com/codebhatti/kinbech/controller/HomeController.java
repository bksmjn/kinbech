package com.codebhatti.kinbech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codebhatti.kinbech.domain.Identity;

@Controller
@RequestMapping(value = "/home")
public class HomeController {

	@Autowired
	private Identity identity;
	
	@RequestMapping(method=RequestMethod.GET)
	public String getWelcomePage(Model model) {
		model.addAttribute("username",identity.getUserName());
		return "home";
	}

	public Identity getIdentity() {
		return identity;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}
	
	

}
