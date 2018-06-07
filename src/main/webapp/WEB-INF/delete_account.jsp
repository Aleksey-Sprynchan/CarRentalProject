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
    <fmt:message key="delete_account" />
  </title>
  <c:import url="../jsp/head_layout.jsp" />
</head>

<body>

  <div class="container">
    <c:import url="../jsp/header.jsp" />
    <c:import url="../jsp/user_navbar.jsp" />
    <hr>
    <div class="row">
      <div class="col-sm">
        <div class="col-sm text-center p-3 mb-2 bg-dark text-white">
          <h4>
            <fmt:message key="deleting_account" />
          </h4>
        </div>
      </div>
    </div>
    <c:choose>
      <c:when test="${not empty info_message}">
        <div class="row">
          <div class="mx-auto text-danger">
            <c:out value="${info_message}" />
          </div>
        </div>
      </c:when>
      <c:otherwise>
        <div class="row">
          <div class="mx-auto text-danger">
            <strong>
              <fmt:message key="sure_to_delete_account" />
            </strong>
            <p>
              <strong>
                <fmt:message key="lost_all_account_info" />
              </strong>
            </p>
          </div>
        </div>
        <form action="CarRentalServlet" method="post">
          <div class="form-group row">
            <div class="mx-auto">
              <button type="submit" class="btn btn-primary mt-1" name="command" value="delete_account">
                <fmt:message key="delete_account" />
              </button>
            </div>
          </div>
        </form>
      </c:otherwise>
    </c:choose>
  </div>
  <ctg:footer/>
  <c:import url="../js/optional_js.jsp" />
</body>

</html>