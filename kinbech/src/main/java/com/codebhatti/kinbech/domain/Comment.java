package com.codebhatti.kinbech.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_comment")
public class Comment implements Serializable{

	private Long commentId;
	private Long parentId;
	private String message;
	private Long productId;
	private User user;
	
	
	//TODO : picture , emoji , notify( maintains public vs owner visiblity )
	
		public Comment(){}
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="commentid")
	public Long getCommentId() {
		return commentId;
	}
		
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	@Column(name="parentid")
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	@Column(name="message")
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Column(name="productid")
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	@OneToOne
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}	

}
