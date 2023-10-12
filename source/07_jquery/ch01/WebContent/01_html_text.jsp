<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script>
		$(document).ready(function() {
			$('#p1').click(() => {
				// $('#p1').html('<b>태그내용바뀜</b>');
				 $('#p1').text('<b>태그내용바뀜</b>');
				$('p').css('background-color', 'red').css('color', 'yellow').css('font-weight', 'bold');
			});
		});
	</script>
</head>
<body>
	<p id="p1">p태그 하나</p>
</body>
</html>