<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Add</title>
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
				<form:errors path="*" />
				<label for="firstName">First Name:</label>
				<form:input path="firstName" id="firstName" /><form:errors path="firstName" />
				<br><label for="middleName">Middle Name:</label>
				<form:input path="middleName" id="middleName" /><form:errors path="middleName" />
				<br><label for="lastName">Last Name:</label>
				<form:input path="lastName" id="lastName" /><form:errors path="lastName" />
				<br>
				<label for="userName">Email Address:</label>
				<form:input path="userName" id="userName" /><form:errors path="userName" />
				<br> <label for="password">Password:</label>
				<form:password path="password" id="password" /><form:errors path="password" />
				<br> <label for="confirmpassword">Confirm Password:</label><input
					type="password" id="confirmpassword"> <br> <label
					for="street">Street: </label>
				<form:input path="address.street" id="street" /><form:errors path="address.street" />
				<br> <label for="zipCode">Zip Code:</label>
				<form:input path="address.zipCode" id="zipCode" /><form:errors path="address.zipCode" />
				<br> <label for="state">State:</label>
				<form:input path="address.state" id="state" /><form:errors path="address.state" />
				<br> <label for="mailBoxNumber">Mail Box No:</label>
				<form:input path="address.mailBoxNumber" id="mailBoxNumber" /><form:errors path="address.mailBoxNumber" />
				<br> <label for="phoneNumber">Phone Number:</label>
				<form:input path="address.phoneNumber" id="phoneNumber" /><form:errors path="address.phoneNumber" />
				<br> <label for="mobileNumber">Mobile Number:</label>
				<form:input path="address.mobileNumber" id="mobileNumber" /><form:errors path="address.mobileNumber" />
				<br> <label for="billingAddress">Billing Address:</label>
				<form:input path="address.billingAddress" id="billingAddress" /><form:errors path="address.billingAddress" />
				<input type="submit" />
			</fieldset>

		</form:form>
	</div>

</body>
</html>