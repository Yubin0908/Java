<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet">
</head>
<body>
	<form action="<%=conPath%>/board/writePro.jsp" method="post">
		<table>
			<caption>글쓰기</caption>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="bname" required autofocus></td>
			</tr>
			<tr>
				<th>글제목</th>
				<td><input type="text" name="btitle" required></td>
			</tr>
			<tr>
				<th>본문</th>
				<td><textarea row="" name="bcontent" required></textarea></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="email" name="bemail"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="bpw" required></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="글쓰기" class="btn">
					<input type="reset" value="초기화" class="btn">
					<input type="button" value="목록" class="btn" onclick="location.href='list.jsp'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>