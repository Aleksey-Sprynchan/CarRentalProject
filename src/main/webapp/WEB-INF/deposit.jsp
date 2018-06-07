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
    <fmt:message key="deposit_page" />
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
          <fmt:message key="deposit_page" />
        </h4>
      </div>
    </div>
    <div class="row">
      <div class="mx-auto text-danger">
        <c:if test="${not empty invalid_deposit_amount}">
          <c:out value="${invalid_deposit_amount}" />
        </c:if>
      </div>
    </div>
    <form action="CarRentalServlet" method="post">
      <div class="form-group row">
        <div class="mx-auto">
          <label>
            <fmt:message key="enter_deposit_amount" />:</label>
          <input class="form-control" name="deposit_amount" pattern="[1-9][0-9]{0,2}" required>
          <small class="form-text text-muted">
            <fmt:message key="please_enter_deposit" />
          </small>
          <button type="submit" class="btn btn-primary mt-1" name="command" value="make_deposit">
            <fmt:message key="make_a_deposit" />
          </button>
        </div>
      </div>
    </form>
  </div>
  <ctg:footer/>
  <c:import url="../js/optional_js.jsp" />
</body>

</html>