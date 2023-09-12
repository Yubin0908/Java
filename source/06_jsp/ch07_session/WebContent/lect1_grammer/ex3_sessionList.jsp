<%@page import="java.util.Enumeration"%>
<%@page import="com.lec.ex.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet">
</head>
<body>
	<% // session에 추가된 모든 데이터 리스트
		out.println("<h1>모든 세션 속성들</h1>");
		Enumeration<String> sAttrNames = session.getAttributeNames();
		int cnt = 0;
		while(sAttrNames.hasMoreElements()) {
			cnt++;
			String sname = sAttrNames.nextElement();
			String svalue = session.getAttribute(sname).toString();
			out.println("<h2>" + cnt + "." + sname + "<- 세션 속성 명 " + svalue + "<- 세션 값</h2>");
		}
		if(cnt == 0) {
			out.println("세션 속성이 없음.");
		}
	%>
	<hr>
	<h2>세션 ID : <%=session.getId() %></h2>
	<h2>세션 유효시간 : <%=session.getMaxInactiveInterval() %></h2>
	<hr>
	<a href="ex1_sessionAddAttr.jsp">session 데이터 추가</a><br>
	<a href="ex2_sessionGet.jsp">특성 session get</a><br>
	<a href="ex3_sessionList.jsp">session의 모든 데이터 리스트</a><br>
	<a href="ex4_sessionRemove.jsp">session delete(특정 세션 데이터나 모든 세션 데이터)</a><br>

</body>
</html>