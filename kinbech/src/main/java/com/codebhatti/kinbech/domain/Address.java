package com.codebhatti.kinbech.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="user_address")
public class Address implements Serializable{

	private Long addressId;
	private String street;
	private String zipCode;
	private String state;
	private String mailBoxNumber;
	private String phoneNumber;
	private String mobileNumber;
	private String billingAddress;
	private User user;
	
	public Address(){
		this.user=new User();
	}

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="addressid")
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	
	
	@Column(name="street")
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	@Column(name="zipcode")
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	@Column(name="state")
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Column(name="mailboxno")
	public String getMailBoxNumber() {
		return mailBoxNumber;
	}
	public void setMailBoxNumber(String mailBoxNumber) {
		this.mailBoxNumber = mailBoxNumber;
	}
	@Column(name="phonenumber")
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Column(name="mobilenumber")
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	@Column(name="billingaddress")
	public String getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}
	@ManyToOne
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
	
	
}
