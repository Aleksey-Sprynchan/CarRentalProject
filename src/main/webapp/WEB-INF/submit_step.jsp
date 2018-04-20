<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pay Step</title>
</head>
<body>
	
	<h3>You created an order with the following information:</h3>
	
	<h4>Booking car:</h4>
	<font size="5" color="red" face="Times New Roman"><c:out value="${booking_car}"/></font>

	<h4>Your personal information:</h4>	
	<form action="CarRentalServlet" method="post">
		<strong>Name:</strong> ${cpData.getName()} <p>
		<strong>Surname:</strong> ${cpData.getSurname()} <p>
		<strong>Passport Number:</strong> ${cpData.getPassportNumb()} <p>
		<strong>Date of birth:</strong> ${cpData.getDateOfBirth().toString()} <p>
		<strong>Driving experience:</strong> ${cpData.getDrivingExp()} <p>
		<strong>Start date of rent:</strong> ${this_order.getStartDate().toString()} <p>
		<strong>End date of rent:</strong> ${this_order.getEndDate().toString()} <p>
	</form>
	
	
	<form action="CarRentalServlet" method="post">
	<input type="hidden" name="this_order_id" value="${this_order.getId()}"/>
	<button type="submit" name="command" value="SUBMIT_ORDER_FORM">OK</button>
	</form>

</body>
</html>