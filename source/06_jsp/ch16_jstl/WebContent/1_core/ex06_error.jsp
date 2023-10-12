<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
 <h2>예외처리태그</h2>
 <c:catch var="e"> <!-- catch절에서 예이ㅗ 발생 시, 예외객체가 e변수에 할당되고 catch절을 빠져나감 -->
 	<h2>테스트</h2>
 	${8/0}
 	<%=8/0 %>
 	<p>예외가 발생하는 즉시 catch절을 빠져나감. 이 문구 출력시 예외발생 안됨.</p>
 </c:catch>
 예외타입과 예외 메세지 : <c:out value="${e }" default="예외 발생 안됨."/>
</body>
</html>