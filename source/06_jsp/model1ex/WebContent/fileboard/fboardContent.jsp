<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="com.lec.dto.FileBoardDto"%>
<%@page import="com.lec.dao.FileBoardDao"%>
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
		#content_form{padding: 40px;}
	</style>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
	<%
		
		String pageNum = request.getParameter("pageNum");
		int fid = Integer.parseInt(request.getParameter("fid"));
		FileBoardDao fDao = FileBoardDao.getinstance();
 		// list.jsp를 통해서 상세보기 페이지를 올 때만 조회수 1Up
		// list.jsp를 통해서 상세보기 페이지로 올 때 url : content.jsp?bid=2
		// 수정성공 후 상세페이지로 올 때 url : content.jsp?bid=2&after=u
		if(request.getParameter("after")==null){
			fDao.hitUp(fid);
		}
		FileBoardDto fDto = fDao.getBoard(fid); // dto가져오기
		if(fDto == null){
			response.sendRedirect(conPath + "/board/list.jsp");
		}
	%>
		<table>
			<caption>글 상세보기</caption>
			<tr><th>글번호</th><td><%=fDto.getFid() %></td></tr>
			<tr><th>제목</th><td><%=fDto.getFtitle() %></td></tr>
			<tr><th>작성자</th><td><%=fDto.getCname() %>
										(<%=fDto.getCemail()!=null?  fDto.getCemail() : "등록된 메일 주소 없음"%>)</td></tr>
			<tr><th>첨부파일</th><td><%
						if(fDto.getFilename()==null){
							out.print("첨부파일없음");
						}else{
							out.print("<a href='../fileboardUpload/"+fDto.getFilename()
														+"' target='_blank'>"+fDto.getFilename()+"</a>");
						}
			%></td></tr>
			<tr><th>본문</th><td><pre><%=fDto.getFcontent()!=null?  fDto.getFcontent():"본문 내용없음"%></pre></td>
			<tr><th>작성일</th><td><%=fDto.getFrdate() %></td></tr>
			<tr><th>조회수</th><td><%=fDto.getFhit() %></td></tr>
			<tr><th>ip</th><td><%=fDto.getFip() %></td></tr>
			<tr><td colspan="2">
					<button onclick="location='fboardList.jsp?pageNum=<%=pageNum%>'">목록</button>
					<%
						String cid = null;
					  CustomerDto customer = (CustomerDto)session.getAttribute("customer");
					  if(customer!=null){
						  cid = customer.getCid();
					  }					
					  if(fDto.getCid().equals(cid)){
					 %>
							<button 
							onclick="location='fboardUpdateForm.jsp?fid=<%=fid%>&pageNum=<%=pageNum%>'">
							수정</button>  
					<%}
						if(session.getAttribute("customer")!=null){ %>
							<button 
							onclick="location='fboardReplyForm.jsp?fid=<%=fid%>&pageNum=<%=pageNum%>'">
							답변</button>  
					<%} %>
					<button 
					onclick="location='fboardDeleteForm.jsp?fid=<%=fid%>&pageNum=<%=pageNum%>'">
					삭제</button>  
				</td>
			</tr>
		</table>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>