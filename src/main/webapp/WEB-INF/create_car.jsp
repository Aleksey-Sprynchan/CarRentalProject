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
    <fmt:message key="adding_car" />
  </title>
  <c:import url="../jsp/head_layout.jsp" />
</head>

<body>

  <div class="container">
    <c:import url="../jsp/header.jsp" />
    <c:import url="../jsp/admin_navbar.jsp" />
    <hr>
    <div class="row">
      <div class="col-sm">
        <div class="col-sm text-center p-3 mb-2 bg-dark text-white">
          <h4>
            <fmt:message key="adding_car_form" /> </h4>
        </div>
      </div>
    </div>
    <div class="col-md-8 mx-auto">
      <form action="CarRentalServlet" method="post">
        <div class="row">
          <div class="col-md-6 mb-3">
            <label for="brand">
              <fmt:message key="brand" />:</label>
            <input type="text" class="form-control" id="brand" name="brand_name" list="brand_names" placeholder="<fmt:message key="select_or_enter_brand" />" value="${brand_name}" required>
            <datalist id="brand_names">
              <c:forEach items="${brand_names_list}" var="brand">
                <option value="${brand}">${brand}</option>
              </c:forEach>
            </datalist>
            <c:if test="${not empty invalid_brand}">
              <small class="form-text text-danger">
                <c:out value="${invalid_brand}" />
              </small>
            </c:if>
          </div>
          <div class="col-md-6 mb-3">
            <label for="model">
              <fmt:message key="model" />:</label>
            <input type="text" class="form-control" id="model" name="model" value="${model}" required>
            <c:if test="${not empty invalid_model}">
              <small class="form-text text-danger">
                <c:out value="${invalid_model}" />
              </small>
            </c:if>
          </div>
        </div>
        <div class="row">
          <div class="col-md-6 mb-3">
            <label for="type">
              <fmt:message key="type" />:</label>
            <input type="text" class="form-control" id="type" name="type" value="${type}" required>
            <c:if test="${not empty invalid_type}">
              <small class="form-text text-danger">
                <c:out value="${invalid_type}" />
              </small>
            </c:if>
          </div>
          <div class="col-md-6 mb-3">
            <label for="transmission">
              <fmt:message key="transmission" />:</label>
            <input type="text" class="form-control" id="transmission" name="transmission" value="${transmission}" required>
            <c:if test="${not empty invalid_transmission}">
              <small class="form-text text-danger">
                <c:out value="${invalid_transmission}" />
              </small>
            </c:if>
          </div>
        </div>
        <div class="row">
          <div class="col-md-6 mb-3">
            <label for="passengers">
              <fmt:message key="passengers" />:</label>
            <input type="text" class="form-control" id="passengers" name="passengers" value="${passengers}" required pattern="([1-9])([0-9]?)">
            <c:if test="${not empty invalid_passengers}">
              <small class="form-text text-danger">
                <c:out value="${invalid_passengers}" />
              </small>
            </c:if>
          </div>
          <div class="col-md-6 mb-3">
            <label for="fuel">
              <fmt:message key="fuel" />:</label>
            <input type="text" class="form-control" id="fuel" name="fuel" value="${fuel}" required>
            <c:if test="${not empty invalid_fuel}">
              <small class="form-text text-danger">
                <c:out value="${invalid_fuel}" />
              </small>
            </c:if>
          </div>
        </div>
        <h6 class="mb-2">
          <fmt:message key="air_conditioner" />:</h6>
        <div class="custom-control custom-radio custom-control-inline">
          <input type="radio" id="radioyes" class="custom-control-input" name="air_condition" value="true" required>
          <label class="custom-control-label" for="radioyes">
            <fmt:message key="yes" />
          </label>
        </div>
        <div class="custom-control custom-radio custom-control-inline mb-3">
          <input type="radio" id="radiono" class="custom-control-input" name="air_condition" value="false" required>
          <label class="custom-control-label" for="radiono">
            <fmt:message key="no" />
          </label>
        </div>
        <div class="row">
          <div class="col-md-6 mb-3">
            <label for="price_per_day">
              <fmt:message key="price_per_day" /> (USD):</label>
            <input type="text" class="form-control" id="price_per_day" name="price_per_day" value="${price_per_day}" placeholder="<fmt:message key="price_message" />" required pattern="([1-9])([0-9]{0,2})">
            <c:if test="${not empty invalid_price}">
              <small class="form-text text-danger">
                <c:out value="${invalid_price}" />
              </small>
            </c:if>
          </div>
        </div>
        <div class="mb-3">
          <label for="image">
            <fmt:message key="image_link" />:</label>
          <input type="text" class="form-control" id="image" name="image" value="${image}" required>
          <c:if test="${not empty invalid_image_link}">
            <small class="form-text text-danger">
              <c:out value="${invalid_image_link}" />
            </small>
          </c:if>
        </div>
        <hr class="mb-4">
        <button class="btn btn-primary btn-lg btn-block mb-2" type="submit" name="command" value="add_car">
          <fmt:message key="create_car" />
        </button>
      </form>
    </div>
  </div>
  <ctg:footer/>
  <c:import url="../js/optional_js.jsp" />
</body>

</html>