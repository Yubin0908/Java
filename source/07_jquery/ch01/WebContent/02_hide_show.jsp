<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script>
		$(function() {
			$('*').css('color', 'blue').css('margin', '20px');
			$('p').click(function() {
				$(this).hide('fast');
			});
			$('#showptag').click(() => {
				$('p').show('slow');
			});
			$('#hidep1').click(() => {
				$('#p1').hide('slow');
			});
			$('#hideptag').click(() => {
				$('p').hide();
			});
		});
	</script>
</head>
<body>
	<h1>이곳은 heading</h1>
	<p>1. 이 p태그를 클릭하면 숨겨짐</p>
	<p>2. 이 p태그를 클릭하면 숨겨짐</p>
	<p id="p1"> p1하나만 숨겨지는 버튼을 만들어요.</p>
	<button id="showptag">p태그가 나타남</button>
	<button id="hidep1">p1만 사라짐</button>
	<button id="hideptag">p태그가 숨겨짐</button>
</body>
</html>