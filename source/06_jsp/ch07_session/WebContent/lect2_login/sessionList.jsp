<%@page import="java.util.Enumeration"%>
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
	<button onclick="history.back()">이전페이지</button>
	<button onclick="location.href='login.jsp'">로그인</button>
	<button onclick="location.href='logout.jsp'">로그아웃</button>
	<button onclick="location.href='welcome.jsp'">HOME</button>
	<button onclick="location.href='sessionList.jsp'">세션 들여다 보기</button>
</body>
</html>