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
<!-- requestScope.replyBoard(원글정보), param.bid, param.pageNum -->
	<form action="${conPath }/reply.do" method="post">
		<input type="hidden" name="pageNum" value="${param.pageNum }" />
		<input type="hidden" name="pid" value="${param.bid }" />
		<input type="hidden" name="bgroup"  value="${replyBoard.bgroup }" />
		<input type="hidden" name="bstep"  value="${replyBoard.bstep }" />
		<input type="hidden" name="bindent"  value="${replyBoard.bindent }" />
		<table>
			<caption>${param.bid }번 글에 답변 달기</caption>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="bname" required autofocus /></td>
			</tr>
			<tr>
				<th>글제목</th>
				<td><input type="text" name="btitle" required value="[답]${replyBoard.btitle }" /></td>
			</tr>
			<tr>
				<th>본문</th>
				<td>
					<textarea name="bcontent" rows="5" style="resize: none;"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="답글쓰기" class="btn"/>
					<input type="reset" value="초기화" class="btn"/>
					<input type="button" value="목록" class="btn" onclick="location.href='${conPath}/list.do?pageNum=${param.pageNum }'" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>