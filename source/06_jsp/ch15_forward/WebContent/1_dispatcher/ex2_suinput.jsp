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
	<form action="<%=conPath%>/ex2_input">
		누적을 원하는 최종 숫자 <input type="number" min="1" name="su" required />
		<input type="submit" value="submit" />
	</form>
</body>
</html>