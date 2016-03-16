<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<!DOCTYPE HTML>

<html>
	<head>
		<title>comment </title>	
		<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
		<script type="text/javascript" src="<spring:url value="/resource/js/comment-ajax.js"/>"></script>
	<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
	</head>
	
	<body>
	<!--  previously posted comments -->

	   commentId : ${comment.commentId} <br/>
       productId : ${comment.productId}
        <br/>
        <c:forEach items="${comment.posts}" var="post">
        ${post.postMessage}  :by: ${post.username}
        <br/>
        
        </c:forEach>
        
        <br/>
               
	
		<!--  new comment -->
		add new comment : <br/>
		                   
            <form id="postid">
            <input id="username" type="hidden" name="username" value="${username} "></input>
            <input id="commentid" type="hidden" name="commentid" value="${comment.commentId} "></input>
            <textarea id="postmessage" name="postcomment" rows="2" cols="10"></textarea>
            </form>
   
        <p>
             <input type="button" value="post comment" onclick="postSubmit();return false;">
        </p>
   
	
	</body>
</html>