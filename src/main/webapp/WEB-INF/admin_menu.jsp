<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Profile</title>
<style type="text/css">
   .block1 { 
   	text-align: center;
    width: 1200px; 
    background: #ccc;
    padding: 5px;
    border: solid 3px black; 
    float: right;
   }
  </style> 
</head>
<body>
			
	<h1>Hello Admin</h1>
	
	<c:if test="${not empty info_message}">
		<p><c:out value="${info_message}" /></p>	
	</c:if>
	
	<div align="left"><p>
	<p><form action="CarRentalServlet" method="get">
		<input type="hidden" name="command" value="VIEW_CAR_PARK" />
		<input type="submit" value="view cars" />	
	</form>

	<br>
	<form action="CarRentalServlet" method="get"> 
	<input type="hidden" name="command" value="ADDING_CAR"/>
	<input type="submit" value="Create car"/>
	</form>

	<form action="CarRentalServlet" method="post">
		<p><button type="submit" name="command" value="SIGN_OUT">Sign out</button>
	</form>
	</div>
	
	<div class="block1">  
		
		
  		
  		<form action="CarRentalServlet" method="post">
  		<strong>Order status:</strong> 
    		<select name="order_status" >
    		<option selected>All orders</option>
    		<c:forEach items="${order_status_list}" var="status">
    		<option value="${status}">${status}</option>   
    		</c:forEach>
   		</select>
   		<button type="submit" name="command" value="SHOW_ORDERS_BY_STATUS">Show by status</button>
  		</form>
  		
  		
  		
     <c:forEach items="${order_list}" var="order">
		<p>
		<form action="CarRentalServlet" method="post"> 
		<c:out value="${order.getId()}"/>
		<c:out value="${order.getStatus()}"/>
		<c:out value="${order.getCustomer().getName()}"/>
		<c:out value="${order.getCustomer().getSurname()}"/>	
		<button type="submit" name="command" value="VIEW_ORDER_DETAILS">View details</button>
		<input type="hidden" name="order_id" value="${order.getId()}"/>
		</form>	
	</c:forEach>
	</div> 
	
	
	

	
</body>
</html>