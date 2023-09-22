<%@page import="com.lec.ex.dao.BoardDao"%>
<%@page import="java.sql.Timestamp"%>
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
		// 전달받을 파라미터 : pageNum, bstep, bindent, bgroup (원글정보)
		// bname, btitle, bcontent, bemail, bpw (답변글 정보)
		request.setCharacterEncoding("utf-8");
		String pageNum = request.getParameter("pageNum");
	%>
	<jsp:useBean id="dto" class="com.lec.ex.dto.BoardDto" scope="page"/>
	<jsp:setProperty property="*" name="dto"/>
	<%
		dto.setBip(request.getRemoteAddr());
		BoardDao bDao = BoardDao.getInstance();
		int result = bDao.replyBoard(dto);
		if(result == BoardDao.SUCCESS) {
	%>
		<script>
			alert('<%=dto.getBid()%>번 글에대한 답변글을 작성했습니다.');
			location.href='<%=conPath%>/board/list.jsp?pageNum=<%=pageNum%>';
		</script>
	<%
		} else {
	%>
	<script>
		alert('<%=dto.getBid()%>번 글에대한 답변글을 작성하지 못했습니다.');
		history.back();
	</script>
	<%
		}
	%>
</body>
</html>