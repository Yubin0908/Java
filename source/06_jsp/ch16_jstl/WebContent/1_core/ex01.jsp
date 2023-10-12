<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet">
</head>
<body>
	<h1>core 라이브러리 태그 : if, for, switch, 변수 선언 및 할등 등</h1>
	<c:forEach var="i" begin="1" end="3">
		<p>${i }번째 안녕하세요.</p>
	</c:forEach>
	
	<h1>fmt 라이브러리 태그 : 날짜 및 숫 자 format, 다국어 지원 </h1>
	<fmt:formatNumber value="1234567.256" pattern="#,###.##"/>
	
	<h1>그 외 라이브러리 태그(functions) : fn라이브러리는 el표기법과 함께 사용</h1>
	id파라미터를 대문자로 : ${param.id.toUpperCase() } <br />
	id파라미터를 대문자로(fn) : ${fn:toUpperCase(param.id) }
</body>
</html>