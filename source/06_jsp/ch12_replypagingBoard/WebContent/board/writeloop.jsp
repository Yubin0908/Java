<%@page import="java.sql.Date"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="com.lec.ex.dto.BoardDto"%>
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
		BoardDao bDao = BoardDao.getInstance();
		BoardDto bDto = new BoardDto(); 
		for(int i=0; i<70; i++) {
			bDto.setBname("홍길동"+i);
			bDto.setBtitle("Write Board"+i);
			bDto.setBcontent("자동 작성됨" );
			if(i%2!=0) {
				bDto.setBemail("hong" + i + "@hong.com");
			}
			bDto.setBpw("111");
			bDto.setBip("14.94.11."+i);
			int result = bDao.writeBoard(bDto);
			System.out.println(result==BoardDao.SUCCESS? i+"번째 성공":i+"번쨰 실패");
		}
		response.sendRedirect(conPath+"/board/list.jsp");
	%>
</body>
</html>