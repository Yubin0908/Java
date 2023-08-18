 -- DROP TABLE --
DROP TABLE HUMAN;
DROP TABLE LEVELGRADE;
DROP TABLE DEPARTMENT;


 -- DROP SEQUENCE --
DROP SEQUENCE DEPARTMENT_NO_SQ;

 -- CEREATE SEQUENCE --
CREATE SEQUENCE DEPARTMENT_NO_SQ
MAXVALUE 999999
NOCACHE
NOCYCLE;

 -- CREATE TABLE --
CREATE TABLE DEPARTMENT (
    DEPTNO NUMBER(6) PRIMARY KEY,
    DNAME VARCHAR2(50) NOT NULL,
    LOCAL VARCHAR2(20) NOT NULL
    );
    
CREATE TABLE LEVELGRADE (
    LNO NUMBER(6) PRIMARY KEY,
    LNAME VARCHAR2(10) NOT NULL
    );
    
CREATE TABLE HUMAN (
    USERID VARCHAR2(20) PRIMARY KEY,
    UNAME VARCHAR2(50) NOT NULL,
    UPW VARCHAR2(50) NOT NULL,
    EMAIL VARCHAR2(50) NOT NULL,
    DEPTNO NUMBER(6) REFERENCES DEPARTMENT(DEPTNO),
    LNO NUMBER(6) REFERENCES LEVELGRADE(LNO)
    );
    

    
COMMIT;
SELECT * FROM DEPARTMENT;
SELECT * FROM HUMAN;
SELECT * FROM LEVELGRADE;

 -- DUMMY DATA INSERT --
INSERT INTO DEPARTMENT VALUES (DEPARTMENT_NO_SQ.NEXTVAL, '고양이주식회사', '경기도');
INSERT INTO DEPARTMENT VALUES (DEPARTMENT_NO_SQ.NEXTVAL, '고양이학교', '서울시');
INSERT INTO DEPARTMENT VALUES (DEPARTMENT_NO_SQ.NEXTVAL, '고양네트워크', '경상북도');

INSERT INTO LEVELGRADE VALUES (010011, '일반');
INSERT INTO LEVELGRADE VALUES (010012, '담당자');
INSERT INTO LEVELGRADE VALUES (010013, '관리자');



INSERT INTO HUMAN VALUES ('cat01', '삼색고양이', 'catpw', 'cat@cat.com', 1, 010011);
INSERT INTO HUMAN VALUES ('cat02', '치즈고양이', 'catpw', 'cat@cat.com', 1, 010013);
INSERT INTO HUMAN VALUES ('cat03', '턱시도고양이', 'catpw', 'cat@catnetwork.com', 3, 010012);
INSERT INTO HUMAN VALUES ('cat04', '치즈고양이', 'catpw', 'cat@catshool.com', 2, 010012);