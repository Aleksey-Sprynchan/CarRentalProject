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
    <fmt:message key="user_orders" />
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
            <fmt:message key="orders_of" />
            <c:out value="${user.getName()} ${user.getSurname()}" />
          </h4>
        </div>
      </div>
    </div>
    <c:if test="${not empty order_list}">
      <div class="table-responsive">
        <table class="table table-bordered table-striped">
          <thead class="thead-dark">
            <tr>
              <th scope="col" class="text-center">#</th>
              <th scope="col" class="text-center">
                <fmt:message key="car" />
              </th>
              <th scope="col" class="text-center">
                <fmt:message key="rental_period" />
              </th>
              <th scope="col" class="text-center">
                <fmt:message key="order_date" />
              </th>
              <th scope="col" class="text-center">
                <fmt:message key="insurance" />
              </th>
              <th scope="col" class="text-center">
                <fmt:message key="total_price" />
              </th>
              <th scope="col" class="text-center">
                <fmt:message key="damages" />
              </th>
              <th scope="col" class="text-center">
                <fmt:message key="status" />
              </th>
              <th scope="col" class="text-center"></th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${order_list}" var="order">
              <tr>
                <th scope="row" class="text-center align-middle">
                  <c:out value="${order.getId()}" />
                </th>
                <td class="text-center align-middle">
                  <c:out value="${orderCar_map.get(order.getId()).getBrandName()}" />
                  <c:out value="${orderCar_map.get(order.getId()).getModel()}" />
                </td>
                <td class="text-center align-middle" nowrap>
                  <c:out value="${order.getStartDate()}" />
                  <br>
                  <c:out value="- ${order.getEndDate()}" />
                </td>
                <td class="text-center align-middle" nowrap>
                  <c:out value="${order.getOrderDate()}" />
                </td>
                <td class="text-center align-middle">
                  <c:if test="${order.isInsurance()}">
                    <span class="fas fa-check-circle fa-lg"></span>
                  </c:if>
                  <c:if test="${not order.isInsurance()}">
                    <span class="fas fa-times-circle fa-lg"></span>
                  </c:if>
                </td>
                <td class="text-center align-middle">
                  <c:out value="${order.getTotalPrice()}" />
                </td>
                <td class="text-center align-middle">
                  <c:if test="${order.isDamaged()}">
                    <span class="fas fa-check-circle fa-lg"></span>
                  </c:if>
                  <c:if test="${not order.isDamaged()}">
                    <span class="fas fa-times-circle fa-lg"></span>
                  </c:if>
                </td>
                <td class="text-center align-middle">
                  <c:out value="${order.getStatus().toString().replace('_', ' ')}" />
                </td>
                <td class="text-center align-middle">
                  <a href="/CarRental/CarRentalServlet?command=manage_order&order_id=${order.getId()}" class="btn btn-warning" role="button">
                    <fmt:message key="view_details" />
                  </a>
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </c:if>
    <c:if test="${empty order_list}">
      <div class="row">
        <div class="mx-auto text-danger">
          <h5>
            <strong>
              <fmt:message key="this_user_has_no_orders_yet" />
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