package com.lec.ex2selectWhere;
// 사용자로부터 부서명을 입력받아 해당 부서정보를 출력

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Ex3_selectWhereDname {
	public static void main(String[] args) {

		String driver = "oracle.jdbc.driver.OracleDriver"; // driver loading
		String url = "jdbc:oracle:thin:@localhost:1521:xe";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);

		System.out.println("조회할 부서명을 입력 :");
		String dname = sc.next();
		//String sql = "SELECT * FROM DEPT WHERE DNAME=" + "'" + dname + "'";
		String sql = String.format("SELECT * FROM DEPT WHERE DNAME=UPPER('%S')", dname);
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tigar");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {

				int deptno = rs.getInt("deptno");
				String loc = rs.getString("loc");

				System.out.println(dname + ". 부서의 정보는 다음과 같습니다.");
				System.out.println("부서번호 : " + deptno);
				System.out.println("부서명 : " + rs.getString("dname"));
				System.out.println("부서위치 : " + loc);

			} else {

				System.out.println(dname + ". 부서는 존재하지 않습니다.");
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
