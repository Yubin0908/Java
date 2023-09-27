<%@page import="com.lex.ex.Member"%>
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
	<%
		// 자바에서 사용될 로직
		Member member = new Member("aaa", "111", "홍길동");
		request.setAttribute("member", member);
	%>
	<h1>회원정보(el표기법)</h1>
	<h2>member : ${member}</h2>
	<h3>ID : ${member.id }</h3>
	<h3>PW : ${member.pw }</h3>
	<h3>NAME : ${member.name }</h3>
</body>
</html>