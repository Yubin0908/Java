<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		.red {
			font-weight: bold;
			color: red;
		}
		.blue {
			font-weight: bold;
			color: blue;
		}
	</style>
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script>
		$(document).ready(function() {
			$('input.pw, input.pwchk').keyup(function() {
				var pw = $('.pw').val();
				var pwchk = $('.pwchk').val();
				
				if(pw == pwchk) {
					$('.result').text('두 비밀번호가 일치합니다.');
					$('.result').addClass(' blue');
					$('.result').removeClass(' red');
				} else {
					$('.result').html('두 비밀번호가 일치하지 않습니다.');
					$('.result').addClass(' red');
					$('.result').removeClass(' blue');
				}
			});
		});
	</script>
</head>
<body>
	<p> ID <input type="text" name="id"/></p>
	<p> PW <input type="password" name="pw" class="pw"/></p>
	<p> PWCHK <input type="password" class="pwchk" /></p>
	<p class="result"></p>
	<button>가입하기</button>
</body>
</html>