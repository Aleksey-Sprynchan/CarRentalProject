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
    <fmt:message key="book_car" />
  </title>
  <c:import url="../jsp/head_layout.jsp" />
  <c:import url="../js/book_car_js.jsp" />
</head>

<body>
  <div class="container">
    <c:import url="../jsp/header.jsp" />
    <c:import url="../jsp/user_navbar.jsp" />
    <hr>
    <div class="row">
      <div class="col-sm text-center p-3 mb-2 bg-dark text-white">
        <h4>
          <fmt:message key="booking_application" />
        </h4>
      </div>
    </div>
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
    <div class="media">
      <img class="mr-5" src="${car.getImage()}" alt="Car image">
      <div class="media-body">
        <h5 class="mt-4 mb-4">
          <c:out value="${car.getBrandName()} ${car.getModel()}" /> </h5>
        <div class="row">
          <div class="col-sm-10">
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
          <div class="col-sm-2 feature text-center">
            <strong>
              <fmt:message key="price" />:
              <c:out value="${car.getPricePerDay()}" />$/
              <fmt:message key="day" />
            </strong>
          </div>
        </div>
      </div>
    </div>
    <hr>
    <div class="col-md-8 mx-auto">
      <form name="mainForm" action="CarRentalServlet" method="post">
        <h4 class="mb-3">
          <fmt:message key="customer_personal_info" />
        </h4>
        <div class="row">
          <div class="col-md-6 mb-3">
            <label for="name">
              <fmt:message key="name" />:</label>
            <input type="text" class="form-control" id="name" name="customer_name" value="${customer_name}" required>
            <c:if test="${not empty invalid_name}">
              <small class="form-text text-danger">
                <c:out value="${invalid_name}" />
              </small>
            </c:if>
          </div>
          <div class="col-md-6 mb-3">
            <label for="surname">
              <fmt:message key="surname" />:</label>
            <input type="text" class="form-control" id="surname" name="customer_surname" value="${customer_surname}" required>
            <c:if test="${not empty invalid_surname}">
              <small class="form-text text-danger">
                <c:out value="${invalid_surname}" />
              </small>
            </c:if>
          </div>
        </div>
        <div class="mb-3">
          <label for="passport">
            <fmt:message key="passport_numb" />:</label>
          <input type="text" class="form-control" id="passport" name="passport_numb" value="${passport_numb}" required>
          <c:if test="${not empty invalid_passport_numb}">
            <small class="form-text text-danger">
              <c:out value="${invalid_passport_numb}" />
            </small>
          </c:if>
        </div>
        <div class="row">
          <div class="col-md-6 mb-3">
            <label for="birthDatePicker">
              <fmt:message key="date_of_birth" />:</label>
            <input type="text" class="form-control" id="birthDatePicker" name="date_of_birth" value="${date_of_birth}" required>
            <c:if test="${not empty invalid_birth_date}">
              <small class="form-text text-danger">
                <c:out value="${invalid_birth_date}" />
              </small>
            </c:if>
          </div>
          <div class="col-md-6 mb-3">
            <label for="drivingExp">
              <fmt:message key="driving_exp" />:</label>
            <input type="text" class="form-control" id="drivingExp" name="driving_exp" value="${driving_exp}" required>
            <c:if test="${not empty invalid_driving_exp}">
              <small class="form-text text-danger">
                <c:out value="${invalid_driving_exp}" />
              </small>
            </c:if>

          </div>
        </div>
        <h4 class="mb-3">
          <fmt:message key="rental_period" />
        </h4>
        <div class="row">
          <div class="col-md-6 mb-3">
            <label for="startDatePicker">
              <fmt:message key="from" />:</label>
            <input type="text" class="form-control" id="startDatePicker" name="start_date" value="${start_date}" required>
            <c:if test="${not empty invalid_start_date}">
              <small class="form-text text-danger">
                <c:out value="${invalid_start_date}" />
              </small>
            </c:if>
          </div>
          <div class="col-md-6 mb-3">
            <label for="endDatePicker">
              <fmt:message key="to" />:</label>
            <input type="text" class="form-control" id="endDatePicker" name="end_date" value="${end_date}" required>
            <c:if test="${not empty invalid_end_date}">
              <small class="form-text text-danger">
                <c:out value="${invalid_end_date}" />
              </small>
            </c:if>
          </div>
        </div>
        <div class="custom-control custom-checkbox">
          <input type="checkbox" class="custom-control-input" name="insurance" id="insurance" onChange="countAmount()" value="true">
          <label class="custom-control-label" for="insurance">
            <strong>
              <fmt:message key="insurance" />
            </strong>
          </label>
        </div>
        <h4 class="my-3">
          <fmt:message key="total_price" />:
          <span id="total">0</span> USD </h4>
        <hr class="mb-4">
        <input type="hidden" name="car_id" value="${car.getId()}" />
        <input type="hidden" name="total_price" />
        <button class="btn btn-primary btn-lg btn-block mb-2" type="submit" name="command" value="create_order">
          <fmt:message key="create_order" />
        </button>
      </form>
    </div>
  </div>
  <ctg:footer/>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
    crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
    crossorigin="anonymous"></script>
</body>

</html>