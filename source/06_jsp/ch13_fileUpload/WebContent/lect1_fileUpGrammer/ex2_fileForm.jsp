<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet">
</head>
<body>
	<form action="ex2_fileFormPro.jsp" method="post" enctype="multipart/form-data">
		<p> 이름 : <input type="text" name="name"></p>
		<p> 나이 : <input type="number" name="age" min="0"></p>
		<p> 파일a : <input type="file" name="file0"></p>
		<p> 파일b : <input type="file" name="file1"></p>
		<p> 파일c : <input type="file" name="file2"></p>
		<p><input type="submit" value="업로드"></p>
	</form>
</body>
</html>