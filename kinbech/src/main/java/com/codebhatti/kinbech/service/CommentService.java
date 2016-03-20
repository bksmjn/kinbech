package com.codebhatti.kinbech.service;

import java.util.List;

import com.codebhatti.kinbech.domain.Comment;
import com.codebhatti.kinbech.domain.Post;
//import com.codebhatti.kinbech.domain.Reply;

/**
 * @author Parmeshwor Thapa
 *
 */
public interface CommentService {
	
	//CRUD service
		
	/**
	 * @return returns all comments as a list
	 */
	public List<Comment> getAll();
	/**
	 * @param productId The product id of the product whose comments are going to be returned
	 * @return returns the comment object associated with the product
	 */
	public Comment get(Long productId);
	
	
	/**
	 * @param CommentId The id of the comment on which the post is going to be attached
	 * @param post The post to be inserted into comment object
	 */
	public void put(Long CommentId, Post post);
//	public void put(Long commentId, Long postId, Reply reply);
	
}
