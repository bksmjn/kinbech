<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- default header name is X-CSRF-TOKEN -->

<title>Default Login</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javascript"
	src="<spring:url value="/resource/js/ajax.js"/>"></script>
<link rel="stylesheet" type="text/css"
	href="<spring:url value="/css/main.css" />" />
</head>
<body>
	<div id="global">
		<form method="POST" action="DoLogin">
			<fieldset>
				<legend>Login</legend>
			
					<c:if test="${not empty error}">
					<p>Invalid Username/Password</p>
					</c:if>
			
				<label style="width:50px;" for="userName">User Name:</label>
				<br/>
				 <input type="text"	name="username" /> 
				 <br/> 
				<label style="width:50px;" for="password">Password:</label>
				<br/>
				<input type="password" name="password" /> 
				<br> 
				<input	type="submit"  value="Login" /> 
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</fieldset>
		</form>
	</div>

</body>
</html>