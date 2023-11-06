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
	<h3>board의 reply 페이지</h3>
	<h4>ID : ${member.id } / PW : ${member.pw }</h4>
	<form action="${conPath }/board/reply" method="post">
		<input type="submit" value="reply" />
	</form>
	<hr />
	<h4 onclick="history.back()">이전 페이지로</h4>
</body>
</html>