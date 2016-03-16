<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>KinBech(Buy-Sell)</title>
<link rel="stylesheet" type="text/css" href="<spring:url value="/css/main.css"/>"/>
</head>
<body>
	<div id="header">
		<h2>KinBech</h2>
		<span id="codebhatti">by codebhatti</span>

	</div>
	<div id="navigation">
		<div id="loginzone">${username}</div>
		<div id="cart">My cart(2)</div>
		<div id="navlinks">

			<a href="">Settings</a> <a href="">Contact</a> <a
				href="http://www.google.com">About</a> <a
				href="http://www.google.com">Buy</a> <a href="http://www.google.com">Sell</a>

		</div>

	</div>
	<div id="category">
		<div id="categoryheader">Category</div>
		<div id="categoryitem">
			<a href="http://google.com">Electronics</a>
		</div>
		<div id="categoryitem">Furnitures</div>
		<div id="categoryitem">Kitchen</div>
		<div id="categoryitem">Gardening and House Improvement</div>
		<div id="categoryitem">Apparel</div>


	</div>

	<div id="body">

		<div id="productsectionheader">Electronics</div>

		<div id="productbox">
			<div class="productimage">
				<img width="200px" height="200px" src="" />
			</div>
			<div class="productinfo">
				<div class="producttitle">Dell Inspiron Laptop</div>

				<div class="productdetails">This is a brand new Dell Inspiron
					Laptop with 8 gigs of RAM and all the gaming hardware you need.</div>

				<span class="sellerid"> <strong>Sold By:</strong>Harke
					Hawaldar
				</span>
				<div class="price">
					<strong>Price:</strong>
				</div>

			</div>
		</div>






		<div id="productsectionheader">Apparel</div>

		<div id="productbox">Jeans</div>
		<div id="productbox">Hat</div>
		<div id="productbox">Scarf</div>
		<div id="productbox">Underwears</div>




	</div>


	<div id="footer">This is the footer</div>



</body>
</html>
