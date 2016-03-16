<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<!DOCTYPE HTML>

<html>
	<head>
		<title>comment </title>	
	</head>
	
	<body>
	<!--  previously posted comments -->

	<c:forEach items="${comments}" var="comment">
       productId : ${comment.productId}
        <br/>
        <c:forEach items="${comment.posts}" var="post">
        ${post.postMessage}  :by: ${post.username}
        <br/>
        
        </c:forEach>
        
        <br/>
               
	</c:forEach>
	<%-- 	<!--  new comment -->
		<form:form modelAttribute="newBook"  action= "${addBook }" method="post">
         <p>
           <label for="post"><spring:message code="post.message" /> </label>
            <form:input path="postMessage" />
         </p>
        
        <p id="buttons">
             <input id="submit" type="submit" value="Add Book">
        </p>
   
		</form:form> --%>
	</body>
</html>