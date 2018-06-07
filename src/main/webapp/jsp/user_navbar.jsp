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
          <a href="/CarRental/CarRentalServlet?command=start_page" class="btn btn-dark navbar-btn ml-2" role="button"><fmt:message key="home"/></a>
        </span>
      </li>
      <li class="nav-item">
        <a href="/CarRental/CarRentalServlet?command=to_my_profile_page" class="btn btn-dark navbar-btn ml-2" role="button"><fmt:message key="my_profile"/></a>
      </li>
      <li class="nav-item">
        <a href="/CarRental/CarRentalServlet?command=view_account_details" class="btn btn-dark navbar-btn ml-2" role="button"><fmt:message key="my_settings"/></a>
      </li>
      <li class="nav-item">
        <a href="/CarRental/CarRentalServlet?command=sign_out" class="btn btn-dark navbar-btn ml-2" role="button"><fmt:message key="sign_out"/></a>
      </li>
    </ul>
    <span class="navbar-text" style="color:black">
      <fmt:message key="balance"/>
      <strong>
        <c:out value="${sessionScope.user.getBalance()}$ "></c:out>
      </strong>
    </span>
    <a href="/CarRental/CarRentalServlet?command=deposit_page" class="btn btn-dark navbar-btn ml-3" role="button"><fmt:message key="make_a_deposit"/></a>
  </div>
</nav>

