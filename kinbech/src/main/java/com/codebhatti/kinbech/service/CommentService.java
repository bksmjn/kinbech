package com.codebhatti.kinbech.service;

import com.codebhatti.kinbech.domain.Comment;
import com.codebhatti.kinbech.domain.Post;
import com.codebhatti.kinbech.domain.Reply;

public interface CommentService {
	
	//CRUD service
		
	public Comment get(Long productId);
	public void save(Comment comment);
	public void put(Long CommentId, Post post);
	public void put(Long commentId, Long postId, Reply reply);
	
}
