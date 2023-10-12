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
			var array = [
				{
					name : '네이버',
					link : 'http://naver.com'
				},
				{
					name : '다음',
					link : 'http://daum.net'
				},
				{
					name : '구글',
					link : 'http://google.com'
				},
				{
					name : '한빛출판사',
					link : 'http://hanbit.co.kr'
				},
			];
			array.forEach(function(item, idx) {
				document.body.innerHTML += '<h2><a href="'+item.link+'">'+idx+'. '+item.name+'</a></h2>';
			});
			document.body.innerHTML += '<hr>'
			$(array).each(function(idx, item) {
				$('body').html($('body').html() + '<h2><a href="'+item.link+'">'+idx+'. '+item.name+'</a></h2>');
			});
			$('body').html($('body').html() + '<hr>');
			$.each(array, function(idx, item) {
				$('body').html($('body').html() + '<h2><a href="'+item.link+'">'+idx+'. '+item.name+'</a></h2>');
			});
		});
	</script>
</head>
<body>
	<!-- <h2><a href="http://naver.com">0. 네이버</a></h2>
	<h2><a href="http://daum.net">1. 다음</a></h2> -->
	
</body>
</html>