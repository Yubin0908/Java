 -- 프로그램에 필요한 쿼리
 
    -- 1. 회원가입(고객전화와 고객이름은 입력받아 INSERT)
    -- public int insertCustomer(String ctel, String cname)
INSERT INTO CUSTOMER (CID, CTEL, CNAME) VALUES (CUSTOMER_CID_SQ.NEXTVAL, '010-6666-6666', '유길동');

COMMIT;
SELECT * FROM CUSTOMER;

    --  2. 폰뒤4자리(FULL) 검색(찾을 전화번호를 받아 CID, CTEL, CNAME, POINT, CAMOUNT, LEVELNAME, FORLEVELUP)
SELECT cID, CTEL, cNAME, POINT, CAMOUNT, LEVELNAME, HIGH+1-CAMOUNT FORLEVELUP FROM CUSTOMER C, CUS_LEVEL L WHERE C.LEVELNO=L.LEVELNO AND CTEL LIKE '%'||'9999';
    
    
    ----== MAIN QUERY ==----
SELECT cID, cTEL, cNAME, POINT, cAMOUNT, LEVELNAME,
    (SELECT HIGH+1-CAMOUNT FROM CUSTOMER WHERE LEVELNO != 5 AND CID=C.CID) FORLEVELNO
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO=L.LEVELNO AND CTEL LIKE '%'||'9999'
    ORDER BY CAMOUNT DESC, CID;
    
    
    -- 3. 물품구매(cID,PRICE를 받아, POINT와 cAMOUNT, LEVELNO 수정, 바뀐 cAMOUNT에 따라 LEVELNO 수정)
    -- 1단계. POINT 와 cAMOUNT 누적
UPDATE CUSTOMER SET POINT = POINT + (1000000 * 0.05),
                cAMOUNT = cAMOUNT + 1000000
                WHERE CID = 1;
    -- 2단계. 바뀐 cAMOUNT에 따라 LEVELNO 조정
SELECT cNAME, cAMOUNT, C.LEVELNO 현재레벨, L.LEVELNO 바뀔레벨, LOW, HIGH
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE cAMOUNT BETWEEN LOW AND HIGH AND CID=1;
    
SELECT L.LEVELNO 
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE cAMOUNT BETWEEN LOW AND HIGH AND CID=1   ;  -- UPDATE안에 SUBQUERY로 들어갈 부분
    
    --== MAIN QUERY ==--
UPDATE CUSTOMER SET LEVELNO = (SELECT L.LEVELNO 
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE cAMOUNT BETWEEN LOW AND HIGH AND CID=1)
    WHERE CID=1;
    
SELECT * FROM CUSTOMER WHERE CID=1;
    
    --== DAO에 들어갈 쿼리 (1+2단계) ==--
            --== MAIN QUERY ==--
UPDATE CUSTOMER SET POINT = POINT + (1000000 * 0.05), 
                cAMOUNT = cAMOUNT + 1000000,
                LEVELNO = (SELECT L.LEVELNO 
                           FROM CUSTOMER C, CUS_LEVEL L
                           WHERE cAMOUNT+1000000 BETWEEN LOW AND HIGH AND CID=1)
                WHERE CID=1;
    
ROLLBACK;
    
    -- 3번 물품구매 후 고객정보를 출력(cID, cTEL, cNAME, POINT, cAMOUNT, LEVELNAME, FORLEVELUP)
SELECT cID, cTEL, cNAME, POINT, cAMOUNT, LEVELNAME,
    (SELECT HIGH+1 cAMOUNT FROM CUSTOMER WHERE LEVELNO != 5 AND CID = C.CID) ForLevelUp
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO=L.LEVELNO AND CID = 1;
    
    
    -- 4-0번 전 고객등급별 출력
    -- public ArrayList<String> getLevelNames()
SELECT LEVELNAME FROM CUS_LEVEL;
    
    -- 4번 고객등급별(등급이름) 출력 
    -- levelname 입력받아 CID, CTEL, CNAME, POINT, CAMOUNT, LEVELNAME, FORLEVELUP
    -- public ArrayList<CustomerDto> levelNameGetCustomers(String levelName)
SELECT cID, cTEL, cNAME, POINT, cAMOUNT, LEVELNAME,
       (SELECT HIGH+1-cAMOUNT FROM CUSTOMER 
                              WHERE LEVELNO != 5 
                              AND CID=C.CID) FORLEVELUP
       FROM CUSTOMER C, CUS_LEVEL L
       WHERE C.LEVELNO=L.LEVELNO AND LEVELNAME = UPPER('NORMAL')
       ORDER BY cAMOUNT DESC, CID;
    
    
    -- 5번 전체출력 
    -- CID, CTEL, CNAME, POINT, CAMOUNT, LEVELNAME, FORLEVELUP
    -- public ArrayList<CustomerDto> GetCustomers()
SELECT cID, cTEL, cNAME, POINT, cAMOUNT, LEVELNAME,
       (SELECT HIGH+1-cAMOUNT FROM CUSTOMER 
                              WHERE LEVELNO != 5 
                              AND CID=C.CID) FORLEVELUP
       FROM CUSTOMER C, CUS_LEVEL L
       WHERE C.LEVELNO=L.LEVELNO
       ORDER BY cAMOUNT DESC, CID;    
    
    
    -- 6번 회원탈퇴 cTEL받아 DELETE
    -- public int deleteCustomer(String ctel)
DELETE FROM CUSTOMER WHERE CTEL = '010-6666-6666';

COMMIT;
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    