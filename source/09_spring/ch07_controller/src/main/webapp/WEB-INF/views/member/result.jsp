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
	<h3>${kind } 페이지</h3>
	<hr />
	<button onclick="history.back()">이전 페이지로</button>
	<button onclick="location.href='${conPath }/'">처음으로</button>
</body>
</html>