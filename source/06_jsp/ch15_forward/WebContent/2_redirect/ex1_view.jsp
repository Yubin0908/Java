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
	<!-- redirect & dispatcher Processing -->
	<!-- ex1_input.jps >> Ex1_input.sevlet >> ex1_view.jsp -->
	<jsp:useBean id="member" class="com.lec.member.Member" scope="page"/>
	<jsp:setProperty property="*" name="member" />
	<h1>회원정보(ex1_view.jsp페이지입니다.)</h1>
	<h3>ID(member.id) : ${member.id }</h3>
	<h3>ID : ${param.id }</h3>
	<h3>PW : ${param.pw }</h3>
	<h3>NAME : ${param.name}</h3>
</body>
</html>