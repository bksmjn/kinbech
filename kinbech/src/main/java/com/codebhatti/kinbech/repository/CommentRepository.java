package com.codebhatti.kinbech.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codebhatti.kinbech.domain.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long>{

	@Query("select comment from comment c where c.productId=: productId")
	public Comment getCommentByProductId(@Param("productId") Long productId);
	
}
