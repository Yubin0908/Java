<%@page import="com.lec.ex.dao.BoardDao"%>
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
		int bid = Integer.parseInt(request.getParameter("bid"));
		String bpw = request.getParameter("bpw");
		BoardDao bDao = BoardDao.getInstance();
		int result = bDao.deleteBoard(bid, bpw);
		if(result == BoardDao.SUCCESS) {
	%>
			<script>
				alert('삭제완료');
				location = '<%=conPath%>/board/list.jsp';
			</script>
	<% 		
		} else {
	%>
			<script>
				alert('비밀번호가 일치하지 않습니다.');
				history.go(-2);
			</script>	
	<%		
		}
	%>
</body>
</html>