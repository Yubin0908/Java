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
		String name = (String)session.getAttribute("name");
		if(name!=null) {
			// Login 상태
			session.removeAttribute("name");
			session.removeAttribute("id");
			
			out.println("성공적으로 로그아웃되었습니다.");
		} else {
			// Login 안 된 상태
			out.println("로그인 상태가 아닙니다.");
		}
	%>
	<button onclick="location.href='login.jsp'">로그인</button>
	<button onclick="location.href='welcome.jsp'">HOME</button>
	<buttononclick="location.href='sessionList.jsp'">세션 들여다 보기</button>
</body>
</html>