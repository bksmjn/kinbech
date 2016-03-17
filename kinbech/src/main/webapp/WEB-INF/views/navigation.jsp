
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="navigation">
	<div id="loginzone">${username}</div>
	<div id="cart">My cart(2)</div>
	<div id="navlinks">
	


		<spring:url value="/users/" var="listUser_url" />
		<a href="${listUser_url}">User List</a>
		
		<spring:url value="/users/add" var="addUser_url" />
		<a href="${addUser_url}">User Add</a>
		
		<spring:url value="/MyCart" var="addcart_url" />
		<a href="${addcart_url}">View Cart </a>
		
		<a href="">Contact</a> 
		
		<a	href="#">About</a> 
					
		<a href="#">Buy</a> 
		
		<spring:url value="/products/Add" var="product_add" />
		<a href="${product_add}">Sell</a>

	</div>

</div>