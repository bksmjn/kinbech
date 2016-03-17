<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product</title>
<link rel="stylesheet" type="text/css"
	href="<spring:url value="/css/main.css" />" />
</head>
<body>
		<div id="productsectionheader">
	ADD A NEW PRODUCT:
	</div>
	<br/><br/>
	<form:form commandName="product" enctype="multipart/form-data" action="Add" method="POST">
	  <fieldset id="productaddbox">
	    <legend>Product iNFO:</legend>
	   	Product Title:<br>
	    <form:input type="text" path="title" /><br><br/>
	    Product Description:<br>
	    <form:textarea name="productdescription" path="description" cols="100px" rows="20px" /><br><br>
	<br/><br/>
		Product Category:<br/>
		<select name="category">
		<option value="Electronics">Electronics</option>
		<option value="Apparel">Apparel</option>
		</select>
		<br/>
		<br/>
		Product Quantity:
		<form:input type="text" path="quantityWhenUpload" name="quantity"/><br/><br/>
		Upload An Image<br/><form:input path="imageFile" type="file" name="image" /><br/><br/>
	    <input type="submit" value="Submit">
	  </fieldset>
	</form:form>
	
</body>
</html>