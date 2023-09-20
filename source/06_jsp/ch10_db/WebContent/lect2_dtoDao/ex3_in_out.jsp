<%@page import="com.lec.dao.EmpDao"%>
<%@page import="com.lec.dto.EmpDto"%>
<%@page import="com.lec.dto.DeptDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.DeptDao"%>
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
	<form>
		<p style="text-align: center;">
			부서번호
			<select name="deptno">
				<option value="0">전체 출력</option>
				<%
					String deptnoStr = request.getParameter("deptno");
					if(deptnoStr==null){
						deptnoStr = "0";
					}
					int deptnoInt = Integer.parseInt(deptnoStr); // Str => Int Convert
					DeptDao dDao = DeptDao.getInstance();
					ArrayList<DeptDto> depts = dDao.detpList();
					for(DeptDto dept : depts) {
						// <option value='10'>10-ACCOUNTING-NEW YORK</option>
						int deptno = dept.getDeptno();
						String dname = dept.getDname();
						String loc = dept.getLoc();
						
						if(deptnoInt == deptno) {
							out.println("<option value='"+deptno+"' selected>"+deptno+"-"+dname+"-"+loc+"</option>");
						} else {
							out.println("<option value='"+deptno+"'>"+deptno+"-"+dname+"-"+loc+"</option>");
						}
					}
					
				%>
			</select>
			<input type="submit" value="검색" class="btn">
		</p>
	</form>
	<table>
		<tr><th>사번</th><th>이름</th><th>직책</th><th>입사일</th><th>급여</th><th>부서명</th>
		<%
			EmpDao eDao = EmpDao.getInstance();
			ArrayList<EmpDto> emps = eDao.dnameEmpList(deptnoInt);
			
			if(!emps.isEmpty()) {
				for(EmpDto emp : emps) {
					out.print(
								"<tr><td>"+emp.getEmpno()+"</td>"
							+ "<td>"+emp.getEname()+"</td>"
							+ "<td>"+emp.getJob()+"</td>"
							+ "<td>"+emp.getHiredate()+"</td>"
							+ "<td>"+emp.getSal()+"</td>"
							+ "<td>"+emp.getDname()+"</td>"
							);
				}
				out.print("<tr><td colspan='6'>총 : " + emps.size() + "명</td></tr>");
			} else {
				out.print("<tr><td colspan='6'>사원이 존재하지 않음</td></tr>");
			}
		%>
	</table>
</body>
</html>