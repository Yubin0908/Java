<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
	<style>
		#content {width: 800px; height:350px;margin: 50px auto; }
		img{width: 100px;}
		a {text-decoration: none; color:black;}
		b {color:red;}
		searchBox {text-align: center;}
	</style>
	
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<script>
		$(document).ready(function(){
			
		});
	</script>
</head>
<body>
	<c:set var="SUCCESS" value="1"/>
	<c:if test="${registerResult == SUCCESS }">
		<script>
			alert('책등록 완료');
		</script>
	</c:if>
	<jsp:include page="../main/header.jsp"/>
	<div id="content">
		<div class="searchBox">
			<form action="">
				<select name="option">
					<option value="" <c:if test="${param.option eq ''}">selected</c:if>>검색조건</option>
					<option value="all" <c:if test="${param.option eq 'all'}">selected</c:if>>책이름 + 저자</option>
					<option value="book" <c:if test="${param.option eq 'book'}">selected</c:if>>책이름</option>
					<option value="people" <c:if test="${param.option eq 'people'}">selected</c:if>>저자</option>
				</select>
				<input type="search" name="searchText" value="${param.searchText }">
				<input type="submit" value="검 색" />
			</form>
		</div>
		<table>
			<caption>도서 LIST</caption>
			<tr>
				<c:forEach var="book" items="${bookList }">
					<td onclick="location.href='${conPath }/book/detail.do?bnum=${book.bnum}&pageNum=${paging.currentPage}&option=${param.option }&searchText=${param.searchText }'">
							${book.btitle }<br>
							<img src="${conPath }/bookImgFileUpload/${book.bimg1}"><br>
							${book.bwriter } 著 <br>
							출판일 : ${book.brdate }
					</td>
				</c:forEach>
			</tr>
		</table><br>
		<div>
			<c:if test="${paging.startPage>paging.blockSize}">
				[ <a href="${conPath }/book/list.do?pageNum=${paging.startPage-1 }&option=${param.option}&searchText=${searchText}">이전</a> ]
			</c:if>	
			<c:forEach var="i" begin="${paging.startPage}" end="${paging.endPage }">
				<c:if test="${paging.currentPage==i }"> 
					<b>[ ${i } ]</b> 
				</c:if>
				<c:if test="${paging.currentPage != i }">
					[ <a href="${conPath }/book/list.do?pageNum=${i }&option=${param.option}&searchText=${searchText}">${i }</a> ]
				</c:if>
			</c:forEach>
			<c:if test="${paging.endPage<paging.pageCnt }">
				[ <a href="${conPath }/book/list.do?pageNum=${paging.endPage+1 }&option=${param.option}&searchText=${searchText}">다음</a> ]
			</c:if>
		</div>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>