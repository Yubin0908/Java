package com.lec.dao;
// connection pool 아용, singleton option

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;

import com.lec.dto.FileBoardDto;

public class FileBoardDao {
	public static final int PASS = 1;
	public static final int FAIL = 0;
	
	private static FileBoardDao instance;
	
	public static FileBoardDao getinstance() {
		if(instance == null) {
			instance = new FileBoardDao();
		}
		return instance;
	}
	private FileBoardDao() {
		
	}
	
	private Connection getConnection() {
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
	
//	-- 글목록(startRow ~ endRow) TOP-N
	public ArrayList<FileBoardDto> listBoard(int startRow, int endRow){
		ArrayList<FileBoardDto> dtos = new ArrayList<FileBoardDto>();
		Connection conn  = null;
		PreparedStatement pstmt = null;
		ResultSet  rs = null;
		String sql = "SELECT * " + 
					"  FROM (SELECT ROWNUM RN, A.*  " + 
					"  FROM (SELECT F.*, CNAME, CEMAIL FROM FILEBOARD F, CUSTOMER C  " + 
					"  WHERE F.CID = C.CID " + 
					"  ORDER BY FGROUP DESC, FSTEP) A) " + 
					"  WHERE RN BETWEEN ? AND ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int fid = rs.getInt("fid");
				String cid = rs.getString("cid");
				String ftitle = rs.getString("ftitle");
				String fcontent = rs.getString("fcontent");
				String filename = rs.getString("filename");
				int fhit = rs.getInt("fhit");
				String fpw = rs.getString("fpw");
				int fgroup = rs.getInt("fgroup");
				int fstep = rs.getInt("fstep");
				int findent = rs.getInt("findent");
				String fip = rs.getString("fip");
				Date frdate = rs.getDate("frdate");
				String cname = rs.getString("cname");
				String cemail = rs.getString("cemail");
				dtos.add(new FileBoardDto(fid, cid, ftitle, fcontent, filename, fhit, fpw, fgroup, fstep, findent, fip, frdate, cname, cemail));
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}
	
//	-- 전체 글갯수
	public int BoardCnt() {
		int totalcnt = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) CNT FROM FILEBOARD";
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();
			totalcnt = rs.getInt("cnt");
		} catch (Exception e) {
			System.out.println("cnt 가져오다 : "+e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return totalcnt;
	}
//	-- 글쓰기 : cid, 글제목, 본문, 첨부파일, 비번
	public int insertBoard(FileBoardDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO FILEBOARD (fid, cid, ftitle, fcontent, filename, fhit, fpw, fgroup, fstep, findent, fip)" + 
				"  VALUES (FILEBOARD_SEQ.NEXTVAL, ?, ?, ?, ?, 0, ?, FILEBOARD_SEQ.CURRVAL, 0, 0, ?)";
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getCid());
			ps.setString(2, dto.getFtitle());
			ps.setString(3, dto.getFcontent());
			ps.setString(4, dto.getFilename());
			ps.setString(5, dto.getFpw());
			ps.setString(6, dto.getFip());
			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
//	-- fid로 조회수 올리기
	public void hitUp(int fid) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "UPDATE FILEBOARD SET  FHIT = FHIT + 1 WHERE FID = ?";
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, fid);
			ps.executeUpdate();
			System.out.println(fid + "번 hitUp");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
//	-- fid로 dto 가져오기
	public FileBoardDto getBoard(int fid) {
		FileBoardDto board = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT F.*, CNAME, CEMAIL FROM FILEBOARD F, CUSTOMER C" + 
				"  WHERE F.CID = C.CID AND FID=?" + 
				"  ORDER BY fGROUP DESC, fSTEP";
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, fid);
			rs = ps.executeQuery();
			if(rs.next()) {	
				String cid = rs.getString("cid");
				String ftitle = rs.getString("ftitle");
				String fcontent = rs.getString("fcontent");
				String filename = rs.getString("filename");
				int fhit = rs.getInt("fhit");
				String fpw = rs.getString("fpw");
				int fgroup = rs.getInt("fgroup");
				int fstep = rs.getInt("fstep");
				int findent= rs.getInt("findent");
				String fip = rs.getString("fip");
				Date frdate = rs.getDate("frdate");
				String cname = rs.getString("cname");
				String cemail = rs.getString("cemail");
				board = new FileBoardDto(fid, cid, ftitle, fcontent, filename, fhit, fpw, fgroup, fstep, findent, fip, frdate, cname, cemail);
			}
		} catch (Exception e) {
			System.out.println( "DTO Load Fail : " + e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return board;
	}
//	-- 글 수정
	public int modifyBoard(FileBoardDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "UPDATE FILEBOARD SET" + 
				"    FTITLE = ?," + 
				"    FCONTENT = ?," + 
				"    FPW = ?," + 
				"    FIP = ?" + 
				"    WHERE FID=?";
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getFtitle());
			ps.setString(2, dto.getFcontent());
			ps.setString(3, dto.getFpw());
			ps.setString(4, dto.getFip());
			ps.setInt(5, dto.getFid());
			result = ps.executeUpdate();
			System.out.println(result == PASS ? "수정성공":"수정실패");
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
//	-- 글 삭제 (need fid & fpw)
	public int deleteBoard(int fid, String fpw) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "DELETE FROM FILEBOARD WHERE FID=? AND FPW=?";
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, fid);
			ps.setString(2, fpw);
			result = ps.executeUpdate();
			System.out.println(result == PASS ? "삭제성공":"삭제실패");
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
//	-- 답변글 쓰기 전단계
	private void replyStep(int fgroup, int fstep) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "UPDATE FILEBOARD SET FSTEP=FSTEP+1 WHERE FGROUP=? AND FSTEP>?";
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, fgroup);
			ps.setInt(2, fstep);
			cnt = ps.executeUpdate();
			System.out.println(cnt + " bstep 조정");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
//	-- 답변글 쓰기
	public int replyBoard(FileBoardDto dto) {
		int result = FAIL;
		replyStep(dto.getFgroup(), dto.getFstep());
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO FILEBOARD (fid, cid, ftitle, fcontent, filename, fgroup, fstep, findent, fpw, fip)" + 
					 "  VALUES (FILEBOARD_SEQ.NEXTVAL,?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getCid());
			ps.setString(2, dto.getFtitle());
			ps.setString(3, dto.getFcontent());
			ps.setString(4, dto.getFilename());
			ps.setInt(5, dto.getFgroup());
			ps.setInt(6, dto.getFstep()+1);
			ps.setInt(7, dto.getFindent()+1);
			ps.setString(8, dto.getFpw());
			ps.setString(9, dto.getFip());
			result = ps.executeUpdate();
			System.out.println("답글 등록 성공");
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
