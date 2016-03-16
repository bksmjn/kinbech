package com.codebhatti.kinbech.domain;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


public class Identity implements Serializable{
	
	
	private String userName;
	
	public Identity(){
		System.out.println("Identity Bean Created");
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
	

}
