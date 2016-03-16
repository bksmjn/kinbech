<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Cart</title>
</head>
<body>
	<div id="productsectionheader">
	Cart:
	</div>
	<c:forEach items="${myCart.cartItems}" var="item">
		<div id="productbox">
		<div class="productimage">
		<img width="200px" height="200px" src=""/>
		</div>
		<div class="productinfo">
		<div class="producttitle">${item.value.productId}</div>
	
		<div class="productdetails">
		Quantity:${item.value.quantity}
		</div>
		</div>
	</div>
	</c:forEach>
	
	<form action='<spring:url value="/Order/Checkout"></spring:url>' method="POST">
		<input type="Submit" class="buybutton,checkoutbutton" value="Checkout" />
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
</body>
</html>