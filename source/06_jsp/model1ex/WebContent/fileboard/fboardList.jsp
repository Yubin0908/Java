<%@page import="com.lec.dto.FileBoardDto"%>
<%@page import="java.util.ArrayList"%>
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
		#content_form{
			height: 570px; 
			padding-top:30px;
		}
	</style>
	
	
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
		<table>
			<tr><td colspan="7"> 
					<%if(session.getAttribute("customer")!=null){%>
						<a href="fboardWriteForm.jsp">글쓰기</a>
					<%} %>
				</td>
			</tr>
			<tr><th>글번호</th><th>작성자</th><th>글제목</th><th>메일</th><th>IP</th><th>작성일</th><th>조회수</th></tr>
			<%
				String pageNum = request.getParameter("pageNum");
				if(pageNum==null) pageNum = "1";
				int currentPage = Integer.parseInt(pageNum);
				final int PAGESIZE=10, BLOCKSIZE=10;
				int startRow = (currentPage-1) * PAGESIZE + 1;
				int endRow   = startRow + PAGESIZE - 1;
				FileBoardDao fbDao = FileBoardDao.getinstance();
				ArrayList<FileBoardDto> dtos = fbDao.listBoard(startRow, endRow);
				if(dtos.size()==0){
					out.print("<tr><td colspan='7'>등록된 글이 없습니다.</td></tr>");
				}else{
					for(FileBoardDto d : dtos){
						out.print("<tr><td>"+d.getFid()+"</td>");
						out.print("<td>"+d.getCname()+"</td>");
						out.print("<td class='left'>");
						if(d.getFindent()>0){
							int width = d.getFindent()*20;
							out.print("<img src='../img/level.gif' width='"+width+"' height='10'>");
							out.print("<img src='../img/re.gif'>");
						}
						if(d.getFhit()>10){
							out.print("<img src='../img/hot.gif'>");
						}
						/* out.print("<a href='fboardContent.jsp?fid="+d.getFid()+"&pageNum="+pageNum+
																					"'>"+d.getFtitle()+"</a> "); */
						out.print(d.getFtitle());
						if(d.getFilename()!=null){
							out.print("<img src='../img/fileup.jpg' width='10'></td>");
						}
						out.print("<td>"+(d.getCemail()!=null? d.getCemail():"-")+"</td>");
						out.print("<td>"+d.getFip()+"</td>");
						out.print("<td>"+d.getFrdate()+"</td>");
						out.print("<td>"+d.getFhit()+"</td>");
					}
				}
			%>
		</table><br>
		<div class="paging">
	<%
		int totCnt = fbDao.BoardCnt();
		int pageCnt = (int)Math.ceil((double)totCnt/PAGESIZE);
		int startPage = ((currentPage-1)/BLOCKSIZE)*BLOCKSIZE +1;
		int endPage = startPage +BLOCKSIZE -1;
		if(endPage>pageCnt) endPage = pageCnt;
		if(startPage>BLOCKSIZE){ %>
			[ <a href="fboardList.jsp?pageNum=<%=startPage-1%>"> 이전 </a> ]
	<%}
		for(int i=startPage ; i<=endPage ; i++){
			if(i==currentPage){
				out.print(" [ <b>"+ i + "</b> ] ");
			}else{
				out.print(" [ <a href='fboardList.jsp?pageNum="+i+"'>" + i + "</a> ]");
			}
		}
		if(endPage<pageCnt){%>
			[ <a href="fboardList.jsp?pageNum=<%=endPage+1 %>"> 다음 </a> ]
	<%}%>
	</div>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script>
	$(document).ready(function() {
		$('tr').click(function() {
			var fid = $(this).children().eq(0).text().trim();
			if(!isNaN(Number(fid))) {
				location.href = 'fboardContent.jsp?pageNum=<%=pageNum%>&fid='+fid;
			}
		});
	});
</script>
