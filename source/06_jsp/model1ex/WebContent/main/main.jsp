
<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.CustomerDaoCP"%>
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
	<link href="<%=conPath %>/css/style.css" rel="stylesheet">
</head>
<body>
	<% 
		session = request.getSession();
		String cid = (String) session.getAttribute("cid");
		System.out.print(cid);
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		final int PAGESIZE = 5, BLOCKSIZE = 2;
		int startRow = (currentPage-1) * PAGESIZE + 1;
		int endRow = startRow + PAGESIZE - 1;
		
		CustomerDaoCP cdao = CustomerDaoCP.getInstanse();
		int totalCnt = cdao.CustomerCnt();
	%>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
		<%// main.jsp -> main.jsp?pageNum=1  main.jsp?pageNum=2%>
		<table>
			<tr><th>회원ID</th><th>비밀번호</th><th>이름</th><th>이메일</th><th>주소</th></tr>
		<%
			if(totalCnt == 0) {
				out.println("<tr><td colspan='5'>등록된 회원이 없습니다</td></tr>");
			} else {
				ArrayList<CustomerDto> dtos = cdao.listCustomer(startRow, endRow);
				for (CustomerDto dto : dtos) {
		%>
					<tr>
						<td><%=dto.getCid() %></td>
						<td><%=dto.getCpw() %></td>
						<td><%=dto.getCname() %></td>
						<td><%
								if(dto.getCemail() == null) {
									out.print("-");
								} else {
									out.print(dto.getCemail());
								}
							
							%></td>
						<td><%
								if(dto.getCaddress() == null) {
									out.print("-");
								} else {
									out.print(dto.getCaddress());
								}
							%></td>
					</tr>
		
		<%			
				}
			}
		%>
		</table>
		<div class="paging">
			<%
				int pageCnt = (int)Math.ceil((double)totalCnt/PAGESIZE);
				int startPage = ((currentPage-1)/BLOCKSIZE)*BLOCKSIZE+1;
				int endPage = startPage+BLOCKSIZE-1;
				if(endPage > pageCnt) {
					endPage = pageCnt;
				}
				if(startPage > BLOCKSIZE) {
					out.print("[<a href='"+conPath+"/main/main.jsp?pageNum="+(startPage-1)+"'>이전</a>] ");
				}
				for(int i=startPage; i<=endPage; i++) {
					if(i==currentPage) {
						out.print("[<b>"+ i +"</b>] ");
					} else {
						out.print("[<a href='"+conPath+"/main/main.jsp?pageNum="+i+"'>"+ i +"</a>] ");
					}
				}
				if(endPage < pageCnt) {
					out.print(" [<a href='"+conPath+"/main/main.jsp?pageNum="+(endPage+1)+"'>다음</a>]");
				}
			%>
	
		</div>		
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>