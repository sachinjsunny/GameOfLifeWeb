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
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript" src="/js/script.js" ></script>
</head>
<body>
	<form action="<%=request.getContextPath()%>/GameOfLife" method="post" id="indexForm"
		name="indexForm">
		<h1>Select a grid size</h1>
		<select name="matrixLength" id="matrixLength">
			<option value="20">20</option>
			<option value="40">40</option>
			<option value="60">60</option>
			<option value="80">80</option>
		</select>
		<br />
		<h1>Select a starting pattern</h1>
		<select name="selectedPattern" id="selectedPattern">
			<option value="">Please Select</option>
			<option value="BOX">Box</option>
			<option value="CROSS">Cross</option>
			<option value="CROSS_IN_A_BOX">CROSS_IN_A_BOX</option>
			<option value="SMALL_EXPLORER">SMALL_EXPLORER</option>
			<option value="DIAMOND">Diamond</option>
			<option value="PLUS">Plus</option>
			<option value="PYRAMID">Pyramid</option>
			<option value="SOLID_DIAMOND">Solid Diamond</option>
			<option value="ALL">All</option>
		</select>
	</form>
</body>
</html>