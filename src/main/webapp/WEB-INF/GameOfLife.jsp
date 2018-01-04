<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Game of Life</title>
<link href="css/common.css" rel="stylesheet" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="/js/script.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		console.log("ready!");
		setTimeout(refreshMatrix, 1000);
	});
</script>
</head>
<body>
	<center>
		<h4>${selectedPattern}</h4>
		<div class="div-table" id="theMatrix">
			<c:forEach items="${matrix}" var="row">
				<div class="div-table-row">
					<c:forEach items="${row}" var="cell">
						<div class="${cell.alive?'table-col-green':'table-col-red' }"
							align="center">&nbsp;</div>
					</c:forEach>
				</div>
			</c:forEach>
		</div>
	</center>
</body>
</html>