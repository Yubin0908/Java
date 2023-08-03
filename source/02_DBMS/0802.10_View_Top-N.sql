    -- View, In-Line View, TOP-N
DROP TABLE EMP1;
CREATE TABLE EMP1 AS SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, DEPTNO FROM EMP;

SELECT * FROM EMP1; -- 타부서에서 권한을 줄 테이블

SELECT * FROM USER_TABLES WHERE TABLE_NAME LIKE 'EMP%';

INSERT INTO EMP1 (EMPNO, ENAME, DEPTNO) VALUES (1111, '홍', 30);

SELECT * FROM EMP1; -- 홍검색
SELECT * FROM EMP; -- 홍 검색안됨
DROP TABLE EMP1;
--==============================================================================================================================================--
    -- [1] View : 가상의 테이블(물리적인 저장공간과 데이터까 따로 없음) (1) 단순뷰, (2) 복합뷰
    -- (1) 단순뷰 : 하나의 테이블을 이용해서 만든 뷰
CREATE OR REPLACE VIEW EMPv0 -- EMP 테이블에서 특정 필드만 VIEW로 생성.
    AS SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, DEPTNO FROM EMP;

SELECT * FROM EMPv0;

SELECT * FROM USER_VIEWS;

INSERT INTO EMPv0 VALUES (1111, '홍', 'MANAGER', NULL, SYSDATE, 40); -- VIEW에 INSERT
    -- VIEW에 데이터 업데이트 시, 메인테이블에서도 데이터가 업데이트 됨.
SELECT * FROM EMPv0; 
SELECT * FROM EMP;
    
ROLLBACK;

CREATE OR REPLACE VIEW EMPv0 -- EMP 테이블에서 특정 행(ROW)만 VIEW로 생성
    AS SELECT * FROM EMP WHERE DEPTNO=30;
    
SELECT * FROM EMPv0;
    
INSERT INTO EMPv0 VALUES (1111, '홍', 'MANAGER', NULL, SYSDATE, NULL, NULL, 30);
    
SELECT * FROM EMP;
    
INSERT INTO EMPv0 (EMPNO, ENAME, DEPTNO) VALUES (1112, '박', 40); -- VIEW에 40번 부서 직원 입력

SELECT * FROM EMPv0; -- 입력한 1112 사원은 보이지않음
SELECT * FROM EMP;

    -- VIEW의 제한조건 
        -- WITH CHECK OPTION 추가 : VIEW의 조건에 해당되는 데이터만 추가,삭제,수정 가능
        -- WITH READ ONLY 추가 : 읽기전용 VIEW(SELECT만 가능)
CREATE OR REPLACE VIEW EMPv0
    AS SELECT * FROM EMP WHERE DEPTNO=30
    WITH CHECK OPTION;

INSERT INTO EMPv0 (EMPNO, ENAME, DEPTNO) VALUES (1113, '이', 30);
INSERT INTO EMPv0 (EMPNO, ENAME, DEPTNO) VALUES (1114, '이', 40); -- 제한조건의 의해 ERROR발생(입력안됨)

DELETE FROM EMPv0 WHERE DEPTNO=20; -- 지워지지않음


    -- WITH READ ONLY 추가 : 읽기전용 VIEW(SELECT만 가능), WITH READ ONLY 추가하지 않은 경우
CREATE OR REPLACE VIEW EMPv0
    AS SELECT * FROM EMP
    WITH READ ONLY;
    
SELECT * FROM EMPv0;

DELETE FROM EMPv0 WHERE EMPNO<2000; -- 읽기전용 제한조건으로 인해 ERROR 발생.

DELETE FROM EMP WHERE EMPNO<2000;
COMMIT;

CREATE OR REPLACE VIEW EMPv0    -- 단순뷰에서도 INSERT 불가한 경우 : VIEW 생성 시, NOT NULL 필드가 미포함된 경우
    AS SELECT ENAME, JOB FROM EMP;
    
SELECT * FROM EMPv0;

