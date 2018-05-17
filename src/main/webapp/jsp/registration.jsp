<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<c:if test="${not empty dup_message}">
		<p><font size="3" color="red" face="Arial"><c:out value="${dup_message}"/></font>	
	</c:if>
	
	<form action="CarRentalServlet" method="post">
		<p><strong>Login:</strong> 
		<input size="30" name="login" required></p>
		
		<p><strong>Password:</strong> 
		<input type="password" maxlength="25" size="30" name="password" required></p>
			
		<p><strong>Name:</strong> 
		<input size="30" name="name" required></p>
		
		<p><strong>Surname:</strong> 
		<input size="30" name="surname" required></p>
		
		<p><strong>e-mail:</strong> 
		<input type="email" size="30" name="email" required></p>
				
		<button type="submit" name="command" value="REGISTER">Register</button>
	</form>
	
	<form action="CarRentalServlet" method="get">				
		<p><button type="submit" name="command" value="START_PAGE">Home Page</button>
	</form>

</body>
</html>