<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		div#toggle {
			width: 100px;
			height: 100px;
			line-height: 100px;
			text-align: center;
			background-color: red;
		}
	</style>
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script>
		$(document).ready(function {
			let showToggle = true;
			$('.goShow').on('click', function() {
				$('div#toggle').show();
				showToggle = true;
				
			});
			$('.goHide').click(function() {
				$('div#toggle').hide();
				showToggle = false;
			});
			$('button').click(function() {
				$('#toggle').toggle();
				/* if(showToggle) {
					if(showToggle) {
						$('#toggle').hide();
						showToggle = false;
					} else {
						$('#toggle').show();
						showToggle = true;
					} */
			});
		});
	</script>
</head>
<body>
	<button>토글링</button>
	<h1 class="goShow">보이게</h1>
	<h1 class="goHide">사라지게</h1>
	<div id="toggle">토글구간</div>
</body>
</html>