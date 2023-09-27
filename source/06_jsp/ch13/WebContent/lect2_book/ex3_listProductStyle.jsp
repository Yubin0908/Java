<%@page import="com.lec.ex.book.BookDto"%>
<%@page import="java.util.ArrayList"%>
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
		BookDao bDao = BookDao.getinstance();
		ArrayList<BookDto> books = bDao.listBook();
		
	%>
	<table>
		<caption>책 리스트</caption>
		<tr>
			<%
				if(books.isEmpty()) {
					out.print("<td>책이 없습니다</td>");
				} else {
					for(int i=0; i<books.size(); i++) {
						int bid = books.get(i).getBid();
						int price = books.get(i).getBprice();
						int discount = books.get(i).getBdiscount();
						int disPrice = price * (100 - discount) / 100;
						
						if(i!=0 && i%3==0) {
							out.print("</tr><tr>");
						} 
				%>
					<td>
						<a href="<%=conPath %>/lect2_book/content.jsp?bid=<%=bid%>">
							<img alt="" src="<%=conPath%>/bookimg/<%=books.get(i).getBimg1()%>"><br>
							<%=bid %>, <%=books.get(i).getBtitle() %><br>
						</a>
						<del><%=price %></del><br>
						<b><%=disPrice %>원(<%=discount %>% 할인)</b>
					</td>
				<%
						
					}
				}
			%>
		</tr>		
	</table>
	<hr>
	<a href="ex1_listBoardStyle.jsp">책 전체 리스트(게시판 스타일)</a> <br>
	<a href="ex2_list.jsp">책 리스트(페이징)(게시판 스타일)</a> <br>
	<a href="ex3_listProductStyle.jsp">책 전체 리스트(제품 리스트 스타일)</a> <br>
	<a href="ex4_product.jsp">책 리스트(페이징)(제품 리스트 스타일)</a> <br>
</body>
</html>