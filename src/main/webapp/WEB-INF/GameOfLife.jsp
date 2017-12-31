<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Game of Life</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	
	function refreshMatrix(){
		var refrehsUrl = "<%=request.getContextPath()%>/refreshMatrix";
		$.ajax({
			url : refrehsUrl,
			type : 'POST',
			success : handleRefreshData,
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	$( document ).ready(function() {
	    console.log( "ready!" );
	    for (i = 1; i <100; i++) {
			setTimeout(refreshMatrix, 2000*i);
		}
	});
	
	function handleRefreshData(resp){
		$("#theMatrix").empty();
		var newMatrix = $(resp).find('#theMatrix').html();
		$("#theMatrix").html(newMatrix);
	}
</script>
<style type="text/css">
.div-table {
	display: table;
	width: auto;
	background-color: #eee;
	border: 1px solid #666666;
	border-spacing: 5px; /* cellspacing:poor IE support for  this */
}

.div-table-row {
	display: table-row;
	width: auto;
	clear: both;
}

.table-col-red {
	float: left; /* fix for  buggy browsers */
	display: table-column;
	width: 40px;
	background-color: RED;
}

.table-col-green {
	float: left; /* fix for  buggy browsers */
	display: table-column;
	width: 40px;
	background-color: GREEN;
}
</style>
</head>
<body>
	<center>
		<div class="div-table" id="theMatrix">
			<c:forEach items="${matrix}" var="row">
				<div class="div-table-row">
					<c:forEach items="${row}" var="cell">
						<div class="${cell.alive?'table-col-green':'table-col-red' }"
							align="center">${cell.alive?'live':'dead'}</div>
					</c:forEach>
				</div>
			</c:forEach>
			<form action="">
	
			</form>
		</div>
	</center>
</body>
</html>