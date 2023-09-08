<%@page import="java.sql.Date"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원 가입 정보</title>
	<link href="join.css" rel="stylesheet">
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String date = request.getParameter("date");
	Date birth = null;
	Timestamp datetime = null;
	if (date != null && !date.equals("")) {
		birth = Date.valueOf(date);
		datetime = Timestamp.valueOf(date + " 00:00:00");
	}
	String[] hobby = request.getParameterValues("hobby");
	String gender = request.getParameter("gender");
	String mail = request.getParameter("email");
	String[] mailSend = request.getParameterValues("mailSend");

	%>
	
	<div id="joinForm_wrap">
		<div id="join_title">
			회원 가입 정보
		</div>
		<div id="join_content">
			<p>name : <%= name %></p>
			<p>id : <%= id %></p>
			<p>pw :
			<% 
			    for(int i = 0; i < pw.length(); i++) {
			        out.print('*');
			    }			
			%>
			</p>
			<p>birth : <%= date %></p>
			<p>birth2 : <%= datetime %></p>
			<p>hobby : 
			<%
				if (hobby != null) {
					for (int i = 0; i < hobby.length; i++) {
						out.print(hobby[i]);
						if (i < hobby.length - 1) {
							out.print(", ");
						}
					}
				} else {
					out.print("없음");
				}
			%>
			</p>
			<p>gender : <%=gender %></p>
			<p>email : <%=mail %></p>
			<p>mailSend : 
			<%
			if (mailSend != null) {
				for (int i = 0; i < mailSend.length; i++) {
					out.print(mailSend[i]);
					if (i < mailSend.length - 1) {
						out.print(", ");
					}
				}
			} else {
				out.print("모두 수신 거부");
			}
			%>
			</p>
			<p>가입ID : <%=request.getRemoteAddr() %>
		</div>
	</div>
	<div>
	<%@include file="footer.jsp" %>
	</div>
</body>
</html>
