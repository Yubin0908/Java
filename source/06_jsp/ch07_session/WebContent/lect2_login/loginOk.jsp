<%@page import="com.lec.ex.Member"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		// id, pw 파라미터로 받아 유효한 로그인 정보인 경우, 로그인 처리(세션에 추가) 후 welcome.jsp / 로그인 정보가 유효하지 않은 경우, login.jsp 이동
		String msg = "";
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		if(id!=null && id.equals("aaa")) {
			// 유효한 id
			
			if(pw!=null && pw.equals("111")) {
				// 유효한 pw 
				session.setAttribute("id", id);
				session.setAttribute("name", "홍길동");
			//	Member membe = new Member(id, pw, "홍길동");
			//	session.setAttribute("member", member);
				response.sendRedirect("welcome.jsp");
			}	else {
			// 유효하지 않은 pw
			msg = URLEncoder.encode("pw를 체크하세요.", "utf-8");
			response.sendRedirect(conPath+"/lect2_login/login.jsp?msg="+msg);
			}
		} else {
			// 유효하지 않은 id
			msg = URLEncoder.encode("id를 체크하세요.", "utf-8");
			response.sendRedirect(conPath+"/lect2_login/login.jsp?msg="+msg);
		}
	%>
</body>
</html>