package com.lec.ex1person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonMng {
	public static void main(String[] args) {

		String driver = "oracle.jdbc.driver.OracleDriver"; // driver loading
		String url = "jdbc:oracle:thin:@localhost:1521:xe";

		Connection conn = null;
		Statement stmt = null; // 직업명
		PreparedStatement pstmt = null; // 1번,2번 가능
		ResultSet rs = null;
		Scanner user = new Scanner(System.in);

		String fn, sql;

		ArrayList<String> jobs = new ArrayList<String>(); // DB에 존재하는 직업명 add

		try {
			sql = "SELECT JNAME FROM JOB";
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tigar");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				jobs.add(rs.getString("jname"));

			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();

			} catch (SQLException e) {

				System.out.println(e.getMessage());
			}

		}
		// System.out.println("DB에 있는 직업명들 : " + jobs);
		do {
			System.out.print("1. 입력 || 2. 직업별조회 || 3.전체조회 || 그외. 종료  >> ");
			fn = user.next();

			switch (fn) {
			case "1": // 이름, 직업명, 국영수 입력받아 insert
				sql = "INSERT INTO PERSON VALUES (PERSON_PNO_SEQ.NEXTVAL, ?, (SELECT JNO FROM JOB WHERE JNAME=?), ?, ?, ?)";
				try {
					conn = DriverManager.getConnection(url, "scott", "tigar");
					pstmt = conn.prepareStatement(sql);
					System.out.print("입력할 이름 : ");
					pstmt.setString(1, user.next());
					System.out.print("입력할 직업" + jobs + "은 : ");
					pstmt.setString(2, user.next());
					System.out.print("국어 점수 :");
					pstmt.setInt(3, user.nextInt());
					System.out.print("영어 점수 :");
					pstmt.setInt(4, user.nextInt());
					System.out.print("수학 점수 :");
					pstmt.setInt(5, user.nextInt());

					int result = pstmt.executeUpdate();

					System.out.println(result > 0 ? "입력성공" : "입력실패");
				} catch (SQLException e) {

					System.out.println(e.getMessage());
				} finally {
					try {
						if (pstmt != null)
							pstmt.close();
						if (conn != null)
							conn.close();

					} catch (SQLException e) {

						System.out.println(e.getMessage());
					}
				}
				break;

			case "2": // 직업명 입력받아 출력
				sql = "SELECT ROWNUM RANK, A.*\r\n"
						+ "    FROM (SELECT PNAME||'('||PNO||')' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM"
						+ "          FROM PERSON P, JOB J"
						+ "          WHERE P.JNO=J.JNO AND JNAME=?"
						+ "          ORDER BY SUM DESC) A";
				
				try {
					conn = DriverManager.getConnection(url, "scott", "tigar");
					pstmt = conn.prepareStatement(sql);
					
					System.out.print("검색할 직업 [" + jobs + "] 입력 :");
					pstmt.setString(1, user.next());
					
					rs = pstmt.executeQuery();
					
					if ( rs.next() ) {
						
						System.out.println("등수\t이름\t직업\t국어\t영어\t수학\t총점");
						do {
							int rank = rs.getInt("rank");
							String pname = rs.getString("pname");
							String jname = rs.getString("jname");
							int kor = rs.getInt("kor");
							int eng = rs.getInt("eng");
							int mat = rs.getInt("mat");
							int sum = rs.getInt("sum");
							
							System.out.printf("%d\t%s\t%s\t%d\t%d\t%d\t%d\t\n", rank, pname, jname, kor, eng, mat, sum);
							
						}while(rs.next());
					} else {
						
						System.out.println("해당 직업의 사람이 등록되지 않았습니다.");
					}
					
				} catch (SQLException e) {

					System.out.println(e.getMessage());
				} finally {
					try {
						if (rs != null)
							rs.close();
						if (pstmt != null)
							pstmt.close();
						if (conn != null)
							conn.close();
					} catch (SQLException e) {

						System.out.println(e.getMessage());
					}
				}
				
				break;

			case "3": // 전체출력
				sql = "SELECT ROWNUM RANK, A.*"
						+ "    FROM (SELECT PNAME||'('||PNO||')' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM"
						+ "          FROM PERSON P, JOB J"
						+ "          WHERE P.JNO=J.JNO"
						+ "          ORDER BY SUM DESC) A";
				
				try {
					conn = DriverManager.getConnection(url, "scott", "tigar");
					pstmt = conn.prepareStatement(sql);
					
					rs = pstmt.executeQuery();
					
					if ( rs.next() ) {
						
						System.out.println("등수\t이름\t직업\t국어\t영어\t수학\t총점");
						do {
							int rank = rs.getInt("rank");
							String pname = rs.getString("pname");
							String jname = rs.getString("jname");
							int kor = rs.getInt("kor");
							int eng = rs.getInt("eng");
							int mat = rs.getInt("mat");
							int sum = rs.getInt("sum");
							
							System.out.printf("%d\t%s\t%s\t%d\t%d\t%d\t%d\t\n", rank, pname, jname, kor, eng, mat, sum);
							
						}while(rs.next());
					} else {
						
						System.out.println("사람이 등록되지 않았습니다.");
					}
					
				} catch (SQLException e) {

					System.out.println(e.getMessage());
				} finally {
					try {
						if (rs != null)
							rs.close();
						if (pstmt != null)
							pstmt.close();
						if (conn != null)
							conn.close();
					} catch (SQLException e) {

						System.out.println(e.getMessage());
					}
				}

			}

		} while (fn.equals("1") || fn.equals("2") || fn.equals("3"));
		System.out.print("BYE");

	}
}
