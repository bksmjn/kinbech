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
	<form action="action_page.php" enctype="multipart/form-data">
	  <fieldset id="productaddbox">
	    <legend>Product iNFO:</legend>
	   	Product Title:<br>
	    <input type="text" name="productname" ><br><br/>
	    Product Description:<br>
	    <textarea name="productdescription" cols="100px" rows="20px"></textarea><br><br>
	<br/><br/>
		Product Category:<br/>
		<select name="category">
		<option value="Electronics">Electronics</option>
		<option value="Apparel">Apparel</option>
		</select>
		<br/>
		<br/>
		Product Quantity:
		<input type="text" name="quantity"/><br/><br/>
		Upload An Image<br/><input type="file" name="image"><br/><br/>
	    <input type="submit" value="Submit">
	  </fieldset>
	</form>
	
</body>
</html>