<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Java Bean - Step4</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet">
</head>
<body>
	<jsp:useBean id="p" class="com.lec.ex.Person" scope="request"/>
	<jsp:setProperty property="name" name="p" param="name"/>
	<jsp:setProperty property="age" name="p" param="age"/>
	<jsp:setProperty property="gender" name="p" param="gender"/>
	<jsp:setProperty property="address" name="p" param="address"/>
	<jsp:forward page="personview.jsp"></jsp:forward>
</body>
</html>