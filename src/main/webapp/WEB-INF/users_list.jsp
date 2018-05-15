<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Users List</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
	
	<c:if test="${not empty user_list}">
	<c:forEach items="${user_list}" var="user">
		<p>
		<form action="CarRentalServlet" method="post">
			<c:out value="${user}" />
			<input type="hidden" name="user_id" value="${user.getId()}" />
			<button type="submit" name="command" value="VIEW_USER_ORDERS">View user orders</button>		
		</form>
	</c:forEach>
	</c:if>
	
	<c:if test="${empty user_list}">
		There are no users yet!
	</c:if>
	
	
	<form action="CarRentalServlet" method="get">
		<br><br><button type="submit" name="command" value="TO_MY_PROFILE_PAGE">My profile</button>	
	</form>	



</body>
</html>