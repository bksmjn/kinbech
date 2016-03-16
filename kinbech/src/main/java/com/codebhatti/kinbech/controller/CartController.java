package com.codebhatti.kinbech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codebhatti.kinbech.domain.Cart;
import com.codebhatti.kinbech.domain.CartItem;

@Controller
public class CartController {
	@Autowired
	private Cart cart;
	
	@RequestMapping(value="/MyCart", method=RequestMethod.GET)
	public String getViewMyCart(Model model) {
		model.addAttribute("myCart", cart);
		return "ViewCart";
	}
	
	@RequestMapping(value="/AddToCart", method=RequestMethod.POST)
	public String postAddToCart(@ModelAttribute CartItem cartItem) {
		System.out.println("/AddToCart : "+ cartItem.toString());
		cart.addToCart(cartItem);
		return "redirect:/MyCart";
	}
	
	@RequestMapping(value="/RemoveFromCart", method=RequestMethod.POST)
	public String postRemoveFromCart(@RequestParam("productId")Long productId) {
		if(cart.containsCartItem(productId)) {
			cart.removeFromCart(productId);
		}
		return "redirect:/MyCart";
	}
}
