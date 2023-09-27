<%@page import="com.lec.ex.book.BookDto"%>
<%@page import="com.lec.ex.book.BookDao"%>
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
				<button onclick="location.href='ex4_product.jsp?pageNum=<%=pageNum%>'">목록</button>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<img src="<%=conPath %>/bookimg/<%=book.getBimg2() %>" alt="추가이미지">
			</td>
		</tr>
	</table>
</body>
</html>