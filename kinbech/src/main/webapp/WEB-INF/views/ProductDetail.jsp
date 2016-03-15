<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Detail</title>
</head>
<body>
	Name : ${product.title}
	<br />
	Description: ${product.description}
	<br />
	<c:choose>
	<c:when test="${product==null || product.productCopyList==null}">
		Product null
	</c:when>
	<c:otherwise>
		<c:forEach items="${product.productCopyList}" var="item">
			<p>Product Copy ID : ${item.id}</p>
			<p>Status : ${item.productStatus}</p>
			<br />
		</c:forEach>
	</c:otherwise>
	</c:choose>
</body>
</html>