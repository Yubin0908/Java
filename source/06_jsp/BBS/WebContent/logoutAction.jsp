<%@page import="java.io.Console"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width" initial-scale="1">
	<link rel="stylesheet" href="css/bootstrap.css"> <!-- BootStrap Css Init -->
	<title>JSP 게시판 웹사이트</title>
</head>
<body>
	<%
		session.invalidate(); // 해당 페이지 진입 시 세션 해제하여 로그아웃 처리해줌.
	%>
	<script>
		location.href="main.jsp";
	</script>
</body>
</html>