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
	<%
		String deptnoStr = request.getParameter("deptno");
		if(deptnoStr==null) {
			deptnoStr = "0";
		}
		int deptnoInt = Integer.parseInt(deptnoStr);
		String param = request.getParameter("param");
		if(param==null) {
			param = "";
		}
	%>
	<form action="">
		<p style="text-align:center;">
			부서번호
			<select name="deptno">
				<option value="0"></option>
				<option value="10"
				<%
				if(deptnoInt==10) {
					out.print("selected");
				}
				%>
				>10-ACCOUNTING-NEW YORK</option>
				<option value="20"
				<%
				if(deptnoInt==20) {
					out.print("selected");
				}
				%>
				>20-RESEARCH-DALLAS</option>
				<option value="30"
				<%
				if(deptnoInt==30) {
					out.print("selected");
				}
				%>
				>30-SALES-CHICAGO</option>
				<option value="40"
				<%
				if(deptnoInt==40) {
					out.print("selected");
				}
				%>
				>40-OPERATIONS-BOSTON</option>
			</select>
			<input type="text" name="param" class="btn" value="<%=param.trim().toUpperCase()%>">
			<input type="submit" value="검색" class="btn">
		</p>
	</form>
</body>
</html>