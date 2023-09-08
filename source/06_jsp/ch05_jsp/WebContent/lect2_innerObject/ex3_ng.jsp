<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
		<h2>ageInput.html(나이입력)->agePro.jsp(나이에 따른 분기)->pass.jsp?age=15</h2>
		<%
			int age = Integer.parseInt(request.getParameter("age"));
		%>
		<h2><%=age %>살은 주류구매가 불가합니다.</h2>
		<button onclick="history.back()">뒤로가기</button>
		<button onclick="location.href='ex3ageInput.html'">새로하기</button>
		
		
		
</body>
</html>