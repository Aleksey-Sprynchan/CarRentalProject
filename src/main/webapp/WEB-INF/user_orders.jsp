<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MY ORDERS</title>
<style type="text/css">
   .block1 { 
   	text-align: left;
    width: 1200px; 
    background: #ccc;
    padding: 5px;
    border: solid 3px black; 
    float: right;
   }
   .block2 { 
   	text-align: center;
    width: 100%; 
    float: right;
   }
   .block3 { 
   	text-align: left;
    width: 120px; 
    height: 200px;
    float: left;
   }
  </style> 
</head>
<body>

	<div class="block2">
	<h3>My Orders</h3>
	</div>
	
	<div class="block3"><p>
	<p><form action="CarRentalServlet" method="get">
		<br><br><button type="submit" name="command" value="TO_MY_PROFILE_PAGE">My profile</button>	
	</form>
	</div>


	<div class="block1"> 
	<ol>
    <c:if test="${not empty order_list}">
     <c:forEach items="${order_list}" var="order">
		<p>
		<li>
		<form action="CarRentalServlet" method="post"> 
		<c:out value="${order.getCustomer().getName()}" />
		<c:out value="${order.getCustomer().getSurname()}" />	
		<c:out value="${order.getCarId()}" />
		<c:out value="${orderCar_map.get(order.getId())}" />
		<c:out value="${order.getStartDate()}" />
		<c:out value="${order.getEndDate()}" />	
		<strong><c:out value="${order.getStatus().name()}" /></strong>
		<c:out value="${order.getTotalPrice()}$" />	
		<c:choose>
		<c:when test="${order.getStatus().name() == 'WAITING_FOR_PAYMENT'}">	
			<input type="hidden" name="order_id" value="${order.getId()}"/>
			<button type="submit" name="command" value="PAY_FOR_ORDER">Pay for order</button>
			<button type="submit" name="command" value="CANCEL_ORDER">Cancel order</button>		
		</c:when>	
		<c:when test="${order.getStatus().name() == 'WAITING_FOR_DAMAGE_PAYMENT'}">		
			<input type="hidden" name="order_id" value="${order.getId()}"/>
			<strong><c:out value="${order.getDamageAmount()} USD" /></strong>
			<button type="submit" name="command" value="PAY_FOR_DAMAGE">Pay for damage</button>	
		</c:when>
		<c:when test="${order.getStatus().name() == 'REJECTED'}">	
			<font size="3" color="red" face="Times New Roman">This order has been rejected by admin!</font>
			<c:out value="(${order.getRejectionReason()})"/> 	
		</c:when>
		<c:when test="${order.getStatus().name() == 'WAITING_FOR_APPROVE'}">
			<input type="hidden" name="order_id" value="${order.getId()}"/>
			<button type="submit" name="command" value="CHANGING_ORDER_PAGE">Change order info</button>	
			<button type="submit" name="command" value="CANCEL_ORDER">Cancel order</button>		
		</c:when>
		<c:when test="${order.getStatus().name() == 'PAID'}">		
		</c:when>
		<c:when test="${order.getStatus().name() == 'FINISHED'}">		
		</c:when>
		<c:when test="${order.getStatus().name() == 'CANCELLED'}">		
		</c:when>
		<c:otherwise>
		<strong>Error</strong>
		</c:otherwise>
		</c:choose>	
		</form>	
		</li>
	</c:forEach>
	</c:if>
    </ol> 
    <c:if test="${empty order_list}">
		<p>You haven't got any orders yet</p>	
	</c:if>
	</div> 
	
	<div class="block2">
	<c:if test="${not empty info_message}">
		<p><c:out value="${info_message}"/></p>	
	</c:if>
	</div>


</body>
</html>