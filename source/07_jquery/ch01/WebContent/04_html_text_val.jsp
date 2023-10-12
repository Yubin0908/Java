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
			$('p#msg').html('<b>Hello, jQuery</b>');
			$('.msg').val('Hello, JSP');
			$('button').click(function() {
				// var pmsg = $('p#msg').html(); // 집어넣는거와 반대로 가져올때는 tag도 함께 가져옴.
				var pmsg = $('p#msg').text(); // 집어넣는거와 반대로 가져올때는 tag를 제외하고 가져옴.
				var inputMsg = $('input[name="msg"]').val();
				alert(pmsg + "\n" + inputMsg);
			});
		});
	</script>
</head>
<body>
	<p id="msg"></p>
	<p>메세지 <input type="text" name="msg"	class="msg" /></p>
	<button>msg 경고창</button>
</body>
</html>