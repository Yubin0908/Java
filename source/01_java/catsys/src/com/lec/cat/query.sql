 -- id/pw 불러오기
SELECT USERID, UPW 
    FROM HUMAN
    WHERE USERID='cat01';
    
 -- 사용자 정보 불러오기(이름조회)
SELECT * FROM HUMAN WHERE UNAME='삼색고양이';

 -- 사용자 정보 불러오기(전체정보) - 이름조회
SELECT USERID, UNAME, EMAIL, LOCAL, DNAME, LNAME FROM HUMAN H, DEPARTMENT D, LEVELGRADE L WHERE H.DEPTNO=D.DEPTNO AND H.LNO=L.LNO AND UNAME='치즈고양이';

