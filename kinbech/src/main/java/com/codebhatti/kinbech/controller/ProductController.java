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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.codebhatti.kinbech.domain.Product;
import com.codebhatti.kinbech.domain.User;
import com.codebhatti.kinbech.service.CategoryService;
import com.codebhatti.kinbech.service.CommentService;
import com.codebhatti.kinbech.service.ProductService;
import com.codebhatti.kinbech.service.UserService;

/**
 * @author Tek Ale
 *
 */
@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CommentService commentService;
	
	public ProductController(){
		System.out.println("Inside Product Controller");
	}
	
//	@InitBinder
//	public void initBinders(WebDataBinder webDataBinder) {
//		webDataBinder.setDisallowedFields("id");
//		webDataBinder.setDisallowedFields("categoryId");
//	}
	
	@RequestMapping(value={"","/"}, method=RequestMethod.GET)
	public String getAllProducts(Model model){
		model.addAttribute("products",productService.getAllProducts());
		return "ProductList";
	}
	
	@RequestMapping(value={"/{category}"}, method=RequestMethod.GET)
	public String getListProducts(@PathVariable("category") String category, Model model) {
		return "home";
	}
	
	/** display the user the Product Detail page
	 * @param productId the id of the product whose detail is needed
	 * @param request
	 * @param model
	 * @return the string representing the Product Detail view
	 */
	@RequestMapping(value="/ProductDetail", method=RequestMethod.GET) 
	public String getProductDetailPage(@RequestParam("productId")Long productId,HttpServletRequest request,
			Model model) {
		System.out.println("productId="+productId);
		if(productId!=null) {
			
			Product prod = productService.findByProductId(productId);
			model.addAttribute("product", prod);
			model.addAttribute("comment",commentService.get(productId));
			System.out.println(commentService.get(productId));
			System.out.println(prod.getProductCopyList());
		} else {
			Object prodObj=request.getSession().getAttribute("product");
			request.getSession().removeAttribute("product");
			model.addAttribute("product", prodObj);
			model.addAttribute("comment",commentService.get(productId));
			System.out.println(commentService.get(productId));
		}
		return "ProductDetail";
	}
	
	@RequestMapping(value="/Add", method=RequestMethod.GET)
	public String getAddProductPage(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("categories", categoryService.getAllCategories());
		return "AddProduct";
	}
	
	/** Add a new product detail
	 * @param newProduct bind form data to this field
	 * @param bindingResult hold if there are any validation errors in the binding
	 * @param redirectAttributes 
	 * @param principal to get username from session
	 * @param model
	 * @param request 
	 * @return string redirecting the user to Product Detail page
	 * @throws IllegalStateException
	 * @throws IOException
	 */
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
		return "redirect:/products/ProductDetail?productId="+savedProduct.getProductId();
	}
}
