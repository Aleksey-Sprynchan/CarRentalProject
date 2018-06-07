<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
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
	var diffDays = Math.round(diffMSeconds/1000/60/60/24);
	var totalAmount = diffDays * (price + insurance);
	if(!isNaN(totalAmount)){
		document.mainForm.total_price.value = totalAmount;
		document.getElementById("total").innerHTML = totalAmount;
	} else {
		document.getElementById("total").innerHTML = 0;
	}
}
</script>