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
    <fmt:message key="rejection_form" />
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
            <c:out value="${order.getStatus().toString()}" />
          </h4>
        </div>
      </div>
    </div>
    <div class="form-group">
      <h5>
        <label for="rejection">
          <fmt:message key="reason" />:</label>
      </h5>
      <textarea class="form-control" id="rejection" rows="3" name="rejection_reason" maxlength="255" required form="rejection_form"></textarea>
    </div>
    <form action="CarRentalServlet" method="post" id="rejection_form">
      <input type="hidden" name="order_id" value="${order.getId()}" />
      <p>
        <button class="btn btn-danger" type="submit" name="command" value="send_reject_message">
          <fmt:message key="reject" />
        </button>
      </p>
    </form>
  </div>
  <ctg:footer/>
  <c:import url="../js/optional_js.jsp" />
</body>

</html>