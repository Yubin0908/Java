	-- insert
        -- ex1
INSERT INTO DEPT VALUES (60, 'IT', 'SEOUL');

SELECT * FROM DEPT WHERE DEPTNO > 40;

COMMIT;
        -- ex2. 부서번호 중복체크 후 insert
SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO=60; -- 중복체크

INSERT INTO DEPT VALUES (60, 'IT', 'SEOUL');


    -- UPDATE
    -- ex1
UPDATE DEPT SET DNAME='CS', LOC='INCHON' WHERE DEPTNO='70';


SELECT * FROM DEPT;

    -- ex2 부서번호 유무확인 후 update
SELECT * FROM DEPT WHERE DEPTNO=70;

UPDATE DEPT SET DNAME='CS', LOC='INCHON' WHERE DEPTNO='70';

COMMIT;


    -- DELETE
DELETE FROM DEPT WHERE DEPTNO=70;
   
   rollback;
   
   
   
    -- 














   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
    