    -- select 부서명을 입력받아 해당부서 사원정보(사번, 이름, 상사사번, 급여, 급여등급) 상사가 없는 경우 상사명에 ceo 출력 후 급여순 정렬
SELECT W.EMPNO, W.ENAME, NVL(M.ENAME, '-CEO-') MANAGER, W.SAL, GRADE
    FROM EMP W, EMP M, SALGRADE, DEPT D
    WHERE W.DEPTNO=D.DEPTNO AND W.MGR=M.EMPNO(+) AND W.SAL BETWEEN LOSAL AND HISAL AND DNAME=UPPER('accounting')
    ORDER BY SAL; 