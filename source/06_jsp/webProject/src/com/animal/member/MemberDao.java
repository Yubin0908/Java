package com.animal.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class MemberDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	// 서버 기초 베이스
	public MemberDao() {
		try {
			String dbUrl = "jdbc:mysql://localhost:3306/ANIMAL";
			String dbId = "root";
			String dbPw = "sqlserver";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
	}
	
	// 로그인 기능
	public int login(String id, String pw) {
		String sql = "SELECT PW FROM MEMBER WHERE ID=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString(1).equals(pw)) {
					return 1; // login 성공
				} else {
					return 0; // login 실패
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return -2; // DB Connecting Fail
	}
}
