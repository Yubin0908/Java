<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script>
		const over = ['img/0over.jpg, img/1over.jpg, img/2over.jpg, img/3over.jpg']
		const out = ['img/0out.jpg, img/1out.jpg, img/2out.jpg, img/3out.jpg']
		$(document).ready(function() {
			$('img').each(function(idx, item) {
				$(this).mouseover(function() {
					$(this).attr('src', 'img/'+idx+'over.jpg');
					$(this).attr('alt', idx+'over');
				});
				$(this).mouseout(function() {
					$(this).attr('src', 'img/'+idx+'out.jpg');
					$(this).attr('alt', idx+'out');
				});
			});
		});
	</script>
</head>
<body>
	<img src="img/0out.jpg" alt="0out" id="0"/>
	<img src="img/1out.jpg" alt="1out" id="1"/>
	<img src="img/2out.jpg" alt="2out" id="2"/>
	<img src="img/3out.jpg" alt="3out" id="3"/>
</body>
</html>