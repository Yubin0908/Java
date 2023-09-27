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
	<form action="">
		<input type="number" name="su1"> * <input type="number" name="su2"> = <input type="number" name="sum"><br>
		<input type="submit" value="확인"><br>
	</form>
	<h1>
		${param.su1} * ${param.su2} = 는 ${(param.su1 * param.su2) eq param.sum ? "true 정답":"false 오답"}
	</h1>
</body>
</html>