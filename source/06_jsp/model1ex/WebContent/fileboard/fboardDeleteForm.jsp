<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet">
	<style>
		#content_form{
			width:1000px; margin: 0px auto; height: 500px; 
			text-align: center;
			color: #003300;
			padding-top:100px;
		}
		#content_form input {height: 20px; padding:3px; margin: 10px 0;}
		#content_form .btn {height: 50px; padding:3px; margin: 5px 0;}
	</style>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
		<%
			String pageNum = request.getParameter("pageNum");
			String fid = request.getParameter("fid");
		%>	
		<table>
			<caption><%=fid %>번 글 삭제</caption>
			<tr>
				<td>
					<fieldset>
						<legend>게시물 비밀번호 입력(삭제)</legend>
						<form action="<%=conPath%>/fileboard/fboardDeletePro.jsp" method="post">
							<input type="hidden" name="pageNum" value="<%=pageNum %>">
							<input type="hidden" name="fid" value="<%=fid %>">
							암호 <input type="password" name="fpw" required autofocus class="btn">
							<input type="submit" value="삭제" class="btn">
							<input type="button" value="돌아가기" class="btn" onclick="history.back()">
						</form>
					</fieldset>
				</td>
			</tr>
		</table>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>