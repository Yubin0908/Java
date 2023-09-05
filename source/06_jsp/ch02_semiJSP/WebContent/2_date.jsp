<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.*"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<<% 
		Date now = new Date();
		SimpleDateFormat sdf = SimpleDateFormat("yy년 MM월 dd일에 JSP시작");
		String strNow = sdf.format(now);
	%>
	<p>StrNow : <%= strNow %></p>
	<hr>
	<%@ include file="hello.jsp" %>
</body>
</html>