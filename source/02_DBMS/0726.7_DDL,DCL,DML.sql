-- DDL//DCL//DML
-- DDL(테이블 생성, 삭제, 구조변경, 데이터 제거)
-- DML(SELECT, INSERT, UPDATE, DELETE)
-- DCL(계정추가, 권한부여, 권한해제, 계정삭제, TCL)
--=========================================================================================================================--
-- [1] DDL ( 테이블 생성, 삭제, 구조변경, 데이터 제거 )
  -- 테이블 생성 ( CREATE TABLE 테이블명 ~ ) : 테이블 구조를 정의
CREATE TABLE BOOK (
  BOOKID NUMBER(4), -- BOOKID 필드의 타입은 숫자4자리
  BOOKNAME VARCHAR2(20), -- BOOKNAME 필드의 타입은 문자20BYTE
  PUBLISHER VARCHAR2(20), -- BOOKNAME 필드의 타입은 문자20BYTE 
  RDATE DATE, -- RDATE 필드의 타입은 DATE
  PRICE NUMBER(7,2), -- PRICE 필드의 타임은 숫자 전체 7자리, 소수점 이하는 2자리 + 소수점 앞은 5자리
  PRIMARY KEY(BOOKID) -- 제약조건 : BOOKID필드가 PRIMARY KEY(주키) : UNIQUE, NOT NULL
  );
  
  CREATE TABLE BOOK (
  BOOKID NUMBER(4) PRIMARY KEY, -- PRIMARY KEY 지정하는 방법 2
  BOOKNAME VARCHAR2(20),
  PUBLISHER VARCHAR2(20), 
  RDATE DATE, 
  PRICE NUMBER(7,2)
  );

  -- DEPT01 : DEPTNO(수2:PK), DNAME(문자14), LOC(문자13)
CREATE TABLE DEPT01 (
  DEPTNO NUMBER(2) PRIMARY KEY,
  DNAME VARCHAR2(14),
  LOC VARCHAR2(13)
  );

SELECT * FROM DEPT01;
  -- EMP01 : EMPNO(수4:PK), ENAME(문자10), SAL(수7,2), DEPTNO(수2:FK)
CREATE TABLE EMP01 (
  EMPNO NUMBER(4) PRIMARY KEY,
  ENAME VARCHAR2(10),
  SAL NUMBER(7,2),
  DEPTNO NUMBER(2) REFERENCES DEPT01(DEPTNO)
  );
  
SELECT * FROM EMP01;

  -- 서브쿼리를 이용한 테이블 생성
  -- EMP02 == EMP
CREATE TABLE EMP02
  AS SELECT * FROM EMP;  -- 서브쿼리 결과로 EMP02 테이블 생성 후 데이터로 들어감(제약조건 미포함)
  
SELECT * FROM EMP02;

  -- EMP03 == EMP의 특정필드
CREATE TABLE EMP03
  AS SELECT EMPNO, ENAME, DEPTNO FROM EMP; -- EMP테이블의 EMPNO, ENAME, DEPTNO만 추출한 데이터가 EMP03

SELECT * FROM EMP03;

  -- EMP04 == EMP의 특정 행
CREATE TABLE EMP04
  AS SELECT * FROM EMP WHERE DEPTNO=10; -- EMP테이블에서 10번 부서의 데이터만 추출해서 EMP04

SELECT * FROM EMP04;

  -- EMP05 == EMP 구조만 추출(데이터 추출X)
CREATE TABLE EMP05
  AS SELECT * FROM EMP WHERE 1=0;
  
SELECT * FROM EMP05;

SELECT ROWNUM, EMPNO,ENAME FROM EMP;  -- ROWNUM : 테이블에서 행의 읽어들인 순서



  -- 테이블 삭제 ( DROP TABLE 테이블 명 )
DROP TABLE BOOK;


  -- 테이블 구조변경 (ALTER TABLE 테이블명 ADD || MODIFY || DROP ~)
  -- (1) 필드 추가(ADD)
