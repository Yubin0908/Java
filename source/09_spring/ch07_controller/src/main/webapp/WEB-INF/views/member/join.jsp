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
	<h3>member의 join 페이지 입니다. ${kind } 가입 페이지</h3>
	<form action="${conPath }/member?method=join" method="post">
		<p>ID <input type="text" name="id" /></p>
		<p><input type="submit" value="가입(POST)" /></p>
	</form>
</body>
</html>