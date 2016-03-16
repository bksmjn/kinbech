package com.codebhatti.kinbech.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.codebhatti.kinbech.domain.Identity;
import com.codebhatti.kinbech.domain.User;
import com.codebhatti.kinbech.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private Identity identity;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getUserForm(@ModelAttribute("user") User user, Model model) {
		System.out.println("UserName" + identity.getUserName());
		return "UserAdd";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
		if (result.hasErrors()) {
			return "UserAdd";
		}
		user.setPassword(Base64.encodeBase64String(DigestUtils.sha256(user.getPassword())));
		this.userService.addUser(user);
		return "redirect:/users/list";

	}

	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String getUserList(Model model) {
		List<User> users = userService.findAllUser();
		model.addAttribute("users", users);
		return "UserList";
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public Identity getIdentity() {
		return identity;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}

}