SELECT * FROM EMP03;  -- EMPNO(NUM4), ENAME(VAR10), DEPTNO(NUM2)

ALTER TABLE EMP03 ADD (
  JOB VARCHAR2(20),
  SAL NUMBER(7)
  );
  
SELECT * FROM EMP03;

  -- (2) 필드 수정(MODIFY)
ALTER TABLE EMP03 MODIFY (  
  EMPNO VARCHAR2(4) -- 숫자데이터가 들어있어 숫자로만 변경 가능(숫자보다 큰 사이즈로만 변경가능)
);

ALTER TABLE EMP03 MODIFY (
  EMPNO NUMBER(5)
);

ALTER TABLE EMP03 MODIFY (
  JOB NUMBER(5)   -- NULL인 필드는 마음대로 수정 가능
);

SELECT MAX(LENGTH(ENAME)) FROM EMP03; -- EMP03의 ENAME는 6글자가 최장길이

ALTER TABLE EMP03 MODIFY (
  ENAME VARCHAR(6)  -- 문자데이터를 늘리거나 줄이는데는 기준데이터에 따라 가능하거나 불가능 할 수 있다.
);

  -- (3) 필드 삭제(DROP)
ALTER TABLE EMP03 DROP COLUMN JOB; -- JOB 필드 삭제

SELECT * FROM EMP03;

ALTER TABLE EMP03 DROP COLUMN DEPTNO;

SELECT * FROM EMP03;

  -- (4) 테이블 삭제(DROP TABLE 테이블명)
DROP TABLE EMP01;

SELECT * FROM EMP01;

DROP TABLE DEPT; -- EMP테이블에서 DEPT의 DEPTNO를 참조하는경우, EMP테이블을 삭제한 후 DEPT를 삭제

  -- (5) 테이블의 모든 행을 제거(TRUNCATE TABLE 테이블명)
SELECT * FROM EMP03;

TRUNCATE TABLE EMP03; -- ROLLBACK 불가능

  -- (6) 테이블명 변경(RENAME 테이블명 TO 바꿀테이블명
SELECT * FROM EMP02;

RENAME EMP02 TO EMP2;

SELECT * FROM EMP2;

-- 데이터 딕셔너리(데이터베이스 자원을 효율적으로 관리하기 위한 시스템테이블 : 접근 불가)
  -- 데이터 딕셔너리 뷰 (가상테이블 : 접근 가능)의 종류
  -- (1) USER_XXX : 현 계정에서 소유하고 있는 객체(테이블, 제약조건, 뷰, 인덱스)
SELECT * FROM USER_TABLES;
SELECT * FROM USER_CONSTRAINTS;
SELECT * FROM USER_VIEWS;
SELECT * FROM USER_INDEXES;
  
  -- (2) ALL_XXX : 현 계정에서 접근가능한 객체(테이블, 제약조건, 뷰, 인덱스)
SELECT * FROM ALL_TABLES;
SELECT * FROM ALL_CONSTRAINTS;
SELECT * FROM ALL_VIEWS;
SELECT * FROM ALL_INDEXES;

  -- (3) DBA_XXX : DBA권한에서만 접근 가능 DBMS의 모든 객체(테이블. 제약조건, 뷰, 인덱스)
SELECT * FROM DBA_TABLES;
SELECT * FROM DBA_CONSTRAINTS;
SELECT * FROM DBA_VIEWS;
SELECT * FROM DBA_INDEXES;
--=========================================================================================================================--
-- [2] DML
  -- INSERT INTO 테이블명 VALUES (값1, 값2, ~)
  -- INSERT INTO 테이블명 (필드명1, 필드명2, ~) VALUES (값1, 값2, ~) - 원하는 필드에만 데이터 추가할때(그 이외값 = NULL)
SELECT * FROM DEPT01;

INSERT INTO DEPT01 VALUES (50, 'ACCOUNTING', 'SEOUL');
INSERT INTO DEPT01 VALUES (60, 'SALES', NULL); -- 명시적으로 NULL 추가
INSERT INTO DEPT01 (DEPTNO, DNAME, LOC) VALUES (70, 'RESEARCH', '서대문');
INSERT INTO DEPT01 (DEPTNO, DNAME) VALUES (80, 'IT'); -- 묵시적으로 NULL 추가(명시되지 않은 필드값은 NULL)
SELECT * FROM DEPT01;

COMMIT;
  
  -- 서브쿼리를 이용한 INSERT
  -- DEPT테이블의 10~30부서를 DEPT01로 INSERT

INSERT INTO DEPT01
  SELECT * FROM DEPT
  WHERE DEPTNO BETWEEN 10 AND 30;
  
SELECT * FROM DEPT01;
  
  -- UPDATE 테이블 SET 필드명1=값1, 필드명2=값2, ~ WHERE 조건;
              DROP TABLE EMP01;
              CREATE TABLE EMP01
                AS SELECT EMPNO, ENAME, SAL, HIREDATE,DEPTNO FROM EMP;

  -- EX. 부서번호를 30으로 수정
UPDATE EMP01 SET DEPTNO=30; -- WHERE절 없이 변경 시 모든 데이터의 DEPTNO가 변경됨
  
  -- EX. 모든 직원(EMP01)의 급여를 10% 인상
UPDATE EMP01 SET SAL = SAL*1.1;

  -- EX. EMP01에서 10번부서 직원의 입사일을 오늘, 부서번호는 30번으로 수정
UPDATE EMP01 SET HIREDATE=SYSDATE, DEPTNO=30 WHERE DEPTNO=10;
  
  -- EX. 급여가 3000이상인 사원만 급여를 10%인상
UPDATE EMP01 SET SAL = SAL*1.1 WHERE SAL >= 3000;
  
  -- EX. DALLAS에서 근무하는 직원들의 급여을 1000인상
UPDATE EMP01 SET SAL = SAL+1000 
  WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE LOC='DALLAS');
  
  -- EX. SCOTT의 부서번호를 20으로, 직급을 MANAGER로 수정
