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
	<link rel="stylesheet" href="${conPath }/css/emp.css" />
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script>
		$(document).ready(function() {
			$('input[type="text"]').keyup(function() {
				$('form').submit();
			});
			$('select').change(function() {
				$('form').submit();
			});
		});
	</script>
</head>
<body>
	<div id="wrap">
		<div style="border: 1px solid gray">
			<form>
				사원명 : <input type="text" name="ename" size="5" value="${searchEmp.ename }"/>&nbsp;&nbsp;
				직책 : <input type="text" name="job" size="5" value="${searchEmp.job }"/>&nbsp;&nbsp;
				 부서번호 : 
				 <select name="deptno" >
				 	<option value="0">모든부서</option>
				 	<c:forEach items="${deptList }" var="dept">
				 		<option value="${dept.deptno }"
				 			<c:if test="${param.deptno eq dept.deptno }">
				 				selected
				 			</c:if>>
				 		${dept.dname }</option>
				 	</c:forEach>
				 </select>
				<input type="submit" value="검색" />
			</form>
		</div>
		<div>
			<table>
				<tr>
					<th>사원번호</th><th>사원명</th><th>직책</th><th>관리자번호</th><th>입사일자</th><th>급여</th><th>상여</th><th>부서번호</th>
				</tr>
				<c:if test="${empList.size() eq 0 }">
					<tr><td colspan="8" style="font-weight:bold;">해당 사원이 존재하지 않습니다.</td></tr>
				</c:if>
				<c:forEach items="${empList }" var="emp">
					<tr>
						<td>${emp.empno }</td>
						<td>${emp.ename }</td>
						<td>${emp.job }</td>
						<td>${emp.mgr eq 0 ? "":emp.mgr }</td>
						<td>
							<fmt:formatDate value="${emp.hiredate }" pattern="yy년 MM월 dd일(E)"/>
						</td>
						<td>
							<fmt:formatNumber value="${emp.sal }" groupingUsed="true"/>
						</td>
						<td>${emp.comm }</td>
						<td>${emp.deptno }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>