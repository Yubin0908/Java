<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet">
</head>
<body>
	<%
		String name = (String)session.getAttribute("name");
		String id = (String)session.getAttribute("id");
		
		if(name!=null) { // Login 상태
	%>
		<h1><%=name %>(<%=id %>)님 안녕하세요.</h1>
		<button onclick="location.href='<%=conPath %>/lect2_login/logout.jsp'">로그아웃</button>
	<% } else { // login 안된 상태 %>
		<h1>손님 안녕하세요, 로그인이 필요합니다.</h1>
		<button onclick="location.href='<%=conPath %>/lect2_login/login.jsp'">로그인</button>
	<% } %>
	<button onclick="location.href='<%=conPath %>/lect2_login/sessionList.jsp'">세션 들여다 보기</button>
</body>
</html>