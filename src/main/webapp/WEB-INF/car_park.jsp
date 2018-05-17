<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CAR PARK</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
	
	<c:if test="${not empty car_list}">

		<tr>
			<td>
		</tr>
	
	
	
	<table>
	<c:forEach items="${car_list}" var="car">
		<tr>	
			
			<c:if test="${car.isAvailable()}">
			<td>
			<c:out value="${car.getBrandName()}" />
			<c:out value="${car.getModel()}" />
			<c:out value="(${car.getType()})" />
			<c:out value="${car.getTransmission()} transmission" />
			<c:out value="${car.getPassengers()} passengers" />
			<c:out value="${car.getFuel()}" />
			<c:out value="Air Condition: ${car.isAirCondition()}" />
			<c:out value="Price:  ${car.getPricePerDay()}$" />
			</td>
			<td>	
				<form action="CarRentalServlet" method="post">			
					<button type="submit" name="command" value="DELETE_CAR">Delete this car</button>
					<input type="hidden" name="car_id" value="${car.getId()}" />
				</form>
			</td>	
			<td>
				<form action="CarRentalServlet" method="get">
					<button type="submit" name="command" value="EDIT_CAR">Update this car info</button>
					<input type="hidden" name="car_id" value="${car.getId()}" />
				</form>
			</td>	
			<td>
				<form action="CarRentalServlet" method="get">		
					<button type="submit" name="command" value="VIEW_CAR_DAMAGE_HISTORY">View car damage history</button>
					<input type="hidden" name="car_id" value="${car.getId()}" />
				</form>
			</td>	
				
		</c:if>
		<tr>
	
	</c:forEach>
	</table>
	</c:if>
	
	<p><strong>Inactive cars, that were deleted from the car park:</strong></p>
	<c:forEach items="${car_list}" var="car">
	<c:if test="${!car.isAvailable()}">		
		<form action="CarRentalServlet" method="get">
			<c:out value="${car.getBrandName()}" />
			<c:out value="${car.getModel()}" />
			<c:out value="(${car.getType()})" />
			<c:out value="${car.getTransmission()} transmission" />
			<c:out value="${car.getPassengers()} passengers" />
			<c:out value="${car.getFuel()}" />
			<c:out value="Air Condition: ${car.isAirCondition()}" />
			<c:out value="Price:  ${car.getPricePerDay()}$" />
			<input type="hidden" name="car_id" value="${car.getId()}" />
			<button type="submit" name="command" value="VIEW_CAR_DAMAGE_HISTORY">View car damage history</button>
		</form>
	</c:if>
	</c:forEach>
	
	<c:if test="${empty car_list}">
		There are no cars in the car park!
	</c:if>
	
	
	<form action="CarRentalServlet" method="get">
		<br><br><button type="submit" name="command" value="TO_MY_PROFILE_PAGE">My profile</button>	
	</form>	



</body>
</html>