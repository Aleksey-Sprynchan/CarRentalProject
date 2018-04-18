<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>REPORT DAMAGES</title>
</head>
<body>
	
	<form action="CarRentalServlet" method="post">
	<input type="checkbox" name="damage" value="99" checked="checked"/>The car is not recoverable<br /> 
	<input type="checkbox" name="damage" value="152" /> Headlight is broken <br /> 
	<input type="checkbox" name="damage" value="185" /> Punctured wheel<br /> 
	<input type="checkbox" name="damage" value="154" /> Engine is lost<br /> 
	<input type="checkbox" name="damage" value="36" /> There is no car roof<br /> 
	<input type="checkbox" name="damage" value="85" /> Side door is crushed <br />
	<input type="hidden" name="damage" value="0"/>
	<input type="hidden" name="order_id" value="${order_id}"/> 
	<p><button type="submit" name="command" value="SEND_DAMAGE_REPORT">Send damage payment amount to customer</button></p>
	<input type="reset" value="Reset" />
	</form>
	

</body>
</html>