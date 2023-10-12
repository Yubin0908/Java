<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		table td {
			width: 100px;
			height: 100px;
			background-color: #aff;
			color: transparent;
		}
		.tdRed {
			background-color: red;
		}
	</style>
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script>
		$(document).ready(function() {
			$('td').click(function() {
				$('td').removeClass('tdRed');
				$(this).addClass('tdRed');
				var idx = $(this).text();
				alert(idx + '번 td 선택!');
			});
		});
	</script>
</head>
<body>
	<table>
		<tr><td>0</td><td>1</td><td>2</td></tr>
		<tr><td>3</td><td>4</td><td>5</td></tr>
		<tr><td>6</td><td>7</td><td>8</td></tr>
	</table>	
</body>
</html>