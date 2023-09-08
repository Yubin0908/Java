<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		body { background-color: lightyellow; }
		tr >td{text-align: center; padding:2px 5px;}
		#msg {color:red; text-align: center;}
	</style>
</head>
<body>
	
	<%
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		if(!id.equals("aaa") || !pw.equals("111")) {
			String msg = "<h2>Check the ID and PW!</h2>";
			response.sendRedirect("login.jsp?msg="+msg);
		}
	%>
	<div id="wrap">
		<h2>아이디는 <%=id %>이고</h2>
		<h2>비밀번호는 <%=pw %>입니다.</h2>
		<br>
		<h2>반갑습니다.</h2>
	</div>

</body>
</html>