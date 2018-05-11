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
		
		<p>Passengers 
		<input size="30" name="passengers" placeholder="Enter passengers number" required pattern="^[0-9]+$">
		
		<p>Fuel 
		<input size="30" name="fuel" placeholder="Enter fuel type" required>
		
		<p>Price per day 
		<input size="30" name="price_per_day" placeholder="Enter price" required pattern="^[0-9]+$"> (integer value)
		
		<fieldset>
    	 <legend>Air Condition</legend>
      		<input type="radio" name="is_air_condition" value="true">Yes
      		<input type="radio" name="is_air_condition" value="false">No
   		 </fieldset>

		<p>Image link
		<input size="30" name="image" placeholder="insert link here" required>
	
		<p><button type="submit" name="command" value="ADD_CAR">Add car</button>
	</form>

</body>
</html>