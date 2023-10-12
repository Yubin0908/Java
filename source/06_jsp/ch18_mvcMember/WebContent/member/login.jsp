<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<c:if test="${not empty joinMsg }">
		<script>
			alert('${joinMsg}');
		</script>
	</c:if>
	<c:if test="${not empty joinErrMsg }">
		<script>
			alert('${joinErrMsg}');
			history.back();
		</script>
	</c:if>
	<form action="${conPath }/login.do" method="post">
	 	<input type="hidden" name="next" value="${param.next }" /> <!-- modify.do => modify.jsp(로그인 안한경우, loginView.do?next=modifyView.do -->
	 	<p>
	 		ID <input type="text" name="mid" required value="${mid }"/>
	 	</p>
	 	<p>
	 		PW <input type="password" name="mpw" required value="${mpw }"/>
	 	</p>
	 	<p>
	 		<input type="submit" value="로그인"/>
	 		<input type="button" value="회원가입" onclick="location.href='${conPath}/joinView.do'"/>
	 	</p>
	</form>
</body>
</html>