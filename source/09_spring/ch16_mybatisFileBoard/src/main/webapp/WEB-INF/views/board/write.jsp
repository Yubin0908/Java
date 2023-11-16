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
	<form action="${conPath }/write.do" method="post" enctype="multipart/form-data">
		<table>
			<caption>글쓰기</caption>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="bname" required autofocus /></td>
			</tr>
			<tr>
				<th>글제목</th>
				<td><input type="text" name="btitle" required /></td>
			</tr>
			<tr>
				<th>본문</th>
				<td>
					<textarea name="bcontent" rows="5" style="resize: none;"></textarea>
				</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td><input type="file" name="bimg"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="글쓰기" class="btn"/>
					<input type="reset" value="초기화" class="btn"/>
					<input type="button" value="목록" class="btn" onclick="history.back()" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>