package com.lec.ex1selectAll;

import java.sql.*;


public class SelectAllMysql {
	public static void main(String[] args) {
		
		String driver = "com.mysql.cj.jdbc.Driver"; // driver loading 8.0.x version
		String url = "jdbc:mysql://localhost:3306/yubin?serverTimezone=UTC"; // 8.0.x version
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM PERSONAL";
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "root", "sqlserver");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql); 
			
			System.out.println("사번\t이름\t직책\t\t상사사번\t입사일\t\t급여\t상여\t부서번호");
			while(rs.next()) {
				
				int pno = rs.getInt("pno");
				String pname = rs.getString("pname");
				String job = rs.getString("job");
				String manager = rs.getString("manager");
				Date startdate = rs.getDate("startdate");
				Timestamp startdate1 = rs.getTimestamp("startdate");
				int pay	= rs.getInt("pay");
				int bonus = rs.getInt("bonus");
				int dno = rs.getInt("dno");
			
				if (job.length() >= 8) {
				System.out.printf("%d\t%s\t%s\t%s\t%TF\t%d\t%d\t%d\n",
									pno, pname, job, manager, startdate, pay, bonus, dno);
				} else {
					System.out.printf("%d\t%s\t%s\t\t%s\t%TF\t%d\t%d\t%d\n",
							pno, pname, job, manager, startdate, pay, bonus, dno);
				}
			}
			
		} catch (ClassNotFoundException e) {
			
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
				
			}catch (SQLException e) {
				
				System.out.println(e.getMessage());
			}
			
			
		}
		
		
	}

}
