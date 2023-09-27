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
		String cid = ""; // cid 초기화
		if (customer != null) {
            cid = customer.getCid();
        }
	%>
	
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
		<form action="<%=conPath%>/fileboard/fboardWritePro.jsp" method="post" enctype="multipart/form-data">
			<table>
				<caption>글쓰기</caption>
				<tr>
					<th>작성자</th>
					<td><%=cid %></td>
				</tr>
				<tr>
					<th>글제목</th>
					<td><input type="text" name="ftitle" min="0" required></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td><input type="file" name="filename"></td>
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
						<input type="submit" value="글등록" class="btn">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>