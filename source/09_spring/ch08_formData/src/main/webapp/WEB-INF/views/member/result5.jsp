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
	<h5>어떤 요청이 들어와도 cnt, list는 model에 add됨 // result_join5</h5>	
	<hr />
	<h6>cnt : ${cnt }</h6>
	<h6>list : ${list }</h6>
	<h4>name : ${memberDto.name }</h4>
	<h4>id : ${memberDto.id }</h4>
	<h4>pw : ${memberDto.pw }</h4>
	<h4>age : ${memberDto.age }</h4>
	<h4>email : ${memberDto.email }</h4>
	<h4>address : ${memberDto.address }</h4>
	<hr />
	<button onclick="history.back()">이전 페이지로 이동</button>
	<button onclick="location.href='${conPath }'">다시입력</button>
</body>
</html>