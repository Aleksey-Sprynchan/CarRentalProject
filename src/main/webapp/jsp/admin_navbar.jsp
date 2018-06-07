<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="Resource"/>

<nav class="navbar navbar-expand-lg navbar-light bg-warning">
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
     <h5>
      <span style="color:black">
      	  <fmt:message key="hello" />,	
          <c:out value="${sessionScope.user.getName()}!"/>
      </span>
     </h5> 
      <li class="nav-item">
        <span class="align-baseline">
          <a href="/CarRental/CarRentalServlet?command=start_page" class="btn  btn-dark navbar-btn ml-2" role="button">
            <fmt:message key="home" />
          </a>
        </span>
      </li>
      <li class="nav-item">
        <a href="/CarRental/CarRentalServlet?command=to_my_profile_page" class="btn btn-dark navbar-btn ml-2" role="button">
          <fmt:message key="my_profile" />
        </a>
      </li>
      <li class="nav-item">
        <a href="/CarRental/CarRentalServlet?command=view_car_park" class="btn btn-dark navbar-btn ml-2" role="button">
          <fmt:message key="car_park" />
        </a>
      </li>
      <li class="nav-item">
        <a href="/CarRental/CarRentalServlet?command=create_car" class="btn btn-dark navbar-btn ml-2" role="button">
          <fmt:message key="create_car" />
        </a>
      </li>
      <li class="nav-item">
        <a href="/CarRental/CarRentalServlet?command=view_user_list" class="btn btn-dark navbar-btn ml-2" role="button">
          <fmt:message key="users_list" />
        </a>
      </li>
    </ul>
    <a href="/CarRental/CarRentalServlet?command=sign_out" class="btn btn-dark navbar-btn ml-2" role="button">
      <fmt:message key="sign_out" />
    </a>
  </div>
</nav>