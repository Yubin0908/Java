package com.lec.ex6preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

// 부서명을 입력받아 해당부서 사원정보(사번, 이름, 상사사번, 급여, 급여등급) 상사가 없는 경우 상사명에 ceo 출력 후 급여순 정렬
public class Ex3_selectWhereDname {
	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver"; // driver loading
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		Scanner users = new Scanner(System.in);
		
		String sql = "SELECT W.EMPNO, W.ENAME, NVL(M.ENAME, '-CEO-') MANAGER, W.SAL, GRADE"
				+ "    FROM EMP W, EMP M, SALGRADE, DEPT D"
				+ "    WHERE W.DEPTNO=D.DEPTNO AND W.MGR=M.EMPNO(+) AND W.SAL BETWEEN LOSAL AND HISAL AND DNAME=UPPER(?)"
				+ "    ORDER BY SAL";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		System.out.print("조회할 부서명을 입력 : ");
		String dname = users.next();
		
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tigar");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dname);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				System.out.println("사번\t이름\t매니저\t급여\t등급");
				do {
					
					int empno = rs.getInt("empno");
					String ename = rs.getString("ename");
					String manager = rs.getString("manager");
					int sal = rs.getInt("sal");
					int grade = rs.getInt("grade");
					
					System.out.printf("%d\t%s\t%s\t%d\t%d\n", empno, ename, manager, sal, grade);
					
				}while(rs.next());
				
			} else {
				
				System.out.println("해당 데이터가 없습니다.");
				
			}
			
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
				
			}catch(SQLException e) {
				
				System.out.println(e.getMessage());
			}
			
		}
		
	}
}
