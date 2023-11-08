package com.lec.ch10.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.lec.ch10.vo.BoardDto;

@Repository
public class BoardDao {

	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	private DataSource ds;
	public BoardDao() { 
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
//	-- 1. 글목록(startRow ~ EndRow)	
	public ArrayList<BoardDto> listBoard(int startRow, int endRow) {
		ArrayList<BoardDto> dto = new ArrayList<BoardDto>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM" + 
				 	 "  (SELECT ROWNUM RN, A.* FROM (SELECT * FROM MVC_BOARD ORDER BY BGROUP DESC) A)" + 
				 	 "  WHERE RN BETWEEN ? AND ?";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, startRow);
			ps.setInt(2, endRow);
			rs = ps.executeQuery();
			while(rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Date bdate = rs.getDate("bdate");
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");
				String bip = rs.getString("bip");
				dto.add(new BoardDto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent, bip));
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
//	-- 2. 글갯수
	public int BoardCount() {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) CNT FROM MVC_BOARD";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();
			cnt = rs.getInt("cnt");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		
		
		return cnt;
	}
//	-- 3. 원글쓰기(bname, btitle, bcontent, bip - 사용자로부터 입력받은내용)
	public int insertBoard(BoardDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO MVC_BOARD (BID, BNAME, BTITLE, BCONTENT, BDATE, BHIT, BGROUP, BSTEP, BINDENT, BIP) "
				   + " VALUES (MVC_BOARD_SEQ.NEXTVAL, ?,?,?,SYSDATE,0,MVC_BOARD_SEQ.CURRVAL,0,0,?)";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getBname());
			ps.setString(2, dto.getBtitle());
			ps.setString(3, dto.getBcontent());
			ps.setString(4, dto.getBip());
			ps.executeUpdate();
			result = SUCCESS;
			System.out.println("원글 쓰기 성공!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return result;
	}
	
	public int writeBoard(BoardDto board) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO MVC_BOARD (BID, BNAME, BTITLE, BCONTENT, BDATE, BHIT, BGROUP, BSTEP, BINDENT, BIP) "
				   + " VALUES (MVC_BOARD_SEQ.NEXTVAL, ?,?,?,SYSDATE,0,MVC_BOARD_SEQ.CURRVAL,0,0,?)";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, board.getBname());
			ps.setString(2, board.getBtitle());
			ps.setString(3, board.getBcontent());
			ps.setString(4, board.getBip());
			ps.executeUpdate();
			result = SUCCESS;
			System.out.println("원글 쓰기 성공!");
		} catch(Exception e) 
		{
		} finally {
			try {
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
			
		}
		return result;
	}
//	-- 4. bid로 조회수 1올리기
	public void hitUp(int bid){
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "UPDATE MVC_BOARD SET BHIT = BHIT + 1 WHERE BID = ?";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bid);
			ps.executeUpdate();
			System.out.println(bid + "조회수 Up!!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
	}
//	-- 5. bid로 dto 가져오기
	public BoardDto getBoardNotHitUp(int bid) {
		BoardDto dto = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MVC_BOARD WHERE BID = ?";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bid);
			rs = ps.executeQuery();
			if(rs.next()) {
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Date bdate = rs.getDate("bdate");
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");
				String bip = rs.getString("bip");
				dto = new BoardDto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent, bip);
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
//	-- 6. 글수정(특정 bid의 bname, btitle, bcontent, bip 수정)
	public int modifyBoard(BoardDto board) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "UPDATE MVC_BOARD SET" + 
				   	 "  BNAME = ?," + 
					 "  BTITLE = ?," + 
					 "  BCONTENT = ?," + 
					 "  BIP = ?" + 
					 "  WHERE BID = ?";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, board.getBname());
			ps.setString(2, board.getBtitle());
			ps.setString(3, board.getBcontent());
			ps.setString(4, board.getBip());
			ps.setInt(5, board.getBid());
			ps.executeUpdate();
			result = SUCCESS;
			System.out.println(result == SUCCESS ? "글수정성공": "글번호(bid) 오류");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		
		return result;
	}
//	-- 7. 글삭제(특정 bid 삭제)
	public int deleteBoard(int bid) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "DELETE FROM MVC_BOARD WHERE BID = ?";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bid);
			ps.executeUpdate();
			result = SUCCESS;
			System.out.println(result == SUCCESS ? "글삭제성공": "글번호(bid) 오류");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
			
		}
		
		return result;
	}
//	-- 8. 답변글 저장 전단계(엑셀 ⓐ 단계)
	private void preReplyStep(int bgroup, int bstep) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "UPDATE MVC_BOARD SET BSTEP=BSTEP+1 WHERE BGROUP= ? AND BSTEP > ?";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bgroup);
			ps.setInt(2, bstep);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
			
		}
	}
//	-- 9. 답변글 저장(사용자 : bname, btitle, bcontent), (시스템 : bip), (원글정보 : bgroup, bstep, bindent)
	public int replyBoard(BoardDto board) {
		int result = FAIL;
		preReplyStep(board.getBgroup(), board.getBstep());
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO MVC_BOARD (BID, BNAME, BTITLE, BCONTENT, BDATE, BHIT, BGROUP, BSTEP, BINDENT, BIP)"
				   + "   VALUES (MVC_BOARD_SEQ.NEXTVAL, ?,?,?,SYSDATE,0,?,?,?,?)";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, board.getBname());
			ps.setString(2, board.getBtitle());
			ps.setString(3, board.getBcontent());
			ps.setInt(4, board.getBgroup());
			ps.setInt(5, board.getBstep()+1);
			ps.setInt(6, board.getBindent()+1);
			ps.setString(7, board.getBip());
			ps.executeUpdate();
			result = SUCCESS;
			System.out.println("답변글 쓰기 성공!!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
			
		}
		return result;
	}
	
}

