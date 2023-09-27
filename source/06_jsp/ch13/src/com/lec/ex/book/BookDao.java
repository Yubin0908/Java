package com.lec.ex.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BookDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	
	private static BookDao instance;
	
	public static BookDao getinstance() {
		if(instance == null) {
			instance = new BookDao();
		}
		return instance;
	}
	private BookDao() {
		
	};
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
//	-- 1. 책등록
	public int createBook(BookDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO BOOK (bID, bTITLE, bPRICE, BIMG1, BIMG2, bCONTENT, bDISCOUNT)" + 
					 "    VALUES (BOOK_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?)";
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getBtitle());
			ps.setInt(2, dto.getBprice());
			ps.setString(3, dto.getBimg1());
			ps.setString(4, dto.getBimg2());
			ps.setString(5, dto.getBcontent());
			ps.setInt(6, dto.getBdiscount());
			result = ps.executeUpdate();
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
//	-- 2. 책목록(NOT PAGING)
	public ArrayList<BookDto> listBook() {
		ArrayList<BookDto> books = new ArrayList<BookDto>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM BOOK ORDER BY BRDATE DESC";
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				 int bid = rs.getInt("bid");
				 String btitle = rs.getString("btitle");
				 int bprice = rs.getInt("bprice");
				 String bimg1 = rs.getString("bimg1");
				 String bimg2 = rs.getString("bimg2");
				 String bcontent = rs.getString("bcontent");
				 int bdiscount = rs.getInt("bdiscount");
				 Timestamp brdate = rs.getTimestamp("brdate");
				 books.add(new BookDto(bid, btitle, bprice, bimg1, bimg2, bcontent, bdiscount, brdate));
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
		return books;
	}
//	-- 2. 책목록(TOP-N)
	public ArrayList<BookDto> listBook(int startRow, int endRow) {
		ArrayList<BookDto> books = new ArrayList<BookDto>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT *" + 
				"  FROM (SELECT ROWNUM RN, A.*" + 
				"        FROM (SELECT * FROM BOOK ORDER BY BRDATE DESC) A)" + 
				"        WHERE RN BETWEEN ? AND ?";
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, startRow);
			ps.setInt(2, endRow);
			rs = ps.executeQuery();
			while(rs.next()) {
				 int bid = rs.getInt("bid");
				 String btitle = rs.getString("btitle");
				 int bprice = rs.getInt("bprice");
				 String bimg1 = rs.getString("bimg1");
				 String bimg2 = rs.getString("bimg2");
				 String bcontent = rs.getString("bcontent");
				 int bdiscount = rs.getInt("bdiscount");
				 Timestamp brdate = rs.getTimestamp("brdate");
				 books.add(new BookDto(bid, btitle, bprice, bimg1, bimg2, bcontent, bdiscount, brdate));
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
		return books;
	}	
//	-- 등록된 책 갯수
	public int bookCount() {
		int totalcnt = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) CNT FROM BOOK";
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();
			totalcnt = rs.getInt("cnt");
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
		
		return totalcnt;
	}
//	-- 3. 책 상세보기(BID로 DTO가져오기)
	public BookDto getBook(int bid) {
		BookDto book = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM BOOK WHERE BID=?";
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bid);

			rs = ps.executeQuery();
			if(rs.next()) {
				 String btitle = rs.getString("btitle");
				 int bprice = rs.getInt("bprice");
				 String bimg1 = rs.getString("bimg1");
				 String bimg2 = rs.getString("bimg2");
				 String bcontent = rs.getString("bcontent");
				 int bdiscount = rs.getInt("bdiscount");
				 Timestamp brdate = rs.getTimestamp("brdate");
				 book = new BookDto(bid, btitle, bprice, bimg1, bimg2, bcontent, bdiscount, brdate);
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
		
		return book;
	}
	
}
