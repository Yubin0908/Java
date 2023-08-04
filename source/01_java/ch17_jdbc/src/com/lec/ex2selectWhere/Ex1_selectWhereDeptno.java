package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 사용자에게 원하는 부서번호를 입력받아 해당 부서 정보 출력
public class Ex1_selectWhereDeptno {
	public static void main(String[] args) {

		String driver = "oracle.jdbc.driver.OracleDriver"; // driver loading
		String url = "jdbc:oracle:thin:@localhost:1521:xe";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);

		System.out.print("조회할 부서번호 : ");
		int deptno = sc.nextInt();
		String sql = "SELECT * FROM DEPT WHERE DEPTNO=" + deptno;

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tigar");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql); // 1행이나 0행 결과

			if (rs.next()) {

				String dname = rs.getString("dname");
				String loc = rs.getString("loc");

				System.out.println(deptno + "번 부서정보는 다음과 같습니다.");
				System.out.println("부서명 : " + dname);
				System.out.println("부서위치 : " + loc);

			} else {

				System.out.println("해당부서번호는 존재하지 않음");
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
