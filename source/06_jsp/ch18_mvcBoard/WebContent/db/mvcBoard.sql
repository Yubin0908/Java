-- Table 및 Sequence 제거
DROP TABLE MVC_BOARD;
DROP SEQUENCE MVC_BOARD_SEQ;

-- Table 및 Sequence 생성
CREATE TABLE MVC_BOARD (
  BID NUMBER(6) PRIMARY KEY,
  BNAME VARCHAR2(50) NOT NULL,
  BTITLE VARCHAR2(100) NOT NULL,
  BCONTENT VARCHAR2(4000),
  BDATE DATE DEFAULT SYSDATE NOT NULL,
  BHIT NUMBER(6) NOT NULL,
  BGROUP NUMBER(6) NOT NULL,
  BSTEP NUMBER(3) NOT NULL,
  BINDENT NUMBER(3) NOT NULL,
  BIP VARCHAR2(20) NOT NULL
);

CREATE SEQUENCE MVC_BOARD_SEQ 
  MAXVALUE 999999
  NOCYCLE NOCACHE;
  
-- dummy data (3개 이상 - 2개 원글 + 1개 답변글)
INSERT INTO MVC_BOARD (BID, BNAME, BTITLE, BCONTENT, BDATE, BHIT, BGROUP, BSTEP, BINDENT, BIP) VALUES (MVC_BOARD_SEQ.NEXTVAL, '작성자-1','더미데이터-1','니ㅏ러니런미러미러미',SYSDATE,0,MVC_BOARD_SEQ.CURRVAL,0,0,'128.0.0.1');
INSERT INTO MVC_BOARD (BID, BNAME, BTITLE, BCONTENT, BDATE, BHIT, BGROUP, BSTEP, BINDENT, BIP) VALUES (MVC_BOARD_SEQ.NEXTVAL, '작성자-2','더미데이터-2','니ㅏ러니런미러미러미',SYSDATE,0,MVC_BOARD_SEQ.CURRVAL,0,0,'128.0.0.2');
INSERT INTO MVC_BOARD (BID, BNAME, BTITLE, BCONTENT, BDATE, BHIT, BGROUP, BSTEP, BINDENT, BIP) VALUES (MVC_BOARD_SEQ.NEXTVAL, '답변자-2','더미데이터-4','니ㅏ러니런미러미러미',SYSDATE,0,2,0,0,'125.0.0.1');

-- dao에 들어갈 쿼리
-- 1. 글목록(startRow ~ EndRow)
SELECT * FROM
  (SELECT ROWNUM RN, A.* FROM (SELECT * FROM MVC_BOARD ORDER BY BGROUP DESC) A)
  WHERE RN BETWEEN 1 AND 3;
-- 2. 글갯수
SELECT COUNT(*) FROM MVC_BOARD;
-- 3. 원글쓰기(bname, btitle, bcontent, bip - 사용자로부터 입력받은내용)
INSERT INTO MVC_BOARD (BID, BNAME, BTITLE, BCONTENT, BDATE, BHIT, BGROUP, BSTEP, BINDENT, BIP) VALUES (MVC_BOARD_SEQ.NEXTVAL, '작성자-1','더미데이터-1','니ㅏ러니런미러미러미',SYSDATE,0,MVC_BOARD_SEQ.CURRVAL,0,0,'128.0.0.1');
-- 4. bid로 조회수 1올리기
UPDATE MVC_BOARD SET BHIT = BHIT + 1 WHERE BID = 1;
-- 5. bid로 dto 가져오기
SELECT * FROM MVC_BOARD WHERE BID = 1;
-- 6. 글수정(특정 bid의 bname, btitle, bcontent, bip 수정)
UPDATE MVC_BOARD SET
  BNAME = '수정된 작성자-1',
  BTITLE = '수정된 데이터-1',
  BCONTENT = '수정수정수정수정수정',
  BIP = 'LOCALHOST'
  WHERE BID = 1;
-- 7. 글삭제(특정 bid 삭제)
DELETE FROM MVC_BOARD WHERE BID = 0;
-- 8. 답변글 저장 전단계(엑셀 ⓐ 단계)
UPDATE MVC_BOARD SET BSTEP=BSTEP+1 WHERE BGROUP=2 AND BSTEP>1;
-- 9. 답변글 저장
INSERT INTO MVC_BOARD (BID, BNAME, BTITLE, BCONTENT, BDATE, BHIT, BGROUP, BSTEP, BINDENT, BIP) VALUES (MVC_BOARD_SEQ.NEXTVAL, '답변자-2','더미데이터-4','니ㅏ러니런미러미러미',SYSDATE,0,2,1,1,'125.0.0.1');
SELECT * FROM MVC_BOARD;
COMMIT;
ROLLBACK;