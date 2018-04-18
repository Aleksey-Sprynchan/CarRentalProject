<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CAR PARK</title>
</head>
<body>

	<c:forEach items="${car_list}" var="car">
		<p>
		<form action="CarRentalServlet" method="post">
			<c:out value="${car.getBrandName()}" />
			<c:out value="${car.getModel()}" />
			<c:out value="(${car.getType()})" />
			<c:out value="${car.getTransmission()} transmission" />
			<c:out value="${car.getDoors()} doors" />
			<c:out value="${car.getPassengers()} passengers" />
			<c:out value="${car.getFuel()}" />
			<c:out value="Air Condition: ${car.isAirCondition()}" />
			<c:choose>
				<c:when test="${car.isAvailable()}">
        			<c:out value="Available for rent" />
   	 			</c:when>
				<c:otherwise>
					<c:out value="RENTED" />
   				</c:otherwise>
			</c:choose>
			<input type="hidden" name="car_id" value="${car.getId()}" />
			<button type="submit" name="command" value="DELETE_CAR">Delete this car</button>
			<button type="submit" name="command" value="EDIT_CAR">Update this car info</button>
		</form>
	</c:forEach>
	
	<form action="CarRentalServlet" method="get">
		<br><br><button type="submit" name="command" value="TO_MY_PROFILE_PAGE">My profile</button>	
	</form>	



</body>
</html>