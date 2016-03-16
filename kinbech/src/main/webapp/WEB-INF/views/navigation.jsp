
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="navigation">
	<div id="loginzone">${username}</div>
	<div id="cart">My cart(2)</div>
	<div id="navlinks">
<spring:url value="/users/add" var="addUser_url" />
<spring:url value="/users/" var="listUser_url" />
		<a href="${listUser_url}">User List</a><a href="${addUser_url}">User Add</a><a href="">Settings</a> <a href="">Contact</a> <a
			href="http://www.google.com">About</a> <a
			href="http://www.google.com">Buy</a> <a href="http://www.google.com">Sell</a>

	</div>

</div>