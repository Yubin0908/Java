    -- Ex1. 사용자로부터 부서번호를 받아 부서정보 출력
SELECT * FROM DEPT WHERE DEPTNO=40;
  
    -- Ex2.  부서정보, 사원정보(사번, 이름, 급여, 상사이름)
SELECT * FROM DEPT WHERE DEPTNO=20;  

SELECT W.EMPNO, W.ENAME, W.SAL, NVL(M.ENAME, ' ') MANAGER
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO(+) AND W.DEPTNO=20;
    
    -- Ex3. 사용자로부터 부서명을 입력받아 해당 부서정보를 출력
SELECT * FROM DEPT WHERE DNAME=UPPER('SALES');