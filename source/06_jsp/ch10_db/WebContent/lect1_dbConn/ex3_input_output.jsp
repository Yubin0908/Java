<%@page import="java.sql.Date"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
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
		<%!
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn;
		PreparedStatement pstmt;
		ResultSet rs;
		String sql = "";
		int cnt;
		%>
		<form action="">
			<p style="text-align: center;">
				부서번호
				<select name="deptno">
					<option value="0"></option>
					<%
						sql = "SELECT * FROM DEPT";
						String deptnoStr = request.getParameter("deptno");
						if(deptnoStr == null) {
							deptnoStr = "0";
						}
						int deptnoInt = Integer.parseInt(deptnoStr);
						try {
							Class.forName(driver);
							conn = DriverManager.getConnection(url, "scott", "tigar");
							pstmt = conn.prepareStatement(sql);
							rs = pstmt.executeQuery();
							
							while(rs.next()) {
								int deptno = rs.getInt("deptno");
								String dname = rs.getString("dname");
								String loc = rs.getString("loc");
								
								if(deptnoInt == deptno) {
									out.println("<option value='"+deptno+"' selected>"+deptno+"-"+dname+"-"+loc+"</option>");
								} else {
									out.println("<option value='"+deptno+"'>"+deptno+"-"+dname+"-"+loc+"</option>");
								}
							}
						} catch(Exception er) {
							System.out.println(er.getMessage());
							
						} finally {
							if(rs!=null) {
								rs.close();
							}
							if(pstmt!=null){
								pstmt.close();
							}
							if(conn!=null){
								conn.close();
							}
						}
					%>
				</select>
				<input type="submit" value="검색" class="btn">
			</p>
		</form>
		<table><!-- empno, ename, job, hiredate, sal, dname -->
			<tr><th>No.</th><th>사번</th><th>이름</th><th>직책</th><th>입사일</th><th>급여</th><th>부서명</th>
			<%
				sql = "SELECT EMPNO, ENAME, JOB, HIREDATE, SAL, DNAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND E.DEPTNO LIKE '%'||"+deptnoInt;
				Class.forName(driver);
				conn = DriverManager.getConnection(url, "scott", "tigar");
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				try {
					if(rs.next()) {
						do{
							++cnt;
							int empno = rs.getInt("empno");
							String ename = rs.getString("ename");
							String job = rs.getString("job");
							Date hiredate = rs.getDate("hiredate");
							int sal = rs.getInt("sal");
							String dname = rs.getString("dname");
							
							out.println("<tr><td>"+cnt+"</td><td>"+empno+"</td><td>"+ename+"</td><td>"+job+"</td><td>"+hiredate+"</td><td>"+sal+"</td><td>"+dname+"</td></tr>");
						} while(rs.next());
						cnt = 0;
					} else {
						out.println("<tr><td colspan='7'>해당부서번호 사원은 없습니다.</td></tr>");
					} 
				} catch(Exception er) {
					System.out.println(er.getMessage());
				} finally {
					if(rs!=null) {
						rs.close();
					}
					if(pstmt!=null){
						pstmt.close();
					}
					if(conn!=null){
						conn.close();
					}
				}
			%>
		</table>
</body>
</html>