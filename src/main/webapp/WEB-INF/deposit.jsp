<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Deposit</title>
</head>

<body>
	
	<strong> Enter Deposit Ammount: </strong>
	
	<form action="CarRentalServlet" method="post"> 
		<p><input size="10" name="deposit_ammount" required pattern="[0-9]{1,3}"> (integer number from 1 to 999) </p>
		<p><button type="submit" name="command" value="MAKE_DEPOSIT">Submit</button>
	</form>
	
	
</body>
</html>