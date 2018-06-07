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
    <fmt:message key="changing_password" />
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
          <fmt:message key="changing_password" />
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
            <fmt:message key="old_password" />:</label>
          <input class="form-control" type="password" name="old_password" required>
          <label class="mt-1">
            <fmt:message key="new_password" />:</label>
          <c:if test="${not empty invalid_password}">
            <small class="form-text text-danger">
              <c:out value="${invalid_password}" />
            </small>
          </c:if>
          <input class="form-control" type="password" name="new_password" required>
          <label class="mt-1">
            <fmt:message key="confirm_new_password" />:</label>
          <input class="form-control" type="password" name="confirm_new_password" required>
          <div class="row">
            <div class="col-sm text-center">
              <button type="submit" class="btn btn-primary mt-2" name="command" value="change_password">
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