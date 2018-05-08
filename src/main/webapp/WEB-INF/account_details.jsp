<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Account details</title>
</head>

<body>
    
       <strong>
       		<p> <c:out value="Name: ${user.getName()}"/>
       		<p> <c:out value="Surname: ${user.getSurname()}"/>
       		<p> <c:out value="Email: ${user.getEmail()}"/>
       		<p> <c:out value="Balance: ${user.getBalance()}"/>      
       </strong>
	

	<form action="CarRentalServlet" method="get"> 	
		<p><button type="submit" name="command" value="CHANGING_ACCOUNT_INFO_PAGE">Change account info</button>
	</form>
	
	<form action="CarRentalServlet" method="get">
		<p><button type="submit" name="command" value="CHANGING_PASSWORD_PAGE">Change password</button>
	</form>
	
	<form action="CarRentalServlet" method="get">
		<p><button type="submit" name="command" value="DEPOSIT_PAGE">Make a deposit</button>
	</form>
	
	<form action="CarRentalServlet" method="get">
		<p><button type="submit" name="command" value="DELETE_ACCOUNT_PAGE">Delete Account</button>
	</form>
	
	<form action="CarRentalServlet" method="get">
		<button type="submit" name="command" value="TO_MY_PROFILE_PAGE">My profile</button>	
	</form>
	
	<p><a href="/CarRental/CarRentalServlet?command=TO_MY_PROFILE_PAGE">TEST</a></p>
	

</body>
</html>