package com.codebhatti.kinbech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codebhatti.kinbech.domain.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{

	@Query("select c from Comment c where productid= :productid")
	public Comment getCommentByProductId(@Param("productid") Long productId);
	
}
