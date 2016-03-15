package com.codebhatti.kinbech.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "post")
public class Post {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="postid")
	private Long postId;
	
	@NotEmpty
	@Size(min=1,max=2000)
	@Column(name="postmessage")
	private String postMessage;
	
	@NotNull
	//@OneToOne(cascade=CascadeType.ALL)
	//@JoinColumn(name="users_username")
	private String username;

/*	@OneToMany
	private List<Reply> replies;*/
	
	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public String getPostMessage() {
		return postMessage;
	}

	public void setPostMessage(String postMessage) {
		this.postMessage = postMessage;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String user) {
		this.username = user;
	}

/*	public List<Reply> getReplies() {
		return replies;
	}

	public void setReplies(List<Reply> replies) {
		this.replies = replies;
	}
	*/

}
