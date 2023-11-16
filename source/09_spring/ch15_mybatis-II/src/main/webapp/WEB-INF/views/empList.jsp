<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<script>
		$(document).ready(function(){
			
		});
	</script>
</head>
<body>
	<c:set var="num" value="${paging.totCnt - paging.startRow + 1 }"/><!--역번호-->
	<table>
		<caption>직원목록</caption>
		<tr>
			<td colspan="6">
				<a href="${conPath }/writeView.do">직원등록</a>
			</td>
		</tr>
		<tr><th>번호</th><th>사번</th><th>이름</th><th>입사일</th><th>급여</th><th>상여</th></tr>
		<c:forEach items="${empList }" var="emp">
			<tr>
				<td>${num }</td>
				<td>${emp.empno }</td>
				<td>${emp.ename }</td>
				<td>${emp.hiredate }</td>
				<td>${emp.sal }</td>
				<td>${emp.comm }</td>
			</tr>		
			<c:set var="num" value="${num-1}"/>
		</c:forEach>
	</table>
	
</body>
</html>














