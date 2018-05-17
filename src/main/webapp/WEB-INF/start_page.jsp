<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Before Index Page</title>
<style>
   body {
    background: #c7b39b; 
   }
  </style>

<style type="text/css">
   .block1 { 
   	text-align: left;
    width: 1000px; 
    background: #ccc;
    padding: 5px;
    border: solid 3px black; 
    float: right;
   }
  </style> 
</head>
<body>

	<div class="block1">  
	<c:if test="${not empty car_list}">
     <c:forEach items="${car_list}" var="car">
		<p>
		<img src="${car.getImage()}" alt="car_image">
		<c:out value="${car}" />	
	</c:forEach>
	</c:if>
	<c:if test="${empty car_list}">
	There are no available cars for rent!
	</c:if>
	</div>
	 
	
	<div align="left">
	
	<c:if test="${not empty info_message}">
		<p><strong><c:out value="${info_message}" /></strong></p>
	</c:if>
	
	
	<c:choose>
	
		<c:when test="${sessionScope.user_type == 'ADMIN'}">
			<p> loggedIn as Admin</p>
			<form action="CarRentalServlet" method="get">
				<p><button type="submit" name="command" value="SIGN_OUT">Sign out</button>
 			 </form>
 			 <form action="CarRentalServlet" method="get">
				<br><br><button type="submit" name="command" value="TO_MY_PROFILE_PAGE">My profile</button>	
			</form>	
		</c:when>
		<c:when test="${sessionScope.user_type == 'USER'}">
			<p> loggedIn as User</p>
			<form action="CarRentalServlet" method="get">
				<p><button type="submit" name="command" value="SIGN_OUT">Sign out</button>
 			 </form>	
 			  <form action="CarRentalServlet" method="get">
				<br><br><button type="submit" name="command" value="TO_MY_PROFILE_PAGE">My profile</button>	
			</form>		
		</c:when>
		<c:otherwise>
		<p> Hello GUEST! </p>
		<form action="CarRentalServlet" method="post">
   			<p><strong>Login:</strong> 
    		<input maxlength="25" size="40" name="login" required ></p>
   			<p><strong>Password:</strong> 
    		<input type="password" maxlength="25" size="40" name="password" required></p>
    		<button type="submit" name="command" value="AUTHORIZATION" >Log In</button>
  		</form>
  
  		<form action="CarRentalServlet" method="get">
   			 <p><button type="submit" name="command" value="REGISTRATION_PAGE" >Registration</button>
  		</form>	
		</c:otherwise>	
		</c:choose>
		</div>
			

</body>
</html>