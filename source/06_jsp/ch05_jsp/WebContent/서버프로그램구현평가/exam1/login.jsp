<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인 화면</title>
	<style>
		body { background-color: lightyellow; }
		td{text-align: center; padding:2px 5px;}
		#msg {color:red; text-align: center;}
	</style>
</head>
<body>

	<table>
		<form action="loginPro.jsp" method="post">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="password" name="pw"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="로그인"></td>
			</tr>
		</form>
	</table>
	<%
		String msg = request.getParameter("msg");
		if(msg!=null){
			out.println(msg);
		}
	%>

</body>
</html>