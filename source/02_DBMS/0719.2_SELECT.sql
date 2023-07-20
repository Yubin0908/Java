  --[II] SELECT문 - 조회
  -- 1. SELECT 문장 작성법 (실행 : CTRL+EN)SQL은 대소문자 구분안함.
  
  SHOW USER;
  SELECT * FROM TAB; -- 한계점이 가지고 있는 테이블 정보
  SELECT * FROM EMP; -- emp테이블의 모든열(필드), 모든 행
  SELECT * FROM DEPT; --DEPT테이블의 모든 열(필드), 모든 행
  SELECT * FROM SALGRADE; --SALGRADE테이블의 모든 열(필드). 모든행
  
  -- 2. 특정 열만 출력
  DESC EMP; 
  --EMP테이블의 구조
  
  SELECT EMPNO, ENAME, SAL, JOB FROM EMP; 
  -- EMP테이블의 EMPNO, ENAME, SAL, JAB필드의 모든행
  
  SELECT EMPNO, ENAME, SAL, JOB, MGR, COMM FROM EMP;
  SELECT EMPNO AS "사 번", ENAME AS "이름", SAL AS "급여", JOB AS "직책" FROM EMP;
  SELECT EMPNO AS "사 번", ENAME AS 이름, SAL AS 급여, JOB AS 직책 FROM EMP;
  -- 필드의 별칭을 두는 경우
  SELECT EMPNO NO, ENAME NAME, SAL SALARY, JOB FROM EMP;
  
  --3. 특정 행 출력 : WHERE절(조건절) -- 비교연산자 " 같음(=), 다르다(!=, ^=, <>)
  SELECT EMPNO "사번", ENAME "이름", SAL "급여" FROM EMP WHERE SAL=3000; --같다
  SELECT EMPNO NO, ENAME ENAME, SAL FROM EMP WHERE SAL != 3000; --다르다
  SELECT EMPNO NO, ENAME ENAME, SAL FROM EMP WHERE SAL ^= 3000; --다르다
  SELECT EMPNO NO, ENAME ENAME, SAL FROM EMP WHERE SAL <> 3000; --다르다
  SELECT * FROM EMP WHERE SAL<3000;
  
      -- 비교연산자는 숫자(NUMBER), 문자(VARCHAR2), DATE 모두 가능.
      -- ex 사원이름(ENAME)이 'A', 'B', 'C'로 시작하는 사원의 모든 필드 출력.
      -- A < AA < AAA < AAAA < AAAA.. < B < BA < BAA..A < BB...
  SELECT * FROM EMP WHERE ENAME < 'D';
      -- EX2. 81년도이전에 입사한 사원의 모든 필드
  SELECT * FROM EMP WHERE HIREDATE < '81/01/10';
      -- EX3. 부서번호(DEPTNO)가 10번 부서인 사원의 모든 필드
  SELECT * FROM EMP WHERE DEPTNO = 10;
      -- EX4. 이름(ENAME)이 FORD인 직원의 사번(EMPNO), 이름(ENAME), 상사의 사번(MGR)을 출력
  SELECT EMPNO, ENAME, MGR FROM EMP WHERE ENAME = 'FORD';
      -- SQL문 대소문자 구별 없음, 데이터의 대소문자 구별
  SELECT empno,ename, mgr from emp where ename = 'FORD';
  
  -- 4. 조건절의 논리연산자 : AND, OR, NOT
    --EX1. 급여(SAL)가 2000이상, 3000이하인 직원의 모든 필드
  SELECT * FROM EMP WHERE SAL > 2000 AND SAL < 3000;
    --EX2. 82년도에 입사한 사원의 모든 필드
  SELECT * FROM EMP WHERE HIREDATE >= '82/01/01' AND HIREDATE <= '82/12/31';
  
    --날짜 표기법 셋팅 (현재 : YY/MM/DD 또는 RR/MM/DD)
  ALTER SESSION SET NLS_DATE_FORMAT = 'MM-DD-YYYY';
  SELECT * FROM EMP WHERE HIREDATE >= '01-01-1982' AND HIREDATE <= '12-31-1982';
  SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') >= '82/01/01' AND TO_CHAR(HIREDATE, 'RR/MM/DD') <= '82/12/31'; -- 단일행함수
  
  ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD';
  
    --EX3. 연봉이 2400이상인 직원의 ENAME, SAL, 연봉(SAL*12)을 출력
  SELECT ENAME, SAL, SAL*12 ANNUALSAL FROM EMP WHERE SAL*12 > 2400;
    --WHERE절에는 필드의 별칭 사용 불가.
    --EX4.연봉이 2400이상인 직원의 ENAME, SAL, 연봉(SAL*12)을 출력(연봉순으로)
  SELECT ENAME, SAL, SAL*12 ANNUALSAL FROM EMP WHERE SAL*12 > 2400 ORDER BY ANNUALSAL;
    --해석순서 FROM --> WHERE --> SELECT --> ORDER BY
    
    --EX5. 10번부서(DEPTNO)이거나 JOB이 MANAGER인 직원의 모든 필드
  SELECT * FROM EMP WHERE DEPTNO=10 OR JOB='MANAGER';
    --EX6. 부서번호가 10번 부서가 아닌 직원의 모든 필드
  SELECT * FROM EMP WHERE DEPTNO != 10;
  SELECT * FROM EMP WHERE DEPTNO ^= 10;
  SELECT * FROM EMP WHERE DEPTNO <> 10;
  SELECT * FROM EMP WHERE NOT DEPTNO = 10;
  
  -- 산술 연산자 (SELECT절, 조건절, ORDER BY절)
  SELECT EMPNO, ENAME, SAL 현재월급, SAL*1.1 올릴월급 FROM EMP;
    -- EX. 모든 사원의 이름(ENAME), 월급(SAL), 상여(COMM) 연봉(SAL*12+COMM)을 출력
  SELECT ENAME, SAL, COMM, SAL*12+COMM FROM EMP;
    -- 산술연산의 결과는 NULL을 포함하면 결과도 NULL
    --NVL(NULL일 수도 있는 필드명, 대체값)을 이용. 필드명과 대체값은 타입(문자, 숫자, 날짜)이 일치해야함.
  SELECT ENAME, SAL, COMM, SAL*12+NVL(COMM, 0) FROM EMP;
    --모든 사원의 SNAME, MGR(상사의 사번)을 출력(상사의 사번 없으면 -1)
  SELECT ENAME, NVL(MGR, -1) FROM EMP;
    --모든 사원의 SNAME, MGR(상사의 사번)을 출력(상사가 없으면 'CEO'라고 출력)
  SELECT ENAME, NVL(TO_CHAR(MGR), 'CEO') FROM EMP;
    --NUMBER --> VARCHAR2 변환 == TO_CHAR()
  
  
  -- 연결연산자(||) : 필드나 문자를 연결
  SELECT ENAME || '은(는) ' || JOB || '다' MESSAGE FROM EMP; 
    -- 모든 사원에 대해 SMITH : ANNUAL SALARY = XXX포맷으로 출력 (연봉 = SAL*12+COMM)
  SELECT ENAME || ': ANNUALSALARY = ' || (SAL*12+NVL(COMM, 0)) MESSAGE FROM EMP;
  
  -- 중복제거(DISTINCT)
  SELECT DISTINCT JOB FROM EMP;
  SELECT DISTINCT DEPTNO FROM EMP;
  
  
  ----- 연습문제 -----
  
    --1. emp 테이블의 구조 출력
  DESC EMP; 
    --2. emp 테이블의 모든 내용을 출력 
  SELECT * FROM EMP;  
    --3. 현 scott 계정에서 사용가능한 테이블 출력
  SELECT * FROM TAB;
    --4. emp 테이블에서 사번, 이름, 급여, 업무, 입사일 출력
  SELECT EMPNO, ENAME, SAL, JOB, HIREDATE FROM EMP; 
    --5. emp 테이블에서 급여가 2000미만인 사람의 사번, 이름, 급여 출력
  SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL < 2000;
    --6. 입사일이 81/02이후에 입사한 사람의 사번, 이름, 업무, 입사일 출력
  SELECT EMPNO, ENAME, JOB, HIREDATE FROM EMP WHERE HIREDATE >=  '81/02/01';
    --7. 업무가 SALESMAN인 사람들 모든 자료 출력
  SELECT * FROM EMP WHERE JOB='SALESMAN';
    --8. 업무가 CLERK이 아닌 사람들 모든 자료 출력
  SELECT * FROM EMP WHERE NOT JOB='CLERK';  
    --9. 급여가 1500이상이고 3000이하인 사람의 사번, 이름, 급여 출력
  SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL > 1500 AND SAL < 3000; 
    --10. 부서코드가 10번이거나 30인 사람의 사번, 이름, 업무, 부서코드 출력
  SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE DEPTNO=30 OR DEPTNO=10;
    --11. 업무가 SALESMAN이거나 급여가 3000이상인 사람의 사번, 이름, 업무, 부서코드 출력
  SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE JOB='SALESMAN' OR SAL > 3000;  
    --12. 급여가 2500이상이고 업무가 MANAGER인 사람의 사번, 이름, 업무, 급여 출력
  SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE SAL > 2500 AND JOB='MANAGER';
    --13.“ename은 XXX 업무이고 연봉은 XX다” 스타일로 모두 출력(연봉은 SAL*12+COMM)
  SELECT ENAME || '은(는)' || JOB || '업무이고 연봉은' || (SAL*12+NVL(COMM, 0)) || '다' MESSAGE FROM EMP;
      
      
  --SQL 연산자(BETWEEN, IN LIKE, IS NULL)
    -- (1) BETWEEN A AND B
    -- EX. 급여가 1500D이상이고 3000이하인 사람의 사번, 이름, 급여 출력
  SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL >= 1500 AND SAL <= 3000;
  SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL BETWEEN 1500 AND 3000;
    -- 급여가 1500미만, 3000초과인 사람의 모든 필드
  SELECT * FROM EMP WHERE SAL NOT BETWEEN 1500 AND 3000;
    -- 이름이 'A', 'B', 'C'로 시작하는 직원의 모든 필드
  SELECT * FROM EMP WHERE ENAME BETWEEN 'A' AND 'D' AND ENAME != 'D';
    -- 82년도에 입사한 직원의 모든 필드
  SELECT * FROM EMP WHERE HIREDATE BETWEEN '82/01/01' AND '82/12/31';
  
  
    -- (2) IN
    -- EX. 부서번호가 10, 20, 40번 부서인 직원의 모든 필드
  SELECT * FROM EMP WHERE DEPTNO=10 OR DEPTNO=20 OR DEPTNO=40;
  SELECT * FROM EMP WHERE DEPTNO IN(10,20,30);
    -- EX. 부서번호가 10, 20, 40번 부서를 제외한 직원의 모든 필드
  SELECT * FROM EMP WHERE DEPTNO!=10 AND DEPTNO!=20 AND DEPTNO!=40;
  SELECT * FROM EMP WHERE DEPTNO NOT IN (10,20,40);
    -- EX. 사원이 7902, 7788, 7566인 사원의 모든 정보
  SELECT * FROM EMP WHERE EMPNO IN (7902, 7788, 7566);
  
  
    -- (3) LIKE 패턴 :%(0글자 이상), _(1글자)을 포함한 패턴
    -- EX. 이름이 M으로 시작하는 사원의 모든 필드 
  SELECT * FROM EMP WHERE ENAME LIKE 'M%';
    -- EX. 이름에 'M'이 들어가는 사원의 모든 필드
  SELECT * FROM EMP WHERE ENAME LIKE '%M%'; -- M, ~M, M~, ~M~ 모두 포함.
    -- EX. 이름에 N이 들어있거나 JOB에 N이 들어가는 사원의 모든 필드.
  SELECT * FROM EMP WHERE ENAME LIKE '%N%' OR JOB LIKE '%N%';
    -- EX. 이름이 S로 끝나는 사원의 모든 필드
  SELECT * FROM EMP WHERE ENAME LIKE '%S';
    -- EX. 월급이 5로 끝나는 사원의 모든 필드
  SELECT * FROM EMP WHERE SAL LIKE '%5';
    -- EX. 82년도에 입사한 모든 사원의 필드
  SELECT * FROM EMP WHERE HIREDATE LIKE '%82%';
  SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') LIKE '82/__/__';
    -- EX. 1월에 입사한 사원의 모든 필드
  SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') LIKE '__/01/__';
  SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') LIKE '%/01/%';
  
  
    -- (4) IS NULL : 값이 NULL인지 확인(검색할떄)
    -- EX. 상여금(COMM)이 없는 사원의 모든 필드
  SELECT * FROM EMP WHERE COMM IS NULL OR COMM = 0;
    -- EX. 상여금이 있는 사원의 모든 필드
  SELECT * FROM EMP WHERE COMM IS NOT NULL AND COMM!=0;
  
    
    -- 정렬(오름차순, 내림차순)
    -- ORDER BY절
  SELECT ENAME, SAL, HIREDATE FROM EMP ORDER BY SAL; -- 급여 오름차순 정렬
  SELECT ENAME, SAL, HIREDATE FROM EMP ORDER BY SAL DESC; -- 급여 내림차순 정렬
  SELECT ENAME, SAL, HIREDATE FROM EMP ORDER BY SAL DESC, HIREDATE DESC; -- 급여 내림차순 (급여가 같은경우 최근 입사일 순으로 정렬)
  SELECT ENAME, SAL, HIREDATE FROM EMP ORDER BY SAL DESC, HIREDATE; -- 급여 내림차순 (급여가 같은경우 입사일 순으로 정렬)  
  SELECT ENAME, SAL, HIREDATE FROM EMP ORDER BY ENAME; -- 이름 오름차순 정렬
  SELECT ENAME, SAL, HIREDATE FROM EMP ORDER BY HIREDATE; -- 입사일 오름차순 정렬
  SELECT ENAME, SAL, HIREDATE FROM EMP ORDER BY HIREDATE DESC; -- 입사일 내림차순 정렬
  
  
  
    
    
    
    
    
  
  
  
  
  
  
  
  
  
  
  
  
  
