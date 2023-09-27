<%@page import="com.lec.dto.FileBoardDto"%>
<%@page import="com.lec.dao.FileBoardDao"%>
<%@page import="com.lec.dto.CustomerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
    String conPath = request.getContextPath(); 
    session = request.getSession();
    CustomerDto customer = (CustomerDto) session.getAttribute("customer");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet" type="text/css">
	<style>
		#content_form{
			width:1000px; margin: 0px auto; height: 550px; 
			text-align: center;
			color: #003300;
			padding-top:50px;
		}
		#content_form input {height: 20px; padding:3px; margin: 10px 0;}
		#content_form .btn {height: 50px; padding:3px; margin: 5px 0;}
	</style>
</head>
<body>
	<%
		String pageNum = request.getParameter("pageNum");
		int fid = Integer.parseInt(request.getParameter("fid"));
		FileBoardDao fDao = FileBoardDao.getinstance();
		FileBoardDto orgDto = fDao.getBoard(fid);
	%>
	
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
		<form action="<%=conPath%>/fileboard/fboardReplyPro.jsp" method="post" enctype="multipart/form-data">
			<input type="hidden" name="pageNum" value="<%=pageNum %>">
			<input type="hidden" name="fid" value="<%=fid%>">
			<input type="hidden" name="fgroup" value="<%=orgDto.getFgroup()%>">
			<input type="hidden" name="fstep" value="<%=orgDto.getFstep() %>">
			<input type="hidden" name="findent" value="<%=orgDto.getFindent() %>">
			<table>
				<caption><%=fid %>번 글에 답변글 작성</caption>
				<tr>
					<th>제목</th>
					<td><input type="text" name="ftitle" required autofocus></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td>
						<input type="file" name="filename" style="width:30%;">
					</td>
				</tr>
				<tr>
					<th>글내용</th>
					<td><textarea rows="5" name="fcontent"></textarea></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="fpw" required></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="답변달기" class="btn">
						<input type="reset" value="다시작성" class="btn">
						<input type="button" value="목록" class="btn" onclick="fboardList.jsp?pageNum=<%=pageNum%>">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>