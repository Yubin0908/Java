<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<%@ page errorPage="exceptionPage.jsp" %> <!-- web.xml에서 예외페이지 처리하는것 보다 우선순위가 높음 -->
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		
		out.println("num1 = " + num1 + "<br>");
		out.println("num2 = " + num2 + "<br>");
		out.println("num1 + num2 : " + (num1+num2) + "<br>");
		out.println("num1 - num2 : " + (num1-num2) + "<br>");
		out.println("num1 x num2 : " + (num1*num2) + "<br>");
		out.println("num1 / num2 : " + (num1/num2) + "<br>");
	%>
</body>
</html>