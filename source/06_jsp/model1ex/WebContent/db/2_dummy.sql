-- dummy data
-- book dummy
INSERT INTO BOOK (bID, bTITLE, bPRICE, BIMG1, BIMG2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '쳇GPT 혁명',16000,'100.jpg','noImg.png','좋아',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, BIMG1, BIMG2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '주린이가 가장 알고 싶은 최대질문Top77',20000,'101.jpg','noImg.png','태영호 증언',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, BIMG1, BIMG2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '공정하다는 착각',14000,'102.jpg','noImg.png','좋아',5);
INSERT INTO BOOK (bID, bTITLE, bPRICE, BIMG1, BIMG2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '부의 대이동',16000,'103.jpg','noImg.png','좋아',5);
INSERT INTO BOOK (bID, bTITLE, bPRICE, BIMG1, BIMG2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '컨버전스 2030',11500,'104.jpg','noImg.png','좋아',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, BIMG1, BIMG2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '내면소통',13000,'105.jpg','noImg.png','좋아',30);
INSERT INTO BOOK (bID, bTITLE, bPRICE, BIMG1, BIMG2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '꽤 괜찮은 해피엔딩',13500,'106.jpg','noImg.png','좋아',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, BIMG1, BIMG2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '결국 무엇이든 해내는 사람',33000,'107.jpg','noImg.png','좋아',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, BIMG1, BIMG2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, 'JSP',20000,'108.jpg','noImg.png','좋아',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, BIMG1, BIMG2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '마지막 몰입',18000,'109.jpg','noImg.png','좋아',5);
INSERT INTO BOOK (bID, bTITLE, bPRICE, BIMG1, BIMG2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, 'SQL',17000,'110.jpg','noImg.png','좋아',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, BIMG1, BIMG2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '세이노의 가르침',1600,'111.jpg','noImg.png','좋아',30);
INSERT INTO BOOK (bID, bTITLE, bPRICE, BIMG1, BIMG2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '기후로 다시 읽는 세계사',2000,'112.jpg','noImg.png','2020 트렌드 키워드 ',15);
INSERT INTO BOOK (bID, bTITLE, bPRICE, BIMG1, BIMG2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, 'ADSP 데이터분석 준전문가',1800,'113.jpg','noImg.png','김영하의 여행 경험',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, BIMG1, BIMG2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, 'HTML5',2000,'114.jpg','noImg.png','좋다 ',10);
    COMMIT;
-- customer dummy
INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CBIRTH, CGENDER) VALUES ('777', '111', '신길동', '010-0000-1234', 'shin@ko.kr', '서울 구로구', '2014-09-09', 'm');
INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CBIRTH, CGENDER) VALUES ('888', '222', '김길동', '010-0000-5678', 'kim@ko.kr', '서울 구로구', '2010-07-09', 'm');
INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CBIRTH, CGENDER) VALUES ('999', '333', '고길동', '010-0000-9101', 'go@ko.kr', '서울 구로구', '205-08-13', 'm');
-- file board dummy
INSERT INTO FILEBOARD (fid, cid, ftitle, fcontent, filename, fhit, fpw, fgroup, fstep, findent, fip) VALUES (FILEBOARD_SEQ.NEXTVAL,'444', 'title', '내용요요요요요용', 'noImg.png', 0, '111', FILEBOARD_SEQ.CURRVAL, 0, 0, '14.96.4.21');
INSERT INTO FILEBOARD (fid, cid, ftitle, fcontent, filename, fhit, fpw, fgroup, fstep, findent, fip) VALUES (FILEBOARD_SEQ.NEXTVAL,'555', 'title1', '글1의 답변', 'noImg.png', 0, '222', FILEBOARD_SEQ.CURRVAL, 0, 0, '14.96.4.54');
INSERT INTO FILEBOARD (fid, cid, ftitle, fcontent, filename, fhit, fpw, fgroup, fstep, findent, fip) VALUES (FILEBOARD_SEQ.NEXTVAL,'666', 'title2', '내용요요요요요용', 'noImg.png', 0, '333', FILEBOARD_SEQ.CURRVAL, 0, 0, '187.96.4.0');