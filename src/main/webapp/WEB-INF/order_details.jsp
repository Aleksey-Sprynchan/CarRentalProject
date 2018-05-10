<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ORDER DETAILS PAGE</title>
</head>
<body>
		<c:out value="${order}" />
		<p><c:out value="${user}" />
		
		<c:choose>
		<c:when test="${order.getStatus() == 'WAITING_FOR_APPROVE'}">
			<form action="CarRentalServlet" method="post">
			<input type="hidden" name="order_id" value="${order.getId()}"/>
			<input type="hidden" name="car_id" value="${order.getCarId()}"/>
			<p><button type="submit" name="command" value="APPROVE_ORDER">Approve order</button></p>
			<p><button type="submit" name="command" value="REJECT_ORDER">Reject order</button></p>
			</form>
		</c:when>	
		<c:when test="${order.getStatus() == 'PAID'}">
			<form action="CarRentalServlet" method="post">
			<input type="hidden" name="order_id" value="${order.getId()}"/>
			<input type="hidden" name="car_id" value="${order.getCarId()}"/>
			<p><button type="submit" name="command" value="MARK_AS_RETURNED">Client returned car</button></p>
			</form>
		</c:when>
		<c:when test="${order.getStatus() == 'RETURNED'}">
			<form action="CarRentalServlet" method="post">
			<input type="hidden" name="order_id" value="${order.getId()}"/>
			<input type="hidden" name="car_id" value="${order.getCarId()}"/>
			<p><button type="submit" name="command" value="REPORT_DAMAGES">Report damages</button></p>
			<p><button type="submit" name="command" value="FINISH_ORDER">Finish order</button></p>
			</form>
		</c:when>
		<c:otherwise>
		<strong>ERROR!!!!!!!!!!!!!!!!</strong>
		</c:otherwise>
		</c:choose>
		


</body>
</html>