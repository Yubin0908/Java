<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	String writer = request.getParameter("writer");
	String memo = request.getParameter("memo");
	String ip = request.getRemoteAddr(); // 오청한 클라이언트이 ip주소
	Date date = new Date(System.currentTimeMillis()); 
	Timestamp time = new Timestamp(System.currentTimeMillis()); 
	%>
	<h2>글쓴이 : <%=writer %></h2>
	<h2>한줄메모 : <%=memo %></h2>
	<h2>글쓴이 ip : <%=ip %></h2>
	<h2>작성일자 : <%=date %></h2>
	<h2>작성시간 : <%=time %></h2>
</body>
</html>