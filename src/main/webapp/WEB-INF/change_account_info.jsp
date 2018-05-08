<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Change Account Info</title>
</head>

<body>
	
	<c:if test="${not empty info_message}">
		<p><strong><font color="red"><c:out value="${info_message}" /></font></strong></p>	
	</c:if>
	
	<form action="CarRentalServlet" method="post"> 
		<p><strong>Name:</strong> 
		<input size="30" name="name" value="${user.getName()}" placeholder="Enter new name here" required></p>
		
		<p><strong>Surname:</strong> 
		<input size="30" name="surname" value="${user.getSurname()}" placeholder="Enter new name here" required></p>
		
		<p><strong>email:</strong> 
		<input type="email" size="30" name="email" value="${user.getEmail()}" placeholder="Enter new email here" required></p>	
		<p><button type="submit" name="command" value="CHANGE_ACCOUNT_INFO">Change Info</button>		
	</form>
	
	<form action="CarRentalServlet" method="get">
			<button type="submit" name="command" value="VIEW_ACCOUNT_DETAILS">Back</button>	
	</form>
	

</body>
</html>