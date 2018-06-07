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
    <fmt:message key="sign_in"/>
  </title>
  <c:import url="head_layout.jsp"/>
</head>

<body>
  <div class="container">
    <c:import url="../jsp/header.jsp"/>
    <div class="card bg-light">
      <article class="card-body mx-auto" style="max-width: 400px;">
        <h4 class="card-title mt-3 text-center">
          <fmt:message key="please_sign_in"/>
        </h4>
        <c:if test="${not empty info_message}">
          <div class="alert alert-error" style="color:red">
            <c:out value="${info_message}"/>
          </div>
        </c:if>
        <form action="CarRentalServlet" method="post">
          <div class="form-group input-group">
            <div class="input-group-prepend">
              <span class="input-group-text">
                <i class="fa fa-user"></i>
              </span>
            </div>
            <input name="login" class="form-control" placeholder=<fmt:message key="login"/> type="text" required>
          </div>
          <div class="form-group input-group">
            <div class="input-group-prepend">
              <span class="input-group-text">
                <i class="fa fa-lock"></i>
              </span>
            </div>
            <input class="form-control" placeholder=<fmt:message key="password"/> type="password" name="password" required>
          </div>
          <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block" name="command" value="authorization">
              <fmt:message key="sign_in"/> </button>
          </div>
          <p class="text-center">
            <fmt:message key="new_here"/>
            <a href="/CarRental/CarRentalServlet?command=registration_page">
              <fmt:message key="sign_up"/>
            </a>
          </p>
          <p class="text-center">
            <a href="/CarRental/CarRentalServlet?command=start_page" class="btn btn-primary navbar-btn" role="button">
              <fmt:message key="home_page"/>
            </a>
          </p>
        </form>
      </article>
    </div>
  </div>
  <ctg:footer/>
  <c:import url="../js/optional_js.jsp"/>
</body>

</html>