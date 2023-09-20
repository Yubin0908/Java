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
                
                commit;