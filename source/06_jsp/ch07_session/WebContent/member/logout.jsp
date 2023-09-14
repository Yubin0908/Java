<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/main.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../member/header.jsp"></jsp:include>
	<% 
		session.invalidate();
	%>
	<div id="mainForm_wrap">
		로그아웃되었습니다. 잠시후 페이지 이동이 있겠습니다.
	</div>
	<script>
		setTimeout(location.href="<%=conPath%>/member/main.jsp", 3000);
	</script>
	<jsp:include page="../member/footer.jsp"/>
</body>
</html>