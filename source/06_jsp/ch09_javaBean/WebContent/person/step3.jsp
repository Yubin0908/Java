<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Java Bean - step3</title>
</head>
<body>
	<!-- Process Group -->
	<jsp:useBean id="p" class="com.lec.ex.Person" scope="request"/>
	<jsp:setProperty property="name" name="p" value='<%=request.getParameter("name") %>'/>
	<jsp:setProperty property="age" name="p" value='<%=Integer.parseInt(request.getParameter("age")) %>'/>
	<jsp:setProperty property="gender" name="p" value='<%=request.getParameter("gender").charAt(0) %>'/>
	<jsp:setProperty property="address" name="p" value='<%=request.getParameter("address") %>'/>
	<jsp:forward page="personview.jsp"/>
</body>
</html>