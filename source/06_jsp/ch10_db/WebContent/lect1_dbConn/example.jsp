<%@page import="java.sql.Date"%>
<%@page import="oracle.net.aso.l"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="javax.naming.directory.SearchControls"%>
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
		String search = "";
		int cnt;
	%>
	<form action="">
		<table>
			<% String searchStr = request.getParameter("search");
			   if (searchStr == null) {
			       searchStr = "";
			   } else {
			       searchStr = searchStr.trim().toUpperCase();
			   }
			%>
			<p style="text-align: center;">
				사원명 
				<input type="text" name="search" class="btn" value="<%=searchStr%>">
				<input type="submit" value="검색" style="width:100px;">
				<tr><th>No.</th><th>사번</th><th>이름</th><th>직책</th><th>상사사번</th><th>입사일</th><th>급여</th><th>부서번호</th><th>부서명</th></tr>

				<% if (searchStr != null && searchStr.equals("")) {
					sql = "SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, E.DEPTNO DEPTNO, DNAME "
		 					+	"FROM EMP E, DEPT D "
			 				+ "WHERE E.DEPTNO=D.DEPTNO";
					Class.forName(driver);
					conn = DriverManager.getConnection(url, "scott", "tigar");
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					
					try {
						while(rs.next()) {
							++cnt;
							int empno = rs.getInt("empno");
							String ename = rs.getString("ename");
							String job = rs.getString("job");
							int mgr = rs.getInt("mgr");
							Date hiredate = rs.getDate("hiredate");
							int sal = rs.getInt("sal");
							int deptno = rs.getInt("deptno");
							String dname = rs.getString("dname");
							
							if(rs!=null) {
								out.println("<tr><td>"+cnt+"</td><td>"+empno+"</td><td>"+ename+"</td><td>"+job+"</td><td>"+mgr+"</td><td>"+hiredate+"</td><td>"+sal+"</td><td>"+deptno+"</td><td>"+dname+"</td></tr>");
							} else {
								out.println("<tr><td colspan='8'>사원이 존재하지 않습니다.'</td></tr>");
							}
						}
						cnt = 0;
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
				} else {
				%>
					</form>
						<%
							sql = "SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, E.DEPTNO DEPTNO, DNAME "
									+ "FROM EMP E, DEPT D "
									+	"WHERE E.DEPTNO=D.DEPTNO AND ENAME LIKE '%'||?||'%'";
							try {	
								Class.forName(driver);
								conn = DriverManager.getConnection(url, "scott", "tigar");
								pstmt = conn.prepareStatement(sql);
								pstmt.setString(1, searchStr);
								rs = pstmt.executeQuery();
								
								if(rs.next()) {
									do {
										++cnt;
										int empno = rs.getInt("empno");
										String ename = rs.getString("ename");
										String job = rs.getString("job");
										int mgr = rs.getInt("mgr");
										Date hiredate = rs.getDate("hiredate");
										int sal = rs.getInt("sal");
										int deptno = rs.getInt("deptno");
										String dname = rs.getString("dname");
										
										out.println("<tr><td>"+cnt+"</td><td>"+empno+"</td><td>"+ename+"</td><td>"+job+"</td><td>"+mgr+"</td><td>"+hiredate+"</td><td>"+sal+"</td><td>"+deptno+"</td><td>"+dname+"</td></tr>");
									} while(rs.next());
								cnt = 0;
								} else {
									out.println("<tr><td colspan='8'>사원이 존재하지 않습니다.'</td></tr>");
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
				<%
				}
				%>
		</table>
</body>
</html>