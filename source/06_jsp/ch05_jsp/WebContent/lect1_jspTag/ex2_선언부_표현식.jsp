<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>선언부_표현식</title>
</head>
<body>
	<!-- HTML 주석 -->
	<%--JSP 주석 --%>
	<% 
		// 스크립트릿내에서는 자바 주석 사용
		int j=0; // 스크립트릿에서 변수만 선언하면 초기화가 안됨.
		String localStr = "몰라요";
		i++; j++;
		globalStr += "<span>★</span>";
		localStr += "<span>@</span>";
		out.println("전역변수 i : " + i + "<br>"
							 +"전역변수 globalStr : " + globalStr + "<br>"
							 +"지역변수 j : " + j + "<br>"
							 +"지역변수 localStr : " + localStr + "<br>");
	%>

	<%! // 선언부 // 선언부가 맨처음 실행
		int i; // 선언부에서 변수만 선언하면 자동 초기화됨.
		String globalStr = "Good";
	%>
	
</body>
</html>