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
    <fmt:message key="car_park" />
  </title>
  <c:import url="../jsp/head_layout.jsp" />
</head>

<body>
  <div class="container">
    <c:import url="../jsp/header.jsp" />
    <c:import url="../jsp/admin_navbar.jsp" />
    <c:if test="${not empty info_message}">
      <div class="row ">
        <div class="col-sm text-center p-3 mb-2 bg-dark text-white">
          <h4>
            <strong>
              <c:out value="${info_message}" />
            </strong>
          </h4>
        </div>
      </div>
    </c:if>
    <hr>
    <div class="row">
      <div class="col-sm">
        <div class="col-sm text-center p-3 mb-2 bg-dark text-white">
          <h4>
            <fmt:message key="car_park" /> </h4>
        </div>
      </div>
    </div>
    <c:if test="${not empty car_list}">
      <div class="row">
        <div class="col-sm">
          <div class="text-center p-3 mb-2 bg-dark text-white">
            <h5>
              <fmt:message key="available_cars" /> </h5>
          </div>
        </div>
      </div>
      <div class="table-responsive">
        <table class="table table-bordered table-striped">
          <thead class="thead-dark">
            <tr>
              <th scope="col" class="text-center">#</th>
              <th scope="col" class="text-center">
                <fmt:message key="image" />
              </th>
              <th scope="col" class="text-center">
                <fmt:message key="brand_and_model" />
              </th>
              <th scope="col" class="text-center">
                <fmt:message key="type" />
              </th>
              <th scope="col" class="text-center">
                <fmt:message key="transmission" />
              </th>
              <th scope="col" class="text-center">
                <fmt:message key="passengers" />
              </th>
              <th scope="col" class="text-center">
                <fmt:message key="fuel" />
              </th>
              <th scope="col" class="text-center">
                <fmt:message key="air_cond" />
              </th>
              <th scope="col" class="text-center">
                <fmt:message key="price_per_day" />
              </th>
              <th scope="col" class="text-center"></th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${car_list}" var="car">
              <tr>
                <th scope="row" class="align-middle">
                  <c:out value="${car.getId()}" />
                </th>
                <td class="align-middle">
                  <img src="${car.getImage()}" width="135" height="90" alt="${car.getBrandName()}">
                </td>
                <td class="text-center align-middle">
                  <c:out value="${car.getBrandName()}" />
                  <c:out value="${car.getModel()}" />
                </td>
                <td class="text-center align-middle">
                  <c:out value="${car.getType()}" />
                </td>
                <td class="text-center align-middle">
                  <c:out value="${car.getTransmission()}" />
                </td>
                <td class="text-center align-middle">
                  <c:out value="${car.getPassengers()}" />
                </td>
                <td class="text-center align-middle">
                  <c:out value="${car.getFuel()}" />
                </td>
                <td class="text-center align-middle">
                  <c:if test="${car.isAirCondition()}">
                    <span class="fas fa-check-circle fa-lg"></span>
                  </c:if>
                  <c:if test="${not car.isAirCondition()}">
                    <span class="fas fa-times-circle fa-lg"></span>
                  </c:if>
                </td>
                <td class="text-center align-middle">
                  <c:out value="${car.getPricePerDay()}" />
                </td>
                <td class="text-center align-middle">
                  <form action="CarRentalServlet" method="post">
                    <div class="btn-group-vertical" role="group">
                      <button type="submit" class="btn btn-danger" name="command" value="delete_car">
                        <fmt:message key="delete_from_carpark" />
                      </button>
                      <input type="hidden" name="car_id" value="${car.getId()}" />

                      <a href="/CarRental/CarRentalServlet?command=edit_car&car_id=${car.getId()}" class="btn btn-success" role="button">
                        <fmt:message key="edit" />
                      </a>
                      <a href="/CarRental/CarRentalServlet?command=view_car_damage_history&car_id=${car.getId()}" class="btn btn-primary" role="button">
                        <fmt:message key="damage_history" />
                      </a>
                    </div>
                  </form>
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </c:if>
    <c:if test="${not empty inactive_cars}">
      <div class="row">
        <div class="col-sm">
          <div class="text-center p-3 mb-2 bg-dark text-white">
            <h5>
              <fmt:message key="inactive_carpark" />
            </h5>
          </div>
        </div>
      </div>
      <div class="table-responsive">
        <table class="table table-bordered table-striped">
          <thead class="thead-dark">
            <tr>
              <th scope="col" class="text-center">#</th>
              <th scope="col" class="text-center">
                <fmt:message key="image" />
              </th>
              <th scope="col" class="text-center">
                <fmt:message key="brand_and_model" />
              </th>
              <th scope="col" class="text-center">
                <fmt:message key="type" />
              </th>
              <th scope="col" class="text-center">
                <fmt:message key="transmission" />
              </th>
              <th scope="col" class="text-center">
                <fmt:message key="passengers" />
              </th>
              <th scope="col" class="text-center">
                <fmt:message key="fuel" />
              </th>
              <th scope="col" class="text-center">
                <fmt:message key="air_cond" />
              </th>
              <th scope="col" class="text-center">
                <fmt:message key="price_per_day" />
              </th>
              <th scope="col" class="text-center"></th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${inactive_cars}" var="car">
              <tr>
                <th scope="row" class="align-middle">
                  <c:out value="${car.getId()}" />
                </th>
                <td class="align-middle">
                  <img src="${car.getImage()}" width="135" height="90" alt="${car.getBrandName()}">
                </td>
                <td class="text-center align-middle">
                  <c:out value="${car.getBrandName()}" />
                  <c:out value="${car.getModel()}" />
                </td>
                <td class="text-center align-middle">
                  <c:out value="${car.getType()}" />
                </td>
                <td class="text-center align-middle">
                  <c:out value="${car.getTransmission()}" />
                </td>
                <td class="text-center align-middle">
                  <c:out value="${car.getPassengers()}" />
                </td>
                <td class="text-center align-middle">
                  <c:out value="${car.getFuel()}" />
                </td>
                <td class="text-center align-middle">
                  <c:if test="${car.isAirCondition()}">
                    <span class="fas fa-check-circle fa-lg"></span>
                  </c:if>
                  <c:if test="${not car.isAirCondition()}">
                    <span class="fas fa-times-circle fa-lg"></span>
                  </c:if>
                </td>
                <td class="text-center align-middle">
                  <c:out value="${car.getPricePerDay()}" />
                </td>
                <td class="text-center align-middle">
                  <a href="/CarRental/CarRentalServlet?command=view_car_damage_history&car_id=${car.getId()}" class="btn btn-primary" role="button">
                    <fmt:message key="damage_history" />
                  </a>
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </c:if>
    <c:if test="${empty car_list && empty inactive_cars}">
      <div class="row">
        <div class="mx-auto text-danger">
          <h5>
            <strong>
              <fmt:message key="empty_carpark" />
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