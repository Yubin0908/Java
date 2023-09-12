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
	<form action="<%=conPath%>/lect3_join/agree.jsp" method="post">
		<table>
			<caption>회원가입</caption>
			<tr>
			<th>아이디</th>
			<td><input type="text" name="id" required autofocus></td>
			</tr>
			<tr>
			<th>비밀번호</th>
			<td><input type="password" name="pw" required></td>
			</tr>
			<tr>
			<th>비밀번호 확인</th>
			<td><input type="password" name="pwchk" required></td>
			</tr>
			<tr>
			<th>이름</th>
			<td><input type="text" name="name" required></td>
			</tr>
			<tr>
			<td colspan="2">
				<input type="submit" value="가입" class="btn">
				<input type="reset" value="다시입력" class="btn">
				<input type="button" value="로그인" class="btn" onclick="location.href='<%=conPath%>/lect2_login/login.jsp'">
			</td>
			</tr>
		</table>
	</form>
</body>
</html>