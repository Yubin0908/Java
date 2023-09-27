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
		FileBoardDto fDto = fDao.getBoard(fid);
	%>
	
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
		<form action="<%=conPath%>/fileboard/fboardUpdatePro.jsp" method="post" enctype="multipart/form-data">
			<input type="hidden" name="pageNum" value="<%=pageNum %>">
			<input type="hidden" name="dbfilename" value="<%=fDto.getFilename()%>">	
			<table>
				<caption>글수정</caption>
				<tr>
					<th>글번호</th>
					<td><input type="text" name="fid" value="<%=fid%>" readOnly></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" name="ftitle" required value="<%=fDto.getFtitle() %>" autofocus></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td>
						<input type="file" name="filename" style="width:30%;">
						<%
							if(fDto.getFilename()!=null){
								out.print("(현재 첨부된 파일 : " + fDto.getFilename()+")");
							}else{
								out.print("첨부화일없음");
							}
						%>
					</td>
				</tr>
				<tr>
					<th>글내용</th>
					<td><textarea rows="5" name="fcontent"><%=fDto.getFcontent()!=null ? fDto.getFcontent():"" %></textarea></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="fpw" required value="<%=fDto.getFpw()%>"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="글수정" class="btn">
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