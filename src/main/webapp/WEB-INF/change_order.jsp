<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Change Order</title>

<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>

<script type="text/javascript">

$(function() {		
	$("#birthDatePicker").datepicker({
		showAnim:"slide", 
		dateFormat:"yy-mm-dd", 
		changeYear : true, 
		yearRange : "-80:+0", 
		changeMonth : true});
});

</script>

</head>
<body>

	<form action="CarRentalServlet" method="post"> 
		<p><strong>Name:</strong> 
		<input size="30" name="customer_name" value="${order.getCustomer().getName()}" placeholder="Enter name" required></p>
		
		<p><strong>Surname:</strong> 
		<input size="30" name="customer_surname" value="${order.getCustomer().getSurname()}" placeholder="Enter surname" required></p>
		
		<p><strong>Passport №:</strong> 
		<input size="30" name="passport_numb" value="${order.getCustomer().getPassportNumb()}" placeholder="Enter passport number" required></p>
		
		<p><strong>Date of birth:</strong> 
		<input type="text" id="birthDatePicker" name="date_of_birth" value="${order.getCustomer().getDateOfBirth().toString()}" required></p>
		
		<p><strong>Driving experience (years):</strong> 
		<input size="30" name="driving_exp" value="${order.getCustomer().getDrivingExp()}" placeholder="Enter driving expirience" required pattern="^[0-9]+$"></p>	
		<input type="hidden" name="customer_id" value="${order.getCustomer().getId()}"/>
		<p><button type="submit" name="command" value="CHANGE_ORDER">Change info</button>		
	</form>
	

</body>
</html>