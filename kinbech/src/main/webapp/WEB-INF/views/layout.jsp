<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javascript"
	src="<spring:url value="/resource/js/ajax.js"/>"></script>
<title>Kinbech</title>
<link rel="stylesheet" type="text/css"
	href="<spring:url value="/css/main.css" />" />
</head>
<body>

		<tiles:insertAttribute name="header" />

		<tiles:insertAttribute name="navigation" />


		<tiles:insertAttribute name="category" />

		<tiles:insertAttribute name="body" />

		<tiles:insertAttribute name="footer" />

</body>

</body>
</html>