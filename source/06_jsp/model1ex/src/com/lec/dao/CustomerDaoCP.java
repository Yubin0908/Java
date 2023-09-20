package com.lec.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.dto.CustomerDto;

public class CustomerDaoCP {
	public static final int CUSTOMER_EXISTENT = 0;
	public static final int CUSTOMER_NOTEXISTENT = 1;
	public static final int LOGIN_SUCCESS = 1;
	public static final int LOGIN_FAIL_PW = 0;
	public static final int LOGIN_FAIL_ID = -1;
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:cpmp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	// 1. 회원가입 ID 중복체크기능
	public int confirmID(String cid) {
		int result = CUSTOMER_EXISTENT;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT CPW FROM CUSTOMER WHERE CID=?";
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, cid);
			rs = ps.executeQuery();
			if(rs.next()) {
				result = CUSTOMER_EXISTENT;
			} else {
				result = CUSTOMER_NOTEXISTENT;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	// 2. 회원가입 처리
	public int joinCustomer(CustomerDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CBIRTH, CGENDER)" + 
				"  VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getCid());
			ps.setString(2, dto.getCpw());
			ps.setString(3, dto.getCname());
			ps.setString(4, dto.getCtel());
			ps.setString(5, dto.getCemail());
			ps.setString(6, dto.getCaddress());
			ps.setDate(7, dto.getCbirth());
			ps.setString(8, dto.getCgender());
			result = ps.executeUpdate();
			System.out.println(result==SUCCESS?"회원가입성공":"회원가입실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("회원가입실패 : " + dto);
		} finally {
			try {
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	// 3. 로그인 id/pw체크
	public int logincheck(String cid, String cpw) {
		int result = LOGIN_FAIL_PW;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT CPW FROM CUSTOMER WHERE CID=?";
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, cid);
			rs = ps.executeQuery();
			if(rs.next()) {
				String dbPw = rs.getString("pw");
				if(dbPw.equals("pw")) {
					return LOGIN_SUCCESS;
				} else {
					return LOGIN_FAIL_PW;
				}
			} else {
				return LOGIN_FAIL_ID;
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
		return result;
	}
	// 4. session에 dto 데이터 추가 
	public CustomerDto getCustomer(String cid) {
		CustomerDto dto = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT CPW FROM CUSTOMER WHERE CID=?";
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, cid);
			rs = ps.executeQuery();
			if(rs.next()) {
				String cpw = rs.getString("cpw");
				String cname = rs.getString("cname");
				String ctel = rs.getString("ctel");
				String cemail = rs.getString("cemail");
				String caddress = rs.getString("caddress");
				Date cbirth = rs.getDate("cbirth");
				String cgender = rs.getNString("cgender");
				dto = new CustomerDto(cid, cpw, cname, ctel, cemail, caddress, cbirth, cgender);
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
		return dto;
	}
	public int modifyCustomer(CustomerDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "UPDATE CUSTOMER SET CPW=?, CNAME=?,CTEL=?,CEMAIL=?,CADDRESS=?,CBIRTH=?,CGENDER=? WHERE CID=?";
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getCpw());
			ps.setString(2, dto.getCname());
			ps.setString(3, dto.getCtel());
			ps.setString(4, dto.getCemail());
			ps.setString(5, dto.getCaddress());
			ps.setDate(6, dto.getCbirth());
			ps.setString(7, dto.getCgender());
			ps.setString(8, dto.getCid());
			result = ps.executeUpdate();
			System.out.println(result==SUCCESS ? "수정성공":"수정실패"+dto);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("회원정보 수정실패 : " + dto);
		} finally {
			try {
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
}
