<%@page import="com.lec.friend.FriendDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.friend.FriendDao"%>
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
	<form action="friendInputListPro.jsp">
		<table>
			<tr>
				<td>친구이름 <input type="text" name="name"></td>
				<td>전화번호 <input type="text" name="tel"></td>
				<td><input type="submit" value="추가"></td>
			</tr>
			<tr>
				<td colspan="3"><h3>등록된 친구들 리스트</h3></td>
			</tr>

			<tr>
				<th>순번</th>
				<th>이름</th>
				<th>전화</th>
			<td>
			<%
				FriendDao dao = new FriendDao();
				ArrayList<FriendDto> list = dao.getList();
				for(int i=0; i<list.size(); i++) {
			%>
			<tr>
				<td><%=list.get(i).getNo() %></td>
				<td><%=list.get(i).getName() %></td>
				<td><%=list.get(i).getTel() %></td>
			</tr>
			<%	
				}
			%>
		</table>
	</form>
</body>
</html>