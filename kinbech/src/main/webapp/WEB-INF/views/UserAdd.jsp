<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javascript"
	src="<spring:url value="/resource/js/ajax.js"/>"></script>
<link rel="stylesheet" type="text/css" href="<spring:url value="/css/main.css" />" />
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
		<input type="button" value="Add Address"
			onclick="make_visible('formInput');return false;"> <input
			type="submit" value="Add User" />
	</div>

	<div id="formInput" style="display: none">

		<h3 align="center">Address</h3>
		<!-- No action method handled by AJAX-->
		<form id="addressForm" method="post">
			<p>
				<label for="street"> Street : </label> <input type="text"
					name="street" id="street" value="" />
			</p>

			<p>
				<label for="zipCode"> ZipCode: </label> <input id="zipCode"
					name="zipCode" type="text" />
			</p>

			<p>
				<label for="state"> State: </label> <input id="state" name="state"
					type="text" />
			</p>

			<p>
				<label for="mailBoxNo"> Mail Box No: </label> <input id="mailBoxNo"
					name="mailBoxNo" type="text" />
			</p>
			<p>
				<label for="phoneNumber"> Phone Number: </label> <input
					id="phoneNumber" name="phoneNumber" type="text" />
			</p>
			<p>
				<label for="mobileNumber"> Mobile Number: </label> <input
					id="mobileNumber" name="mobileNumber" type="text" />
			</p>

			<p>
				<label for="billingAddress"> Billing Address: </label> <input
					id="billingAddress" name="billingAddress" type="text" />
			</p>
			<input type="button" value="Add Address"
				onclick="addressSubmit();return false;">

		</form>
		<h4 align="center">
			<a href="#"
				onclick="make_hidden('formInput'); make_hidden('result');resetForm('addressForm');">
				<b>EXIT</b>
			</a>
		</h4>


	</div>

</body>
</html>