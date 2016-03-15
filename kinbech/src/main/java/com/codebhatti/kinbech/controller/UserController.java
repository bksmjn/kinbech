package com.codebhatti.kinbech.controller;

import java.security.MessageDigest;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.codebhatti.kinbech.domain.Credential;
import com.codebhatti.kinbech.domain.User;
import com.codebhatti.kinbech.service.CredentialService;
import com.codebhatti.kinbech.service.UserService;

@Controller
@Transactional
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired CredentialService credentialService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addUser(@ModelAttribute("user") User user, BindingResult result){
		String hashedPassword=Base64.encodeBase64String(DigestUtils.sha256(user.getPassword()));
			Credential credential=new Credential(user.getUserName(), hashedPassword);
			this.userService.addUser(user);

	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
