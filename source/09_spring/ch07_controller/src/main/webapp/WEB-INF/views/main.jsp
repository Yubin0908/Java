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
	<h3>Board관련 요청 경로 (BoardController)</h3>
	<h4><a href="${conPath }/board/write">Board의 Write로 가기</a></h4>
	<h4><a href="${conPath }/board/content">Board의 Content로 가기</a></h4>
	<h4><a href="${conPath }/board/list">Board의 list로 가기</a></h4>
	<h4><a href="${conPath }/board/reply">Board의 Reply로 가기</a></h4>
	<hr />
	<h3>Member관련 요청 경로 (MemberController)</h3>
	<p><button onclick="location.href='${conPath}/member?method=join'">회원가입</button></p>
	<p><button onclick="location.href='${conPath }/member?method=login'">로그인</button></p>
	<p><button onclick="location.href='${conPath }/member?method=logout'">로그아웃</button></p>
	<p><button onclick="location.href='${conPath}/member?method=modify'">회원정보수정</button></p>
	
</body>
</html>