package com.codebhatti.kinbech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.codebhatti.kinbech.domain.Comment;
import com.codebhatti.kinbech.domain.Identity;
import com.codebhatti.kinbech.domain.Post;
import com.codebhatti.kinbech.service.CommentService;

/**
 * This controller responsible for handling comment related requests via AJAX
 * @author Parmeshwor Thapa
 * 
 *
 */
@Controller
@RequestMapping(value = "/comment")
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@Autowired
	Identity identity;
		

	//localhost:8080/kinbech/comment/1
	/**
	 * @param productId The product Id obtained from AJAX request
	 * @param model The model which is going to be passed to commentservice
	 * @return comment object encoded in JSON
	 */
	@RequestMapping(value=("/{productId}"),method=RequestMethod.GET)
	public @ResponseBody Comment getComment(
			@PathVariable("productId")Long productId
			,Model model)
	{
		model.addAttribute("comment", commentService.get(productId));
		return commentService.get(productId);
	}
	
	/**
	 * @param commentId The id of the comment that the post is to be inserted 
	 * @param post The message in the comment
	 * @param bindingResult The result from binder about success or failure
	 * @param model The model that is going to be passed to CommentService
	 * @return The post message encoded as JSON
	 */
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
