package com.codebhatti.kinbech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/home")
public class HomeController {
	
	
	public String getWelcomePage(){
		return "home";
	}

}
