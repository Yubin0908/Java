package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 * 사용자에게 부서번호를 입력받음 (1) 해당부서번호가 존재 : 부서정보 출력, 사원정보(사번, 이름, 급여, 상사이름) 출력 (2)
 * 해당부서번호가 부존재 : 부서번호가 존재않는다고 출력
 **/
public class Ex2_selectWhereDeptno2 {
	public static void main(String[] args) {

		String driver = "oracle.jdbc.driver.OracleDriver"; // driver loading
		String url = "jdbc:oracle:thin:@localhost:1521:xe";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);

		System.out.println("조화할 부서번호 : ");
		int deptno = sc.nextInt();

		String sql1 = "SELECT * FROM DEPT WHERE DEPTNO=" + deptno;

		String sql2 = "SELECT W.EMPNO, W.ENAME, W.SAL, NVL(M.ENAME, ' ') MANAGER" + "    FROM EMP W, EMP M"
				+ "    WHERE W.MGR=M.EMPNO(+) AND W.DEPTNO=" + deptno;

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tigar");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql1);

			if (rs.next()) {

				System.out.println("부서번호 : " + deptno);
				System.out.println("부서명 : " + rs.getString("dname"));
				System.out.println("부서위치 : " + rs.getString("loc") + "\n");

				rs.close();

				rs = stmt.executeQuery(sql2);

				if (rs.next()) {

					System.out.println("사번\t이름\t급여\t상사");
					do {

						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						int sal = rs.getInt("sal");
						String manager = rs.getString("manager");

						System.out.println(empno + "\t" + ename + "\t" + sal + "\t" + manager);

					} while (rs.next());

				} else {

					System.out.println(deptno + "번 부서에 존재하는 사원이 없습니다.");

				}

			} else {

				System.out.println(deptno + "번 부서는 존재하지 않습니다.");
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

			} catch (Exception e) {

				System.out.println(e.getMessage());
			}

		}
	}
}
