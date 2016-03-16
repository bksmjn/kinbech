package com.codebhatti.kinbech.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="comment")
public class Comment implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="commentid")
	private Long commentId;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	
	private List<Post> posts;
	
	@NotNull
	@Column(name="productid")
	private Long productId;
	
	public Comment(){}
	
	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder();
		for(Post post :posts){
			str.append(post.getPostMessage()+"post by : "+post.getUsername()+"\n");
		}
		str.append(this.commentId+"\n");
		str.append(this.productId+"\n");
		return str.toString();
	}

}

	



