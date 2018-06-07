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
    <fmt:message key="damage_history" />
  </title>
  <c:import url="../jsp/head_layout.jsp" />
</head>

<body>
  <div class="container">
    <c:import url="../jsp/header.jsp" />
    <c:import url="../jsp/admin_navbar.jsp" />
    <hr>
    <div class="row mb-2">
      <div class="col-sm">
        <div class="col-sm text-center p-3 mb-2 bg-dark text-white">
          <h4>
            <fmt:message key="damage_history_for"/>
            <c:out value="${car.getBrandName()} ${car.getModel()}" />
          </h4>
        </div>
      </div>
    </div>
    <c:if test="${not empty orderId_set}">
      <c:forEach items="${orderId_set}" var="order">
        <div class="row">
          <div class="col-sm">
            <div class="row">
              <div class="col-sm-8 mx-auto">
                <div class="col-sm text-center p-2 bg-info text-white">
                  <h5>
                    <fmt:message key="order_numb" />
                    <strong>
                      <c:out value="${order}" />
                    </strong>
                    <a href="/CarRental/CarRentalServlet?command=manage_order&order_id=${order}" class="btn btn-warning ml-2" role="button">
                      <fmt:message key="order_details" />
                    </a>
                  </h5>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-sm-8 mx-auto">
            <table class="table table-bordered table-striped">
              <thead class="thead-dark">
                <tr>
                  <th scope="col" class="text-center w-75">
                    <fmt:message key="damage" />
                  </th>
                  <th scope="col" class="text-center w-25">
                    <fmt:message key="repair_cost" />
                  </th>
                </tr>
              </thead>
              <tbody>
                <c:forEach items="${carDamHist_map.get(order)}" var="damage">
                  <tr>
                    <th scope="row" class="text-center">
                      <c:out value="${damage.getDamageName()}" />
                    </th>
                    <td class="text-center">
                      <c:out value="${damage.getDamageCost()} " />USD
                    </td>
                  </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
      </c:forEach>
    </c:if>
    <c:if test="${empty orderId_set}">
      <div class="row">
        <div class="mx-auto text-danger">
          <h5>
            <strong>
              <fmt:message key="car_has_never_been_damaged" />
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