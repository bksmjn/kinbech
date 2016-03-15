<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javascript"
	src="<spring:url value="/resource/js/ajax.js"/>"></script>
<link rel="stylesheet" type="text/css"
	href="<spring:url value="/css/main.css" />" />
</head>
<body>
	<div id="global">
		<form:form modelAttribute="user" method="POST" action="add">
			<fieldset>
				<legend>User Add</legend>
				<label for="userName">User Name:</label>
				<form:input path="userName" id="userName" />
				<br> <label for="password">Password:</label>
				<form:input path="password" id="password" />
				<br> <label for="confirmpassword">Confirm Password:</label><input
					type="password" id="confirmpassword"> <br>
			</fieldset>

		</form:form>
	</div>

	<div id="global">
		<form:form modelAttribute="address" method="POST" action="addAddress">
			<fieldset>
				<legend> Add Address</legend>
				<label for="street">Street: </label>
				<form:input path="street" id="street" />
				<br> <label for="zipCode">Zip Code:</label>
				<form:input path="zipCode" id="zipCode" />
				<br> <label for="state">State:</label>
				<form:input path="state" id="state" />
				<br> <label for="mailBoxNumber">Mail Box No:</label>
				<form:input path="mailBoxNumber" id="mailBoxNumber" />
				<br> <label for="phoneNumber">Phone Number:</label>
				<form:input path="phoneNumber" id="phoneNumber" />
				<br> <label for="mobileNumber">Mobile Number:</label>
				<form:input path="mobileNumber" id="mobileNumber" />
				<br> <label for="billingAddress">Billing Address:</label>
				<form:input path="billingAddress" id="billingAddress" />
				<input type="submit" value="Add Address">
			</fieldset>

		</form:form>
	</div>
	<div id="global">
		<h1>Address List</h1>
		<table>
			<tr style="width: 100%;">
				<th style="width: 19%;">Street</th>
				<th style="width: 21%;">Mobile Number</th>
				<th style="width: 21%;">Zip Code</th>
				<th style="width: 21%;">State</th>
				<th style="width: 23%;">Billing Address</th>
			</tr>
			<c:forEach items="${user.addresses}" var="address">
				<tr>
					<td>${address.street}</td>
					<td>${address.mobileNumber}</td>
					<td>${address.zipCode}</td>
					<td>${address.state}</td>
					<td>${address.billingAddress}</td>
				</tr>
			</c:forEach>
		</table>

		<input type="button" value="Add Category"
			onclick="make_visible('formInput');return false;">

	</div>

</body>
</html>