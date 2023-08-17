package com.lec.ex0Conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnMySql {

	public static void main(String[] args) {

		String driver = "com.mysql.cj.jdbc.Driver"; // driver loading 8.0.x version
		String url = "jdbc:mysql://localhost:3306/yubin?serverTimezone=UTC"; // 8.0.x version
		Connection conn = null;
		try {
			Class.forName(driver);
			System.out.println("1. 드라이버 로드 성공");

			conn = DriverManager.getConnection(url, "s", "sqlserver"); // DB 연결객체
			System.out.println("2. MySql 연결 성공");
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
