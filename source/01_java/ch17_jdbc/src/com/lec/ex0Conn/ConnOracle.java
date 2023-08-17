package com.lec.ex0Conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnOracle {

	public static void main(String[] args) {

		String driver = "oracle.jdbc.driver.OracleDriver"; // driver loading
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = null;
		try {
			Class.forName(driver);
			System.out.println("1. 드라이버 로드 성공");

			conn = DriverManager.getConnection(url, "scott", "tigar"); // DB 연결객체
			System.out.println("2. Oracle 연결 성공");
		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage() + "driver Fail");
		} catch (SQLException e) {

			System.out.println(e.getMessage() + "Login Fail");
		} finally {
			try {
				if (conn != null)
					conn.close(); // DB 연결해제

			} catch (SQLException e) {

				System.out.println(e.getMessage());
			}
		}

	}
}
