<%@page import="com.lec.ex.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String conPath = request.getContextPath(); 
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="dto" class="com.lec.ex.dto.BoardDto"/>
<jsp:setProperty property="*" name="dto"/>
<%
	dto.setBip(request.getRemoteAddr());
	BoardDao bDao = BoardDao.getInstance();
	int result = bDao.writeBoard(dto);
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet">
</head>
<body>
	<%
		//response.sendRedirect(conPath+"/board/list.jsp?writeResult="+writeResult);
		if(result == BoardDao.SUCCESS) {
	%>
			<script>
				alert('글쓰기 완료');
				location.href="<%=conPath%>/index.jsp";
			</script>
	<%
		} else {
	%>	
			<script>
				alert('글쓰기 실패');
				history.back;
			</script>
	<%		
		}
	%>
</body>
</html>