SELECT * FROM TAB;
SELECT * FROM USER_TABLES; -- 현 계정이 소유한 테이블
SELECT * FROM ALL_TABLES; -- 현 계정이 사용가능한 테이블
SELECT * FROM SCOTT.EMP;
SELECT * FROM SCOTT.DEPT;

SELECT * FROM SCOTT.EMP E, SCOTT.DEPT D
  WHERE E.DEPTNO=D.DEPTNO;


EXIT;
