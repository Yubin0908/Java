<%@page import="javax.swing.text.DefaultEditorKit.CutAction"%>
<%@page import="com.lec.ex.dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.ex.dao.BoardDao"%>
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
//		String result = request.getParameter("result");
//		if(result!=null && result.equals("1")) {
//			out.print("<script>alert('글쓰기성공');</script>");
//		} else if (result!=null && result.equals("0")) {
//			out.print("<script>alert('글쓰기실패');history.back();</script>");
//		}
	%>
	<table>
		<caption>게시판</caption>
		<tr><td><a href="<%=conPath %>/board/writeForm.jsp">글쓰기</a></td></tr>
	</table>
	<table>
		<%
			String pageNum = request.getParameter("pageNum");
			if(pageNum == null) {
				pageNum="1"; // 전달받은 파라미터가 없으면 1로 세팅
			}
			int currentPage = Integer.parseInt(pageNum);
			final int PAGESIZE = 10, BLOCKSIZE = 10;
			int startRow = (currentPage-1)*PAGESIZE + 1;
			int endRow = startRow + PAGESIZE-1;
			
			BoardDao bDao = BoardDao.getInstance();
			int totalCnt = bDao.getContentCnt();
			%>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;총 개시글 수 : <%=totalCnt %>&nbsp;&nbsp;&nbsp;</p>
			<tr><th>글번호</th><th>작성자</th><th>글제목</th><th>메일</th><th>조회수</th></tr>
		<%
			if(totalCnt == 0){
				out.println("<tr><td colspan='5'>등록된 글이 없습니다</td></tr>");
			}else{
				ArrayList<BoardDto> dtos = bDao.listBoard(startRow, endRow);
				for(BoardDto dto : dtos){
					out.println("<tr><td>"+dto.getBid() + "</td>");
					out.println("<td>" + dto.getBname() + "</td>");
					out.println("<td class='left'>");
					if(dto.getBindent() > 0) { // 답변글 일 때
						int width = dto.getBindent()*15;
		%>
						<img src="<%=conPath %>/img/level.gif" style="width: <%=width %>px; vertical-align:middle;">
						<img src="<%=conPath %>/img/re.gif">
		<%
					}
					if(dto.getBhit() > 10){
						out.println("<img src='"+conPath+"/img/hot.gif'>");
					}
					out.println("<a href='"+conPath + "/board/content.jsp?bid="+ dto.getBid()+"&pageNum="+pageNum+"'>"+ dto.getBtitle()+"</a>");
					out.println("</td>");
					String email = dto.getBemail();
					out.println("<td>" + (email==null? "-":email) + "</td>");
					out.println("<td>"+dto.getBhit()+"</td></tr>");
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
				out.print("[<a href='"+conPath+"/board/list.jsp?pageNum="+(startPage-1)+"'>이전</a>] ");
			}
			for(int i=startPage; i<=endPage; i++) {
				if(i==currentPage) {
					out.print("[<b>"+ i +"</b>] ");
				} else {
					out.print("[<a href='"+conPath+"/board/list.jsp?pageNum="+i+"'>"+ i +"</a>] ");
				}
			}
			if(endPage < pageCnt) {
				out.print(" [<a href='"+conPath+"/board/list.jsp?pageNum="+(endPage+1)+"'>다음</a>]");
			}
		%>

	</div>
</body>
</html>