<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="${conPath }/css/style.css" />
</head>
<body>
	<div align="center">
		<hr width="500" color="green"/>
		<h2>File Upload(View Page)</h2>
		<hr width="500" color="green"/>
		<form action="fileUp.do" method="post" enctype="multipart/form-data">
			<p>첨부파일 1 : <input type="file" name="file1" /></p>
			<p>첨부파일 2 : <input type="file" name="file2" /></p>
			<p>첨부파일 3 : <input type="file" name="file3" /></p>
			<input type="submit" value="전송(POST)" />
		</form>
	</div>
</body>
</html>