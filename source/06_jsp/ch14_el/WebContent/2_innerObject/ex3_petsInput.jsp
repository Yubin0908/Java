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
	<!-- 파라미터값이 여러개 들어오는 경우(같은 파라미터명) -->
	<form action="ex4_petResult.jsp">
		ID <input type="text" name="id"><br>
		키우는 애완동물을 선택하세요.
		<input type="checkbox" name="pets" value="개">개
		<input type="checkbox" name="pets" value="고양이">고양이
		<input type="checkbox" name="pets" value="앵무새">앵무새
		<input type="checkbox" name="pets" value="열대어">열대어<br>
		<input type="submit" value="확인">
		
	</form>
	
</body>
</html>