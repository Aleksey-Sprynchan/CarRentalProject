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
    <fmt:message key="sign_up"/>
  </title>
  <c:import url="head_layout.jsp"/>
</head>

<body>
  <div class="container">
    <c:import url="header.jsp"/>
    <div class="card bg-light">
      <article class="card-body mx-auto" style="max-width: 400px;">
        <h4 class="card-title mt-3 text-center">
          <fmt:message key="registration"/>
        </h4>
        <c:if test="${not empty dup_message}">
          <div class="alert alert-error" style="color:red">
            <c:out value="${dup_message}"/>
          </div>
        </c:if>
        <form action="CarRentalServlet" method="post">
          <div class="input-group-prepend" style="color:red; font-size:small">
            <c:if test="${not empty invalid_login}">
              <c:out value="${invalid_login}"/>
            </c:if>
          </div>
          <div class="form-group input-group">
            <div class="input-group-prepend">
              <span class="input-group-text">
                <i class="fa fa-user"></i>
              </span>
            </div>
            <input class="form-control" placeholder=<fmt:message key="login"/> type="text" name="login" value="${new_user.getLogin()}" required>
          </div>
          <div class="input-group-prepend" style="color:red; font-size:small">
            <c:if test="${not empty invalid_name}">
              <c:out value="${invalid_name}"/>
            </c:if>
          </div>
          <div class="form-group input-group">
            <div class="input-group-prepend">
              <span class="input-group-text">
                <i class="fa fa-user"></i>
              </span>
            </div>
            <input class="form-control" placeholder=<fmt:message key="name"/> type="text" name="name" value="${new_user.getName()}" required>
          </div>
          <div class="input-group-prepend" style="color:red; font-size:small">
            <c:if test="${not empty invalid_surname}">
              <c:out value="${invalid_surname}"/>
            </c:if>
          </div>
          <div class="form-group input-group">
            <div class="input-group-prepend">
              <span class="input-group-text">
                <i class="fa fa-user"></i>
              </span>
            </div>
            <input class="form-control" placeholder=<fmt:message key="surname"/> type="text" name="surname" value="${new_user.getSurname()}" required>
          </div>
          <div class="input-group-prepend" style="color:red; font-size:small">
            <c:if test="${not empty invalid_email}">
              <c:out value="${invalid_email}" />
            </c:if>
          </div>
          <div class="form-group input-group">
            <div class="input-group-prepend">
              <span class="input-group-text">
                <i class="fa fa-envelope"></i>
              </span>
            </div>
            <input class="form-control" placeholder=<fmt:message key="email"/> type="email" name="email" value="${new_user.getEmail()}" required>
          </div>
          <div class="input-group-prepend" style="color:red; font-size:small">
            <c:if test="${not empty invalid_password}">
              <c:out value="${invalid_password}"/>
            </c:if>
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
            <button type="submit" class="btn btn-primary btn-block" name="command" value="register">
              <fmt:message key="create_account"/> </button>
          </div>
          <p class="text-center">
            <fmt:message key="have_account"/>
            <a href="/CarRental/CarRentalServlet?command=sign_in_page">
              <fmt:message key="sign_in"/>
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