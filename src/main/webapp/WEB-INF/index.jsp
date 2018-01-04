<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Welcome to the Game of Life</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
	   $('#selectedPattern').change(function() {
	     var parentForm = $(this).closest("form");
	     if (parentForm && parentForm.length > 0)
	       parentForm.submit();
	   });
	});
</script>
</head>
<body>
	<form action="<%=request.getContextPath()%>/GameOfLife" method="post" id="indexForm"
		name="indexForm">
		<h1>Select a grid size</h1>
		<select name="matrixLength" id="matrixLength">
			<option value="10">10</option>
			<option value="25">25</option>
			<option value="50">50</option>
			<option value="75">75</option>
		</select>
		<br />
		<h1>Select a starting pattern</h1>
		<select name="selectedPattern" id="selectedPattern">
			<option value="">Please Select</option>
			<option value="BOX">Box</option>
			<option value="ALL">All</option>
			<option value="CROSS">Cross</option>
			<option value="CROSS_IN_A_BOX">CROSS_IN_A_BOX</option>
			<option value="SMALL_EXPLORER">SMALL_EXPLORER</option>
		</select>
	</form>
</body>
</html>