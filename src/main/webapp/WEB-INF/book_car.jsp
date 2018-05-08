<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Book Car</title>

<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
<!-- <script src="http://wisdomweb.ru/editor/localization.js"></script>  -->

<script type="text/javascript">

var array = JSON.parse('${reserved_dates}');

$(function() {
	
	var dates = $( "#startDatePicker, #endDatePicker" ).datepicker({
		showAnim:"slide",
		dateFormat:"yy-mm-dd",
        minDate: new Date(), 
        onClose: function( selectedDate ) {
            var option = this.id == "startDatePicker" ? "minDate" : "maxDate",
                instance = $( this ).data( "datepicker" ),
                date = $.datepicker.parseDate(
                    instance.settings.dateFormat ||
                    $.datepicker._defaults.dateFormat,
                    selectedDate, instance.settings );
            dates.not( this ).datepicker( "option", option, date );
            
            countAmount(); 
          
        },
	
	beforeShowDay: function(date){
        var string = jQuery.datepicker.formatDate('yy-mm-dd', date);
        return [ array.indexOf(string) == -1 ]
    }
});
		
	$("#birthDatePicker").datepicker({
		showAnim:"slide", 
		dateFormat:"yy-mm-dd", 
		changeYear : true, 
		yearRange : "-80:+0", 
		changeMonth : true});
});

function countAmount() {
		
	var ins = document.getElementById('insurance');
	var insurance; 

	if (ins.checked) {
		insurance = 1;
	} else {
		insurance = 0;
	}

	var startDate = document.getElementById('startDatePicker');
	var endDate = document.getElementById('endDatePicker');
	var price = ${car.getPricePerDay()};
	
	var date1 = new Date(startDate.value);
	var date2 = new Date(endDate.value);
	var diffMSeconds = date2 - date1;
	var diffDays = Math.round(diffMSeconds / 1000 / 60 / 60 / 24);
	var totalAmount = diffDays * (price + insurance);
	if(!isNaN(totalAmount)){
		document.mainForm.total_price.value = totalAmount;
		document.getElementById("total").innerHTML = totalAmount;
	} else {
		document.getElementById("total").innerHTML = 0;
	}

}
</script>

</head>
<body>

	<h3>Fill the bid to book this car:</h3>
	<font size="5" color="red" face="Times New Roman"><c:out value="${car}"/></font>

	<form name="mainForm" action="CarRentalServlet" method="post">
		<p><strong>Name:</strong> 
		<input size="30" name="customer_name" required></p>
		
		<p><strong>Surname:</strong> 
		<input size="30" name="customer_surname" required></p>
		
		<p><strong>Passport №:</strong> 
		<input size="30" name="passport_numb" required></p>
		
		<p><strong>Date of birth:</strong> 
		<input type="text" id="birthDatePicker" name="date_of_birth" required></p>
		
		<p><strong>Driving experience (years):</strong> 
		<input size="30" name="driving_exp" required pattern="^[0-9]+$"></p>
		 
		<p><strong>From:</strong> 
		<input type="text" id="startDatePicker" name="start_date"  required> </p>
			
		<p><strong>To:</strong> 
		<input type="text" id="endDatePicker" name="end_date"  required></p>
		<input type="checkbox" name="insurance" id="insurance" onChange="countAmount()" value="true"/>Insurance<br /> 
		
		<h4>Total price: <span id="total">0</span> </h4>
		
		<input type="hidden" name="car_id" value="${car.getId()}"/>
		<input type="hidden" name="total_price"/>
		<button type="submit" name="command" value="CREATE_ORDER">Submit order</button>
	</form>

</body>
</html>