-- TABLE DROP & CREATE
DROP TABLE MVC_MEMBER;

CREATE TABLE MVC_MEMBER (
  MID VARCHAR2(30) PRIMARY KEY,
  MPW VARCHAR2(30) NOT NULL,
  MNAME VARCHAR2(30) NOT NULL,
  MEMAIL VARCHAR2(30),
  MPHOTO VARCHAR2(30) NOT NULL,
  MBIRTH DATE,
  MADDRESS VARCHAR2(300),
  MRDATE DATE DEFAULT SYSDATE NOT NULL
);

-- DUMMY DATA
INSERT INTO MVC_MEMBER (mID, mPw, mName, mEmail, mPhoto, mBirth, mAddress)
    VALUES ('gayun','1','김가연','gayun@naver.com','gayun.jpg','1972/09/09','광주광역시');
INSERT INTO MVC_MEMBER (mID, mPw, mName, mEmail, mPhoto, mBirth, mAddress)
    VALUES ('gico','1','지코','gico@naver.com','gico.jpg','1992/09/14','서울시');
INSERT INTO MVC_MEMBER (mID, mPw, mName, mEmail, mPhoto, mBirth, mAddress)
    VALUES ('go','1','고소영','go@naver.com','go.jpg','1972/10/06','서울시');
INSERT INTO MVC_MEMBER (mID, mPw, mName, mEmail, mPhoto, mBirth, mAddress)
    VALUES ('son','1','손흥민','son@naver.com','son.jpg','1992/07/08','강원도');
INSERT INTO MVC_MEMBER (mID, mPw, mName, mEmail, mPhoto, mBirth, mAddress)
    VALUES ('han','1','한지민','han@naver.com','han.jpg','1982/11/05','서울시');
SELECT * FROM MVC_MEMBER ORDER BY mRDATE DESC;

-- dao에 들어갈 query
-- (1) 회원id 중복체크
SELECT * FROM MVC_MEMBER WHERE MID = 'gayun';
-- (2) 회원가입
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS) 
  VALUES ('sample', '1', '샘플계정', 'sample@sam.ple', 'NOIMG.JPG', '2023/01/02', '인터넷');
-- (3) 로그인
SELECT * FROM MVC_MEMBER WHERE MID = 'gayun' AND MPW = '1';
-- (4) mid로 dto가져오기(로그인 성공시 session에 넣기 위함)
SELECT * FROM MVC_MEMBER WHERE MID = 'gayun';
-- (5) 회원정보 수정
UPDATE MVC_MEMBER SET 
  MPW = '2',
  MNAME = '샘플수정',
  MEMAIL = 'sample@sample.net',
  MPHOTO = 'NOIMG.JPG',
  MBIRTH = '2023/01/02',
  MADDRESS = '경기도'
  WHERE MID = 'sample';
-- (6) 회원리스트(top-N구문)
SELECT *
  FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM MVC_MEMBER) A)
  WHERE RN BETWEEN 1 AND 3;
-- (7) 회원수
SELECT COUNT(*) CNT FROM MVC_MEMBER;
-- (8) 회원탈퇴
DELETE FROM MVC_MEMBER WHERE MID = 'sample';

COMMIT;

SELECT * FROM MVC_MEMBER;

ROLLBACK;

