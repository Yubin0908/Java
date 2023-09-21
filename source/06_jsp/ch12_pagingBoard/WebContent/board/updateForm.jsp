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
		String pageNum = request.getParameter("pageNum");
		int bid = Integer.parseInt(request.getParameter("bid"));
		BoardDao bDao = BoardDao.getInstance();
		BoardDto bDto = bDao.getBoard(bid);
	%>
	<form action="<%=conPath%>/board/updatePro.jsp?pageNum=<%=pageNum %>" method="post">
		<input type="hidden" name="bid" value="<%=bid%>">
		<table>
			<caption><%=bid %>번 글 수정</caption>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="bname" required autofocus value="<%=bDto.getBname()%>"></td>
			</tr>
			<tr>
				<th>글제목</th>
				<td><input type="text" name="btitle" required value="<%=bDto.getBtitle()%>"></td>
			</tr>
			<tr>
				<th>본문</th>
				<td><textarea row="" name="bcontent" required><%=bDto.getBcontent()==null? "":bDto.getBcontent() %></textarea></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="email" name="bemail" value="<%=bDto.getBemail()==null? "":bDto.getBemail()%>"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="bpw" required value="<%=bDto.getBpw() %>"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="글수정" class="btn">
					<input type="button" value="취소" class="btn" onclick="history.back()">
					<input type="button" value="목록" class="btn" onclick="location.href='list.jsp?pageNum=<%=pageNum%>'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>