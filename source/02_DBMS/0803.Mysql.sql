	-- DCL(계정생성, 권한부여, 권한박탈, 계정삭제)
	-- DDL(FK 제약조건, 시퀀스없음)
    -- DML(outer join, and;&&, or:||, 일부단일함수, rownum 없음)
    -- JAVA시간에 쓸 데이터 넣고 연습해 보기
    
SHOW DATABASES;
    
	-- DCL(계정생성, 권한부여, 권한박탈, 계정삭제)
create user scott identified by 'tigar'; -- 계정 생성
    
grant all on *.* to scott; -- 권한부여
flush privileges;
revoke all on *.* from scott; -- 권한박탈
drop user scott; -- 계정삭제
  
	-- 특정 데이터 베이스로 들어감
show databases; -- 데이터베이스 리스트
use world; -- 데이트베이스 들어감
select database(); -- 현재 들어와있는 데이터베이스
show tables; -- 현재 데이터베이스안의 테이블들

create database yubin; -- new db create
use yubin;
select database();
show tables; 

	-- DDL(FK 제약조건, 시퀀스없음)
create table emp(
	empno numeric(4) primary key,
    ename varchar(20) not null,
    nickname varchar(20) unique,
    sal numeric(7,2) check(sal>0),
    comm numeric(7,2) default 0
	);

desc emp;
    
drop table if exists emp;
    
create table emp(
	empno numeric(4),
    ename varchar(20) not null,
    nickname varchar(20),
    sal numeric(7,2) ,
    comm numeric(7,2) default 0,
    primary key(empno),
    unique(nickname),
    check(sal>0)
	);    
    
insert into emp values (1111, '홍길동', '동해번쩍', 900, null);
insert into emp values (1111, '홍길동', '동해번쩍', 900, null); -- error(nickname-unique)
select * from emp;    
    
	-- Table create 08.03 
    
use yubin;

select database();
    
	-- MAJOR 테이블 (mCode(pk) 학과번호(순차번호) / mName 학과명 / mOffice 학과사무실)

drop table if exists student;
drop table if exists major;

create table major (	
	mCode int primary key auto_increment, -- auto_increment 필드의 경우 int 타입으로 생성
    mName varchar(30) unique,
    mOffice varchar(30) not null
    );
    
insert into major (mName, mOffice) values ('컴퓨터공학', '202호');
insert into major (mName, mOffice) values ('빅데이터', '203호');
insert into major (mName, mOffice) values ('중국어', '402호');
insert into major (mName, mOffice) values ('중국어', '501호'); -- unique 에러