INSERT INTO EMPv0 VALUES ('홍길', 'MANAGER'); -- 사번, MGR, SAL, COMM, DEPTNO는 NULL (EMPNO - PK제약조건 NOT NULL) 입력안됨


    -- (2) 복합뷰 : 2개 이상의 테이블로 구성한 뷰, 1개의 테이블로 가상의 필드를 이용한 뷰
    -- ① 2개 이상의 테이블로 구성한 뷰
CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, JOB, DNAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO;
    
SELECT * FROM EMPv0;

INSERT INTO EMPv0 VALUES (1111, '홍', 'MANAGER', 'SALES'); -- 복합뷰에서는 INSERT 불가
    
    
    -- ② 1개의 테이블로 가상의 필드를 이용한 뷰(컬럼에 별칭을 사용)
CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, SAL, SAL*12 YEARSAL FROM EMP;

SELECT * FROM EMPv0;

INSERT INTO EMPv0 VALUES (1111, '홍', 100, 1200); -- 복합뷰에서는 INSERT 불가

CREATE OR REPLACE VIEW EMPv0 (EMANO, ENAME, SAL, YEARSAL) -- 별칭 따로
    AS SELECT EMPNO, ENAME, SAL, SAL*12 FROM EMP;
    
SELECT * FROM EMPv0;

CREATE OR REPLACE VIEW EMPv0 (DEPTNO, AVGSAL)
    AS SELECT DEPTNO, ROUND(AVG(SAL)) FROM EMP 
        GROUP BY DEPTNO;

SELECT * FROM EMPv0;
--==============================================================================================================================================--
    -- [2] IN-LINE VIEW : FROM절의 서브쿼리를 INLINE VIEW라 함, FROM절에 오는 서브퀴리는 VIEW처럼 작용
    -- EX. 급여가 2000을 초과하는 사원의 평균 급여
SELECT AVG(SAL) FROM EMP WHERE SAL>2000;
SELECT AVG(SAL) FROM (SELECT SAL FROM EMP WHERE SAL>2000);
    -- EX. 부서 평균 급여보다 급여가 높은 사원의 사번, 이름, 급여, 부서번호를 츨력
SELECT EMPNO, ENAME, SAL, DEPTNO 
    FROM EMP E
    WHERE SAL>(SELECT AVG(SAL) FROM EMP WHERE DEPTNO=E.DEPTNO);
    
/* A */SELECT EMPNO, ENAME, SAL, DEPTNO FROM EMP;
/* B */SELECT DEPTNO, AVG(SAL) AVGSAL 
            FROM EMP
            GROUP BY DEPTNO;
    -- A + B EQUI JOIN
SELECT EMPNO, ENAME, SAL, A.DEPTNO, ROUND(AVGSAL)
    FROM EMP A, (SELECT DEPTNO, AVG(SAL) AVGSAL FROM EMP GROUP BY DEPTNO) B
    WHERE A.DEPTNO=B.DEPTNO AND SAL>AVGSAL;
--==============================================================================================================================================--  
   -- [3] TOP-N 구문(TOP 1~10등, 11~20등, ~)
    -- ROWNUM(테이블의 가져온 순서)과 INLINE VIEW를 이용한 TOP-N구문
SELECT ROWNUM, EMPNO, ENAME FROM EMP; -- SCOTT의 ROWNUM = 0
SELECT ROWNUM, EMPNO, ENAME FROM EMP  -- SCOTT의 ROWNUM = 3
    WHERE DEPTNO=20;
    
SELECT ROWNUM, ENAME, SAL FROM EMP;
SELECT ROWNUM, ENAME, SAL
    FROM EMP
    ORDER BY SAL;
    
    -- 1~꼴찌 등수, 이름, 급여
SELECT ROWNUM RANK, ENAME, SAL
    FROM (SELECT * FROM EMP ORDER BY SAL);
    
    -- SAL 기준, 1~5등
