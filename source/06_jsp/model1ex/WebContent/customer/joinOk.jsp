<%@page import="com.lec.dao.CustomerDao"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String conPath = request.getContextPath(); 
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="dto" class="com.lec.dto.CustomerDto"/>
<jsp:setProperty property="*" name="dto"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		String tempCbirth = request.getParameter("tempCbirth");
		if(!tempCbirth.equals("")) {
			dto.setCbirth(Date.valueOf(tempCbirth));
		}
		CustomerDao cDao = CustomerDao.getInstanse();
		int result = cDao.confirmID(dto.getCid());
		if(result == CustomerDao.CUSTOMER_NOTEXISTENT) {
			result = cDao.joinCustomer(dto);
			if(result == CustomerDao.SUCCESS) {
				session.setAttribute("cid", dto.getCid());
				response.sendRedirect("loginForm.jsp");
			} else {
	%>
		<script>
			alert('문자길이제한을 초과하였습니다.');
			history.go(-1);
		</script>
	<% 
			}
		} else {
	%>
		<script>
			alert('중복된 아이디입니다.');
			history.back();
		</script>
	<%
		}
	%>
</body>
</html>