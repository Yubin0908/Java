package com.lec.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Person_Dao {
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	
	public final static int SUCCESS = 1;
	public final static int FAIL = 0;
	
	private static Person_Dao INSTANCE = new Person_Dao();
	
	public static Person_Dao getInstance()	{
		
		return INSTANCE;
	}
	
	
	private Person_Dao() {
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public ArrayList<String> jnameList() {
		ArrayList<String> jnames = new ArrayList<String>();
		Connection conn = null;
		Statement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT JNAME FROM JOB";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tigar");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			while (rs.next()) {
				
				jnames.add(rs.getString("jname"));
				
			}
			
		} catch (SQLException e) {
		
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs!=null)
					rs.close();
				if (pstmt!=null)
					pstmt.close();
				if (conn!=null)
					conn.close();
				
			}catch(Exception e) {
				
				System.out.println(e.getMessage());
				}
		}
		
		
		
		return jnames;
	}
	
	public int insertPerson(Person_Dto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO PERSON VALUES (PERSON_PNO_SEQ.NEXTVAL, ?, (SELECT JNO FROM JOB WHERE JNAME=?), ?, ?, ?)";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tigar");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPname());
			pstmt.setString(2, dto.getJname());
			pstmt.setInt(3, dto.getKor());
			pstmt.setInt(4, dto.getEng());
			pstmt.setInt(5, dto.getMat());
			System.out.println(result == SUCCESS ? "연결성공":"연결실패");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
				
			}catch(Exception e) {System.out.println(e.getMessage());
			}
		}
	
		return result;
	}
	
	public ArrayList<Person_Dto> selectJname(String jname) {
		ArrayList<Person_Dto> dtos = new ArrayList<Person_Dto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql ="SELECT ROWNUM RANK, A.*"
				+ "    FROM (SELECT PNAME||'('||PNO||')' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM"
				+ "          FROM PERSON P, JOB J"
				+ "          WHERE P.JNO=J.JNO AND JNAME=?"
				+ "          ORDER BY SUM DESC) A";
		
				try {
					conn = DriverManager.getConnection(url, "scott", "tigar");
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					
					while (rs.next()) {
						
						int rank = rs.getInt("rank");
					}
					
				} catch (SQLException e) {
					
					System.out.println(e.getMessage());
					
				}
	
				
		
		
		return dtos;
	}
	
}
