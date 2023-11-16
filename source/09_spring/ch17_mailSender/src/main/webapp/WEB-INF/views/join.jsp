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
  <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>
<body>
  <form action="textMail.do">
  	<p>이름 <input type="text" name="name" required /></p>
  	<p>메일 <input type="email" name="email" required /></p>
  	<input type="submit" value="회원가입(text 단순메일)" />
  </form>
  <hr />
  <form action="htmlMail.do">
  	<p>이름 <input type="text" name="name" required /></p>
  	<p>메일 <input type="email" name="email" required /></p>
  	<input type="submit" value="회원가입(html 메일)" />
  </form>
</body>
</html>