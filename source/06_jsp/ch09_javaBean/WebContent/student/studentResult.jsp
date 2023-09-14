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
	<jsp:useBean id="st" class="com.lec.ex.Student" scope="request"/>
	<h2>입력 내용 출력</h2>
	<p>학번 : <jsp:getProperty property="studentNum" name="st"/></p>
	<p>이름 : <jsp:getProperty property="name" name="st"/></p>
	<p>학년 : <jsp:getProperty property="grade" name="st"/></p>
	<p>반 : <jsp:getProperty property="className" name="st"/></p>
	<p>점수 : <jsp:getProperty property="score" name="st"/></p>
</body>
</html>