<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="${conPath }/css/style.css" />
</head>
<body>
	<h1>
		${greetting }
	</h1>
	<img alt="이미지" src="${conPath }/img/노르웨이숲_피망.png" />

</body>
</html>
