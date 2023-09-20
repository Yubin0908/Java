<%@page import="com.lec.member.MemberDaoCP"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="dto" class="com.lec.member.MemberDto" scope="page"/>
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
		String tempBirth = request.getParameter("tempBirth");
		if(!tempBirth.equals("")) {
			dto.setBirth(Date.valueOf(tempBirth));
			// birth가 timestamp형이면 Timestamp.valueOf(tempBirth + "00:00:00")
		}
		MemberDaoCP mDao = new MemberDaoCP();
		int result = mDao.confirmID(dto.getId()); // ID 중복체크
		if(result == MemberDaoCP.MEMBER_NONEXISTENT) {
			// 회원가입가능 -> session ID추가 -> login페이지
			result = mDao.joinMember(dto); // 회원가입
			if(result == MemberDaoCP.SUCCESS) { // 가입성공
				session.setAttribute("id", dto.getId()); 
	%>
			<script>
				alert('<%=dto.getName()%>님 회원가입 감사합니다.');
				location.href='login.jsp';
			</script>
	<% 	} else { %>
			<script>
				alert('회원가입이 실패했습니다. 길이제한이 있습니다.')
				history.go(-1);
			</script>
	<%
			}
		} else {
	%>
			// 회원가입불가 -> 이전페이지로 이동
	
		<script>
			alert('중복된 아이디입니다. 다른 아이디를 사용하세요.');
			history.back();
		</script>
	<%
		}
	%>
</body>
</html>