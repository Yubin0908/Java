<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="user.User" %>
<%@ page import="user.UserDAO" %>
<%
   request.setCharacterEncoding("UTF-8");
   String userID = (String)session.getAttribute("userID");
   User user = null; // User 객체를 미리 초기화
   if (userID != null) { // userID가 null이 아닐 때만 실행
       UserDAO userDAO = new UserDAO();
       user = userDAO.getUser(userID);
   }
%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width" initial-scale="1">
    <link rel="stylesheet" href="css/bootstrap.css"> <!-- BootStrap Css Init -->
    <title>JSP 게시판 웹사이트</title>
</head>
<body>

    <nav class="navbar navbar-default">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed"
                            data-toggle="collapse" data-target="$bs-example-navbar-collapse-1"
                            aria-expanded="false">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="main.jsp">JSP 게시판 웹사이트</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="main.jsp">메인</a></li>
                <li><a href="bbs.jsp">게시판</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                                        aria-haspopup="true" aria-expanded="false">접속하기<span class="caret"></span></a>
                    <!--caret span : 하나의 아이콘 개념 -->
                    <ul class="dropdown-menu">
                        <li><a href="logoutAction.jsp">로그아웃</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>

    <div class="container">
        <div class="col-lg-4"></div>
        <div class="col-lg-4">
            <div class="jumbotron" style="padding-top: 20px">
                <form action="memberUpdateAction.jsp" method="post">
                    <h3 style="text-align: center;">회원정보변경</h3>
                    <div class="form-group">
                        <p> 아이디 : <%= userID %></p>
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" placeholder="변경할 비밀번호" name="userPW" maxlength="20">
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="변경할 이름" name="userName" maxlength="20" value="<%= (user != null) ? user.getUserName() : "" %>">
                    </div>
                    <div class="form-group">
                        <input type="email" class="form-control" placeholder="이메일" name="userEmail" maxlength="50" value="<%= (user != null) ? user.getUserEmail() : "" %>">
                    </div>
                    <input type="submit" class="btn btn-primary form-control" value="정보변경">
                </form>
            </div>
        </div>
        <div class="col-lg-4"></div>
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.js"></script>
</body>
</html>