<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UPDATING CAR PAGE</title>
</head>
<body>
	
	<form action="CarRentalServlet" method="post">
	<strong>Brand:</strong> 
		<input type="text" name="brand_name" list="brand_names"  placeholder="Select or enter brand">
		
		<datalist id="brand_names">
			<c:forEach items="${brand_names}" var="brand">
				<option value="${brand}">${brand}</option>
			</c:forEach>
		</datalist>
		  
		<strong>Model:</strong>
		<input size="30" name="model" value="${carToEdit.getModel()}" placeholder="Enter car model here"> 	
		
		<strong>Type:</strong> 
		<input size="30" name="type" value="${carToEdit.getType()}" placeholder="Enter car type here">

		<strong>Transmission:</strong> 
		<input size="30" name="transmission" value="${carToEdit.getTransmission()}" placeholder="Enter car transmission type here">
		
		<strong>Doors:</strong> 
		<input size="30" name="doors" value="${carToEdit.getDoors()}" placeholder="Enter doors number">
		
		<strong>Passengers:</strong> 
		<input size="30" name="passengers" value="${carToEdit.getPassengers()}" placeholder="Enter passengers number">
		
		<strong>Fuel:</strong> 
		<input size="30" name="fuel" value="${carToEdit.getFuel()}" placeholder="Enter fuel type here">
		
		<strong>AirCondition:</strong> 
		<input size="30" name="is_air_condition" value="${carToEdit.isAirCondition()}" placeholder="is Air Condition">
		
		<strong>Price per day:</strong> 
		<input size="30" name="price_per_day" value="${carToEdit.getPricePerDay()}" placeholder="Enter price">
		
		<input type="hidden" name="car_id" value="${carToEdit.getId()}" />
		<input type="hidden" name="is_available" value="${carToEdit.isAvailable()}" />
		<button type="submit" name="command" value="UPDATE_CAR">Update car info</button>
	</form>


	
	

</body>
</html>