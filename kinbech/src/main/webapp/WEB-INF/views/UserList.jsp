<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User List</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javascript"
	src="<spring:url value="/resource/js/ajax.js"/>"></script>
<link rel="stylesheet" type="text/css"
	href="<spring:url value="/css/main.css" />" />
</head>
<body>
	<div id="global">
		<fieldset>
		<legend>User List</legend>
		<!-- Query Parameter passing  -->
		<spring:url value="/users/add" var="addUser_url">
		</spring:url>
		<a href="${addUser_url}">Add User</a><br />
		<table>
			<tr style="width: 100%;">
				<th style="width: 19%;">UserName</th>
				<th style="width: 21%;">PhoneNumber</th>
				<th style="width: 21%;">State</th>
				<th style="width: 21%;">Billing Address</th>
				<th style="width: 23%;">Street</th>
			</tr>
			<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.userName}</td>
					<td>${user.address.phoneNumber}</td>
					<td>${user.address.state}</td>
					<td>${user.address.billingAddress}</td>
					<td>${user.address.street}</td>
				</tr>
			</c:forEach>
		</table></fieldset>
	</div>
</body>
</html>