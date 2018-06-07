<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${empty sessionScope.locale}">
<c:set var="locale" value="en" scope="session"/>
</c:if>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index Page</title>
</head>
<body>
	<jsp:forward page="/CarRentalServlet">
		<jsp:param name="command" value="start_page" />
	</jsp:forward>
</body>
</html>