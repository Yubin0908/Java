package com.lec.ex4Update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 수정할 부서번호를 받아 존재여부를 확인 후, 부서명, 근무지를 입력받아 update
public class Updatedept2 {
	public static void main(String[] args) {

		String driver = "oracle.jdbc.driver.OracleDriver"; // driver loading
		String url = "jdbc:oracle:thin:@localhost:1521:xe";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner users = new Scanner(System.in);

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tigar");
			stmt = conn.createStatement();

			System.out.print("수정할 부서번호 입력 :");
			int deptno = users.nextInt();
			String selectSQL = "SELECT * FROM DEPT WHERE DEPTNO="+deptno;

			rs = stmt.executeQuery(selectSQL);
			if (rs.next()) { // 있을경우, 수정진행

				System.out.print("수정할 부서명 입력 : ");
				String dname = users.next();
				System.out.print("수정할 근무지 입력 : ");
				String loc = users.next();

				String updateSQL = String.format("UPDATE DEPT SET DNAME='%s', LOC='%s' WHERE DEPTNO='%d'", dname, loc,
						deptno);

				int result = stmt.executeUpdate(updateSQL);
				if (result > 0) {

					System.out.println(deptno + " 번 부서 수정 성공");

				}
			} else { // 없을경우,

				System.out.println(deptno + "번 부서는 유효한 부서번호가 아님");

			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
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
