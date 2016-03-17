package com.codebhatti.kinbech.controller;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
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
	
	public ProductController(){
		System.out.println("Inside Product Controller");
	}
	
//	@InitBinder
//	public void initBinders(WebDataBinder webDataBinder) {
//		webDataBinder.setDisallowedFields("id");
//		webDataBinder.setDisallowedFields("categoryId");
//	}
	
	@RequestMapping(value={"/{category}"}, method=RequestMethod.GET)
	public String getListProducts(@PathVariable("category") String category, Model model) {
		return "home";
	}
	
	@RequestMapping(value="/ProductDetail", method=RequestMethod.GET) 
	public String getProductDetailPage(Product product,HttpServletRequest request,
			Model model) {
		Object prodObj=request.getSession().getAttribute("product");
		request.getSession().removeAttribute("product");
		model.addAttribute("product", prodObj);
		System.out.println("getProductDetailPage()");
		return "ProductDetail";
	}
	
	@RequestMapping(value="/Add", method=RequestMethod.GET)
	public String getAddProductPage(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("categories", categoryService.getAllCategories());
		return "AddProduct";
	}
	
	@RequestMapping(value="/Add", method=RequestMethod.POST)
	public String postAddProductPage(@ModelAttribute("product") Product newProduct,
			BindingResult bindingResult, RedirectAttributes redirectAttributes, Principal principal,
			Model model, HttpServletRequest request) throws IllegalStateException, IOException {
		String root=request.getServletContext().getRealPath("/");
		System.out.println("postAddProductPage="+newProduct.getProductAsString());
		User user = userService.findByUserName(principal.getName());
		newProduct.setSellerId(user.getUserName());
		Product savedProduct = productService.saveOrUpdate(newProduct);
		//model.addAttribute("product", savedProduct);
		request.getSession().setAttribute("product", savedProduct);
		//redirectAttributes.addAttribute("productId", savedProduct.getProductId()+"");
		System.out.println("savedProduct="+savedProduct.getProductAsString());
		//return "ProductDetail";
		return "redirect:/products/ProductDetail";
	}
}
