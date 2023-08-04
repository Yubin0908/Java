package com.lec.ex6preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

// 입력받은 부서번호를 중복체크 후 부서명, 근무지 insert
public class Ex2_InsertDept2 {
	public static void main(String[] args) {

		String driver = "oracle.jdbc.driver.OracleDriver"; // driver loading
		String url = "jdbc:oracle:thin:@localhost:1521:xe";

		Scanner users = new Scanner(System.in);

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String selectSQL = "SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO=?";
		String insertSQL = "INSERT INTO DEPT VALUES (?, ?, ?)";

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tigar");
			pstmt = conn.prepareStatement(selectSQL);
			System.out.print("입력할 부서번호 입력 : ");
			int deptno = users.nextInt();
			pstmt.setInt(1, deptno);

			rs = pstmt.executeQuery();
			rs.next();
			int cnt = rs.getInt("cnt");

			if (cnt != 0) {

				System.out.println("중복된 번호는 입력이 불가합니다.");

			} else {
				rs.close();
				pstmt.close();
				pstmt = conn.prepareStatement(insertSQL);

				pstmt.setInt(1, deptno);

				System.out.print("입력할 부서명 입력 : ");
				pstmt.setString(2, users.next());
				System.out.print("입력할 근무지 입력 : ");
				pstmt.setString(3, users.next());

				int result = pstmt.executeUpdate();

				System.out.println(result > 0 ? deptno + "번 입력성공" : deptno + "번 입력실패");
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

	}
}
