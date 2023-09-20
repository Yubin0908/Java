<%@page import="com.lec.ex.dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.ex.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet">
</head>
<body>
	<%
//		String result = request.getParameter("result");
//		if(result!=null && result.equals("1")) {
//			out.print("<script>alert('글쓰기성공');</script>");
//		} else if (result!=null && result.equals("0")) {
//			out.print("<script>alert('글쓰기실패');history.back();</script>");
//		}
	%>
	<table>
		<caption>게시판</caption>
		<tr><td><a href="<%=conPath %>/board/writeForm.jsp">글쓰기</a></td></tr>
	</table>
	<table>
		<tr><th>글번호</th><th>작성자</th><th>글제목</th><th>메일</th><th>조회수</th></tr>
		<%
			BoardDao bDao = BoardDao.getInstance();
			int totalCnt = bDao.getContentCnt();
			if(totalCnt == 0){
				out.println("<tr><td colspan='5'>등록된 글이 없습니다</td></tr>");
			}else{
				ArrayList<BoardDto> dtos = bDao.listBoard();
				for(BoardDto dto : dtos){
					out.println("<tr><td>"+dto.getBid() + "</td>");
					out.println("<td>" + dto.getBname() + "</td>");
					out.println("<td class='left'>");
					if(dto.getBhit() > 10){
						out.println("<img src='"+conPath+"/img/hot.gif'>");
					}
					out.println("<a href='"+conPath + "/board/content.jsp?bid="+ dto.getBid() +"'>"+ dto.getBtitle()+"</a>");					
					out.println("</td>");
					String email = dto.getBemail();
					out.println("<td>" + (email==null? "-":email) + "</td>");
					out.println("<td>"+dto.getBhit()+"</td></tr>");
				}
			}
		%>
	</table>
</body>
</html>