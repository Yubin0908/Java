package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public UserDAO() {
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

	public int login(String userID, String userPW) {
		String SQL = "SELECT userPW FROM USER WHERE userID = ?";

		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (rs.getString(1).equals(userPW)) {
					return 1; // Login Success
				} else {
					return 0; // Login Fail
				}
			}
			return -1; // ID가 없을때
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return -2; // database Error
	}
	
	// 회원가입 DAO
	public int join(User user) {
		String sql = "INSERT INTO USER VALUES (?, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserID());
			pstmt.setString(2, user.getUserPW());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getUserGender());
			pstmt.setString(5, user.getUserEmail());
			return pstmt.executeUpdate();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return -1; // database Error
	}
	// 회원정보 조회
    public User getUser(String userID) {
        String sql = "SELECT * FROM users WHERE userID = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userID);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setUserID(rs.getString("userID"));
                user.setUserPW(rs.getString("userPW"));
                user.setUserName(rs.getString("userName"));
                user.setUserGender(rs.getString("userGender"));
                user.setUserEmail(rs.getString("userEmail"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null; // 사용자 정보가 없을 경우
    }
	// 회원정보 수정 
    public boolean updateUser(User user) {
        String sql = "UPDATE users SET userPW=?, userName=?, userGender=?, userEmail=? WHERE userID=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUserPW());
            pstmt.setString(2, user.getUserName());
            pstmt.setString(3, user.getUserGender());
            pstmt.setString(4, user.getUserEmail());
            pstmt.setString(5, user.getUserID());

            int result = pstmt.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false; // 업데이트 실패
    }

}
