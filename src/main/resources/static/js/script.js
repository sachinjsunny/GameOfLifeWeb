$(document).ready(function() {
	$('#selectedPattern').change(function() {
		var parentForm = $(this).closest("form");
		if (parentForm && parentForm.length > 0)
			parentForm.submit();
	});
});

function handleRefreshData(resp) {
	$("#theMatrix").empty();
	var newMatrix = $(resp).find('#theMatrix').html();
	$("#theMatrix").html(newMatrix);
}

function refreshMatrix(){
	var refrehsUrl = "refreshMatrix";
	
	$.ajax({
		url : refrehsUrl,
		type : 'POST',
		success : handleRefreshData,
		error : function(e) {
			console.log('Error: ' + e);
		}
	});
	setTimeout(refreshMatrix,500);
}