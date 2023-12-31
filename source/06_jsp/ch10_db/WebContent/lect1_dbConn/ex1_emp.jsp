<%@page import="java.sql.Timestamp"%>
<%@page import="oracle.net.aso.l"%>
<%@page import="java.sql.Date"%>
<%@page import="java.sql.Statement"%>
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
	%>
	<table>
		<%
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			String sql = "SELECT * FROM EMP";
			try {
				Class.forName(driver); // 1. Driver Load
				conn = DriverManager.getConnection(url, "scott", "tigar"); // 2. DB Connection
				stmt = conn.createStatement(); // 3. SQL문 전송객체생성
				rs = stmt.executeQuery(sql); // 4. SQL 전송 및 5. SQL 결과 반환
				if(rs.next()) { // 6. 반환된 결과값에 따라 로직 수행
					out.println("<tr><th>사번</th><th>이름</th><th>직책</th><th>상사사번</th><th colspan='3'>입사일</th><th>급여</th><th>상여</th><th>부서번호</th></tr>");
					
					do {
						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						String job = rs.getString("job");
						int mgr = rs.getInt("mgr");
						String hiredate = rs.getString("hiredate");
						Date hiredateD = rs.getDate("hiredate");
						Timestamp hiredateT = rs.getTimestamp("hiredate");
						int sal = rs.getInt("sal");
						int comm = rs.getInt("comm");
						int deptno = rs.getInt("deptno");
						out.println("<tr><td>" + empno + "</td>" +
												"<td>" + ename + "</td>" +
												"<td>" + job + "</td>" +
												"<td>" + mgr + "</td>" +
												"<td>" + hiredate + "</td>" +
												"<td>" + hiredateD + "</td>" +
												"<td>" + hiredateT + "</td>" +
												"<td>" + sal + "</td>" +
												"<td>" + comm + "</td>" +
												"<td>" + deptno + "</td></tr>"
								);
					}while(rs.next());
				} else {
					out.println("<tr><td>입력된 데이터가 없습니다.</td></tr>");
				}
			} catch(Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if(rs!=null) {
						rs.close();
					}
					if(stmt!=null) {
						stmt.close();
					}
					if(conn!=null) {
						conn.close();
					}
				} catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		%>
	</table>
</body>
</html>