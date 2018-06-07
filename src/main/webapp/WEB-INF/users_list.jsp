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
    <fmt:message key="users_list" />
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
            <fmt:message key="users_list" /> </h4>
        </div>
      </div>
    </div>
    <c:if test="${not empty user_list}">
      <div class="table-responsive">
        <table class="table table-bordered table-striped">
          <thead class="thead-dark">
            <tr>
              <th scope="col" class="text-center">id</th>
              <th scope="col" class="text-center">
                <fmt:message key="login" />
              </th>
              <th scope="col" class="text-center">
                <fmt:message key="name" />
                <fmt:message key="surname" />
              </th>
              <th scope="col" class="text-center">
                <fmt:message key="email" />
              </th>
              <th scope="col" class="text-center">
                <fmt:message key="balance_column" />
              </th>
              <th scope="col" class="text-center"></th>
            </tr>
          </thead>
          <c:forEach items="${user_list}" var="user">
            <tbody>
              <tr>
                <th scope="row" class="text-center align-middle">
                  <c:out value="${user.getId()}" />
                </th>
                <td class="text-center align-middle">
                  <c:out value="${user.getLogin()}" />
                </td>
                <td class="text-center align-middle">
                  <c:out value="${user.getName()} ${user.getSurname()}" />
                </td>
                <td class="text-center align-middle">
                  <c:out value="${user.getEmail()}" />
                </td>
                <td class="text-center align-middle">
                  <c:out value="${user.getBalance()}" />
                </td>
                <td class="text-center align-middle">
                  <a href="/CarRental/CarRentalServlet?command=view_user_orders&user_id=${user.getId()}" class="btn btn-success" role="button">
                    <fmt:message key="view_user_orders" />
                  </a>
                </td>
              </tr>
            </tbody>
          </c:forEach>
        </table>
      </div>
    </c:if>
    <c:if test="${empty user_list}">
      <div class="row">
        <div class="mx-auto text-danger">
          <h5>
            <strong>
              <fmt:message key="no_users_yet" />
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