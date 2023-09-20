<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String conPath = request.getContextPath(); 
	if(session.getAttribute("member")!=null) { // 로그인 된 상태
		response.sendRedirect("main.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet">
</head>
<body>
	<form action="loginOk.jsp" method="post">
		<!-- 로그인안된 상태에서 회원정보수정 시  login 후 회원정보수정 페이지로 이동 -->
		<input type="hidden" name="method" value="<%=request.getParameter("method") %>">
		<table>
			<caption>로그인</caption>
			<th>아이디</th>
			<td>
				<input type="text" name="id" required value="<%
																												String id = (String)session.getAttribute("id");
																												if(id!=null) {
																													out.print(id!=null ? id : "");
																												}
																										 %>">
			</td>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pw" required></td>
			</tr>
			<tr>
			<td colspan="2">
				<input type="submit" value="로그인">
				<input type="button" value="회원가입" onclick="location.href='join.jsp'">
			</td>
		</table>
	</form>
</body>
</html>