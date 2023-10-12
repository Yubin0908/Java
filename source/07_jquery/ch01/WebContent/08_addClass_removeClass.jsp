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
		}
		.tdRed {
			background-color: red;
		}
	</style>
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script>
		$(document).ready(function() {
		//	$('td').each(function(idx, item) {
				$('td').click(function() {
					$('td').removeClass('tdRed');
					$(this).addClass('tdRed');
					var no = $(this).attr('id');
					$(this).attr('id' + Number(no)+1);
					alert(no + '번째 td를 선택하셧습니다.');
				});
		//	});
		});
	</script>
</head>
<body>
	<table>
		<tr><td id="0"></td><td id="1"></td><td id="2"></td></tr>
		<tr><td id="3"></td><td id="4"></td><td id="5"></td></tr>
		<tr><td id="6"></td><td id="7"></td><td id="8"></td></tr>
	</table>	
</body>
</html>