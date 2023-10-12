<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		.red {
			color: red;
		}
		.blue {
			color: blue;
		}
	</style>
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script>
		$(document).ready(function() {
			let count = 0; // h1을 클릭한 횟수를 저장할 변수
			$('h1#h1').click(function() {
				count ++;
				if(count < 6) {
					$(this).append('<span class="red">♡</span>');
					$(this).prepend('<span class="blue">♥</span>');
				} else {
					// count == 6 일경우 click event remove
					$(this).off();
				}
			});
			$('h1#h2').click(function() {
				$(this).append('<span class="red">♬</span>');
			});
			setInterval(() => {
				$('h1').last().trigger('click'); // 강제 이벤트 발생
			}, 1500);
		});
	</script>
</head>
<body>
	<h1 id="h1">죠아여(Max 5)</h1>
	<h1 id="h2">죠아여.</h1>
</body>
</html>