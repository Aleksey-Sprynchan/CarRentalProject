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
		<strong>Brand:</strong> 
		<input type="text" name="brand_name" list="brandList" placeholder="Select or enter brand">
		
		<datalist id="brandList">
			<c:forEach items="${brand_names}" var="brand">
				<option value="${brand}">${brand}</option>
			</c:forEach>
		</datalist>
		
		<strong>Model:</strong>
		<input size="30" name="model" placeholder="Enter car model here"> 	
		
		<strong>Type:</strong> 
		<input size="30" name="type" placeholder="Enter car type here">

		<strong>Transmission:</strong> 
		<input size="30" name="transmission" placeholder="Enter car transmission type here">
		
		<strong>Doors:</strong> 
		<input size="30" name="doors" placeholder="Enter doors number">
		
		<strong>Passengers:</strong> 
		<input size="30" name="passengers" placeholder="Enter passengers number">
		
		<strong>Fuel:</strong> 
		<input size="30" name="fuel" placeholder="Enter fuel type">
		
		<strong>AirCondition:</strong> 
		<input size="30" name="is_air_condition" placeholder="is Air Condition">
		
		
		<button type="submit" name="command" value="ADD_CAR">Add car</button>
	</form>

</body>
</html>