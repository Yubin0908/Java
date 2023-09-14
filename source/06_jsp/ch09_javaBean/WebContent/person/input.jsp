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
	<form action="step5.jsp" method="get">
		<p>이름 <input type="text" name="name" autofocus></p>
		<p>나이 <input type="number" name="age"></p>
		<p>성별&nbsp;&nbsp; <input type="radio" name="gender" value="M" checked>남자&nbsp;&nbsp;
											 <input type="radio" name="gender" value="F">여자
		</p>
		<p>주소 <input type="text" name="address"></p>
		<p><input type="submit" value="입력"></p>
	</form>
</body>
</html>