<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 이 페이지는 ex2.jsp 예외 발생 시 표시되는 페이지 --%>
<%@ page isErrorPage="true" %>
<% response.setStatus(200); %>
<!-- 
	200 : passing
	404 : 찾을 수 없음
	500 : 문법오류 또는 예외발생
	400, 407 : 인증을 받지 못한 경우
 -->
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script>
		console.log('예외 메세지 : <%=exception.getMessage()%>');
		console.log('예외 타입 : <%=exception.getClass().getName()%>');
	</script>
</head>
	<body>
		<h1>공사중입니다. 조속한 시일내에 복구하겠습니다.</h1>
		<%
			System.out.println("예외 메세지 : " + exception.getMessage());
			System.out.println("예외 타입 : " + exception.getClass().getName());
		%>
	</body>
</html>