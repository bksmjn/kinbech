package com.codebhatti.kinbech.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.springframework.context.annotation.Scope;

@Entity
@Table(name="users")
public class User implements Serializable {
	
	private String userName;
	private String password;
	private Account account;
	private Address address;
	
	public User() {
		this.account=new Account();
		this.address=new Address();
	
	}
	@Id
	@Column(name="username")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Column(name="password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="account_id")
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="address_id")
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	
	

}
