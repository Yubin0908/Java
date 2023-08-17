package com.lec.ex5Delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 사용자로부터 삭제하고자하는 부서번호를 입력받아 delete
public class DeleteDept {
	public static void main(String[] args) {

		String driver = "oracle.jdbc.driver.OracleDriver"; // driver loading
		String url = "jdbc:oracle:thin:@localhost:1521:xe";

		Connection conn = null;
		Statement stmt = null;
		Scanner users = new Scanner(System.in);

		System.out.print("삭제할 부서번호 입력 :");
		int deptno = users.nextInt();

		String sql = "DELETE FROM DEPT WHERE DEPTNO=" + deptno;

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tigar");
			stmt = conn.createStatement();

			int result = stmt.executeUpdate(sql);

			if (result > 0) {

				System.out.println(deptno + "번 부서 삭제 성공");
			} else {

				System.out.println(deptno + "번 부서가 존재하지 않아 삭제 실패");

			}

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
