<%@page import="java.sql.Date"%>
<%@page import="com.lec.dao.CustomerDao"%>
<%@page import="com.lec.dto.CustomerDto"%>
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
	<link href="<%=conPath %>/css/style.css" rel="stylesheet">
</head>
<body>
	<% 
		String tempCbirth = request.getParameter("tempCbirth");
		if(!tempCbirth.equals("")) {
			dto.setCbirth(Date.valueOf(tempCbirth));
		}
		CustomerDto customer = (CustomerDto)session.getAttribute("customer");
		String sessionPw = null;
		if(customer!=null) {
			sessionPw = customer.getCpw();
		}
		String oldCpw = request.getParameter("oldCpw");
		if(sessionPw.equals(oldCpw)) {
			if(dto.getCpw() == null) {
				dto.setCpw(oldCpw);
			}
			CustomerDao cDao = CustomerDao.getInstanse();
			int result = cDao.modify(dto);
			if(result == CustomerDao.SUCCESS) {
				session.setAttribute("member", dto);
				out.print("<script>"
						+ "alert('정보수정이 완료되었습니다.');"	
						+ "location.href='../main/main.jsp'"
						+ "</script>"
							);
			}else {
				out.print("<script>"
						+ "alert('글자수 제한으로 정보수정이 실패했습니다.');"	
						+ "</script>"
							);
			}
			} else {
				out.print("<script>"
								+ "alert('기존비밀번호를 잘못 입력했습니다.');"
								+ "history.back();"
								+ "</script>"
									);
		}
	%>
</body>
</html>