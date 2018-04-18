<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Book Car</title>

</head>
<body>

	<h3>Fill the bid to book this car:</h3>
	<font size="5" color="red" face="Times New Roman"><c:out value="${car}"/></font>

	<form action="CarRentalServlet" method="post">
		<p><strong>Name:</strong> 
		<input size="30" name="customer_name" required></p>
		
		<p><strong>Surname:</strong> 
		<input size="30" name="customer_surname" required></p>
		
		<p><strong>Passport №:</strong> 
		<input size="30" name="passport_numb" required></p>
		
		<p><strong>Date of birth:</strong> 
		<input type="date" name="date_of_birth" required></p>
		
		<p><strong>Driving experience (years):</strong> 
		<input size="30" name="driving_exp" required pattern="^[0-9]+$"></p>
		
		<p><strong>From:</strong> 
		<input type="date" name="start_date" required></p>
		
		<p><strong>To:</strong> 
		<input type="date" name="end_date" required></p>

		<input type="hidden" name="car_id" value="${car.getId()}"/>
		<button type="submit" name="command" value="CREATE_ORDER">Submit order</button>
	</form>

</body>
</html>