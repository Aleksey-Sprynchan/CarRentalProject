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
    <fmt:message key="report_damages" />
  </title>
  <c:import url="../jsp/head_layout.jsp" />
  <script type="text/javascript">
    function addItem() {
      div = document.getElementById("items");
      button = document.getElementById("add");
      newitem = "<div class=\"row\"><div class=\"col-sm-6 mb-3\">";
      newitem += "<input type=\"text\" class=\"form-control\" id=\"damage\" ";
      newitem += "name=\"damage_name\" required></div>";
      newitem += "<div class=\"col-sm-6 mb-3\">";
      newitem += "<input type=\"text\" class=\"form-control\" id=\"damage_cost\" name=\"damage_cost\" ";
      newitem += "required pattern=\"([1-9])([0-9]{0,3})\"></div></div>";
      newnode = document.createElement("span");
      newnode.innerHTML = newitem;
      div.insertBefore(newnode, button);
    }
  </script>
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
            <fmt:message key="report_damages_for_order" />
            <c:out value="${order_id}" />
          </h4>
        </div>
      </div>
    </div>
    <c:if test="${not empty invalid_id || not empty empty_damage_name }">
      <div class="row">
        <div class="mx-auto text-danger">
          <strong>
            <c:out value="${invalid_id}" />
          </strong>
          <p>
            <strong>
              <c:out value="${empty_damage_name}" />
            </strong>
          </p>
        </div>
      </div>
    </c:if>
    <form name="form1" action="CarRentalServlet" method="post">
      <div>
        <div id="items" class="col-md-8 mx-auto">
          <div class="row">
            <div class="col-sm-6 mb-3">
              <label for="damage">
                <fmt:message key="damage_type" />:</label>
              <input type="text" class="form-control" id="damage" name="damage_name" required>
            </div>
            <div class="col-sm-6 mb-3">
              <label for="damage_cost">
                <fmt:message key="damage_cost" />:</label>
              <input type="text" class="form-control" id="damage_cost" name="damage_cost" placeholder="<fmt:message key="price_message" />" required pattern="([1-9])([0-9]{0,3})">
              <c:if test="${not empty invalid_cost}">
                <small class="form-text text-danger">
                  <c:out value="${invalid_cost}" />
                </small>
              </c:if>
            </div>
          </div>
          <div id="add">
            <input class="btn btn-primary mb-2" type="button" value="<fmt:message key="add_damage" />" onClick="addItem();">
          </div>
          <input type="hidden" name="order_id" value="${order_id}" />
          <input type="hidden" name="car_id" value="${car_id}" />
          <button class="btn btn-primary mb-2" type="submit" name="command" value="send_damage_report">
            <fmt:message key="send_damage_report" />
          </button>
        </div>
      </div>
    </form>
  </div>
  <ctg:footer/>
  <c:import url="../js/optional_js.jsp" />
</body>

</html>