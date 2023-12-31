  -- ex 1
SELECT * FROM EMP;  
  -- ex 2
SELECT * FROM DEPT;

  -- ex 3
SELECT * FROM EMP WHERE DEPTNO LIKE '%'||'10' ORDER BY ENAME;
SELECT EMPNO, ENAME, JOB, HIREDATE, SAL, DNAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND E.DEPTNO LIKE '%'||'10';

SELECT E.*, DNAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND E.DEPTNO LIKE '%'||'10';

-- ENAME 검색
SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, E.DEPTNO, DNAME
FROM EMP E, DEPT D
WHERE E.DEPTNO=D.DEPTNO AND ENAME LIKE '%'||'N'||'%';

-- 전체출력
SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, E.DEPTNO DEPTNO, DNAME
FROM EMP E, DEPT D
WHERE E.DEPTNO=D.DEPTNO;