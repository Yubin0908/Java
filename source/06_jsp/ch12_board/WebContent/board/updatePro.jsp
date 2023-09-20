<%@page import="com.lec.ex.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String conPath = request.getContextPath(); 
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="dto" class="com.lec.ex.dto.BoardDto"/>
<jsp:setProperty property="*" name="dto"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		dto.setBip(request.getRemoteAddr());
		BoardDao bDao = BoardDao.getInstance();
		int result = bDao.modifyBoard(dto);
		String bid = request.getParameter("bid");
		if(result == BoardDao.SUCCESS) {
	%>
			<script>
				alert('수정 완료');
				location.href="<%=conPath%>/board/content.jsp?bid=<%=bid%>";
			</script>
	<%
		} else {
	%>
			<script>
				alert('수정 실패');
				history.back;
			</script>
	<%
		}
	%>
</body>
</html>