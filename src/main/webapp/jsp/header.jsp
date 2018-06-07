<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="Resource"/>

    <div class="jumbotron my-2">
      <div class="row align-items-center">
        <div class="col">
          <a href="/CarRental/CarRentalServlet?command=start_page">
          <img class="mr-5" src="images/car-hire.png" alt="header image" height="77" width="192"></a>
        </div>
        <div class="col">
          <h3 class="text-center">Alex's Cars
            <br> <fmt:message key="car_rental_service"/>
          </h3>
        </div>
        <div class="col text-right align-self-end">
          <a href="/CarRental/CarRentalServlet?command=change_locale&locale=en" 
          class="btn btn-link text-white btn-sm px-0" role="button">EN</a>
          <a href="/CarRental/CarRentalServlet?command=change_locale&locale=ru" 
          class="btn btn-link text-white btn-sm px-0 mr-2" role="button">RU</a>
        </div>
      </div>
    </div>
