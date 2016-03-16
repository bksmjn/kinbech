package com.codebhatti.kinbech.controller;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.codebhatti.kinbech.domain.Address;
import com.codebhatti.kinbech.domain.Credential;
import com.codebhatti.kinbech.domain.Identity;
import com.codebhatti.kinbech.domain.User;
import com.codebhatti.kinbech.service.CredentialService;
import com.codebhatti.kinbech.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired CredentialService credentialService;
	@Autowired
	private Identity identity;
	
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String getUserForm(@ModelAttribute("user") User user, Model model){
		System.out.println("UserName"+identity.getUserName());
		return "UserAdd";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addUser(@ModelAttribute("user") User user, BindingResult result){
		String hashedPassword=Base64.encodeBase64String(DigestUtils.sha256(user.getPassword()));
			Credential credential=new Credential(user.getUserName(), hashedPassword);
			this.userService.addUser(user);
			this.credentialService.save(credential);

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
