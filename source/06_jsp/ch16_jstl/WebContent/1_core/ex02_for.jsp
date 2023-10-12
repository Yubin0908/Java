<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet">
</head>
<body>
	<%
		String[] names = {"홍길동", "신길동", "김길동"};
		// request.setAttribute("names", names);
		/* for(String name : names) {
			out.print("<p>" + name + "</p>");
		}
		for(int idx=0; idx<names.length; idx++) {
			out.print("<p>" + idx + "번쨰" + names[idx] + "</p>");
		} */
	%>
	<c:set var="names" value="<%=names %>" /> <!-- 변수 선언 및 할당 -->
	<c:forEach var="name" items="${names }"> <!-- 확장for문과 동일한 문법 -->
		<p>${name }</p>
	</c:forEach>
	<hr />
	<c:forEach var="name" items="${names }" begin="0" end="1">
		<p>${name }</p>
	</c:forEach>
	<hr />
	<c:set var="idx" value="0"/>						<!-- 일반for문과 동일한 문법 -->
	<c:forEach var="name" items="${names }">
		<p>${idx }번째 : ${name }</p>
		<c:set var="idx" value="${idx+1 }" /> <!-- idx 변수를 기족의 idx + 1 로 재선언 -->
	</c:forEach>
	<p>최종 idx값은 ${idx }입니다.</p>
</body>
</html>