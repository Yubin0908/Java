<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/ex4.css" rel="stylesheet">

</head>
<body>
	<%!
		String suParam; int su; int comsu;
	%>
	<%
		suParam = request.getParameter("su");
		if(suParam != null) {
			su = Integer.parseInt(suParam);
			// su와 컴퓨터가 발생한 난수를 비교하여 분기 or 머무르기
			// int comsu = (int)(Math.random()*3)+1;
			Random random = new Random();
			comsu = random.nextInt(3)+1;
			
			if(su != comsu) {
				String msg = "<h2>Wrong! Try Agein!</h2>" + "<h3>"+su+"는 아니고 정답은 "+comsu+"</h3>";
				msg = URLEncoder.encode(msg, "utf-8"); // 한글 파라미터를 넘기기 위한 작업
				response.sendRedirect("ex4_yaba.jsp?msg="+msg);
			} 
		} else {
			response.sendRedirect("ex4_yaba.jsp");
		}
	%>
	<div id="wrap">
		<h2>정답입니다.</h2>
		<h3>동전이 있던 곳은 <%=su %></h3>
		<button onclick="location.href='ex4_yaba.jsp'">다시 도전</button>
	</div>
</body>
</html>