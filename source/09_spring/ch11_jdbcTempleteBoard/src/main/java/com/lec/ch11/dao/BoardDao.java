package com.lec.ch11.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.lec.ch11.vo.BoardDto;

@Repository
public class BoardDao {

	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
//	-- 1. 글목록(startRow ~ EndRow)	
	public ArrayList<BoardDto> listBoard(final int startRow, final int endRow) {
		String sql = "SELECT * FROM" + 
				 	 "  (SELECT ROWNUM RN, A.* FROM (SELECT * FROM MVC_BOARD ORDER BY BGROUP DESC) A)" + 
				 	 "  WHERE RN BETWEEN ? AND ?";
		
		return (ArrayList<BoardDto>)jdbcTemplate.query(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, startRow);
				ps.setInt(2, endRow);
			}
		}, new BeanPropertyRowMapper<BoardDto>(BoardDto.class));
	}
	
//	-- 2. 글갯수
	public int BoardCount() {
		String sql = "SELECT COUNT(*) CNT FROM MVC_BOARD";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
//	-- 3. 원글쓰기(bname, btitle, bcontent, bip - 사용자로부터 입력받은내용)
	public int insertBoard(final BoardDto dto) {
		String sql = "INSERT INTO MVC_BOARD (BID, BNAME, BTITLE, BCONTENT, BDATE, BHIT, BGROUP, BSTEP, BINDENT, BIP) "
				   + " VALUES (MVC_BOARD_SEQ.NEXTVAL, ?,?,?,SYSDATE,0,MVC_BOARD_SEQ.CURRVAL,0,0,?)";
		return jdbcTemplate.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, dto.getBname());
				ps.setString(2, dto.getBtitle());
				ps.setString(3, dto.getBcontent());
				ps.setString(4, dto.getBip());
			}
		});
	}
	
	public int writeBoard(final BoardDto board) {
		String sql = "INSERT INTO MVC_BOARD (BID, BNAME, BTITLE, BCONTENT, BDATE, BHIT, BGROUP, BSTEP, BINDENT, BIP) "
				   + " VALUES (MVC_BOARD_SEQ.NEXTVAL, ?,?,?,SYSDATE,0,MVC_BOARD_SEQ.CURRVAL,0,0,?)";
		return jdbcTemplate.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, board.getBname());
				ps.setString(2, board.getBtitle());
				ps.setString(3, board.getBcontent());
				ps.setString(4, board.getBip());
			}
		});
	}
//	-- 4. bid로 조회수 1올리기
	public void hitUp(int bid){
		String sql = "UPDATE MVC_BOARD SET BHIT = BHIT + 1 WHERE BID ="+bid;
		jdbcTemplate.update(sql);
	}
//	-- 5. bid로 dto 가져오기
	public BoardDto getBoardNotHitUp(int bid) {
		String sql = "SELECT * FROM MVC_BOARD WHERE BID ="+bid;
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<BoardDto>(BoardDto.class));
	}
//	-- 6. 글수정(특정 bid의 bname, btitle, bcontent, bip 수정)
	public int modifyBoard(final BoardDto board) {
		String sql = "UPDATE MVC_BOARD SET" + 
				   	 "  BNAME = ?," + 
					 "  BTITLE = ?," + 
					 "  BCONTENT = ?," + 
					 "  BIP = ?" + 
					 "  WHERE BID = ?";
		
		return jdbcTemplate.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, board.getBname());
				ps.setString(2, board.getBtitle());
				ps.setString(3, board.getBcontent());
				ps.setString(4, board.getBip());
				ps.setInt(5, board.getBid());
				
			}
		});
	}
//	-- 7. 글삭제(특정 bid 삭제)
	public int deleteBoard(int bid) {
		String sql = "DELETE FROM MVC_BOARD WHERE BID = " +bid;
		return jdbcTemplate.update(sql);
	}
//	-- 8. 답변글 저장 전단계(엑셀 ⓐ 단계)
	private void preReplyStep(int bgroup, int bstep) {
		String sql = "UPDATE MVC_BOARD SET BSTEP=BSTEP+1 WHERE BGROUP= ? AND BSTEP > ?";
		jdbcTemplate.update(sql);
	}
//	-- 9. 답변글 저장(사용자 : bname, btitle, bcontent), (시스템 : bip), (원글정보 : bgroup, bstep, bindent)
	public int replyBoard(final BoardDto board) {
		String sql = "INSERT INTO MVC_BOARD (BID, BNAME, BTITLE, BCONTENT, BDATE, BHIT, BGROUP, BSTEP, BINDENT, BIP)"
				   + "   VALUES (MVC_BOARD_SEQ.NEXTVAL, ?,?,?,SYSDATE,0,?,?,?,?)";
		return jdbcTemplate.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, board.getBname());
				ps.setString(2, board.getBtitle());
				ps.setString(3, board.getBcontent());
				ps.setInt(4, board.getBgroup());
				ps.setInt(5, board.getBstep()+1);
				ps.setInt(6, board.getBindent()+1);
				ps.setString(7, board.getBip());
				
			}
		});
	}
	
}

