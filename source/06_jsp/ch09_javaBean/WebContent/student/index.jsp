<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet">
	<script>
		
	</script>
</head>
<body>
	<form action="step5.jsp">
		<p>학번 <input type="text" name="studentNum" required="required"></p>
		<p>이름 <input type="text" name="name" required="required"></p>
		<p>학년 <select name="grade">
						<option value="1" selected>1학년</option>
						<option value="2">2학년</option>
						<option value="3">3학년</option>
						<option value="4">4학년</option>
					 </select> 
		</p>
		<p>반 &nbsp; <select name="className">
						<option value="A" selected>A반</option>
						<option value="B">B반</option>
						<option value="C">C반</option>
					 </select>
		</p>
		<p>점수 <input type="number" name="score"></p>
		<p><input type="submit" value="입력"></p>
	</form>
</body>
</html>