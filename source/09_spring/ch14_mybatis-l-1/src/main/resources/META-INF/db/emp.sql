-- EMP의 ID=deptList (DeptDao.java x)
SELECT * FROM DEPT;

-- EMP의 ID=emtList
SELECT * FROM EMP
  WHERE 1 = 1 
    AND ENAME LIKE '%'||'A'||'%' 
    AND JOB LIKE '%'||'M'||'%'
    AND DEPTNO = 10;
