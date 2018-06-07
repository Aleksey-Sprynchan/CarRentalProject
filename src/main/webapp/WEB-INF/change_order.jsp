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
    <fmt:message key="change_order" />
  </title>
  <c:import url="../jsp/head_layout.jsp" />
  <c:import url="../js/change_order_js.jsp" />
</head>

<body onload="loadData()">
  <div class="container">
    <c:import url="../jsp/header.jsp" />
    <c:import url="../jsp/user_navbar.jsp" />
    <hr>
    <div class="row">
      <div class="col-sm text-center p-3 mb-2 bg-dark text-white">
        <h4>
          <fmt:message key="change_order_customer_info" />
        </h4>
      </div>
    </div>
    <form name="main" action="CarRentalServlet" method="post">
      <div id="div_one" class="form-group row">
        <div id="div_two" class="col-sm-3 mx-auto">
          <label>
            <fmt:message key="name" />:</label>
          <c:if test="${not empty invalid_name}">
            <small class="form-text text-danger">
              <c:out value="${invalid_name}" />
            </small>
          </c:if>
          <input class="form-control" name="customer_name" required>
          <label class="mt-1">
            <fmt:message key="surname" />:</label>
          <c:if test="${not empty invalid_surname}">
            <small class="form-text text-danger">
              <c:out value="${invalid_surname}" />
            </small>
          </c:if>
          <input class="form-control" name="customer_surname" required>
          <label class="mt-1">
            <fmt:message key="passport_numb" />:</label>
          <c:if test="${not empty invalid_passport_numb}">
            <small class="form-text text-danger">
              <c:out value="${invalid_passport_numb}" />
            </small>
          </c:if>
          <input class="form-control" name="passport_numb" required>
          <label class="mt-1">
            <fmt:message key="date_of_birth" />:</label>
          <c:if test="${not empty invalid_birth_date}">
            <small class="form-text text-danger">
              <c:out value="${invalid_birth_date}" />
            </small>
          </c:if>
          <input class="form-control" type="text" id="birthDatePicker" name="date_of_birth" required>
          <label class="mt-1">
            <fmt:message key="driving_exp" />:</label>
          <c:if test="${not empty invalid_driving_exp}">
            <small class="form-text text-danger">
              <c:out value="${invalid_driving_exp}" />
            </small>
          </c:if>
          <input class="form-control" name="driving_exp" required pattern="^[0-9]+$">
          <input type="hidden" name="customer_id" />
          <div class="row">
            <div class="col-sm text-center">
              <button type="submit" class="btn btn-primary my-2" name="command" value="change_order">
                <fmt:message key="change" />
              </button>
            </div>
          </div>
        </div>
      </div>
    </form>
  </div>
  <ctg:footer/>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
    crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
    crossorigin="anonymous"></script>
</body>

</html>