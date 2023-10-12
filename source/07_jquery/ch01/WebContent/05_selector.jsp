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
			$('tr:nth-child(3n)').css('color', 'red'); // 1번째 부터 3, 6, 9
			$('tr:nth-child(3n+1)').css('color', 'green'); // 1번째 부터 1, 4, 7
			$('tr:nth-child(3n+2)').css('color', 'blue'); // 1번째 부터 2, 5, 8
			$('tr:even').css('background-color', '#ccc'); // 0번째부터 짝수
			$('tr:odd').css('background-color', '#ffa'); // 0번째부터 홀수
			/* $('tr:eq(0)').css('backgroundColor', 'black').css('color', '#fff'); */
			$('tr').eq(0).css('backgroundColor', 'black').css('color', '#fff'); // 많이 사용하는 방법
			/* $('tr:first()').css('backgroundColor', 'black').css('color', '#fff'); */
			/* $('tr').first().css('backgroundColor', 'black').css('color', '#fff'); */
			/* $('tr').last().css('backgroundColor', 'black').css('color', '#fff'); */
			$('tr:last()').css('backgroundColor', 'black').css('color', '#fff');
		});
	</script>
</head>
<body>
	<table>
		<tr>
			<th>글번호</th><th>제목</th><th>글쓴이</th><th>조회수</th>
		</tr>
		<tr><th>10</th><th>제목입니다.</th><th>홍길동</th><th>9</th></tr>
		<tr><th>9</th><th>제목21313.</th><th>홍길동</th><th>5</th></tr>
		<tr><th>8</th><th>제ㅇㅎㄶㄶ.</th><th>홍길동</th><th>7</th></tr>
		<tr><th>7</th><th>제ㅎ륭ㄱㅈㅅㄱ.</th><th>홍길동</th><th>99</th></tr>
		<tr><th>6</th><th>제자리걸음</th><th>홍길동</th><th>1</th></tr>
		<tr><th>5</th><th>테스트.</th><th>홍길동</th><th>0</th></tr>
		<tr><th>4</th><th>가나다라.</th><th>홍길동</th><th>500</th></tr>
		<tr><th>3</th><th>하하핳.</th><th>홍길동</th><th>9</th></tr>
		<tr><th>2</th><th>제목입니다.</th><th>홍길동</th><th>9</th></tr>
		<tr><th>1</th><th>제목입니다.</th><th>홍길동</th><th>9</th></tr>
		<tr><th colspan="10">총 10개</th></tr>
	</table>
</body>
</html>