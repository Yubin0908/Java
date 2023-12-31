--  연 습 문 제 (DDL, INSERT, DROP TABLE, INSERT, UPDATE, DELETE, COMMIT) --

  -- MY_DATA 테이블생성
CREATE TABLE MY_DATA (
  ID NUMBER(4) PRIMARY KEY,
  NAME VARCHAR2(10),
  USERID VARCHAR2(30),
  SALARY NUMBER(10,2)
);

SELECT * FROM MY_DATA;

  -- 데이터 추가
INSERT INTO MY_DATA (ID, NAME, USERID, SALARY) VALUES (1, 'Scott', 'sscott', 10000);
INSERT INTO MY_DATA VALUES (2, 'Ford', 'fford', 13000);
INSERT INTO MY_DATA VALUES (3, 'Patel', 'ppatel', 33000 );
INSERT INTO MY_DATA VALUES (4, 'Report', 'rreport', 23000);
INSERT INTO MY_DATA VALUES (5, 'Good', 'ggood', 44450);

  -- 데이터 출력
SELECT ID, NAME, USERID, TO_CHAR(SALARY, '999,999.99')
  FROM MY_DATA;

COMMIT;

  -- UPDATE(5)
UPDATE MY_DATA SET SALARY = 65000 
    WHERE ID = 3;

SELECT * FROM MY_DATA;
COMMIT;

  -- DELETE (6)
DELETE FROM MY_DATA WHERE NAME='Ford';
COMMIT;

  -- UPDATE(7)
UPDATE MY_DATA SET SALARY = 15000
    WHERE SALARY <= 15000;

  -- 테이블 삭제
DROP TABLE MY_DATA;


