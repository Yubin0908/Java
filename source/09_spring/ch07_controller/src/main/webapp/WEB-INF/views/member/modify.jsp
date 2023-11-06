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
	<h3>member의 modify 페이지</h3>
	<form action="${conPath }/member?method=modify" method="post">
		<p>
			<input type="text" name="id" value="${member.id }" />
			<input type="password" name="pw" value="${member.pw }" />
		</p>
		<p>
			<input type="submit" value="modify(POST)" />
		</p>
	</form>
	<hr />
	<h4 onclick="history.back()">이전 페이지로</h4>
</body>
</html>