UPDATE EMP SET DEPTNO=20, JOB='MANAGER' WHERE ENAME='SCOTT';
  
  -- EX. 급여가 1500이하인 직원의 급여를 1500으로 수정
UPDATE EMP01 SET SAL = 1500 WHERE SAL <= 1500;
  
  -- EX. 모든 사원의 급여와 입사일을 'KING'의 급여와 입사일로 수정
UPDATE EMP01 SET SAL = (SELECT SAL FROM EMP01 WHERE ENAME='KING'), HIREDATE 
  =  (SELECT HIREDATE FROM EMP01 WHERE ENAME='KING');
  
UPDATE EMP01 SET (SAL, HIREDATE) = (SELECT SAL,HIREDATE FROM EMP01 WHERE ENAME='KING');
  
SELECT * FROM EMP01;
ROLLBACK;

--=========================================================================================================================--
  -- ☆ 연 습 문 제 ☆
  
  -- 테이블 생성 --
CREATE TABLE SAM01 (
  EMPNO NUMBER(4) PRIMARY KEY,
  ENAME VARCHAR2(10),
  JOB VARCHAR2(9),
  SAL NUMBER(7,2)
  );

SELECT * FROM SAM01;
DESC SAM01;

  -- 데이터 생성 --
INSERT INTO SAM01 VALUES (1000, 'APPLE', 'POLICE', 10000);
INSERT INTO SAM01 VALUES (1010, 'BANANA', 'NURSE', 15000);
INSERT INTO SAM01 VALUES (1020, 'ORANGE', 'DOCTER', 25000);
INSERT INTO SAM01 (EMPNO, ENAME, SAL) VALUES (1030, 'VERY', 25000);
INSERT INTO SAM01 (EMPNO, ENAME, JOB, SAL) VALUES (1040, 'CAT', NULL, 2000);

INSERT INTO SAM01
  SELECT EMPNO, ENAME, JOB, SAL FROM EMP
    WHERE DEPTNO=10;

COMMIT;

--=========================================================================================================================--