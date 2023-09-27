<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="com.lec.dao.CustomerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String conPath = request.getContextPath(); 
	String cid = request.getParameter("cid");
	String cpw = request.getParameter("cpw");
	CustomerDao cDao = CustomerDao.getInstanse();
	String method = request.getParameter("method");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet">
</head>
<body>
	<%
		int result = cDao.Logincheck(cid, cpw);
		if(result == CustomerDao.LOGIN_SUCCESS) {
			CustomerDto customer = cDao.getCustomer(cid);
			session.setAttribute("customer", customer);
			if(method.equals("null")) {
				response.sendRedirect("../main/main.jsp");
			} else {
				response.sendRedirect(method+".jsp");
			}
			
		} else if(result == CustomerDao.LOGIN_FAIL_PW) {
			response.sendRedirect("loginForm.jsp?msg=");
	%>
	<script>
		alert('비밀번호를 확인하세요.');
		history.back();
	</script>
	<%
		} else if(result == CustomerDao.LOGIN_FAIL_ID) {
			response.sendRedirect("loginForm.jsp?msg=");
	%>
	<script>
		alert('아이디를 확인하세요.');
		history.back();
	<%
		}
	%>
	</script>
</body>
</html>