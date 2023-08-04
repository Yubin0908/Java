package com.lec.ex4Update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 사용자로부터 수정할 부서번호와 부서명, 근무지를 입력받아 update
public class UpdateDept {
	public static void main(String[] args) {

		String driver = "oracle.jdbc.driver.OracleDriver"; // driver loading
		String url = "jdbc:oracle:thin:@localhost:1521:xe";

		Connection conn = null;
		Statement stmt = null;
		Scanner users = new Scanner(System.in);

		System.out.print("수정할 부서번호를 입력하세요 : ");
		int deptno = users.nextInt();

		System.out.print("수정할 부서명을 입력하세요 : ");
		String dname = users.next();

		System.out.print("수정할 근무지를 입력하세요 : ");
		String loc = users.next();

		String sql = String.format("UPDATE DEPT SET DNAME='%s', LOC='%s' WHERE DEPTNO='%d'", dname, loc, deptno);

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tigar");
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);

			System.out.println(result > 0 ? deptno + "번 부서 수정성공" : deptno + "번 부서가 없어 수정실패");

		} catch (Exception e) {

			System.out.println(e.getMessage());
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();

			} catch (SQLException e) {

				System.out.println(e.getMessage());
			}

		}

	}
}
