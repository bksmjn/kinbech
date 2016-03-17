package com.codebhatti.kinbech.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;

import com.codebhatti.kinbech.domain.Identity;
import com.codebhatti.kinbech.exception.BusinessException;

@ControllerAdvice
public class GlobalInterceptor {
	
	//@Autowired
	///Identity identity;
	
	
	@InitBinder
	public void initBinder(WebDataBinder binders) {
		
	//	model.addAttribute("username", identity==null?"":identity.getUserName());
		
	}
	
	@ExceptionHandler(value=BusinessException.class)
	public ModelAndView handleException(
			HttpServletRequest servletRequest
			,BusinessException businessException
			){
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("ErrorPage");
		modelAndView.addObject("errorMessage", businessException.getErrorMessage());
		
		return modelAndView;
		
	}
	
	/*@ExceptionHandler(value=RuntimeException.class)
	public ModelAndView handleRuntimeException(
			HttpServletRequest servletRequest
			,RuntimeException businessException
			){
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("ErrorPage");
		modelAndView.addObject("errorMessage", "OOPS!! please take a nap and come again!!");
		
		return modelAndView;
		
	}*/
}
