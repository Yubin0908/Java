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
			$('tr:even').css('background-color', '#ccc'); // 0번째부터 짝수
			$('tr:odd').css('background-color', '#ffa'); // 0번째부터 홀수
			$('tr').click(function() {
				var no = $(this).children().eq(0).text().trim(); // String
				// alert('글번호 : ' + no + '/ 타입 : ' + typeof(no));
				if(isNaN(Number(no))) {
					alert('타이틀을 클릭함');
				} else {
					location.href = '05_selector.jsp?no='+no;
				}
			});
		});
	</script>
</head>
<body>
	<table>
		<tr>
			<th>글번호</th><th>제목</th><th>글쓴이</th><th>조회수</th>
		</tr>
		<tr><td>10</td><td>제목입니다.</td><td>홍길동</td><td>9</td></tr>
		<tr><td>9</td><td>제목21313.</td><td>홍길동</td><td>5</td></tr>
		<tr><td>8</td><td>제ㅇㅎㄶㄶ.</td><td>홍길동</td><td>7</td></tr>
		<tr><td>7</td><td>제ㅎ륭ㄱㅈㅅㄱ.</td><td>홍길동</td><td>99</td></tr>
		<tr><td>6</td><td>제자리걸음</td><td>홍길동</td><td>1</td></tr>
		<tr><td>5</td><td>테스트.</td><td>홍길동</td><td>0</td></tr>
		<tr><td>4</td><td>가나다라.</td><td>홍길동</td><td>500</td></tr>
		<tr><td>3</td><td>하하핳.</td><td>홍길동</td><td>9</td></tr>
		<tr><td>2</td><td>제목입니다.</td><td>홍길동</td><td>9</td></tr>
		<tr><td>1</td><td>제목입니다.</td><td>홍길동</td><td>9</td></tr>
		<tr><th colspan="10">총 10개</th></tr>
	</table>
</body>
</html>