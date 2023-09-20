<%@page import="java.io.Console"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bbs.Bbs"	%>
<%@ page import="bbs.BbsDAO"	%>
<%@ page import="java.io.PrintWriter"	%>
<% request.setCharacterEncoding("UTF-8");	%>	
<jsp:useBean id="bbs" class="bbs.Bbs" scope="page"/>
<jsp:setProperty name="bbs" property="bbsTitle"/>
<jsp:setProperty name="bbs" property="bbsContent"/>
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
		String userID = null;
		if(session.getAttribute("userID") != null) {
			userID = (String) session.getAttribute("userID");
		}
	  if(userID == null) { // 로그인이 안되있으면 로그인화면 호출
		  PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('로그인을 하셔야 게시글 작성이 가능합니다.')");
			script.println("location.href = 'login.jsp'");
			script.println("</script>");
	  } else {
			if (bbs.getBbsTitle() == null || bbs.getBbsContent() == null) {
				// Empty Form
					PrintWriter script = response.getWriter();
					script.println("<script>");
					script.println("alert('빈칸이 존재합니다. 빈칸을 모두 채워주세요.')");
					script.println("history.back()");
					script.println("</script>");
			} else {
					BbsDAO bbsDAO = new BbsDAO();
					int result = bbsDAO.write(bbs.getBbsTitle(), userID, bbs.getBbsContent());
					if (result == -1) { // database error
						PrintWriter script = response.getWriter();
						script.println("<script>");
						script.println("alert('글쓰기에 실패하였습니다.')");
						script.println("history.back()");
						script.println("</script>");
					}
					else { // Success
 						PrintWriter script = response.getWriter();
						script.println("<script>");
						script.println("location.href = 'bbs.jsp'");
						script.println("</script>");
	 				}
		}
	}
		
	%>
</body>
</html>