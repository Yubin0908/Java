<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>JavaBean - Step2</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet">
</head>
<body>
	<jsp:useBean id="p" class="com.lec.ex.Person" scope="page"/>
	<jsp:setProperty property="name" name="p" value='<%=request.getParameter("name") %>'/>
	<jsp:setProperty property="age" name="p" value='<%=Integer.parseInt(request.getParameter("age")) %>'/>
	<jsp:setProperty property="gender" name="p" value='<%=request.getParameter("gender").charAt(0) %>'/>
	<jsp:setProperty property="address" name="p" value='<%=request.getParameter("address") %>'/>
	
	<h2>입력받은 개인정보(step2)</h2>
	<p>이름 : <jsp:getProperty property="name" name="p"/></p>
	<p>나이 : <jsp:getProperty property="age" name="p"/></p>
	<p>성별 : <jsp:getProperty property="gender" name="p"/></p>
	<p>주소 : <jsp:getProperty property="address" name="p"/></p>
</body>
</html>