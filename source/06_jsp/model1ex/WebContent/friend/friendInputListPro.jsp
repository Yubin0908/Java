<%@page import="com.lec.friend.FriendDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="dto" class="com.lec.friend.FriendDto"/>
<jsp:setProperty property="name" name="dto"/>
<jsp:setProperty property="tel" name="dto"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <%
        FriendDao dao = new FriendDao();
        String name = dto.getName();
        String tel = dto.getTel();

        if (name == null) {
            name = " ";
        }

        int result = dao.input(name, tel);
			
      	  if (result == dao.FRIEND_INPUT_FAIL) {
    %>
        <script>
            alert('등록되지 않았습니다.');
            history.back();
        </script>
    <%
       	 } else if (result == dao.FRIEND_INPUT_PASS) {
    %>
        <script>
            alert('친구추가완료');
            location.href = 'friendInputList.jsp';
        </script>

    <%
        }
    %>
</body>
</html>