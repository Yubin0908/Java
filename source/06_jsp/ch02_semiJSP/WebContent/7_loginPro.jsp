<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		div {
			text-align: center;
			border: 2px solid blue;
			width: 300px;
			height: 300px;
		}
		input {
			background-color: skyblue;
			padding: 5px 20px;
		}
	</style>
</head>
<body>
	<div>
		<%! // 선언부(함수, 변수 선언)에 선언된 변수는 자동 초기화 
			String name, id, pw;		
		%>
		<%
			request.setCharacterEncoding("utf-8"); // post방식 전송시 추가
			name = request.getParameter("name");
			id = request.getParameter("id");
			pw = request.getParameter("pw");
		%>
		
		
		<p>아이디는 <%= id %> 이고,</p>
		<p>패스워드는 <%= pw %> 입니다.</p>
		<p><%= name %>님 반갑습니다.</p>
		<input type="button" value="뒤로가기" onclick="history.back(-1)">
		<input type="button" value="로그인">
	</div>
</body>
</html>