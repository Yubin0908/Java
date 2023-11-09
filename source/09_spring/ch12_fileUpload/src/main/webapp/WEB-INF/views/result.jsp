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
	<div align="center">
		<h2>파일 전송 결과 : ${fileUpResult }</h2>
		<h4> file - 1 : dbResource/${fileNames[0] }</h4>
		<c:if test="${not empty fileNames[0] }">
			<img src="${conPath }/dbResource/${fileNames[0]}" alt="File One" width="350" height="auto"/>
		</c:if>
		<c:if test="${empty fileNames[0] }">
			<span>첫번째 파일 없음</span>
		</c:if>
		<hr />
		<h4> file - 2 : dbResource/${fileNames[1] }</h4>
		<c:if test="${not empty fileNames[1] }">
			<img src="${conPath }/dbResource/${fileNames[1]}" alt="File Two" width="350" height="auto" />
		</c:if>
		<c:if test="${empty fileNames[1] }">
			<span>첫번째 파일 없음</span>
		</c:if>
		<hr />
		<h4> file - 3 : dbResource/${fileNames[2] }</h4>
		<c:if test="${not empty fileNames[2] }">
			<img src="${conPath }/dbResource/${fileNames[2]}" alt="File Three" width="350" height="auto" />
		</c:if>
		<c:if test="${empty fileNames[2] }">
			<span>첫번째 파일 없음</span>
		</c:if>
	</div>
	
</body>
</html>