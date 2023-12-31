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
 <h2>변수 선언과 출력과 삭제</h2>
 <c:set var="varName" value="varValue" scope="page"/>
 varName : ${varName } <br />
 <c:set var="varName" value="varValue <varValue>"/>
 varName : ${varName }(수정 후) <br /> <!-- 특수문자 출력안됨 -->
 varName : <c:out value="${varName }"/> <br />
 <c:remove var="varName"/> <!-- 변수 삭제 -->
 varName : ${varName }(변수 삭제 후) <br />
 varName : ${empty varName ? "삭제되서 없음":"varName 남아 있음" } <br />
 varName : <c:out value="${varName }" default="삭제되서 없음"/>
</body>
</html>