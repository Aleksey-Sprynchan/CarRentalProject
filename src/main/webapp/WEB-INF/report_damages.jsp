<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">

function AddItem() {
  div=document.getElementById("items");
  button=document.getElementById("add");

  newitem="<p><strong>Damage type: </strong>";
  newitem+="<input type=\"text\" name=\"damage_name";
  newitem+="\" size=\"30\"> ";
  newitem+="<strong>damage price: </strong><input type=\"text\" name=\"damage_cost\" size=\"10\"></p>";
  newnode=document.createElement("span");
  newnode.innerHTML=newitem;
  div.insertBefore(newnode,button);
}

</script>


</head>
<body>

	<form name="form1" action="CarRentalServlet" method="post">
	<div ID="items">
    <strong>Damage type: </strong><input type="text" name="damage_name" size="30">
    <strong>damage price: </strong><input type="text" name="damage_cost" size="10"><p>
    <div ID="add"><input type="button" value="Add one more damage" onClick="AddItem();" ></div>
    
    <input type="hidden" name="order_id" value="${order_id}"/> 
    <input type="hidden" name="car_id" value="${car_id}"/> 
	<p><button type="submit" name="command" value="SEND_DAMAGE_REPORT">SEND damage report</button></p>
	</div>
	</form>
	

</body>
</html>