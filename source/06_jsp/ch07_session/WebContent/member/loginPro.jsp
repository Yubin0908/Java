<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/login.css" rel="stylesheet" type="text/css">
</head>
<body>

	<%
		request.setCharacterEncoding("utf-8"); // post방식일 때만
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		if(id==null || !id.equals("aaa") || pw==null || !pw.equals("111")){
			response.sendRedirect(conPath+"/member/login.jsp?msg=");
		}
	%>
	<br><br><br><br><br><br>
	<%
		session.setAttribute("name", "홍길동");
	%>
	<div id="loginForm_wrap">
		<script>
			location.href = 'main.jsp';
		</script>
	</div>
	<br><br><br><br><br><br>
	<jsp:include page="../member/footer.jsp"/>
</body>
</html>















