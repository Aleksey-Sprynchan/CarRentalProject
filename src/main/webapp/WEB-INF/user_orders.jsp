<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User orders</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
	
	<c:if test="${not empty order_list}">
	<ol>
	<c:forEach items="${order_list}" var="order">
		
		<li>
		<form action="CarRentalServlet" method="post">
		<p>
		<c:out value="${order}" />
		<input type="hidden" name="order_id" value="${order.getId()}"/>
		<button type="submit" name="command" value="VIEW_ORDER_DETAILS">View details</button>	
		</p>	
		</form>
		</li>
	</c:forEach>
	</ol>
		
	</c:if>
	
	<c:if test="${empty order_list}">
		This user hasn't got any orders yet!
	</c:if>
	
	
	<form action="CarRentalServlet" method="get">
		<br><br><button type="submit" name="command" value="TO_MY_PROFILE_PAGE">My profile</button>	
	</form>	



</body>
</html>