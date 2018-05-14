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
			<c:forEach items="${brand_names_list}" var="brand">
				<option value="${brand}">${brand}</option>
			</c:forEach>
		</datalist>
		  
		<strong>Model:</strong>
		<input size="30" name="model" value="${car.getModel()}" placeholder="Enter car model here"> 	
		
		<strong>Type:</strong> 
		<input size="30" name="type" value="${car.getType()}" placeholder="Enter car type here">

		<strong>Transmission:</strong> 
		<input size="30" name="transmission" value="${car.getTransmission()}" placeholder="Enter car transmission type here">
	
		
		<strong>Passengers:</strong> 
		<input size="30" name="passengers" value="${car.getPassengers()}" placeholder="Enter passengers number">
		
		<strong>Fuel:</strong> 
		<input size="30" name="fuel" value="${car.getFuel()}" placeholder="Enter fuel type here">
		
		<strong>AirCondition:</strong> 
		<input size="30" name="air_condition" value="${car.isAirCondition()}" placeholder="is Air Condition">
		
		<strong>Price per day:</strong> 
		<input size="30" name="price_per_day" value="${car.getPricePerDay()}" placeholder="Enter price">
		
		<input type="hidden" name="car_id" value="${car.getId()}" />
		<input type="hidden" name="is_available" value="${car.isAvailable()}" />
		<button type="submit" name="command" value="UPDATE_CAR">Update car info</button>
	</form>


	
	

</body>
</html>