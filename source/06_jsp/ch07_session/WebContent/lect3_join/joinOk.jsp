<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		String agree = request.getParameter("agree");
		
		if("y".equals(agree)) {
			// 약관 동의 : 세션 데이터값 받아 파일로 저장(DB) -> pw,name 값 삭제 ->result.jsp?msg=success 이동
			String id = (String)session.getAttribute("id");
			String pw = (String)session.getAttribute("pw");
			String name = (String)session.getAttribute("name");
			// 파일에 저장(D:/Project/source/06_jsp/ch07_session/WebContent/WEB-INF)
			String filePath = "D:/Project/source/06_jsp/ch07_session/WebContent/WEB-INF/"+id+".txt";
			PrintWriter writer = new PrintWriter(filePath);
			writer.print("오늘은 DB에 insert하는 대신 파일 출력\n");
			writer.print("id : " + id + "\n");
			writer.print("pw : " + pw + "\n");
			writer.print("name : " + name + "\n");
			writer.close();
			session.removeAttribute("pw");
			session.removeAttribute("name");
			response.sendRedirect("result.jsp?msg=success");
		} else {
			// 약관 동의 안함 : 세션 삭제 후 result.jsp?msg=fail 이동
			session.invalidate();
			response.sendRedirect("result.jsp?msg=fail");
		}
	
	%>
</body>
</html>