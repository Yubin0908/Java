<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		td {
			width: 100px;
			height: 100px;
			background-color: #aaf;
			color: transparent;
		}
		.tdRed {
			background-color: red;
		}
		.dduk {
			background-image: url("img/dduk.jpg");
			background-repeat: no-repeat;
			background-size: 100%;
		}
	</style>
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script>
		$(document).ready(function() {
			ddukidx = parseInt(Math.random()*9 + 1);
			$('.result').text('떡 위치 : ' + ddukidx);
			$('input.result').attr('value', '떡 위치 : ' + ddukidx);
			$('td').click(function() {
			var idx = $(this).text();
				if(Number(idx) == ddukidx) {
					$(this).addClass('dduk');
					$('td').removeClass('tdRed');
					$('p.result').html('떡위치를 찾았음.');
					$('input.result').attr('value', '떡위치를 찾았음.');
					$('td').off();
				} else {
					$('td').removeClass('tdRed');
					$(this).addClass('tdRed');
					$('.result').html('선택한곳에 떡이 없음.');
					$('input.result').attr('value', '선택한곳에 떡이 없음.');
				}	
			});
		});
	</script>
</head>
<body>
	<table>
		<tr><td>1</td><td>2</td><td>3</td></tr>
		<tr><td>4</td><td>5</td><td>6</td></tr>
		<tr><td>7</td><td>8</td><td>9</td></tr>
	</table>
	<p class="result"></p>
	<input type="text" class="result"/>	
</body>
</html>