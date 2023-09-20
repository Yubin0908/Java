package bbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BbsDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public BbsDAO() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/BBS";
			String dbID = "root";
			String dbPW = "sqlserver";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPW);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public String getDate() {
		String sql = "select now()";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ""; // database error
	}
	public int getNext() {
		String sql = "select bbsID from BBS order by bbsID desc";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1) + 1;
			}
			return 1; // 첫 번째 게시물인 경우
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return -1; // database error
	}
	
	public int write(String bbsTitle, String userID, String bbsContent) {
		String sql = "insert into BBS values (?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, getNext());
			pstmt.setString(2, bbsTitle);
			pstmt.setString(3, userID);
			pstmt.setString(4, getDate());
			pstmt.setString(5, bbsContent);
			pstmt.setInt(6, 1);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return -1; // database error
	}
	public ArrayList<Bbs> getList(int pageNumber) {
	    int postsPerPage = 10; // 한 페이지당 표시할 게시물 수
	    int start = (pageNumber - 1) * postsPerPage;
	    String sql = "SELECT * FROM BBS WHERE bbsAvailable = 1 ORDER BY bbsID DESC LIMIT ?, ?";
	    ArrayList<Bbs> list = new ArrayList<Bbs>();

	    try {
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, start);
	        pstmt.setInt(2, postsPerPage);
	        rs = pstmt.executeQuery();

	        while (rs.next()) {
	            Bbs bbs = new Bbs();
	            bbs.setBbsID(rs.getInt(1));
	            bbs.setBbsTitle(rs.getString(2));
	            bbs.setUserID(rs.getString(3));
	            bbs.setBbsDate(rs.getString(4));
	            bbs.setBbsContent(rs.getString(5));
	            bbs.setBbsAvailable(rs.getInt(6));
	            list.add(bbs);
	        }
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
	    return list;
	}
	
	public boolean nextPage(int pageNumber) {
	    String sql = "select * from BBS where bbsAvailable = 1";
	    try {
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        rs = pstmt.executeQuery();
	        int totalPosts = 0;
	        while (rs.next()) {
	            totalPosts++;
	        }

	        int postsPerPage = 10;
	        int totalPages = (totalPosts + postsPerPage - 1) / postsPerPage;
	        return pageNumber < totalPages;
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
	    return false;
	}
	public Bbs getBbs(int bbsID) {
		String sql = "select * from BBS where bbsID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bbsID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Bbs bbs = new Bbs();
				bbs.setBbsID(rs.getInt(1));
				bbs.setBbsTitle(rs.getString(2));
				bbs.setUserID(rs.getString(3));
				bbs.setBbsDate(rs.getString(4));
				bbs.setBbsContent(rs.getString(5));
				bbs.setBbsAvailable(rs.getInt(6));
				return bbs;
			} 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null; 
	} 
	public int update(int bbsID, String bbsTitle, String bbsContent) {
		String sql = "update BBS set bbsTitle = ?, bbsContent = ? where bbsID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bbsTitle);
			pstmt.setString(2, bbsContent);
			pstmt.setInt(3, bbsID);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return -1; // database error
	}
	public int delete(int bbsID) {
		String sql = "update BBS set bbsAvailable = 0 where bbsID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bbsID);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return -1; // database error
	}

}
