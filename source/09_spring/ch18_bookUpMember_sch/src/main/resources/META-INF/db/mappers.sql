 -- Mapper에 들어갈 Query
 -- Book.xml id = mainList (신작순서대로 bookList 출력)
 SELECT * FROM BOOK ORDER BY BRDATE;
 -- Book,xml id = bookList(책이름 가나다 순서대로 출력 TOP-N)
 SELECT * FROM
  (SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOOK ORDER BY BTITLE) A) 
  WHERE RN BETWEEN 1 AND 10;
 -- Book.xml id = totCntBook(책 갯수)
 SELECT COUNT(*) FROM BOOK;
 -- Book.xml id = getDetailBook (책 상세보기)
 SELECT * FROM BOOK WHERE BNUM = 1;
 -- Book.xml id = registerBook (bimg를 둘다 입력할 수도 하나만 입력할 수도 있고 안 할수도 있음)
 INSERT INTO BOOK VALUES (BOOK_SQ.NEXTVAL, 'JAVA의 모든것', '강작가', SYSDATE, 'noImg.png', 'noImg.png', '자바 개발 서적');
 -- Book.xml id = modifyBook (책 수정)
 UPDATE BOOK SET
   BTITLE = '모든 JAVA',
   BWRITER = '강선생',
   BRDATE = SYSDATE,
   BIMG1 = 'noImg.png',
   BIMG2 = 'noImg.png',
   BINFO = '자바 개발 서적'
   WHERE BNUM = 5;
 
 COMMIT;
 SELECT * FROM MEMBER;
 -- Member.xml id = idComfirm (resultType = int)
 SELECT * FROM MEMBER WHERE MID = 'aaa';
 -- Member.xml id = joinMember
 INSERT INTO MEMBER VALUES ('bbb', '111', '김길동', 'kim@naver.com', 12345, '경기');
 -- Member.xml id = getDetailMember
 SELECT * FROM MEMBER WHERE MID = 'bbb';
 -- Member.xml id = modifyMember
 UPDATE MEMBER SET 
   MPW = '111',
   MNAME = '김길동',
   MMAIL = 'kim2@naver.com',
   MPOST = 12123,
   MADDR = 'seoul'
   WHERE MID = 'bbb';

SELECT MID, MPW FROM MEMBER WHERE MID = 'aaa' AND MPW = '1';
   
   COMMIT;
   
 
 