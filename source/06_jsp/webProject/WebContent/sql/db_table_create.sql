CREATE DATABASE ANIMAL;
USE ANIMAL;
-- MEMBER TABLE --
DROP TABLE MEMBER;
CREATE TABLE MEMBER (
	ID VARCHAR(20) PRIMARY KEY,
    PW VARCHAR(20) NOT NULL,
    NAME VARCHAR(50) NOT NULL,
    TEL1 VARCHAR(10),
    TEL2 VARCHAR(10),
    TEL3 VARCHAR(10),
    EMAIL VARCHAR(50) NOT NULL,
    NICKNAME VARCHAR(20),
    ANAME VARCHAR(50),
    ADATE DATE,
    ADDRESS VARCHAR(200),
    RDATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- DUMMY DATE
INSERT INTO MEMBER (ID, PW, NAME, TEL1, TEL2, TEL3,EMAIL, NICKNAME, ANAME, ADATE, ADDRESS) VALUES ('hong','aaa','홍길동','010','1234','5678','hong@naver.com','아빠','cat','2014-09-08','서울 서대문구'); 

-- TABLE CHECK
SELECT * FROM MEMBER;

-- query
-- login check
SELECT PW FROM MEMBER WHERE ID='hong';
 ----------------------------------------------------------------
-- DOG TABLE
DROP TABLE DOG;
CREATE TABLE DOG (
	DOGID INT AUTO_INCREMENT PRIMARY KEY,
    ID VARCHAR(20),
    DOGTYPE VARCHAR(50) NOT NULL,
    DOGAGE NUMERIC(2) NOT NULL,
    DOGPRICE VARCHAR(10) NOT NULL,
    DOGIMG BLOB,
    FOREIGN KEY (ID) REFERENCES MEMBER(ID)
);
SELECT * FROM DOG;


INSERT INTO DOG (ID, DOGTYPE, DOGAGE, DOGPRICE) VALUES ('hong', '진도개',2,'200000');

