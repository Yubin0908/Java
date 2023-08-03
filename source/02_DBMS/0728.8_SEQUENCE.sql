-- Sequence : 순차번호 생성기, 대부분의 인위적인 PK사용용도

DROP SEQUENCE FRIEND_SEQ;

CREATE SEQUENCE FRIEND_SEQ 
  START WITH 1 -- 1부터 시작 (START WITH 안하면 DEFAULT 1)
  INCREMENT BY 1 -- 1씩 증가(DEFAULT)
  MAXVALUE 9999 -- 최댓값
  MINVALUE 1  -- 최솟값(DEFAULT)
  NOCACHE   -- 캐쉬 생성 안함
  NOCYCLE;  -- 최대값 초과 시, 사이클 안함
  
--===========================================================================================================================================--
  -- Sequence 사용 --
SELECT FRIEND_SEQ.NEXTVAL FROM DUAL;  -- 순차번호 생성
SELECT FRIEND_SEQ.CURRVAL FROM DUAL;  -- 시퀀스의 현재값
DROP SEQUENCE FRIEND_SEQ;

CREATE SEQUENCE FRIEND_SEQ
  MAXVALUE 99999
  NOCACHE
  NOCYCLE;
  
CREATE TABLE FRIEND (
  NO NUMBER(5) PRIMARY KEY, -- 시퀀스를 사용해서 값이 들어갈 필드.
  NAME VARCHAR2(30) NOT NULL,
  TEL VARCHAR2(20) UNIQUE,
  ADDRESS VARCHAR2(255),
  LAST_MODIFY DATE DEFAULT SYSDATE
  );
  
INSERT INTO FRIEND (NO, NAME, TEL, ADDRESS) 
      VALUES (FRIEND_SEQ.NEXTVAL, '홍길동', NULL, '서울 서대문'); -- 몇번을 실행해도 가능 
INSERT INTO FRIEND (NO, NAME, TEL, ADDRESS) VALUES (FRIEND_SEQ.NEXTVAL, NULL, '010-9999-9999', '서울 마포'); -- NOT NULL 
INSERT INTO FRIEND (NO, NAME, TEL, ADDRESS) VALUES (FRIEND_SEQ.NEXTVAL, '홍길순', '010-9999-8888', '서울 영등포');
INSERT INTO FRIEND (NO, NAME, TEL, ADDRESS) VALUES (FRIEND_SEQ.NEXTVAL, '신길동', '010-9999-9999', '서울 마포'); -- UNIQUE


SELECT * FROM FRIEND;

  -- EX. 초기값 101부터 최대값 999,999까지 1씩 증가하는 TEST_SEQ 시퀀스를 생성하고 시퀀스를 사용하시오.
CREATE SEQUENCE TEST_SEQ
  START WITH 101
  MAXVALUE 999999
  NOCACHE
  NOCYCLE;
  
SELECT TEST_SEQ.CURRVAL FROM DUAL; -- 시퀀스 사용전에는 현재값을 조회할 수 없음.
SELECT TEST_SEQ.NEXTVAL FROM DUAL;

  -- EX. 시퀀스 NO_SEQ 초기값 1 ~ 최대값 999까지 1씩 증가
    -- SYSDATE : 'RRMMDD' 추출 
    DROP SEQUENCE NO_SEQ;
CREATE SEQUENCE NO_SEQ
  MAXVALUE 999
  NOCACHE
  NOCYCLE;

SELECT TO_CHAR(SYSDATE, 'RRMMDD')
  FROM DUAL;  -- '230728'
SELECT TO_CHAR(NO_SEQ.NEXTVAL, '000')
  FROM DUAL;
  
SELECT TO_CHAR(SYSDATE, 'RRMMDD')||TO_CHAR(NO_SEQ.NEXTVAL, '000')  -- '030728 000'
  FROM DUAL;
 SELECT TO_CHAR(SYSDATE, 'RRMMDD')||TRIM(TO_CHAR(NO_SEQ.NEXTVAL, '000')) NO -- '230728000'
  FROM DUAL; 
--===========================================================================================================================================--
  -- 시퀀스 문제 --
  
  
  
  
  
  
  
  
  