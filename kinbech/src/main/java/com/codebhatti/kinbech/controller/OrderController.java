package com.codebhatti.kinbech.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codebhatti.kinbech.domain.Order;
import com.codebhatti.kinbech.domain.User;
import com.codebhatti.kinbech.exception.BusinessException;
import com.codebhatti.kinbech.service.OrderService;
import com.codebhatti.kinbech.service.UserService;

@Controller
@RequestMapping(value="/Order")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/Process", method=RequestMethod.GET)
	public String getProcessOrder() {
		return "ProcessOrder";
	}
	
	@RequestMapping(value="/Process", method=RequestMethod.POST)
	public String postProcessOrder(Order order, RedirectAttributes redirectAttributes, 
			Principal principal) throws BusinessException {
		User user = userService.findByUserName(principal.getName());
		orderService.makeOrder(user, order);
		return "redirect:/Order/Process";
	}

}
