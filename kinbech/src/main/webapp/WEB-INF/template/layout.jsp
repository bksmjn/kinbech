<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<link rel="stylesheet" type="text/css" href="style/pagestyle.css">
<body>

	<div id="header">
		<tiles:insertAttribute name="header" />

	</div>
	<div id="navigation">
		<tiles:insertAttribute name="navigation" />
		>
	</div>
	<div id="category">
		<tiles:insertAttribute name="category" />
		<div id="body">
			<tiles:insertAttribute name="body" />

		</div>
		<div id="footer">
			<tiles:insertAttribute name="footer" />
		</div>
</body>

</body>
</html>