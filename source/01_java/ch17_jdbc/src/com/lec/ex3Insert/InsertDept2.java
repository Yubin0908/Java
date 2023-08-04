package com.lec.ex3Insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

// 사용자로부터 부서번호를 입력받아 중복체크 후, 부서명, 근무지를 입력받아 dept 테이블에 인서트
public class InsertDept2 {
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

			System.out.print("입력할 부서번호를 입력하세요(숫자2자리 이내) : ");
			int deptno = users.nextInt();
			// 부서번호 중복체크
			String selectSQL = "SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO=" + deptno;

			rs = stmt.executeQuery(selectSQL);
			rs.next();
			int cnt = rs.getInt("cnt");
			if (cnt == 1) {

				System.out.println("중복된 부서번호는 입력이 불가합니다.");
			} else {

				System.out.print("입력할 부서이름을 입력하세요 : ");
				String dname = users.next();
				System.out.print("입력할 부서위지를 입력하세요 : ");
				String loc = users.next();
				String sql = String.format("INSERT INTO DEPT VALUES ('%d', '%s', '%s')", deptno, dname, loc);

				int result = stmt.executeUpdate(sql);

				System.out.println(result > 0 ? "입력성공" : "입력실패");
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

			} catch (Exception e) {

				System.out.println(e.getMessage());
			}

		}
	}
}
