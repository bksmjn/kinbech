package com.kinbech.comment;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.codebhatti.kinbech.domain.Account;
import com.codebhatti.kinbech.domain.Comment;
import com.codebhatti.kinbech.domain.Post;
import com.codebhatti.kinbech.domain.User;
import com.codebhatti.kinbech.repository.CommentRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/test-context.xml")
@Transactional
public class CommentRepositoryTest {
	
	@Autowired
	CommentRepository repository;
	
	@Test
	public void insertTest(){
		
		Comment comment =  new Comment();
		comment.setProductId(11L);		
		
		Post post = new Post();
		
		repository.save(comment);
		Comment dbcomment = repository.findOne(comment.getCommentId());
		//List<Comment> comments = (List<Comment>) repository.findAll();
		assertEquals(11, dbcomment.getProductId().intValue());
	}
	
	@Test
	public void insertPosts(){
		
		String user = "pthapa";
		String user2 = "pthapa2";
		String user3 = "pthapa3";
		
		//user.setAccount(new Account());
		//user.setAccount(account);
		
		Post post = new Post();
		//post.setPostId(1l);
		post.setPostMessage("this is message");
		post.setUsername(user);
		
		Post post2 = new Post();
		//post.setPostId(2l);
		post2.setPostMessage("this is message 2");
		post2.setUsername(user2);
		
		Post post3 = new Post();
		//post.setPostId(3l);
		post3.setPostMessage("this is message 3");
		post3.setUsername(user3);
		
		List<Post> posts = new ArrayList<>();
		posts.add(post);
		posts.add(post2);
		posts.add(post3);
		
		Comment comment =  new Comment();
		comment.setProductId(11L);	
		comment.setPosts(posts);
				
		repository.save(comment);
		Comment dbcomment = repository.findOne(comment.getCommentId());
		System.out.println("-----------------");
		System.out.println(comment);
		System.out.println();
		System.out.println("-------------------");
	}
}
