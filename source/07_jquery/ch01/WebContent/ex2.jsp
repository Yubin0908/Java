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
			$('img').mousedown(function() {
				$(this).attr('src', 'img/but2.gif').attr('alt', '클릭후');
			});
			$('img').mouseup(function() {
				$(this).attr('src', 'img/but1.gif').attr('alt', '클린전');
			});
			$
		});
	</script>
</head>
<body>
	<img src="img/but1.gif" alt="클릭전" />
	<img src="img/but1.gif" alt="클릭전" />
</body>
</html>