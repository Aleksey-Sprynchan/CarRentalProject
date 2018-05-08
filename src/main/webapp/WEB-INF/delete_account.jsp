<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete Account</title>
</head>

<body>

	<c:choose>
		<c:when test="${not empty info_message}">
			<p><strong><c:out value="${info_message}" /></strong></p>			
			<form action="CarRentalServlet" method="get">
				<button type="submit" name="command" value="TO_MY_PROFILE_PAGE">My profile</button>	
			</form>		
		</c:when>			
		<c:otherwise>
			<strong>Are you sure that you want to delete your account?</strong>     
       		<p><strong>All you order history and personal information will be lost forever!</strong>	
			<form action="CarRentalServlet" method="post"> 	
				<p><button type="submit" name="command" value="DELETE_ACCOUNT">Delete</button>
			</form> 	
		</c:otherwise>
	</c:choose>
	
	
</body>
</html>