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
	<form action="<%=conPath %>/ex1_input" method="post">
		<p>ID <input type="text" name="id"></p>
		<p>PW <input type="text" name="pw"></p>
		<p>NAME <input type="text" name="name"></p>
		<p><input type="submit" value="입력"></p>
	</form>
</body>
</html>