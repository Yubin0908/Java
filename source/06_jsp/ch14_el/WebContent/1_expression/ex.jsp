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
	<h2>표현식 태그 사용</h2>
	<p>산술 연산자 : 10 + 1 = <%=10 + 1 %></p>
	<p>산술 연산자 : 10 / 0.0 = <%=10 / 0.0 %></p> <!-- 0으로 나누면 에러발생, 0.0으로 나누면 0에 가까운 수로 나누어짐(infinity) -->
	<p>관계 연산자 : 1 > 2 = <%=1 > 2 %></p>
	<p>관계 연산자 : 1 == 2 = <%=1 == 2 %></p>
	<p>관계 연산자 : 1 != 2 = <%=1 != 2 %></p>
	<p>조건 연산자 : <%=(1 > 2) ? "1이 더 크다.":"1이 크지 않다." %></p>
	<p>로그인 여부 : <%=session.getAttribute("customer") == null ? "로그인 안함":"로그인 함" %></p>
	<p>로그인 여부 : <%=session.getAttribute("customer") != null ? "로그인 함":"로그인 안함" %></p>
	<p>pageNum 파라미터 여부 : <%=request.getParameter("pageNum") == null ? "pageNum 없음":"pageNum 있음" %></p>
	<p>name 파라미터 값 : <%=request.getParameter("name") %></p>
	<%-- <p>name 파라미터의 대문자 변경 : <%=request.getParameter("name").toUpperCase() %></p> --%>
	
	<h2>EL 표기법 사용(표현식 안에 쓸 수 있는 모든 연산자는 모두 사용 가능)</h2>
	<p>산술 연산자 : 10 + 1 = ${10+1}</p>
	<p>산술 연산자 : 10 / 0.0 = ${10 / 0.0}</p> <!-- 0으로 나누면 에러발생, 0.0으로 나누면 0에 가까운 수로 나누어짐(infinity) -->
	<p>관계 연산자 : 1>2 = ${1 > 2 }</p>
	<p>관계 연산자 : 1 eq 2 = ${1 eq 2 }</p>
	<p>관계 연산자 : 1 != 2 = ${1 != 2 }</p>
	<p>조건 연산자 : ${(1 > 2) ? "1이 더 크다.":"1이 크지 않다."}</p>
	<p>로그인 여부 : ${customer eq null ? "로그인 안함":"로그인 함"}</p>
	<p>로그인 여부 : ${empty customer ? "로그인 안함":"로그인 함"}</p>
	<p>로그인 여부 : ${not empty customer ? "로그인 함":"로그인 안함"}</p>
	<p>pageNum 파라미터 여부 : ${empty param.pageNum ? "pageNum 없음":"pageNum 있음"}</p> <!-- param = 내장객체 -->
	<p>name 파라미터 값 : ${param.name}</p> <!-- EL표기법에서 값이 없을땐 "", 빈스트링으로 처리됨. -->
	<p>name 파라미터의 대문자 변경 : ${param.name.toUpperCase()}</p>
</body>
</html>