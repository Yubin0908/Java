<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet">
</head>
<body>
	<form action="ex2_scope.jsp" method="post">
		<p>ID <input type="text" name="id"></p>
		<p>PW <input type="password" name="pw"></p>
		<p>ID <input type="submit" value="전송"></p>
	</form>
	<%
		// 자바에서 사용할 로직
		pageContext.setAttribute("pageNum", "pageValue");
		session.setAttribute("sessionName", "sessionValue");  // *
		request.setAttribute("requestName", "requestValue"); // *
		application.setAttribute("appName", "appValue"); // application 구동 ~ Tomcat Server Shutdown 까지 메모리 상주
		// 자바에서 forward할 객체 생성 후 forward
		/* RequestDispatcher dispatcher = request.getRequestDispatcher("ex2_scope.jsp?id="+URLEncoder.encode("한글아이디","utf-8")+"&pw=111");
		dispatcher.forward(request, response);  */
 	/* 	response.sendRedirect("ex2_scope.jsp");  */
	%>
	<%-- <jsp:forward page="ex2_scope.jsp"/> --%>
	<hr>
	<h3>페이지 내 attribute : <%=pageContext.getAttribute("pageNum") %></h3>
	<h3>request 내 attribute : <%=request.getAttribute("requestName") %></h3>
	<h3>session 내 attribute : <%=session.getAttribute("sessionName") %></h3>
	<h3>application 내 attribute : <%=application.getAttribute("appName") %></h3>
	<hr>
	<h3>페이지 내 attribute : ${pageNum}</h3>
	<h3>request 내 attribute : ${requestName}</h3>
	<h3>session 내 attribute : ${sessionName}</h3>
	<h3>application 내 attribute : ${appName}</h3>
</body>
</html>