package com.codebhatti.kinbech.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codebhatti.kinbech.domain.Comment;
import com.codebhatti.kinbech.domain.Post;
//import com.codebhatti.kinbech.domain.Reply;
import com.codebhatti.kinbech.repository.CommentRepository;
import com.codebhatti.kinbech.service.CommentService;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentRepository commentRepository;

	@Override
	public Comment get(Long productId) {

		return commentRepository.getCommentByProductId(productId);
	}

	@Override
	public void save(Comment comment) {
		// TODO Auto-generated method stub

	}

	@Override
	public void put(Long CommentId, Post post) {
		// TODO Auto-generated method stub

	}

	/*
	 * @Override public void put(Long commentId, Long postId, Reply reply) { //
	 * TODO Auto-generated method stub
	 * 
	 * }
	 */

}
