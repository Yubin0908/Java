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
	<h2>어떤 요청이 들어와도, cnt, list는 model에 add됨</h2>
	<h3>${result } 페이지</h3>
	<hr />
	<h4>cnt : ${cnt }</h4>
	<h4>list : ${list }</h4>
	<h4>name : ${name }</h4>
	<h4>id : ${id }</h4>
	<h4>pw : ${pw }</h4>
	<h4>age : ${age }</h4>
	<h4>email : ${email }</h4>
	<h4>address : ${address }</h4>
	<hr />
	<button onclick="history.back()">이전 페이지로 이동</button>
	<button onclick="location.href='${conPath }'">다시입력</button>
</body>
</html>