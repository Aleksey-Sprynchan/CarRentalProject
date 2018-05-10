<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Car Damage History</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>

	
	<c:if test="${not empty order_set}">
	<c:forEach items="${order_set}" var="order">
		<br><p><strong><c:out value="Order №${order}:" /></strong></p>	
		<c:forEach items="${carDamHist_map.get(order)}" var="damage">
			<c:out value="${damage}" /><br>		
		</c:forEach>
	</c:forEach>
	</c:if>
	
	<c:if test="${empty order_set}">
		<p>This has never been damaged</p>	
	</c:if>

	<form action="CarRentalServlet" method="get">
		<button type="submit" name="command" value="TO_MY_PROFILE_PAGE">My profile</button>	
	</form>	


</body>
</html>