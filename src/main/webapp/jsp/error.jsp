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
    <fmt:message key="error_page" />
  </title>
  <c:import url="../jsp/head_layout.jsp" />
</head>

<body>
  <div class="container">
    <c:import url="../jsp/header.jsp" />
    <hr>
    <div class="row">
      <div class="col-sm">
        <div class="col-sm text-center p-3 mb-2 bg-dark text-white">
          <h4>
            <fmt:message key="oops" />
          </h4>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-sm-8 mx-auto text-danger text-center">
        <h5>
          <strong>
            <fmt:message key="error_page_message" />
          </strong>
        </h5>
      </div>
    </div>
    <div class="row">
      <div class="mx-auto">
        <p>
          <a href="/CarRental/CarRentalServlet?command=start_page">
            <img src="images/mona-lisa.jpg" alt="Comming Soon">
          </a>
        </p>
      </div>
    </div>
    <div class="row">
      <div class="mx-auto">
        <a href="/CarRental/CarRentalServlet?command=start_page" class="btn btn-dark navbar-btn" role="button">
          <fmt:message key="home_page" />
        </a>
      </div>
    </div>
  </div>
  <ctg:footer/>
  <c:import url="../js/optional_js.jsp" />
</body>

</html>