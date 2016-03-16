package com.codebhatti.kinbech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codebhatti.kinbech.domain.User;

@Controller
public class LoginController {
	@RequestMapping(value = {"","/login"}, method = RequestMethod.GET)
	public String getLoginPage(@ModelAttribute("user") User user) {
		return "login";
	}


	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(Model model) {
 
		model.addAttribute("error", "true");
		return "login";
 
	}
	
	@RequestMapping(value="/doLogout", method=RequestMethod.GET)
	public String doLogout(){
		return "login";
	}
}
