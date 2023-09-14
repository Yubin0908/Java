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
		String sql = "SELECT * FROM EMP WHERE DEPTNO LIKE '%'||?";
	%>
	<table>
		<%
			String deptnoStr = request.getParameter("deptno");
			if(deptnoStr == null) {
				deptnoStr = "0";
			}
			int deptnoInput = Integer.parseInt(deptnoStr);
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, "scott", "tigar");
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, deptnoInput);
				rs = pstmt.executeQuery();
				
				out.print("<tr><th>사번</th><th>이름</th><th>직책</th><th>부서번호</th></tr>");
				if(rs.next()) {
					do {
						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						String job = rs.getString("job");
						int deptno = rs.getInt("deptno");
						
						out.println("<tr><td>"+empno+"</td><td>"+ename+"</td><td>"+job+"</td><td>"+deptno+"</td></tr>");
					} while(rs.next());
				} else {
					out.println("<tr><td colspan='4'>해당부서번호 사원은 없습니다.</td></tr>");
				}
			}catch(Exception er) {
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
		넘어온 부서번호는 <%=deptnoInput %>
	</table>
</body>
</html>