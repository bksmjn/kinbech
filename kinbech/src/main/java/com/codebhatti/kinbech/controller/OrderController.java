package com.codebhatti.kinbech.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codebhatti.kinbech.domain.Cart;
import com.codebhatti.kinbech.domain.User;
import com.codebhatti.kinbech.exception.BusinessException;
import com.codebhatti.kinbech.service.OrderService;
import com.codebhatti.kinbech.service.ProductCopyService;
import com.codebhatti.kinbech.service.UserService;

@Controller
@RequestMapping(value="/Order")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductCopyService productCopyService;
	
	@Autowired
	private Cart cart;
	
	@RequestMapping(value="/Checkout", method=RequestMethod.GET)
	public String getProcessOrder() {
		return "CheckOut";
	}
	
	@RequestMapping(value="/Checkout", method=RequestMethod.POST)
	public String postProcessOrder(Principal principal, RedirectAttributes redirectAttributes) throws BusinessException {
		System.out.println(principal.getName());
		User user = userService.findByUserName(principal.getName());
		Boolean success=orderService.processOrder(user, cart);
		redirectAttributes.addFlashAttribute("success", success);
		return "redirect:/Order/Checkout";
	}

}
