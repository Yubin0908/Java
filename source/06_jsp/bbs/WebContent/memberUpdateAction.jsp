<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="user.User" %>
<%@ page import="user.UserDAO" %>
<% request.setCharacterEncoding("UTF-8"); %>

<%
    // 세션에서 현재 로그인한 사용자의 아이디를 가져옴
    String userID = (String) session.getAttribute("userID");

    // 만약 로그인이 되어있지 않다면 로그인 페이지로 이동
    if (userID == null) {
        PrintWriter script = response.getWriter();
        script.println("<script>");
        script.println("alert('로그인을 하셔야 회원 정보를 변경할 수 있습니다.')");
        script.println("location.href = 'login.jsp'");
        script.println("</script>");
    } else {
        // 사용자가 입력한 회원 정보를 가져옴
        String userPW = request.getParameter("userPW");
        String userName = request.getParameter("userName");
        String userGender = request.getParameter("userGender");
        String userEmail = request.getParameter("userEmail");

        // 입력한 정보로 User 객체 생성
        User user = new User(userID, userPW, userName, userGender, userEmail);

        // UserDAO를 사용하여 회원 정보 업데이트
        UserDAO userDAO = new UserDAO();
        int result = userDAO.updateUser(user);

        if (result == 1) {
            // 업데이트 성공
            PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("alert('회원 정보가 성공적으로 변경되었습니다.')");
            script.println("location.href = 'main.jsp'");
            script.println("</script>");
        } else {
            // 업데이트 실패
            PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("alert('회원 정보 변경에 실패하였습니다. 다시 시도해주세요.')");
            script.println("history.back()");
            script.println("</script>");
        }
    }
%>
