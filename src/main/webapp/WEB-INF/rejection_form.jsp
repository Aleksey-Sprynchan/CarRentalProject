<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rejection form</title>
</head>
<body>
	
	<strong>Reject reason message:</strong> 
	<p><textarea name="rejection_reason" rows="10" cols="50" maxlength="255" required form="rejection_form"></textarea>
	<form action="CarRentalServlet" method="post" id="rejection_form">		
		<input type="hidden" name="order_id" value="${order_id}"/>
		<p><button type="submit" name="command" value="SEND_REJECT_MESSAGE">Send reject message</button></p>
	</form>
	
	

</body>
</html>