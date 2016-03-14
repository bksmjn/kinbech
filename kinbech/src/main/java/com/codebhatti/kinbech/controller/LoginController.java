package com.codebhatti.kinbech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codebhatti.kinbech.domain.User;

@Controller
public class LoginController {
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage(@ModelAttribute("user") User user) {
		return "login";
	}

	@RequestMapping(value = "/LoginFailed", method = RequestMethod.GET)
	public String processLogin(@ModelAttribute("user") User user) {
		return "login";
	}
}