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
	<h3>"현재 총 ${cnt }명"</h3>
	<h2>개인 정보 입력</h2>
	<form action="${conPath }/input.do" method="post">
		이름 : <input type="text" name="name" required/><br />
		국어 : <input type="number" name="kor" min=0 max=100 required/><br />
		영어 : <input type="number" name="eng" min=0 max=100 required/><br />
		수학 : <input type="number" name="math" min=0 max=100 required/><br />
		<input type="submit" value="입 력" />
	</form>
</body>
</html>