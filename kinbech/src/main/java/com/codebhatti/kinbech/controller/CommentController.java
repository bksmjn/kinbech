package com.codebhatti.kinbech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codebhatti.kinbech.domain.Comment;
import com.codebhatti.kinbech.service.CommentService;

@Controller
@RequestMapping(value = "/comment")
public class CommentController {
	
	@Autowired
	CommentService commentService;

	@RequestMapping(value=("/{productId}"),method=RequestMethod.POST)
	public @ResponseBody Comment getComment(@PathVariable("productId")Long productId)
	{
		return commentService.get(productId);
	}
}
