<%@page import="com.lec.dto.BookDto"%>
<%@page import="java.util.ArrayList"%>
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
	</style>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
		<div id="content_form">
			<%	
				String pageNum = request.getParameter("pageNum");
				if(pageNum == null) {
					pageNum = "1";
				}
				int currentPage = Integer.parseInt(pageNum);
				final int PAGESIZE = 3, BLOCKSIZE = 5;
				int startRow = (currentPage - 1) *  PAGESIZE + 1;
				int endRow = startRow + PAGESIZE - 1;
			
			
				BookDao bDao = BookDao.getinstance();
				ArrayList<BookDto> books = bDao.listBook(startRow, endRow);
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
								<a href="<%=conPath %>/book/bookContent.jsp?bid=<%=bid%>&pageNum=<%=pageNum%>">
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
			<div class="paging">
				<%
					int pageCnt = (int)Math.ceil((double)bDao.bookCount()/PAGESIZE);
					int startPage = ((currentPage - 1) / BLOCKSIZE) * BLOCKSIZE + 1;
					int endPage = startPage + BLOCKSIZE - 1;
					if(endPage > pageCnt) {
						endPage = pageCnt;
					}
					if(startPage > BLOCKSIZE) { // [Prev]
				%>
					[ <a href="bookList.jsp?pageNum=<%=startPage-1%>">Prev</a> ]
				<% } 
					for(int i=startPage; i<=endPage; i++) {
						if(i == currentPage) {
							out.print(" [ <b>" + i + "</b> ] ");
						} else {
							out.print(" [ <a href='bookList.jsp?pageNum=" + i + "'>" + i + "</a> ] ");
						}
					}
					if(endPage < pageCnt) {
				%>	
					[ <a href="bookList.jsp?pageNum=<%=endPage+1%>">Next</a> ]
				<%	
					}
				%>	
			</div>
		</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>