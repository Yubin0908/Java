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
		String bid = request.getParameter("bid");
		if(bid == null) {
			response.sendRedirect(conPath + "/board/list.jsp");
		}
	%>
	<form action="deletePro.jsp" method="post">
		<table>
			<caption><%=bid %>번 글 삭제</caption> 
			<tr>
				<td>
					<fieldset>
						<legend>삭제를 위한 암호</legend>
							<input type="hidden" name="bid" value="<%=bid %>">
							<p>암호 <input type="password" name="bpw" required autofocus class="btn"></p>
							<input type="submit" value="삭제" class="btn">
							<input type="button" value="취소" class="btn" onclick="history.back()">
					</fieldset>
		</table>	
	</form>	
</body>
</html>