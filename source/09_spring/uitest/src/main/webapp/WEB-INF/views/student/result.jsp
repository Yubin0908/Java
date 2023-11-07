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
	<h2>결과는 다음과 같습니다</h2>
	<p>
		<c:set var="total" value="${student.kor + student.eng + student.math }"/>
		이름 : ${student.name } <br />
		국어 : ${student.kor } <br />
		영어 : ${student.eng } <br />
		수학 : ${student.math } <br />
		총점 : ${total } <br />
		평균 : ${total / 3} <br />
	</p>
	<button onclick="history.back()">뒤로가기</button>
	<button onclick="location.href='input.do'">다시입력</button>
</body>
</html>