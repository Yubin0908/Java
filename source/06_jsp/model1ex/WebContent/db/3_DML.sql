-- 1. 책등록
INSERT INTO BOOK (bID, bTITLE, bPRICE, BIMG1, BIMG2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?);
-- 2. 책목록(NOT PAGING)
SELECT * FROM BOOK ORDER BY BRDATE DESC;
-- 2. 책목록(TOP-N)
SELECT ROWNUM RN, A.*
  FROM (SELECT * FROM BOOK ORDER BY BRDATE DESC) A; -- 1단계
  
SELECT * 
  FROM (SELECT ROWNUM RN, A.*
        FROM (SELECT * FROM BOOK ORDER BY BRDATE DESC) A)
        WHERE RN BETWEEN 11 AND 20; -- 최종 쿼리
        
-- 등록된 책 갯수        
SELECT COUNT(*) CNT FROM BOOK;
-- 3. 책 상세보기(BID로 DTO가져오기)
SELECT * FROM BOOK WHERE BID=1;

---------------------------------------------------------------------------------------------------------------------------------------------------

SELECT * FROM CUSTOMER;

-- 회원가입 시 중복체크
SELECT CPW FROM CUSTOMER WHERE CID='kim';

-- 회원가입
INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CBIRTH, CGENDER)
  VALUES ('kim', '1234', '김길동', '02-393-0512', 'kim@google.com', '서울 서대문구', '2014-01-20', 'f');

-- 로그인 id pw 체크
SELECT CPW FROM CUSTOMER WHERE CID='kim';

-- 회원정보 수정
UPDATE CUSTOMER SET CPW='111', CNAME='신길동',CTEL='010-0000-1234',CEMAIL='sin@SIN.GO.KR',CADDRESS='INCHONE',CBIRTH='2014-09-08',CGENDER='f' 
                WHERE CID='kim';
-- 회원리스트 public ArrayList<CustomerDto> listCustomer (startRow, endRow) : cid순으로 정렬'
SELECT CID, CPW, CNAME, CEMAIL, CADDRESS
  FROM CUSTOMER
  ORDER BY CID;
-- 가입한 회원 수 public int getCustomerTotalCnt()
SELECT COUNT(*) CNT FROM CUSTOMER;
---------------------------------------------------------------------------------------------------------------------------------------------------
-- FileBoardDao에 들어갈 query
-- 글목록(startRow ~ endRow) TOP-N
SELECT F.*, CNAME, CEMAIL
  FROM FILEBOARD F, CUSTOMER C
  WHERE F.CID = C.CID
  ORDER BY FGROUP DESC, FSTEP;
  
SELECT *
    FROM (SELECT ROWNUM RN, A.* 
        FROM (SELECT F.*, CNAME, CEMAIL FROM FILEBOARD F, CUSTOMER C 
          WHERE F.CID = C.CID
          ORDER BY FGROUP DESC, fSTEP) A)
  WHERE RN BETWEEN 1 AND 10;
-- 전체 글갯수
SELECT COUNT(*) CNT FROM FILEBOARD;

-- 글쓰기 : cid, 글제목, 본문, 첨부파일, 비번
INSERT INTO FILEBOARD (fid, cid, ftitle, fcontent, filename, fhit, fpw, fgroup, fstep, findent, fip) 
  VALUES (FILEBOARD_SEQ.NEXTVAL,'111', '글 1', NULL, NULL, NULL, '111', FILEBOARD_SEQ.CURRVAL, 0, 0, '14.96.4.21');
  
-- fid로 조회수 올리기
  UPDATE FILEBOARD SET  FHIT = FHIT + 1 WHERE FID = 1;
  
-- fid로 dto 가져오기
SELECT F.*, CNAME, CEMAIL FROM FILEBOARD F, CUSTOMER C 
  WHERE F.CID = C.CID AND FID=1
  ORDER BY fGROUP DESC, fSTEP;

-- 글 수정
  UPDATE FILEBOARD SET
    FTITLE = '글 3',
    FCONTENT = '내용입력됨',
    FPW = '444',
    FIP = '127.0.0.1'
    WHERE FID=4;

-- 글 삭제 (need fid & fpw)
DELETE FROM FILEBOARD WHERE FID=4 AND FPW=444;

-- 답변글 쓰기 전단계
UPDATE FILEBOARD SET FSTEP=FSTEP+1 WHERE FGROUP=3 AND FSTEP>0;

-- 답변글 쓰기
INSERT INTO FILEBOARD (fid, cid, ftitle, fcontent, filename, fhit, fpw, fgroup, fstep, findent, fip) 
  VALUES (FILEBOARD_SEQ.NEXTVAL,'111', '글 3-1', '3-1의 답변글', NULL, NULL, '111', 3, 1, 1, '14.96.4.21');


SELECT * FROM CUSTOMER;
SELECT * FROM FILEBOARD;
SELECT * FROM BOOK ORDER BY BID DESC;
                commit;
                
                
                ROLLBACK;