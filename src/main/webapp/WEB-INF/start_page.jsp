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
    <fmt:message key="home_page" />
  </title>
  <c:import url="../jsp/head_layout.jsp" />
</head>

<body>

  <div class="container">
    <c:import url="../jsp/header.jsp" />
    <nav class="navbar navbar-expand-lg navbar-light bg-warning">
      <span class="fas fa-hand-peace fa-lg"></span>
      <span class="navbar-brand font-weight-bold font-italic ml-2">
        <fmt:message key="slogan" /> </span>
      <ul class="navbar-nav mr-auto"></ul>
      <c:choose>
        <c:when test="${sessionScope.user_type == 'ADMIN'}">
          <a href="/CarRental/CarRentalServlet?command=to_my_profile_page" class="btn btn-dark navbar-btn ml-3" role="button">
            <fmt:message key="my_profile" />
          </a>
          <a href="/CarRental/CarRentalServlet?command=sign_out" class="btn btn-dark navbar-btn ml-2" role="button">
            <fmt:message key="sign_out" />
          </a>
        </c:when>
        <c:when test="${sessionScope.user_type == 'USER'}">
          <a href="/CarRental/CarRentalServlet?command=to_my_profile_page" class="btn btn-dark navbar-btn ml-3" role="button">
            <fmt:message key="my_profile" />
          </a>
          <a href="/CarRental/CarRentalServlet?command=sign_out" class="btn btn-dark navbar-btn ml-2" role="button">
            <fmt:message key="sign_out" />
          </a>
        </c:when>
        <c:otherwise>
          <ul class="nav navbar-nav navbar-right">
            <li class="nav-item dropdown active">
              <a class="btn btn-dark nav-link dropdown-toggle text-white" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true"
                aria-expanded="false">
                <span class="fas fa-user fa-lg"></span>
                <fmt:message key="sign_in" />
              </a>
              <div class="dropdown-menu">
                <form class="px-4 py-3" action="CarRentalServlet" method="post">
                  <div class="form-group">
                    <label for="exampleDropdownFormEmail1">
                      <fmt:message key="login" />:</label>
                    <input type="text" class="form-control" id="exampleDropdownFormEmail1" name="login" required>
                  </div>
                  <div class="form-group">
                    <label for="exampleDropdownFormPassword1">
                      <fmt:message key="password" />:</label>
                    <input type="password" class="form-control" id="exampleDropdownFormPassword1" name="password" required>
                  </div>
                  <button class="btn btn-primary" type="submit" name="command" value="authorization">
                    <fmt:message key="sign_in" />
                  </button>
                </form>
                <div class="dropdown-divider"></div>
                <form action="CarRentalServlet" method="get">
                  <a class="dropdown-item" href="/CarRental/CarRentalServlet?command=registration_page">
                    <fmt:message key="new_here" />
                    <fmt:message key="sign_up" />
                  </a>
                </form>
              </div>
            </li>
            <a href="/CarRental/CarRentalServlet?command=registration_page" class="btn btn-dark navbar-btn ml-2" role="button">
              <fmt:message key="sign_up" />
            </a>
          </ul>
        </c:otherwise>
      </c:choose>
    </nav>
    <c:if test="${not empty info_message}">
      <div class="row ">
        <div class="col-sm">
          <div class="col-sm text-center p-3 mb-2 bg-dark text-white">
            <h4>
              <strong>
                <c:out value="${info_message}" />
              </strong>
            </h4>
          </div>
        </div>
      </div>
    </c:if>
    <c:if test="${not empty car_list}">
      <c:forEach items="${car_list}" var="car">
        <ul class="list-unstyled">
          <hr>
          <li class="media">
            <img class="mr-5" src="${car.getImage()}" alt="Car image">
            <div class="media-body">
              <h5 class="mt-4 mb-4">
                <c:out value="${car.getBrandName()} ${car.getModel()}" /> </h5>
              <div class="row">
                <div class="col-sm-9">
                  <div class="row">
                    <div class="col-sm">
                      <div class="row">
                        <div class="col-sm-1">
                          <span class="fas fa-car fa-lg"></span>
                        </div>
                        <div class="col-sm-1">
                          <c:out value="${car.getType()}" />
                        </div>
                      </div>
                    </div>
                    <div class="col-sm">
                      <div class="row">
                        <div class="col-sm-1">
                          <span class="fas fa-arrows-alt fa-lg"></span>
                        </div>
                        <div class="col-sm-1">
                          <c:out value="${car.getTransmission()}" />
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-sm">
                      <div class="row">
                        <div class="col-sm-1">
                          <span class="fas fa-battery-three-quarters fa-lg"></span>
                        </div>
                        <div class="col-sm-1">
                          <c:out value="${car.getFuel()}" />
                        </div>
                      </div>
                    </div>
                    <div class="col-sm">
                      <div class="row">
                        <div class="col-sm-1">
                          <span class="fas fa-user-friends fa-sm"></span>
                        </div>
                        <div class="col-sm-1">
                          <c:out value="${car.getPassengers()}" />
                        </div>
                      </div>
                    </div>
                  </div>
                  <c:if test="${car.isAirCondition() eq true}">
                    <div class="row">
                      <div class="col-sm">
                        <div class="row">
                          <div class="col-sm-1">
                            <span class="fas fa-thermometer-half fa-lg"></span>
                          </div>
                          <div class="col-sm-10">Air condition</div>
                        </div>
                      </div>
                      <div class="col-sm"></div>
                    </div>
                  </c:if>
                </div>
                <div class="col-sm-3 feature text-center">
                  <strong>
                    <fmt:message key="only" />
                    <c:out value="${car.getPricePerDay()}" />$/
                    <fmt:message key="day" />
                  </strong>
                  <c:if test="${sessionScope.user_type == 'ADMIN'}">
                    <a href="/CarRental/CarRentalServlet?command=edit_car&car_id=${car.getId()}" class="btn btn-warning" role="button">
                      <fmt:message key="edit_car" />
                    </a>
                  </c:if>
                  <c:if test="${empty sessionScope.user_type}">
                    <a href="/CarRental/CarRentalServlet?command=sign_in_page" class="btn btn-warning" role="button">
                      <fmt:message key="book_car" />
                    </a>
                  </c:if>
                  <c:if test="${sessionScope.user_type == 'USER'}">
                    <a href="/CarRental/CarRentalServlet?command=book_car&car_id=${car.getId()}" class="btn btn-warning" role="button">
                      <fmt:message key="book_car" />
                    </a>
                  </c:if>
                </div>
              </div>
            </div>
          </li>
          <hr>
        </ul>
      </c:forEach>
    </c:if>
    <c:if test="${empty car_list}">
      <div class="row">
        <div class="mx-auto text-danger">
          <h5>
            <strong>
              <fmt:message key="no_cars_for_rent" />
            </strong>
          </h5>
        </div>
      </div>
    </c:if>
  </div>
  <ctg:footer/>
  <c:import url="../js/optional_js.jsp" />
</body>

</html>