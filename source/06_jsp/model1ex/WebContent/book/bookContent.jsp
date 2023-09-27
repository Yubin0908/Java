<%@page import="com.lec.dto.BookDto"%>
<%@page import="com.lec.dao.BookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet" type="text/css">
	<style>
		#content_form{
			height: 550px; 
			padding-top:50px;
		}
		.footer {
			margin-top: 100px;
		}
	</style>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
		<%
		int bid = Integer.parseInt(request.getParameter("bid"));
		String pageNum = request.getParameter("pageNum");
		BookDao bDao = BookDao.getinstance();
		BookDto book = bDao.getBook(bid);
		
		%>
		<table>
			<tr>
				<td rowspan="4">
					<img src="<%=conPath %>/bookimg/<%=book.getBimg1() %>" alt="대표이미지">
				</td>
				<td><%=book.getBid() %>번 도서 상세보기</td>
			</tr>
			<tr>
				<td><%=book.getBtitle() %></td>
			</tr>
			<tr>
				<td>
					<del><%=book.getBprice() %></del><br>
					<b><%=book.getBprice() * (100 - book.getBdiscount()) / 100%>원<br>(<%=book.getBdiscount() %>% 할인)</b>
				</td>
			</tr>
			<tr>
				<td>
					<button>구매</button>
					<button onclick="location.href='bookList.jsp?pageNum=<%=pageNum%>'">목록</button>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<img src="<%=conPath %>/bookimg/<%=book.getBimg2() %>" alt="추가이미지">
				</td>
			</tr>
		</table>
	</div>
	<div class="footer">
		<jsp:include page="../main/footer.jsp"/>
	</div>
</body>
</html>