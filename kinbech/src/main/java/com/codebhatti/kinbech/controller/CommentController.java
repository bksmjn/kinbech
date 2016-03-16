package com.codebhatti.kinbech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.codebhatti.kinbech.domain.Comment;
import com.codebhatti.kinbech.domain.Identity;
import com.codebhatti.kinbech.domain.Post;
import com.codebhatti.kinbech.service.CommentService;

@Controller
@RequestMapping(value = "/comment")
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@Autowired
	Identity identity;
		
	@RequestMapping(value="",method=RequestMethod.GET)
	
	public String get(Model model){
		
		System.out.println("---------fjsdklfjsdkfjsdkfjsdklfj--------------");
		model.addAttribute("comment", commentService.get(1l));
		model.addAttribute("username", identity.getUserName());
		return "comment";
	}
	
	//localhost:8080/kinbech/comment/1
	@RequestMapping(value=("/{productId}"),method=RequestMethod.GET)
	public @ResponseBody Comment getComment(
			@PathVariable("productId")Long productId
			,Model model)
	{
		model.addAttribute("comment", commentService.get(productId));
		return commentService.get(productId);
	}
	
	@RequestMapping(value=("/{commentId}"),method=RequestMethod.POST)
	public @ResponseBody Post saveComment(
			@PathVariable("commentId")Long commentId
			,@RequestBody Post post
			,BindingResult bindingResult
			,Model model){
		post.setUsername(identity.getUserName());
		commentService.put(commentId, post);
		
		return post;
	}
	
	
}