SELECT ROWNUM RANK, ENAME, SAL
    FROM (SELECT * FROM EMP ORDER BY SAL)
    WHERE ROWNUM BETWEEN 1 AND 5;
    
    -- SAL 기준, 6~10등
SELECT ROWNUM RANK, ENAME, SAL
    FROM (SELECT * FROM EMP ORDER BY SAL)
    WHERE ROWNUM BETWEEN 6 AND 10;    
    
    -- TOP-N
SELECT ROWNUM RN, ENAME, SAL
    FROM (SELECT * FROM EMP ORDER BY SAL); -- 2단계
SELECT ROWNUM, RN, ENAME, SAL
    FROM (SELECT ROWNUM RN, ENAME, SAL FROM (SELECT * FROM EMP ORDER BY SAL))
    WHERE RN BETWEEN 6 AND 10; -- 3단계
    
    -- EX. 이름순(ABC)으로 6번째부터 10번째까지 사원의 모든 정보 출력
SELECT * FROM EMP ORDER BY ENAME;
SELECT ROWNUM RN, A.*
    FROM (SELECT * FROM EMP ORDER BY ENAME) A;
SELECT *
    FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM EMP ORDER BY ENAME) A) 
    WHERE RN BETWEEN 6 AND 10;
--==============================================================================================================================================--    
    --  <총 연습문제>
    -- 1. 부서명과 사원명을 출력하는 용도의 뷰, DNAME_ENAME_VU 를 작성하시오
CREATE OR REPLACE VIEW DNAME_ENAME_VU 
    AS SELECT DNAME, ENAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO;
    
SELECT * FROM DNAME_ENAME_VU;

    -- 2. 사원명과 직속상관명을 출력하는 용도의 뷰,  WORKER_MANAGER_VU를 작성하시오
CREATE OR REPLACE VIEW WORKER_MANAGER_VU
    AS SELECT W.ENAME WORKER, M.ENAME MANAGER FROM EMP W, EMP M WHERE W.MGR=M.EMPNO;
    
SELECT * FROM WORKER_MANAGER_VU;
    
    -- 3. 부서별 급여합계 등수를 출력하시오(부서번호, 급여합계, 등수). -- 학생 질문
SELECT DEPTNO, SUM(SAL) FROM EMP GROUP BY DEPTNO;
SELECT ROWNUM RANK, A.*
    FROM (SELECT DEPTNO, SUM(SAL) FROM EMP GROUP BY DEPTNO ORDER BY SUM(SAL) DESC) A;
    
    -- 3-1. 부서별 급여합계 등수가 2~3등인 부서번호, 급여합계, 등수를 출력하시오.
SELECT DEPTNO, SUM(SAL) SUMSAL FROM EMP GROUP BY DEPTNO ORDER BY SUMSAL DESC;
SELECT *
FROM (SELECT ROWNUM RN, DEPTNO, SUMSAL
    FROM (SELECT DEPTNO, SUM(SAL) SUMSAL FROM EMP GROUP BY DEPTNO ORDER BY SUMSAL DESC))
    WHERE RN BETWEEN 2 AND 3;
    
    -- 4. 사원테이블에서 사번, 사원명, 입사일을 입사일이 최신에서 오래된 사원 순으로 정렬하시오
SELECT EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC;

    -- 5. 사원테이블에서 사번, 사원명, 입사일을 입사일이 최신에서 오래된 사원 5명을 출력하시오
SELECT ROWNUM, EMPNO, ENAME, HIREDATE
    FROM (SELECT ROWNUM RN, EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC)
    WHERE ROWNUM <= 5;
    
    -- 6. 사원 테이블에서 사번, 사원명, 입사일을 최신부터 오래된 순으로 6번째로 늦은 사원부터 10번째 사원까지 출력
SELECT ROWNUM, RN, EMPNO, ENAME, HIREDATE
    FROM (SELECT ROWNUM, RN, EMPNO, ENAME, HIREDATE FROM (SELECT ROWNUM RN, EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC))
    WHERE RN BETWEEN 6 AND 10;
--==============================================================================================================================================--

    
    
    
    
    