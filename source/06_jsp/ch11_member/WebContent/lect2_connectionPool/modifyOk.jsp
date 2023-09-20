<%@page import="com.lec.member.MemberDaoCP"%>
<%@page import="com.lec.member.MemberDto"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String conPath = request.getContextPath(); 
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="dto" class="com.lec.member.MemberDto"/>
<jsp:setProperty property="*" name="dto"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		String tempBirth = request.getParameter("tempBirth");
		if(!tempBirth.equals("")) {
			dto.setBirth(Date.valueOf(tempBirth));
		}
		MemberDto member = (MemberDto)session.getAttribute("member");
		String sessionPw = null;
		if(member!=null) {
			sessionPw = member.getPw();
		}
		String oldPw = request.getParameter("oldPw");
		if(sessionPw.equals(oldPw)) {
			// 기존비밀번호와 동일하게 입력함. 수정진행
			if(dto.getPw() == null) {
				// 새비밀번호를 입력하지 않은 경우
				dto.setPw(oldPw); // 새비밀번호를 현비밀번호로
			}
			MemberDaoCP mDao = MemberDaoCP.getInstance();
			int result = mDao.modifyMember(dto);
			if(result == MemberDaoCP.SUCCESS) {
				// 정보수정 성공
				session.setAttribute("member", dto); // 수정된 정보를 세션속성으로도 변경
				out.print("<script>"
								+ "alert('정보수정이 완료되었습니다.');"	
								+ "location.href='main.jsp'"
								+ "</script>"
									);
			} else {
				out.print("<script>"
								+ "alert('글자수 제한으로 정보수정이 실패했습니다.');"	
								+ "</script>"
									);
			}
		} else {
			// 기존비밀번호와 다르게 입력함. 수정불가
			out.print("<script>"
							+ "alert('기존비밀번호를 잘못 입력했습니다.');"
							+ "history.back();"
							+ "</script>"
								);
		}
	%>
</body>
</html>