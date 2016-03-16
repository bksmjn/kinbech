<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javascript"
	src="<spring:url value="/resource/js/comment-ajax.js"/>"></script>
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />
<title>Product Detail</title>

</head>
<body>
	<div id="productsectionheader">Description:</div>
	<br />
	<div class="productimage">
		<img width="200px" height="200px" src="" />
	</div>
	<div id="productdescription">
		<strong>Name :</strong> <span class="italicized">${product.title}</span>
		<br />
		<br /> <strong>Description:</strong><span class="italicized">
			${product.description}</span> <br />
		<br /> <strong>Available:</strong><span class="italicized">
			${fn:length(product.productCopyList)} </span>available <br />
		<br />
		<form action='<spring:url value="/AddToCart"></spring:url>'
			method="POST">
			<input type="hidden" name="productId" value="${product.productId}" />
			Quantity : <input type="text" name="quantity" /> <br />
			<br />
			<br /> <input type="submit" value="Add to Cart" class="buybutton">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>

	</div>
	<div id="comments">
		<hr />
		<span id="commentlabel"><Strong>Comments</strong></span>
		<div id="commentcontainer">
			commentId : ${comment.commentId} <br /> productId :
			${comment.productId} <br />
			<c:forEach items="${comment.posts}" var="post">
				<div class="commentbox">
					<strong class="italicized">${post.username} Says:</strong><br /> <span
						class="commenttext">${post.postMessage} </span>

				</div>
				<br />

			</c:forEach>
		</div>
			<!--  new comment -->
	add new comment :
	<br />

	<form id="postid">
		<input id="username" type="hidden" name="username"
			value="${username} "></input> <input id="commentid" type="hidden"
			name="commentid" value="${comment.commentId} "></input>
		<textarea id="postmessage" name="postcomment" rows="2" cols="10"></textarea>
			<p>
		<input type="button" value="post comment"
			onclick="postSubmit();return false;">
	</p>
	</form>
	<script>
	function addcomment(message,username){
		var comment="<div class='commentbox'><strong class='italicized'>"+username+" Says:</strong><br/><span class='commenttext'>"+message+"</span></div>";
		document.getElementById("commentcontainer").innerHTML+=comment;	
	}
</script>
		
			
	</div>

</body>
</html>