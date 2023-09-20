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
	<a href="xx.jsp">예외페이지 테스트</a>
	<hr>
	<h3>
	<% 
		BoardDao bDao = BoardDao.getInstance();
		out.println("1. 글 목록 출력");
		ArrayList<BoardDto> dtos = bDao.listBoard();
		for(BoardDto dto : dtos) {
			out.println("</h3>" + dto + "<br>");
		}
	%>
	<hr>
	<h3>
	<%
		out.println("2. 게시물 갯수 : " + bDao.getContentCnt());
	%>
	<hr>
	<%
		out.println("3. 원글 쓰기");
		BoardDto dto = new BoardDto(0, "신길동", "벌써 절반지났다", "남은 시간도 화이팅!", "shin@go.kr", 0, "111",
				0, 0, 0, "14.96.0.97", null);
		int result = bDao.writeBoard(dto);
		if(result == BoardDao.SUCCESS) {
			out.print("성공");
		} else {
			out.print("실패");
		}
	%>
	<hr>
	<%
		out.println("6. 조회수 안올리고 글번호로 dto 가져오기<br></h3>");
		out.println("3번 글 : " + bDao.getBoard(3) + "<br>");
		out.println("4or5. 조회수 올리고 글번호로 dto 가져오기<br>");
		out.println("3번 글 상세 : " + bDao.getContent(3) + "<br>");
	%>
	<hr>
	<%
		out.println("<h3>7. 글수정</h3>");
		dto = bDao.getBoard(3);
		dto.setBname("독특자");
		dto.setBtitle("독특한 제목");
		dto.setBcontent("독특한 본문수정");
		result = bDao.modifyBoard(dto);
		out.print(result == BoardDao.SUCCESS ? "성공":"실패");
	%>	
	<hr>
	<%
		out.println("<h3>8. 글 삭제</h3>");
		result = bDao.deleteBoard(2, "222");
		out.print(result == BoardDao.SUCCESS ? "삭제성공":"삭제실패");
	%>
</body>
</html>