select * from major;
    
    
    -- STUDENT 테이블 (sNo(pk) 학번 / sName 이름 / score 성적 / mCode(fk) 학과번호
drop table student;
create table student(
	sNo numeric(4) primary key,
    sName varchar(30) not null,
    score numeric(3) check(score >= 0 and score <= 100),
    mCode int,
    foreign key(mCode) references major(mCode) -- 제약조건 중 foreign key는 반드시 아래에 명시(My sql만)
    );    
    
insert into student values (1000, '홍길동', -2, 1);   -- check 에러
insert into student values (1000, '홍길동', 100, 1);     
insert into student values (1001, '신길동', 90, 3); 
insert into student values (1002, '김길동', 80, 4);    -- foreign key 에러

select * from student;
    
    
	-- 학번, 이름, 점수, 학과번호, 학과명, 학과사무실(Mysql = oracle => equi join, non equi join, self join 방법 동일) 
select sNo, sName, score, s.mCode, mName, mOffice
	from student s, major m
    where s.mCode=m.mCode;
	
    -- 학번, 이름, 점수, 학과번호, 학과명, 학과사무실(학생이 없는 학과도 출력)
select sNo, sName, score, s.mCode, mName, mOffice
	from student s right outer join major m
    on s.mCode=m.mCode;
	
    -- nvl함수 대체
select ifnull(sNo, '-') "sNO", if(sName is null, '-', sName) "sName", ifnull(score, '-')"score", m.mCode, mName, mOffice
	from major m left outer join student s
    on m.mCode=s.mCode;
    
	
    -- 자바(JDBC) 사용할 테이블 데이터 --
drop table if exists personal; -- emp와 비슷
drop table if exists division; -- dept와 비슷

create table division (
	dno int, 
    dname varchar(20) not null,
    phone varchar(20) unique,
    position varchar(20),
    primary key(dno)
    );

create table personal (
	pno int primary key,
    pname varchar(20) not null,
    job varchar(20) not null,
    manager int,
    startdate date,
    pay int,
    bonus int,
    dno int,
    foreign key(dno) references division(dno)
    );

select * from division;
select * from personal;

insert into division values (10, 'finance', '02-393-4321', '서대문');
insert into division values (20, 'research', '02-555-5555', '강남');
insert into division values (30, 'sales', '02-717-5555', '마포');
insert into division values (40, 'cs', '31-4444-4444', '안양');


insert into personal values (1111,'smith','manager', 1001, '1990-12-17', 1000, null, 10);
insert into personal values (1112,'ally','salesman',1116,'1991-02-20',1600,500,30);
insert into personal values (1113,'word','salesman',1116,'1992-02-24',1450,300,30);
insert into personal values (1114,'james','manager',1001,'1990-04-12',3975,null,20);
insert into personal values (1001,'bill','president',null,'1989-01-10',7000,null,10);
insert into personal values (1116,'johnson','manager',1001,'1991-05-01',3550,null,30);
insert into personal values (1118,'martin','analyst',1111,'1991-09-09',3450,null,10);
insert into personal values (1121,'kim','clerk',1114,'1990-12-08',4000,null,20);
insert into personal values (1123,'lee','salesman',1116,'1991-09-23',1200,0,30);
insert into personal values (1226,'park','analyst',1111,'1990-01-03',2500,null,10);

select * from personal;



	-- DML -- (outer join, and &&, or ||, 단일행함수)
    
	-- 1. 사번, 이름, 급여를 출력
select pno, pname, pay
	from personal;
    
	-- 2. 급여가 2000~5000 사이 모든 직원의 모든 필드
select *
	from personal p, division d
    where p.dno = d.dno;

	-- 3. 부서번호가 10또는 20인 사원의 사번, 이름, 부서번호
select pno, pname, p.dno
	from personal p, division d
    where p.dno=d.dno and p.dno=20 or p.dno=10 and p.dno= d.dno;

	-- 4. 보너스가 null인 사원의 사번, 이름, 급여 급여 큰 순정렬
select pno, pname, pay
	from personal
    where bonus is null
    order by pay desc;
    
	-- 5. 사번, 이름, 부서번호, 급여. 부서코드 순 정렬 같으면 PAY 큰순
select pno, pname, p.dno, pay
	from personal p, division d
    where p.dno = d.dno
    order by dno desc, pay desc;

	-- 6. 사번, 이름, 부서명
select pno, pname, dname 
	from personal p, division d
    where p.dno = d.dno;
    
	-- 7. 사번, 이름, 상사이름
select w.pno, w.pname, m.pname
	from personal w, personal m
    where w.manager = m.pno;
    
	-- 8. 사번, 이름, 상사이름(상사가 없는 사람도 출력)
select w.pno, w.pname, ifnull(m.pname, 'CEO') manager
	from personal w left outer join personal m
    on w.manager = m.pno;
    
	-- 9. 이름이 s로 시작하는 사원 이름
select pname
	from personal
    where  pname like 's%';
    
	-- 10. 사번, 이름, 급여, 부서명, 상사이름
select w.pno, w.pname, w.pay, d.dname, m.pname
	from personal w, personal m, division d
    where w.dno = d.dno and w.manager = m.pno;
    
	-- 11. 부서코드, 급여합계, 최대급여
select dno, sum(pay), max(pay)
	from personal
    group by dno;
    
	-- 12. 부서명, 급여평균, 인원수
select dname, round(avg(pay)), count(*)
	from personal p, division d
    where p.dno = d.dno
    group by dname;
    
	-- 13. 부서코드, 급여합계, 인원수 인원수가 4명 이상인 부서만 출력
select p.dno, sum(pay), count(pno) 
	from personal p, division d
    where p.dno = d.dno and 
    group by p.dno;
    
	-- 14. 사번, 이름, 급여 회사에서 제일 급여를 많이 받는 사람
select pno, pname, pay
	from personal
	where pay > max(pay) 
    group by pno;
    
	-- 15. 회사 평균보다 급여를 많이 받는 사람 이름, 급여, 부서번호

	-- 16. 회사 평균 급여보다 많이 받는 사원의 사번, 이름, 급여, 부서명을 출력(부서명순 정열 같으면 급여 큰순 정렬)

	-- 17. 자신이 속한 부서의 평균보다 많인 받는 사람의 이름, 급여, 부서번호, 반올림한 해당부서평균

	-- 18. 입사가 가장 빠른 사람의 이름, 급여, 부서명
	 
	-- 19. 이름, 급여, 해당부서평균

	-- 20. 이름, 급여, 부서명, 해당부서평균

		
		
		