package com.codebhatti.kinbech.controller;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.codebhatti.kinbech.domain.User;
import com.codebhatti.kinbech.service.CredentialService;
import com.codebhatti.kinbech.service.UserService;

@Controller
@RequestMapping("/users")
@SessionAttributes("newuser")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired CredentialService credentialService;
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String getUserForm(@ModelAttribute("user") User user, @ModelAttribute("address") Address address, Model model){
		model.addAttribute("newuser", user);
		return "UserAdd";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addUser(@ModelAttribute("user") User user, BindingResult result){
		String hashedPassword=Base64.encodeBase64String(DigestUtils.sha256(user.getPassword()));
			Credential credential=new Credential(user.getUserName(), hashedPassword);
			this.userService.addUser(user);

	}
	
	@RequestMapping(value="/addAddress",method=RequestMethod.POST)
	public String addAddress(@RequestBody @ModelAttribute("address") Address address, BindingResult result, SessionStatus status, Model model){
		User u=(User)((ModelMap) model).get("newuser");
		u.getAddresses().add(address);
		System.out.println("Inside Add Address"+u.getAddresses().size());
		return "UserAdd";
		
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
