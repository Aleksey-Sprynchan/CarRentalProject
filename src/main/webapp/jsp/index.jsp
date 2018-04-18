<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Page</title>

</head>
<body>


	<jsp:forward page="/CarRentalServlet">
		<jsp:param  name="command" value="INDEX_PAGE"/>
	</jsp:forward>

	


</body>
</html>