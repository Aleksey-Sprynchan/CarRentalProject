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
    <fmt:message key="manage_order" />
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
            <fmt:message key="order_numb" />
            <c:out value="${order.getId()}" />
          </h4>
          <h4>
            <fmt:message key="status" />:
            <c:out value="${order.getStatus().toString().replace('_',' ')}" />
          </h4>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-sm-4">
        <c:if test="${not empty current_user}">
          <strong>
            <fmt:message key="who_made_order" />:</strong>
          <br>
          <c:out value="${current_user.getName()} ${current_user.getSurname()}" />
          <br>
          <a href="/CarRental/CarRentalServlet?command=view_user_orders&user_id=${current_user.getId()}" class="btn btn-warning my-2"
            role="button">
            <fmt:message key="view_user_orders" />
          </a>
        </c:if>
        <p>
          <strong>
            <fmt:message key="customer_personal_info" />:</strong>
        </p>
        <ul class="no-markers">
          <li>
            <fmt:message key="name" />:
            <strong class="ml-2">
              <c:out value="${order.getCustomer().getName()}" />
            </strong>
          </li>
          <li>
            <fmt:message key="surname" />:
            <strong class="ml-2">
              <c:out value="${order.getCustomer().getSurname()}" />
            </strong>
          </li>
          <li>
            <fmt:message key="passport_numb" />:
            <strong class="ml-2">
              <c:out value="${order.getCustomer().getPassportNumb()}" />
            </strong>
          </li>
          <li>
            <fmt:message key="driving_exp" />:
            <strong class="ml-2">
              <c:out value="${order.getCustomer().getDrivingExp()}" />
            </strong>
          </li>
          <li>
            <fmt:message key="date_of_birth" />:
            <strong class="ml-2">
              <c:out value="${order.getCustomer().getDateOfBirth()}" />
            </strong>
          </li>
        </ul>
      </div>
      <div class="col-sm-8">
        <div class="media">
          <img class="mr-5" src="${car.getImage()}" alt="Car image">
          <div class="media-body">
            <h5 class="mt-4 mb-4">
              <c:out value="${car.getBrandName()} ${car.getModel()}" />
              <a href="/CarRental/CarRentalServlet?command=view_car_damage_history&car_id=${car.getId()}" class="btn btn-primary ml-3"
                role="button">
                <fmt:message key="damage_history" />
              </a>
            </h5>
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
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-sm-4">
        <p>
          <strong class="mr-2">
            <fmt:message key="rental_period" />:</strong>
          <c:out value="${order.getStartDate()}" />
          <c:out value="- ${order.getEndDate()}" />
        </p>
        <p>
          <strong class="mr-2">
            <fmt:message key="order_date" />:</strong>
          <c:out value="${order.getOrderDate()}" />
        </p>
        <p>
          <strong class="mr-2">
            <fmt:message key="insurance" />:</strong>
          <c:if test="${order.isInsurance()}">
            <span class="fas fa-check-circle fa-lg"></span>
          </c:if>
          <c:if test="${not order.isInsurance()}">
            <span class="fas fa-times-circle fa-lg"></span>
          </c:if>
        </p>
        <p>
          <strong class="mr-2">
            <fmt:message key="total_price" />:</strong>
          <c:out value="${order.getTotalPrice()}" /> USD
        </p>
        <c:choose>
          <c:when test="${order.getStatus().name() == 'WAITING_FOR_APPROVE'}">
            <form action="CarRentalServlet" method="post">
              <input type="hidden" name="order_id" value="${order.getId()}" />
              <p>
                <button class="btn btn-success" type="submit" name="command" value="approve_order">
                  <fmt:message key="approve" />
                </button>
              </p>
            </form>
            <form action="CarRentalServlet" method="get">
              <input type="hidden" name="order_id" value="${order.getId()}" />
              <p>
                <button class="btn btn-danger" type="submit" name="command" value="reject_order">
                  <fmt:message key="reject" />
                </button>
              </p>
            </form>
          </c:when>
          <c:when test="${order.getStatus().name() == 'PAID'}">
            <form action="CarRentalServlet" method="post">
              <input type="hidden" name="order_id" value="${order.getId()}" />
              <p>
                <button class="btn btn-success" type="submit" name="command" value="mark_as_returned">
                  <fmt:message key="returned" />
                </button>
              </p>
            </form>
          </c:when>
          <c:when test="${order.getStatus() == 'RETURNED'}">
            <form action="CarRentalServlet" method="post">
              <input type="hidden" name="order_id" value="${order.getId()}" />
              <p>
                <button class="btn btn-success" type="submit" name="command" value="finish_order">
                  <fmt:message key="finish" />
                </button>
              </p>
            </form>
            <form action="CarRentalServlet" method="get">
              <input type="hidden" name="order_id" value="${order.getId()}" />
              <input type="hidden" name="car_id" value="${order.getCarId()}" />
              <p>
                <button class="btn btn-primary" type="submit" name="command" value="report_damages">
                  <fmt:message key="report_damages" />
                </button>
              </p>
            </form>
          </c:when>
        </c:choose>
        <br>
      </div>
      <c:if test="${order.isDamaged()}">
        <div class="col-sm-8">
          <p>
            <strong>
              <fmt:message key="damages" />:</strong>
          </p>
          <ol class="no-markers">
            <c:forEach items="${order_damages}" var="damage">
              <li>
                <c:out value="${damage.getDamageName()}" /> 
                (<c:out value="${damage.getDamageCost()}" /> USD)
              </li>
            </c:forEach>
          </ol>
          <p>
            <strong class="mr-2">
              <fmt:message key="amount_for_damages" />:</strong>
            <c:out value="${order.getDamageAmount()}" /> USD
          </p>
        </div>
      </c:if>
      <c:if test="${order.getStatus().name() == 'REJECTED'}">
        <div class="col-sm-8">
          <p>
            <strong>
              <fmt:message key="rejection_reason" />:</strong>
          </p>
          <div class="d-inline-flex p-2 bd-highlight bg-danger text-white">
            <c:out value="${order.getRejectionReason()}" />
          </div>
        </div>
      </c:if>
    </div>
  </div>
  <ctg:footer/>
  <c:import url="../js/optional_js.jsp" />

</body>

</html>