<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
<script type="text/javascript">
$(function() {		
	$("#birthDatePicker").datepicker({
		showAnim:"slide", 
		dateFormat:"yy-mm-dd", 
		changeYear : true, 
		yearRange : "-80:+0", 
		changeMonth : true});
});

</script>
<script type="text/javascript">
	function loadData() {	
		var customer = JSON.parse('${cpData}');
		var dateOfBirth = JSON.parse('${date_of_birth}');
		document.main.customer_name.value = customer.name;
	 	document.main.customer_surname.value = customer.surname;
		document.main.passport_numb.value = customer.passportNumb;
		document.main.date_of_birth.value = dateOfBirth.value;
		document.main.driving_exp.value = customer.drivingExp;
		document.main.customer_id.value = customer.id; 
}
</script>