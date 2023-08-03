package com.lec.ex1selectAll;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectAllOracle {
	public static void main(String[] args) {

		String driver = "oracle.jdbc.driver.OracleDriver"; // driver loading
		String url = "jdbc:oracle:thin:@localhost:1521:xe";

		String sql = "SELECT * FROM EMP";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver); // 1. driver load
			conn = DriverManager.getConnection(url, "scott", "tigar"); // 2. DB connetion
			stmt = conn.createStatement(); // 3. SQL 전송객체
			rs = stmt.executeQuery(sql); // 4. SQL 전송 + 결과 호출
			// 6. 전송 결과에 따른 원하는 로직 수행
			if (rs.next()) { // select문 결과가 1행 이상
				System.out.println("사번\t이름\t직책\t\t상사사번\t입사일\t\t급여\t상여\t부서번호");

				do { // rs가 가르키는 곳의 empno, ename, job, ~~ 을 가져와 출력
					int empno = rs.getInt("empno");
					String ename = rs.getString("ename");
					String job = rs.getString("job");
					String mgr = rs.getString("mgr");
					Date hiredate = rs.getDate("hiredate");
					// Timestemp hiredate = rs.getTimestamp("hiredate"); // 날짜와 시간
					int sal = rs.getInt("sal");
					int comm = rs.getInt("comm");
					int deptno = rs.getInt("deptno");
					if (job.length() >= 8)	{
						System.out.printf("%d\t%s\t%s\t%s\t%TF\t%d\t%d\t%d\n", empno, ename, job, mgr,
								hiredate, sal, comm, deptno);
					} else {
						System.out.printf("%d\t%s\t%s\t\t%s\t%TF\t%d\t%d\t%d\n", empno, ename, job, mgr,
								hiredate, sal, comm, deptno);
					}
				} while (rs.next());

			} else { // select문 결과가 없는 경우
				System.out.println("등록된 사원이 없습니다.");
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

			} catch (Exception e) {

				System.out.println(e.getMessage());
			}

		}

	}
}
