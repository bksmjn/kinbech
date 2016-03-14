<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product</title>
</head>
<body>
	<h2>Add New Product : </h2>
	<spring:url var="login_url" value='/products/add' ></spring:url>
	<form:form modelAttribute="newProduct" 
		action="${login_url}" method="POST">
		<form:errors path="title" class="errors" />
		Product Name : <form:input path="title" tabindex="1"/> 
		<br />
		<form:errors path="description" class="errors" />
		Description : <form:input path="description" tabindex="2"/> 
		<br />
		<form:errors path="categoryId" class="erros" />
		<form:select path="categoryId" tabindex="3">
			<form:option value="0">--Select a category</form:option>
			<form:options items="${categories}" itemValue="id" itemLabel="title" />
		</form:select>  
		<br />
		<form:errors path="quantityWhenUpload" class="errors" />
		Quantity : <form:input path="quantityWhenUpload" tabindex="4" />
		<br />
		<form:errors path="unitPrice" class="errors" />
		Unit Price : <form:input path="unitPrice" tabindex="5" />
		<br />
		<form:errors path="imagePath" class="errors" />
		Upload a image : <input type="file" name="imageFile" />
		<br />
		<br />
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>