<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Car</title>
</head>
<body>

	<form action="CarRentalServlet" method="post">
		<p><strong>New car:</strong>
		<p>Brand 
		<input type="text" name="brand_name" list="brandList" placeholder="Select or enter brand">
		
		<datalist id="brandList">
			<c:forEach items="${brand_names}" var="brand">
				<option value="${brand}">${brand}</option>
			</c:forEach>
		</datalist>
		
		<p>Model
		<input size="30" name="model" placeholder="Enter car model here" required> 	
	
		<p>Type 
		<input size="30" name="type" placeholder="Enter car type here" required>

		<p>Transmission 
		<input size="30" name="transmission" placeholder="Enter car transmission type here" required>
		
		<p>Doors 
		<input size="30" name="doors" placeholder="Enter doors number" required pattern="^[0-9]+$">
		
		<p>Passengers 
		<input size="30" name="passengers" placeholder="Enter passengers number" required pattern="^[0-9]+$">
		
		<p>Fuel 
		<input size="30" name="fuel" placeholder="Enter fuel type" required>
		
		<p>Price per day 
		<input size="30" name="price_per_day" placeholder="Enter price" required pattern="^[0-9]+$"> (integer value)
		
		<p>AirCondition 
		<input size="30" name="is_air_condition" placeholder="is Air Condition" required> (TRUE of FALSE)
		
	<!--	<p><strong>Damage costs for this car:</strong> 
		
	 	<p>Cracked windshield 
		<input size="30" name="cracked_windshield_cost" placeholder="Cracked windshield cost" required pattern="^[0-9]+$"> (integer value)
		
		<p>Small dent 
		<input size="30" name="small_dent_cost" placeholder="Small dent cost" required pattern="^[0-9]+$"> (integer value)
		
		<p>Broken headlight 
		<input size="30" name="broken_headlight_cost" placeholder="Broken headlight cost" required pattern="^[0-9]+$"> (integer value)
		
		<p>Punctured wheel 
		<input size="30" name="punctured_wheel_cost" placeholder="Punctured wheel cost" required pattern="^[0-9]+$"> (integer value)
		
		<p>Large dent 
		<input size="30" name="large_dent_cost" placeholder="Large dent cost" required pattern="^[0-9]+$"> (integer value)
		
		<p>Engine damage 
		<input size="30" name="engine_damage_cost" placeholder="Engine damage cost" required pattern="^[0-9]+$"> (integer value)
		
		<p>Huge damage 
		<input size="30" name="huge_damage_cost" placeholder="Huge damage cost" required pattern="^[0-9]+$"> (integer value) -->
	
		<p><button type="submit" name="command" value="ADD_CAR">Add car</button>
	</form>

</body>
</html>