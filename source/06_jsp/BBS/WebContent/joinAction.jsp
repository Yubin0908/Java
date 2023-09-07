<%@page import="java.io.Console"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="user.UserDAO"	%>
<%@ page import="java.io.PrintWriter"	%>
<% request.setCharacterEncoding("UTF-8");	%>
<jsp:useBean id="user" class="user.User" scope="page" />
<jsp:setProperty name="user" property="userID" />
<jsp:setProperty name="user" property="userPW" />
<jsp:setProperty name="user" property="userName" />
<jsp:setProperty name="user" property="userGender" />
<jsp:setProperty name="user" property="userEmail" />
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width" initial-scale="1">
	<link rel="stylesheet" href="css/bootstrap.css"> <!-- BootStrap Css Init -->
	<title>JSP 게시판 웹사이트</title>
</head>
<body>
	<%
		if (user.getUserID() == null || user.getUserPW() == null || user.getUserName() == null || user.getUserGender() == null || user.getUserEmail() == null) {
			// Empty Form
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('빈칸이 존재합니다. 빈칸을 모두 채워주세요.')");
				script.println("history.back()");
				script.println("</script>");
		} else {
				UserDAO userDAO = new UserDAO();
				int result = userDAO.join(user);
				if (result == -1) { // userID Fail
					PrintWriter script = response.getWriter();
					script.println("<script>");
					script.println("alert('이미 존재하는 아이디입니다.')");
					script.println("history.back()");
					script.println("</script>");
				}
				else { // Success
					PrintWriter script = response.getWriter();
					script.println("<script>");
					script.println("location.href = 'main.jsp'");
					script.println("</script>");
				}
		}
		
	%>
</body>
</html>