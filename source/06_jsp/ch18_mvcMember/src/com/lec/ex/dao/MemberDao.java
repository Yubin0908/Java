package com.lec.ex.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.ex.dto.MemberDto;

public class MemberDao {

	public static final int EXISTENT = 0;
	public static final int NONEXISTENT = 1;
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	
	private DataSource ds;
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public void close(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {
		if(conn!=null) conn.close();
		if(ps!=null) ps.close();
		if(rs!=null) rs.close();
	}
	
	
	private static MemberDao instance = new MemberDao();
	public static MemberDao getInstance() {
		return instance;
	}
	
	private MemberDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}
	

//	-- (1) 회원id 중복체크
	public int midConfirm(String mid) throws SQLException {
		int result = NONEXISTENT;
		conn = null;
		ps = null;
		rs = null;
		String sql = "SELECT * FROM MVC_MEMBER WHERE MID = ?";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			if(rs.next()) {
				result = EXISTENT;
			} else {
				result = NONEXISTENT;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			close(conn, ps, rs);
		}
		
		return result;
	}
//	-- (2) 회원가입
	public int joinMember(MemberDto member) throws SQLException {
		int result = FAIL;
		conn = null;
		ps = null;
		String sql = "INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS) " + 
					 "  VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getMid());
			ps.setString(2, member.getMpw());
			ps.setString(3, member.getMname());
			ps.setString(4, member.getMemail());
			ps.setString(5, member.getMphoto());
			ps.setDate(6, member.getMbirth());
			ps.setString(7, member.getMaddress());
			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			close(conn, ps, null);
		}
		return result;
	}
//	-- (3) 로그인
	public int loginCheck(String mid, String mpw) throws SQLException {
		int result = FAIL;
		conn = null;
		ps = null;
		rs = null;
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
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			close(conn, ps, rs);
		}
		
		return result;
	}
//	-- (4) mid로 dto가져오기(로그인 성공시 session에 넣기 위함)
	public MemberDto getMember(String mid) throws SQLException {
		MemberDto member = null;
		conn = null;
		ps = null;
		rs = null;
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
				String mphoto = rs.getString("mphoto");
				Date mbirth = rs.getDate("mbirth");
				String maddress = rs.getString("maddress");
				Timestamp mrdate = rs.getTimestamp("mrdate");
				member = new MemberDto(mid, mpw, mname, memail, mphoto, mbirth, maddress, mrdate);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			close(conn, ps, rs);
		}
		return member;
	}
//	-- (5) 회원정보 수정
	public int modifyMember(MemberDto member) throws SQLException {
		int result = FAIL;
		conn = null;
		ps = null;
		String sql = "UPDATE MVC_MEMBER SET " + 
										"  MPW = ?, " + 
										"  MNAME = ?, " + 
										"  MEMAIL = ?, " + 
										"  MPHOTO = ?, " + 
										"  MBIRTH = ?, " + 
										"  MADDRESS = ? " + 
										"  WHERE MID = ?";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getMpw());
			ps.setString(2, member.getMname());
			ps.setString(3, member.getMemail());
			ps.setString(4, member.getMphoto());
			ps.setDate(5, member.getMbirth());
			ps.setString(6, member.getMaddress());
			ps.setString(7, member.getMid());
			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			close(conn, ps, null);
		}
		return result;
	}
//	-- (6) 회원리스트(top-N구문)
	public ArrayList<MemberDto> getMemberlist(int startRow, int endRow) throws SQLException {
		ArrayList<MemberDto> members = new ArrayList<MemberDto>();
		conn = null;
		ps = null;
		rs = null;
		String sql = "SELECT * " + 
				     "  FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM MVC_MEMBER) A) " + 
				     "  WHERE RN BETWEEN ? AND ?";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, startRow);
			ps.setInt(2, endRow);
			rs = ps.executeQuery();
			while(rs.next()) {
				String mid = rs.getString("mid");
				String mpw = rs.getString("mpw");
				String mname = rs.getString("mname");
				String memail = rs.getString("memail");
				String mphoto = rs.getString("mphoto");
				Date mbirth = rs.getDate("mbirth");
				String maddress = rs.getString("maddress");
				Timestamp mrdate = rs.getTimestamp("mrdate");
				MemberDto member = new MemberDto(mid, mpw, mname, memail, mphoto, mbirth, maddress, mrdate);
				members.add(member);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			close(conn, ps, rs);
		}
		return members;
	}
//	-- (7) 회원수
	public int getMemberTotCnt() throws SQLException {
		int totCnt = 0;
		conn = null;
		ps = null;
		rs = null;
		String sql = "SELECT COUNT(*) CNT FROM MVC_MEMBER";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();
			totCnt = rs.getInt("cnt");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			close(conn, ps, rs);
		}
		return totCnt;
	}
//	-- (8) 회원탈퇴
	public int withdrawalMember(String mid) throws SQLException {
		int result = FAIL;
		conn = null;
		ps = null;
		String sql = "DELETE FROM MVC_MEMBER WHERE MID = ?";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, mid);
			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			close(conn, ps, null);
		}
		return result;
	}
}
