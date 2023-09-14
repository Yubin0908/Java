<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<% response.setStatus(200); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
		<script>
			console.log('예외 메세지 : <%=exception.getMessage()%>');
			console.log('예외 타입 : <%=exception.getClass().getName()%>');
		</script>
</head>
	<body>
		<h1>공사중입니다. 조속한 시일내에 복구하겠습니다.</h1>
		<h2>Error Code : 500</h2>
		<%
			System.out.println("예외 메세지 : " + exception.getMessage());
			System.out.println("예외 타입 : " + exception.getClass().getName());
		%>
</body>
</html>