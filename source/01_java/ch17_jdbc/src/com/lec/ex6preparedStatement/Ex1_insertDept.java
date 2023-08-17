package com.lec.ex6preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

// 부서번호, 부서명, 위치, 입력받아 insert
public class Ex1_insertDept {
	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver"; // driver loading
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		Scanner users = new Scanner(System.in);
		
		String sql = "INSERT INTO DEPT VALUES (?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		System.out.print("추가할 부서번호 입력 : ");
		int deptno = users.nextInt();
		
		System.out.print("추가할 부서명 입력 : ");
		String dname = users.next();
		
		System.out.println("추가할 근무지 입력 : ");
		String loc = users.next();
		
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tigar");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);
			
			int result = pstmt.executeUpdate();
			
			System.out.println(result > 0 ? deptno+"번 입력성공" : deptno+"번 입력실패");
			
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
				
			}catch (SQLException e) {
				
				System.out.println(e.getMessage());
				
			}
			
		}
		
		
		
		
	}
}
