package com.lec.friend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class FriendDao {
	public static final int FRIEND_INPUT_PASS = 1;
	public static final int FRIEND_INPUT_FAIL = 0;
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	// 1. INSERT
	public int input(String name, String tel) {
	    int result = FRIEND_INPUT_FAIL;
	    String sql = "INSERT INTO FRIEND (NO, NAME, TEL) VALUES (FRIEND_NO_SEQ.NEXTVAL, ?, ?)";
	    Connection conn = null;
	    PreparedStatement ps = null;
	    try {
	        conn = getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, name);
	        ps.setString(2, tel);
 
	        int insert = ps.executeUpdate();
	        if (insert > 0) {
	            result = FRIEND_INPUT_PASS;
	        }
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    } finally {
	        try {
	            if (ps != null) ps.close();
	            if (conn != null) conn.close();
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	    }
	    return result;
	}
	// 2. OUTPUT
	public ArrayList<FriendDto> getList() {
		String sql = "SELECT * FROM FRIEND ORDER BY NO";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<FriendDto> list = new ArrayList<FriendDto>();
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				FriendDto dto = new FriendDto();
				dto.setNo(rs.getInt("no"));
				dto.setName(rs.getString("name"));
				dto.setTel(rs.getString("tel"));
				list.add(dto);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return list;
	}
}
