<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>REDIRECT</title>

</head>
<body>

	<jsp:forward page="/CarRentalServlet/${path}">
	<!-- 	<jsp:param  name="command" value="REDIRECT"/>  -->
		<jsp:param  name="path" value="${path}"/>
	</jsp:forward>

</body>
</html>