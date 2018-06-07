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
    <fmt:message key="my_profile"/>
  </title>
  <c:import url="../jsp/head_layout.jsp"/>
</head>

<body>
  <div class="container">
    <c:import url="../jsp/header.jsp"/>
    <c:import url="../jsp/user_navbar.jsp"/> 
    <c:if test="${not empty info_message}">
      <div class="row ">
       <div class="col-sm">
        <div class="col-sm text-center p-3 mb-2 bg-dark text-white">
          <h4>
            <strong>
              <c:out value="${info_message}"/>
            </strong>
          </h4>
         </div>
        </div>
      </div>
    </c:if>
    <hr>
    <div class="row">
      <div class="col-sm">
        <div class="col-sm text-center p-3 mb-2 bg-dark text-white">
          <h4>
            <fmt:message key="my_orders"/>
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
              <th scope="col" class="text-center" nowrap>
                <fmt:message key="customer_driver"/>
              </th>
              <th scope="col" class="text-center">
                <fmt:message key="car" />
              </th>
              <th scope="col" class="text-center" nowrap>
                <fmt:message key="rental_period"/>
              </th>
              <th scope="col" class="text-center" nowrap>
                <fmt:message key="order_date"/>
              </th>
              <th scope="col" class="text-center">
                <fmt:message key="insurance"/>
              </th>
              <th scope="col" class="text-center" nowrap>
                <fmt:message key="total_price"/>
              </th>
              <th scope="col" class="text-center">
                <fmt:message key="status"/>
              </th>
              <th scope="col" class="text-center"></th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${order_list}" var="order">
              <tr>
                <th scope="row" class="align-middle">
                  <c:out value="${order.getId()}"/>
                </th>
                <td class="text-center align-middle">
                  <c:out value="${order.getCustomer().getName()} ${order.getCustomer().getSurname()}"/>
                </td>
                <td class="text-center align-middle">
                  <c:out value="${orderCar_map.get(order.getId()).getBrandName()}"/>
                  <c:out value="${orderCar_map.get(order.getId()).getModel()}"/>
                </td>
                <td class="text-center align-middle">
                  <c:out value="${order.getStartDate()}"/>
                  <c:out value="- ${order.getEndDate()}"/>
                </td>
                <td class="text-center align-middle">
                  <c:out value="${order.getOrderDate()}"/>
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
                  <c:out value="${order.getTotalPrice()}"/> $
                </td>
                <td class="text-center align-middle">
                  <c:out value="${order.getStatus().toString().replace('_', ' ')}"/>
                </td>
                <td class="text-center align-middle">
                  <a href="/CarRental/CarRentalServlet?command=view_order_details&order_id=${order.getId()}" class="btn btn-warning" role="button">
                    <span class="fas fa-info-circle fa-lg"></span>
                    <fmt:message key="view_details"/>
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
              <fmt:message key="user_no_orders_yet"/>
            </strong>
          </h5>
        </div>
      </div>
    </c:if>
  </div>
  <ctg:footer/>
  <c:import url="../js/optional_js.jsp"/>
</body>

</html>