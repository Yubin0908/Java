package com.lec.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.ex.dto.BoardDto;

public class BoardDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	
	private static BoardDao instance = new BoardDao();
	public static BoardDao getInstance() {
		return instance;
	}
	private BoardDao() {
	}
	// Connection Pool 리턴함수
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

//	-- 1. 글목록(글 그룹 최신순)
	public ArrayList<BoardDto> listBoard() {
		ArrayList<BoardDto> dto = new ArrayList<BoardDto>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM BOARD ORDER BY BGROUP DESC";
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				String bemail = rs.getString("bemail");
				int bhit = rs.getInt("bhit");
				String bpw = rs.getString("bpw");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");
				String bip = rs.getString("bip");
				Timestamp bdate = rs.getTimestamp("bdate");
				dto.add(new BoardDto(bid, bname, btitle, bcontent, bemail, bhit, bpw, bgroup, bstep, bindent, bip, bdate));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(conn!= null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dto;
	}
//	-- 1. 글목록(Startrow ~ EndRow)
	public ArrayList<BoardDto> listBoard(int startRow, int endRow) {
		ArrayList<BoardDto> dto = new ArrayList<BoardDto>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOARD ORDER BY BGROUP DESC, BSTEP) A) WHERE RN BETWEEN ? AND ?";
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, startRow);
			ps.setInt(2, endRow);
			rs = ps.executeQuery();
			while(rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				String bemail = rs.getString("bemail");
				int bhit = rs.getInt("bhit");
				String bpw = rs.getString("bpw");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");
				String bip = rs.getString("bip");
				Timestamp bdate = rs.getTimestamp("bdate");
				dto.add(new BoardDto(bid, bname, btitle, bcontent, bemail, bhit, bpw, bgroup, bstep, bindent, bip, bdate));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(conn!= null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dto;
	}
//	-- 2. 전체 글 갯수
	public int getContentCnt() {
		int totalCnt = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) CNT FROM BOARD";
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();
			totalCnt = rs.getInt("cnt");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(conn!= null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return totalCnt;
	}
//	-- 3. 원글 쓰기 [작성자, 글제목, 본분, 이메일, 비밀번호, IP, BGORUP: 글번호, BTEP: 0, BINDENT: 0]
	public int writeBoard(BoardDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO BOARD (BID, BNAME, BTITLE, BCONTENT, BEMAIL, BPW, BGROUP, BSTEP, BINDENT, BIP)" + 
				"        VALUES (BOARD_SEQ.NEXTVAL, ?, ?, ?, ?, ?, BOARD_SEQ.CURRVAL, 0, 0, ?)";
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getBname());
			ps.setString(2, dto.getBtitle());
			ps.setString(3, dto.getBcontent());
			ps.setString(4, dto.getBemail());
			ps.setString(5, dto.getBpw());
			ps.setString(6, dto.getBip());
			result = ps.executeUpdate();
			System.out.println("글 작성 성공");
			
		} catch (Exception e) {
			System.out.println(e.getMessage() + "글 작성 중 예외 발생 : " + dto);
		} finally {
			try {
				if(ps!=null) ps.close();
				if(conn!= null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
			return result;
	}
//	-- 4. BID로 조회수 올리기 (글 상세보기)
	public void hitUp(int bid) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "UPDATE BOARD SET BHIT=BHIT+1 WHERE BID=?";
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bid);
			ps.executeUpdate();
			System.out.println(bid + "번 글 조회수 up");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	finally {
			try {
				if(ps!=null) ps.close();
				if(conn!= null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	public void hitUp(String bid) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "UPDATE BOARD SET BHIT=BHIT+1 WHERE BID=?";
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, bid);
			ps.executeUpdate();
			System.out.println(bid + "번 글 조회수 up");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	finally {
			try {
				if(ps!=null) ps.close();
				if(conn!= null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

////	-- 5. BID로 DTO 받기(글 상세보기)
//	public BoardDto getContent(int bid) {
//		hitUp(bid); // 글 상세보기 시 조회수 올리기
//		BoardDto dto = null;
//		Connection conn = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		String sql = "SELECT * FROM BOARD WHERE BID=?";
//		try {
//			conn = getConnection();
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, bid);
//			rs = ps.executeQuery();
//			if(rs.next()) {
//				String bname = rs.getString("bname");
//				String btitle = rs.getString("btitle");
//				String bcontent = rs.getString("bcontent");
//				String bemail = rs.getString("bemail");
//				int bhit = rs.getInt("bhit");
//				String bpw = rs.getString("bpw");
//				int bgroup = rs.getInt("bgroup");
//				int bstep = rs.getInt("bstep");
//				int bindent = rs.getInt("bindent");
//				String bip = rs.getString("bip");
//				Timestamp bdate = rs.getTimestamp("bdate");
//				dto = new BoardDto(bid, bname, btitle, bcontent, bemail, bhit, bpw, bgroup, bstep, bindent, bip, bdate);
//			}
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		} finally {
//			try {
//				if(rs!=null) rs.close();
//				if(ps!=null) ps.close();
//				if(conn!= null) conn.close();
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//			}
//		}		
//		return dto;
//	}
//	public BoardDto getContent(String bid) {
//		hitUp(bid); // 글 상세보기 시 조회수 올리기
//		BoardDto dto = null;
//		Connection conn = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		String sql = "SELECT * FROM BOARD WHERE BID=?";
//		try {
//			conn = getConnection();
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, bid);
//			rs = ps.executeQuery();
//			if(rs.next()) {
//				String bname = rs.getString("bname");
//				String btitle = rs.getString("btitle");
//				String bcontent = rs.getString("bcontent");
//				String bemail = rs.getString("bemail");
//				int bhit = rs.getInt("bhit");
//				String bpw = rs.getString("bpw");
//				int bgroup = rs.getInt("bgroup");
//				int bstep = rs.getInt("bstep");
//				int bindent = rs.getInt("bindent");
//				String bip = rs.getString("bip");
//				Timestamp bdate = rs.getTimestamp("bdate");
//				dto = new BoardDto(Integer.parseInt(bid), bname, btitle, bcontent, bemail, bhit, bpw, bgroup, bstep, bindent, bip, bdate);
//			}
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		} finally {
//			try {
//				if(rs!=null) rs.close();
//				if(ps!=null) ps.close();
//				if(conn!= null) conn.close();
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//			}
//		}		
//		return dto;
//	}

//	-- 6. BID로 DTO 받기(글 수정FORM, 답변글쓰기FORM) - HitUp : x
	public BoardDto getBoard(int bid) {
		BoardDto dto = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM BOARD WHERE BID=?";
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bid);
			rs = ps.executeQuery();
			if(rs.next()) {
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				String bemail = rs.getString("bemail");
				int bhit = rs.getInt("bhit");
				String bpw = rs.getString("bpw");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");
				String bip = rs.getString("bip");
				Timestamp bdate = rs.getTimestamp("bdate");
				dto = new BoardDto(bid, bname, btitle, bcontent, bemail, bhit, bpw, bgroup, bstep, bindent, bip, bdate);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(conn!= null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}		
		return dto;
	}
	public BoardDto getBoard(String bid) {
		BoardDto dto = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM BOARD WHERE BID=?";
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, bid);
			rs = ps.executeQuery();
			if(rs.next()) {
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				String bemail = rs.getString("bemail");
				int bhit = rs.getInt("bhit");
				String bpw = rs.getString("bpw");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");
				String bip = rs.getString("bip");
				Timestamp bdate = rs.getTimestamp("bdate");
				dto = new BoardDto(Integer.parseInt(bid), bname, btitle, bcontent, bemail, bhit, bpw, bgroup, bstep, bindent, bip, bdate);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(conn!= null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}		
		return dto;
	}
//	-- 7. 글 수정(작성자, 글제목, 본문, 이메일, 비번, IP 수정)
	public int modifyBoard(BoardDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "UPDATE BOARD SET " + 
				"      BNAME = ?, " + 
				"      BTITLE = ?," + 
				"      BCONTENT = ?, " + 
				"      BEMAIL = ?, " + 
				"      BPW = ?, " + 
				"      BIP = ? " + 
				"      WHERE BID=? ";
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getBname());
			ps.setString(2, dto.getBtitle());
			ps.setString(3, dto.getBcontent());
			ps.setString(4, dto.getBemail());
			ps.setString(5, dto.getBpw());
			ps.setString(6, dto.getBip());
			ps.setInt(7, dto.getBid());
			result = ps.executeUpdate();
			System.out.println(result == SUCCESS ? "수정성공":"수정실패");
		} catch (Exception e) {
			System.out.println(e.getMessage() + "글 수정 중 예외 발생 : " + dto);
		} finally {
			try {
				if(ps!=null) ps.close();
				if(conn!= null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
			return result;
	}
//	-- 8. 글 삭제(비밀번호 일치 시에만 동작)
	public int deleteBoard(int bid, String bpw) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "DELETE FROM BOARD WHERE BID=? AND BPW=?";
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bid);
			ps.setString(2, bpw);
			result = ps.executeUpdate();
			System.out.println(result == SUCCESS ? "삭제성공":"삭제실패");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(ps!=null) ps.close();
				if(conn!= null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
			return result;
	}
//	-- 9. 답변 글 저장 전 BSTEP 조정단계
	private void preReplyStep(int bgroup, int bstep) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "UPDATE BOARD SET BSTEP=BSTEP+1" + 
					 "  WHERE BGROUP=? AND BSTEP>?";
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bgroup);
			ps.setInt(2, bstep);
			cnt = ps.executeUpdate();
			System.out.println("기존 답변글 " + cnt + "개 bstep 조정됨.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(ps!=null) ps.close();
				if(conn!= null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
//	-- 10. 답변글 쓰기	
	public int replyBoard(BoardDto dto) {
		int result = FAIL;
		preReplyStep(dto.getBgroup(), dto.getBstep()); // 전처리 단계
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO BOARD (BID, BNAME, BTITLE, BCONTENT, BEMAIL, BPW, BGROUP, BSTEP, BINDENT, BIP)" + 
				"  VALUES (BOARD_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getBname());
			ps.setString(2, dto.getBtitle());
			ps.setString(3, dto.getBcontent());
			ps.setString(4, dto.getBemail());
			ps.setString(5, dto.getBpw());
			ps.setInt(6, dto.getBgroup());
			ps.setInt(7, dto.getBstep()+1);
			ps.setInt(8, dto.getBindent()+1);
			ps.setString(9, dto.getBip());
			result = ps.executeUpdate();
			System.out.println("답글 작성 성공");
		} catch (Exception e) {
			System.out.println(e.getMessage() + " 답변글 예외 발생 : " + dto);
		} finally {
			try {
				if(ps!=null) ps.close();
				if(conn!= null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
}
	
	
