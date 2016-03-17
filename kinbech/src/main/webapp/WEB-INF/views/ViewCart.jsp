<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div id="body">
	<div id="productsectionheader">
	Cart:
	</div>
	<c:forEach items="${cartItemsList}" var="item">
		<div id="productbox">
		<div class="productimage">
		<img width="200px" height="200px" src=""/>
		</div>
		<div class="productinfo">
		<div class="producttitle">${item.product.title}</div>
	
		<div class="productdetails">
		Quantity:${item.quantity}
		</div>
		</div>
	</div>
	</c:forEach>
	
	<form action='<spring:url value="/Order/Checkout"></spring:url>' method="POST">
		<input type="Submit" class="buybutton,checkoutbutton" value="Checkout" />
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
	</div>
