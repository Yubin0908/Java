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
	<h3>board의 list의 페이지</h3>
	<c:if test="${list.size() eq 0 }">
		<h3>추가된 멤버 데이터가 없습니다.</h3>
	</c:if>
	<c:if test="${list.size () ne 0}">
		<c:forEach var="member" items="${list }">
		<h4>ID : ${member.id } / PW : ${member.pw }</h4>
		</c:forEach>
		<h4>이상 추가된 Member 는 ${list.size() } 명 입니다.</h4>
	</c:if>
	
	<hr />
	<h4 onclick="history.back()">이전 페이지로 가기</h4>
</body>
</html>