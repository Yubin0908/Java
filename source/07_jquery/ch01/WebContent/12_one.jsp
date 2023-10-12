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
			$('h2').one('click', function() { // one 사용 시 event 1회 사용 후, event remove
				$(this).append('♥').prepend('♡');
				/* $(this).off(); */
			});
		});
	</script>
</head>
<body>
	<h2>방탄 좋아요.(한번만)</h2>
	<h2>블핑 좋아요.(한번만)</h2>
</body>
</html>