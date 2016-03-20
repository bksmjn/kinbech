package com.codebhatti.kinbech.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codebhatti.kinbech.domain.Cart;
import com.codebhatti.kinbech.domain.CartDetails;
import com.codebhatti.kinbech.domain.CartItem;
import com.codebhatti.kinbech.domain.Product;
import com.codebhatti.kinbech.service.ProductService;

/**
 *This controller is responsible for handling cart related requests
 * @author uoogle
 *
 */
@Controller
public class CartController {
	@Autowired
	private Cart cart;
	@Autowired
	private ProductService productService;
	
	Map<Long, Product> products=new HashMap<>();
	
	/**
	 * @param model Model used to pass cart items to JSP page
	 * @return ViewCart Page
	 */
	@RequestMapping(value="/MyCart", method=RequestMethod.GET)
	
	public String getViewMyCart(Model model) {
		List<CartDetails> cartItemsList=new ArrayList<>();
		Map<Long, CartItem> items = cart.getCartItems();
		Iterator<Long> iterator=items.keySet().iterator();
		while(iterator.hasNext()) {
			Long key=(Long)iterator.next();
			CartItem cartItem=items.get(key);
			
			Product product=productService.findByProductId(cartItem.getProductId());
			CartDetails cart=new CartDetails(product, cartItem.getQuantity());
			cartItemsList.add(cart);
		}
		model.addAttribute("cartItemsList",cartItemsList);
		return "ViewCart";
	}
	
	/**
	 * @param cartItem CartItem obtained via POST
	 * @return Redirection to MyCart Page
	 */
	@RequestMapping(value="/AddToCart", method=RequestMethod.POST)
	public String postAddToCart(@ModelAttribute CartItem cartItem) {
		System.out.println("/AddToCart : "+ cartItem.toString());
		cart.addToCart(cartItem);
		return "redirect:/MyCart";
	}
	
	/**
	 * @param productId Id of the product that is to be removed
	 * @return redirection to MyCart Page
	 */
	@RequestMapping(value="/RemoveFromCart", method=RequestMethod.POST)
	public String postRemoveFromCart(@RequestParam("productId")Long productId) {
		if(cart.containsCartItem(productId)) {
			cart.removeFromCart(productId);
		}
		return "redirect:/MyCart";
	}
}
