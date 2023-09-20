<%@page import="com.lec.member.MemberDto"%>
<%@page import="com.lec.member.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String conPath = request.getContextPath(); 
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String method = request.getParameter("method"); // null or modify
	MemberDao mDao = MemberDao.getInstance();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		int result = mDao.loginCheck(id, pw);
		if(result == MemberDao.LOGIN_SUCCESS) { // 로그인 성공
			MemberDto member = mDao.getMember(id);
			session.setAttribute("member", member);
			if(method.equals("null")) {
			response.sendRedirect("main.jsp");
			} else {
				response.sendRedirect(method+".jsp");
			}
		} else if(result == MemberDao.LOGIN_FAIL_PW) { // 비밀번호 오류
	%>
		<script>
			alert('비밀번호를 확인하세요.');
			history.back();
		</script>
	<%
		} else if(result == MemberDao.LOGIN_FAIL_ID) { // 아이디 오류
	%>
		<script>
			alert('아이디를 확인하세요.');
			location.href='login.jsp';
		</script>
	<%}%>
		
	
</body>
</html>