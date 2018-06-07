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
    <fmt:message key="changing_personal_info" />
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
          <fmt:message key="changing_personal_info" />
        </h4>
      </div>
    </div>
    <div class="row">
      <div class="mx-auto text-danger">
        <c:if test="${not empty info_message}">
          <c:out value="${info_message}" />
        </c:if>
      </div>
    </div>
    <form action="CarRentalServlet" method="post">
      <div class="form-group row">
        <div class="col-sm-3 mx-auto">
          <label>
            <fmt:message key="name" />:</label>
          <c:if test="${not empty invalid_name}">
            <small class="form-text text-danger">
              <c:out value="${invalid_name}" />
            </small>
          </c:if>
          <input class="form-control" name="name" value="${user.getName()}" required>
          <label class="mt-1">
            <fmt:message key="surname" />:</label>
          <c:if test="${not empty invalid_surname}">
            <small class="form-text text-danger">
              <c:out value="${invalid_surname}" />
            </small>
          </c:if>
          <input class="form-control" name="surname" value="${user.getSurname()}" required>
          <label class="mt-1">
            <fmt:message key="email" />:</label>
          <c:if test="${not empty invalid_email}">
            <small class="form-text text-danger">
              <c:out value="${invalid_email}" />
            </small>
          </c:if>
          <input class="form-control" name="email" value="${user.getEmail()}" required>
          <div class="row">
            <div class="col-sm text-center">
              <button type="submit" class="btn btn-primary mt-2" name="command" value="change_personal_info">
                <fmt:message key="change" />
              </button>
            </div>
          </div>
        </div>
      </div>
    </form>
  </div>
  <ctg:footer/>
  <c:import url="../js/optional_js.jsp" />
</body>

</html>