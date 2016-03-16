package com.codebhatti.kinbech.controller;

import java.io.IOException;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codebhatti.kinbech.domain.Product;
import com.codebhatti.kinbech.domain.User;
import com.codebhatti.kinbech.service.CategoryService;
import com.codebhatti.kinbech.service.ProductService;
import com.codebhatti.kinbech.service.UserService;

@Controller
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private UserService userService;
	
	@InitBinder
	public void initBinders(WebDataBinder webDataBinder) {
		webDataBinder.setDisallowedFields("id");
		webDataBinder.setDisallowedFields("categoryId");
	}
	
	@RequestMapping(value={"/{category}"}, method=RequestMethod.GET)
	public String getListProducts(@PathVariable("category") String category, Model model) {
		return "home";
	}
	
	@RequestMapping(value="/ProductDetail", method=RequestMethod.GET) 
	public String getProductDetailPage(@ModelAttribute("productdetail")Product product,
			Model model) {
		System.out.println("getProductDetailPage()");
		return "ProductDetail";
	}
	
	@RequestMapping(value={"/Add"}, method=RequestMethod.GET)
	public String getAddProductPage(@ModelAttribute("newProduct")Product newProduct,
			Model model) {
		model.addAttribute("categories", categoryService.getAllCategories());
		return "AddProduct";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String postAddProductPage(@ModelAttribute("newProduct")Product newProduct,
			BindingResult bindingResult, RedirectAttributes redirectAttributes, Principal principal) throws IllegalStateException, IOException {
		System.out.println("postAddProductPage="+newProduct.getProductAsString());
		User user = userService.findByUserName(principal.getName());
		newProduct.setSellerId(user.getUserName());
		Product savedProduct = productService.saveOrUpdate(newProduct);
		redirectAttributes.addFlashAttribute("product", savedProduct);
		System.out.println("savedProduct="+savedProduct.getProductAsString());
		return "redirect:/products/ProductDetail";
	}
}
