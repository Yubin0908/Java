<%@page import="com.lec.ex.dto.BoardDto"%>
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
		String bid = request.getParameter("bid");
		BoardDao bDao = BoardDao.getInstance();
		BoardDto bDto = bDao.getContent(bid);
		if(bDto == null) {
			response.sendRedirect(conPath+"/board/list.jsp");
		} else {
	%>
				<table>
					<caption><%=bid %>번 글 상세보기</caption>
					<tr>
						<th>글번호</th>
						<td><%=bDto.getBid() %></td>
					</tr>
					<tr>
						<th>글제목</th>
						<td><%=bDto.getBtitle() %></td>
					</tr>
					<tr>
						<th>골 본문</th>
						<td><pre><%=bDto.getBcontent()==null? "":bDto.getBcontent() %></pre></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><%=bDto.getBemail()==null? "":bDto.getBemail() %></td>
					</tr>
					<tr>
						<th>조회수</th>
						<td><%=bDto.getBhit() %></td>
					</tr>
					<tr>
						<th>IP</th>
						<td><%=bDto.getBip() %></td>
					</tr>
					<tr>
						<th>작성일자</th>
						<td><%=bDto.getBdate() %></td>
					</tr>
					<tr>
						<td colspan="2">
							<button onclick="location.href='<%=conPath%>/board/updateForm.jsp?bid=<%=bDto.getBid()%>'">수정</button>
							<button onclick="location='<%=conPath%>/board/deleteForm.jsp?bid=<%=bDto.getBid()%>'">삭제</button>
							<button>답변</button>
							<button onclick="location.href='<%=conPath%>/board/list.jsp'">목록</button>
						</td>
					</tr>
				</table>
	
	<% 		
		}
	%>
	
</body>
</html>