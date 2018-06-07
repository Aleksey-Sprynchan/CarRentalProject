<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="ctg" uri="customtags" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="Resource"/>

<!DOCTYPE html>
<html>

<head>
  <title>
    <fmt:message key="delete_account" />
  </title>
  <c:import url="../jsp/head_layout.jsp" />
</head>

<body>
  <div class="container">
    <c:import url="../jsp/header.jsp" />
    <c:import url="../jsp/user_navbar.jsp" />
    <hr>
    <div class="row">
      <div class="col-sm text-center p-3 mb-2 bg-dark text-white">
        <h4>
          <fmt:message key="my_settings" />
        </h4>
      </div>
    </div>
    <div class="row">
      <div class="col-sm">
        <p>
          <strong>
            <fmt:message key="personal_info" />:</strong>
        </p>
        <ul class="no-markers">
          <li>
            <fmt:message key="name" />:
            <strong class="ml-2">
              <c:out value="${sessionScope.user.getName()}" />
            </strong>
          </li>
          <li>
            <fmt:message key="surname" />:
            <strong class="ml-2">
              <c:out value="${sessionScope.user.getSurname()}" />
            </strong>
          </li>
          <li>
            <fmt:message key="email" />:
            <strong class="ml-2">
              <c:out value="${sessionScope.user.getEmail()}" />
            </strong>
        </ul>
        <p>
          <a href="/CarRental/CarRentalServlet?command=changing_personal_info_page" class="btn btn-warning" role="button">
            <fmt:message key="change_personal_info" />
          </a>
        </p>
        <p>
          <a href="/CarRental/CarRentalServlet?command=changing_password_page" class="btn btn-warning" role="button">
            <fmt:message key="change_password" />
          </a>
        </p>
        <p>
          <a href="/CarRental/CarRentalServlet?command=delete_account_page" class="btn btn-warning" role="button">
            <fmt:message key="delete_account" />
          </a>
        </p>
      </div>
    </div>
  </div>
  <ctg:footer/>
  <c:import url="../js/optional_js.jsp"/>
</body>

</html>