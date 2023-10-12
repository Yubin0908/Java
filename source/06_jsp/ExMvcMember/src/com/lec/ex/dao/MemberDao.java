package com.lec.ex.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.lec.ex.dto.MemberDto;

public class MemberDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	public static final int EXESITENT = 1;
	public static final int NOTEXESITENT = 0;
	private DataSource ds;
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	
	private static MemberDao instance = new MemberDao();
	public static MemberDao getInstance() {
		return instance;
	}
	
	private MemberDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
//	-- 1. ID Confirm
	public int id_check(String mid) throws SQLException {
		int result = EXESITENT;
		conn = null; ps = null; rs = null;
		String sql = "SELECT * FROM MVC_MEMBER WHERE MID = ? ";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			if(rs.next()) {
				result = EXESITENT;
			} else {
				result = NOTEXESITENT;
			}
		} finally {
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}
		
		return result;
	}
//	-- 2. Join
	public int joinMember(MemberDto mDto) throws SQLException {
		int result = FAIL;
		conn = null; ps = null;
		String sql = "INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MBIRTH, MADDRESS) " + 
				"  VALUES (?, ?, ?, ?, ?, ?)";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, mDto.getMid());
			ps.setString(2, mDto.getMpw());
			ps.setString(3, mDto.getMname());
			ps.setString(4, mDto.getMemail());
			ps.setDate(5, mDto.getMbirth());
			ps.setString(6, mDto.getMaddress());
			result = ps.executeUpdate();
		} finally {
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}
		return result;
	}
//	-- 3. Login Check
	public int loginCheck(String mid, String mpw) throws SQLException {
		int result = FAIL;
		conn = null; ps = null; rs = null;
		String sql = "SELECT * FROM MVC_MEMBER WHERE MID = ? AND MPW = ?";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2, mpw);
			rs = ps.executeQuery();
			if(rs.next()) {
				result = SUCCESS;
			}
		} finally {
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}
		
		return result;
	}
//	-- 4. Session Dto init
	public MemberDto getMember(String mid) throws SQLException {
		MemberDto member = null;
		conn = null; ps = null; rs = null;
		String sql = "SELECT * FROM MVC_MEMBER WHERE MID = ?";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			if(rs.next()) {
				String mpw = rs.getString("mpw");
				String mname = rs.getString("mname");
				String memail = rs.getString("memail");
				Date mbirth = rs.getDate("mbirth");
				String maddress = rs.getString("maddress"); 
				Date mrdate = rs.getDate("mrdate");
				member = new MemberDto(mid, mpw, mname, memail, mbirth, maddress, mrdate);
			}
		} finally {
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}
		return member;
	}
}
