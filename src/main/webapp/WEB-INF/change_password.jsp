<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Change Password</title>
</head>

<body>
	
	<c:if test="${not empty info_message}">
		<p><strong><font color="red"><c:out value="${info_message}" /></font></strong></p>	
	</c:if>
	
	<form action="CarRentalServlet" method="post"> 
		<p><strong>Old password:</strong> 
		<input type="password" maxlength="25" size="30" name="old_password" required></p>
		
		<p><strong>New password:</strong> 
		<input type="password" maxlength="25" size="30" name="new_password" required></p>
		
		<p><strong>Confirm new password:</strong> 
		<input type="password" maxlength="25" size="30" name="confirm_new_password" required></p>
		
		<p><button type="submit" name="command" value="CHANGE_PASSWORD">Change</button>		
	</form>
	
	
</body>
</html>