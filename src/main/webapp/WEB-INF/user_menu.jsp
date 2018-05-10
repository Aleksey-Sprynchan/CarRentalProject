<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Profile</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

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

       
       <h1>Hello,
       <c:out value="${user.getName()}"/>
       <c:out value="${user.getSurname()} !" /></h1>
      
       <form action="CarRentalServlet" method="get">
       <p>Your balance: <strong><c:out value="${user.getBalance()}$ "></c:out></strong>
		<button type="submit" name="command" value="DEPOSIT_PAGE">Make a deposit</button>
		</form>
       
       
     <div class="block1">  
     <c:forEach items="${car_list}" var="car">
		<p>
		<form action="CarRentalServlet" method="post"> 
		<c:out value="${car}" />	
		<button type="submit" name="command" value="BOOK_CAR">Book this car</button>
		<input type="hidden" name="car_id" value="${car.getId()}"/>
		</form>	
	</c:forEach>
	</div> 
	
	<div align="left"><p>
	<form action="CarRentalServlet" method="post"> 	
		<p><button type="submit" name="command" value="VIEW_MY_ORDERS">My orders</button>
	</form>
	<form action="CarRentalServlet" method="post">
		<p><button type="submit" name="command" value="VIEW_ACCOUNT_DETAILS">My Account</button>
	</form>
	<form action="CarRentalServlet" method="post">
		<p><button type="submit" name="command" value="SIGN_OUT">Sign out</button>
	</form>
	</div>

</body>
</html>