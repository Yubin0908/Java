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
	<h2>ex2_scope.jsp 페이지 입니다.</h2>
	<h3>페이지 내 attribute : ${pageNum}</h3>
	<h3>request 내 attribute : ${requestName}</h3>
	<h3>session 내 attribute : ${sessionName}</h3>
	<h3>application 내 attribute : ${appName}</h3>
	<h3>넘어온 ID 파라미터 : ${param.id}</h3>
	<h3>넘어온 PW 파라미터 : ${param.pw}</h3>
	
	
</body>
</html>