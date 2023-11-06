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
	<h4>board의 content.jsp 페이지</h4>
	<h4>ID : ${id }</h4>
	<h4>PW : ${pw }</h4>
	<h4>member : ${member }</h4>
	<h4>member.id : ${member.id }</h4>
	<h4>member.pw : ${member.pw }</h4>
	<hr />
	<h4 onclick="history.back()">이전 페이지로 가기</h4>
</body>
</html>