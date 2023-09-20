<%@page import="java.io.Console"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bbs.Bbs"	%>
<%@ page import="bbs.BbsDAO"	%>
<%@ page import="java.io.PrintWriter"	%>
<% request.setCharacterEncoding("UTF-8");	%>

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
        } 
        int bbsID = 0;
        if (request.getParameter("bbsID") != null) {
                bbsID = Integer.parseInt(request.getParameter("bbsID"));
        }
        if (bbsID == 0) { // 글이 존재하지 않을때
            PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("alert('유효하지않은 게시물 입니다.')");
            script.println("location.href = 'bbs.jsp'");
            script.println("</script>");
        }
        Bbs bbs = new BbsDAO().getBbs(bbsID);
        if (!userID.equals(bbs.getUserID())) {
            PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("alert('수정 권한이 없습니다.')");
            script.println("location.href = 'bbs.jsp'");
            script.println("</script>");
        } else {
            String bbsTitle = request.getParameter("bbsTitle");
            String bbsContent = request.getParameter("bbsContent");
            
            if (bbsTitle == null || bbsTitle.trim().isEmpty() || bbsContent == null || bbsContent.trim().isEmpty()) {
                // 빈칸이 있는 경우
                PrintWriter script = response.getWriter();
                script.println("<script>");
                script.println("alert('제목과 내용을 모두 입력하세요.')");
                script.println("history.back()");
                script.println("</script>");
            } else {
                BbsDAO bbsDAO = new BbsDAO();
                int result = bbsDAO.update(bbsID, bbsTitle, bbsContent);
                if (result == -1) { // database error
                    PrintWriter script = response.getWriter();
                    script.println("<script>");
                    script.println("alert('게시글 수정에 실패하였습니다.')");
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