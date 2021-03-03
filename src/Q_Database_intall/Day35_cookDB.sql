
DROP DATABASE IF EXISTS cookDB; -- 만약 cookDB가 존재하면 우선 삭제한다.
CREATE DATABASE cookDB;

USE cookDB;
CREATE TABLE userTBL -- 회원 테이블
( userID  	CHAR(8) NOT NULL PRIMARY KEY, -- 사용자 아이디(PK)
  userName    	VARCHAR(10) NOT NULL, -- 이름
  birthYear   INT NOT NULL,  -- 출생년도
  addr	  	CHAR(2) NOT NULL, -- 지역(경기,서울,경남 식으로 2글자만입력)
  mobile1	CHAR(3), -- 휴대폰의 국번(011, 016, 017, 018, 019, 010 등)
  mobile2	CHAR(8), -- 휴대폰의 나머지 전화번호(하이픈제외)
  height    	SMALLINT,  -- 키
  mDate    	DATE  -- 회원 가입일
);
CREATE TABLE buyTBL -- 회원 구매 테이블
(  num 		INT AUTO_INCREMENT NOT NULL PRIMARY KEY, -- 순번(PK)
   userID  	CHAR(8) NOT NULL, -- 아이디(FK)
   prodName 	CHAR(6) NOT NULL, --  물품명
   groupName 	CHAR(4)  , -- 분류
   price     	INT  NOT NULL, -- 단가
   amount    	SMALLINT  NOT NULL, -- 수량
   FOREIGN KEY (userID) REFERENCES userTBL(userID)
);

INSERT INTO userTBL VALUES('YJS', '유재석', 1972, '서울', '010', '11111111', 178, '2008-8-8');
INSERT INTO userTBL VALUES('KHD', '강호동', 1970, '경북', '011', '22222222', 182, '2007-7-7');
INSERT INTO userTBL VALUES('KKJ', '김국진', 1965, '서울', '019', '33333333', 171, '2009-9-9');
INSERT INTO userTBL VALUES('KYM', '김용만', 1967, '서울', '010', '44444444', 177, '2015-5-5');
INSERT INTO userTBL VALUES('KJD', '김제동', 1974, '경남', NULL , NULL      , 173, '2013-3-3');
INSERT INTO userTBL VALUES('NHS', '남희석', 1971, '충남', '016', '66666666', 180, '2017-4-4');
INSERT INTO userTBL VALUES('SDY', '신동엽', 1971, '경기', NULL , NULL      , 176, '2008-10-10');
INSERT INTO userTBL VALUES('LHJ', '이휘재', 1972, '경기', '011', '88888888', 180, '2006-4-4');
INSERT INTO userTBL VALUES('LKK', '이경규', 1960, '경남', '018', '99999999', 170, '2004-12-12');
INSERT INTO userTBL VALUES('PSH', '박수홍', 1970, '서울', '010', '00000000', 183, '2012-5-5');

INSERT INTO buyTBL VALUES(NULL, 'KHD', '운동화', NULL   , 30,   2);
INSERT INTO buyTBL VALUES(NULL, 'KHD', '노트북', '전자', 1000, 1);
INSERT INTO buyTBL VALUES(NULL, 'KYM', '모니터', '전자', 200,  1);
INSERT INTO buyTBL VALUES(NULL, 'PSH', '모니터', '전자', 200,  5);
INSERT INTO buyTBL VALUES(NULL, 'KHD', '청바지', '의류', 50,   3);
INSERT INTO buyTBL VALUES(NULL, 'PSH', '메모리', '전자', 80,  10);
INSERT INTO buyTBL VALUES(NULL, 'KJD', '책'    , '서적', 15,   5);
INSERT INTO buyTBL VALUES(NULL, 'LHJ', '책'    , '서적', 15,   2);
INSERT INTO buyTBL VALUES(NULL, 'LHJ', '청바지', '의류', 50,   1);
INSERT INTO buyTBL VALUES(NULL, 'PSH', '운동화', NULL   , 30,   2);
INSERT INTO buyTBL VALUES(NULL, 'LHJ', '책'    , '서적', 15,   1);
INSERT INTO buyTBL VALUES(NULL, 'PSH', '운동화', NULL   , 30,   2);

SELECT * FROM userTBL;
SELECT * FROM buyTBL;

-- WHERE 절
SELECT * FROM userTBL where userName ='강호동';
select userID,userName from userTBL WHERE birthYear >= 1970 and height >=182;

-- in, like, between, or, and, limit 절
select userName, height from userTBL where height >=180 and height<=182;
select userName, height from userTBL where height between 180 and 182;
select userName, addr from userTBL where addr='경남' or addr='충남' or addr='경북';
select userName, addr from userTBL where addr in ('경남','충남','경북');
select userName, height from userTBL where userName like '김%';
select userName, height from userTBL where userName like '_경규';
select userName, height from userTBL where height > 177;
select userName, height from userTBL where height > 177 limit 5;
select userName, height from userTBL where height > 177 limit 0, 5;


-- 서브쿼리
select userName, height from userTBL where userName like '김용만';
select userName, height from userTBL where height > (select height from userTBL where userName ='김용만');
select userName, height from userTBL where height >= (select height from userTBL where addr = '경기');
select userName, height from userTBL where height >= any (select height from userTBL where addr = '경기');
select userName, height from userTBL where height = any (select height from userTBL where addr = '경기');
select userName, height from userTBL where height in (select height from userTBL where addr = '경기');

-- order by
select userName, mDate from userTBL order by mDate; -- 기본 오름차순
select userName, mDate from userTBL order by mDate desc; -- 내림차순
select userName, mDate from userTBL order by height desc, userName asc;
select addr from userTBL;
select addr from userTBL order by addr;
select distinct addr from userTBL; -- 중복값 제거

-- 테이블 복사
use cookDB;
create table buyTBL2 (select * from buyTBL);
select * from buyTBL2;

create table buyTBL3 (select * from buyTBL);
select * from buyTBL3;

-- group by 
select userID, sum(amount) from buyTBL group by userID;
select userID AS '사용자 아이디', SUM(AMOUNT) AS '총 구매개수' FROM BUYTBL GROUP BY USERID; 
select userID AS '사용자 아이디', SUM(AMOUNT*price) AS '총 구매액' FROM BUYTBL GROUP BY USERID; 

-- min, max, avg, count 절
select avg(amount) as '평균 구매 개수' from buyTBL;
select userID, avg(amount) as '평균 구매 개수' where buyTBL group by userID; -- where 절에는 group by 가 들어가지 못함.
select userName, max(height), min(height) from usertbl;
select userName, max(height), min(height) from usertbl group by userName;
select userName, height from usertbl
	where height = (select max(height) from usertbl) or height = (select max(height) from usertbl);
select count(*) from usertbl;
select count(mobile1) as '휴대폰이 있는 사용자' from usertbl;

-- having 절 
-- where 절에는 group by 가 들어가지 못함. 둘중 하나만 사용가능
select userID as '사용자', sum(price*amount) as '총구매액'
	from buytbl group by userID;
select userID as '사용자', sum(price*amount) as '총구매액'
	from buytbl where sum (price*amount) > 1000 group by userID; -- where 절에는 group by 가 들어가지 못함.
select userID as '사용자', sum(price*amount) as '총구매액'
	from buytbl group by userID having sum(price*amount) > 1000;
select userID as '사용자', sum(price*amount) as '총구매액'
	from buytbl group by userID having sum(price*amount) > 1000
	order by sum(price * amount);

	
-- rollup	
select num, groupName, sum(price*amount) as '비용'
	from buytbl
    group by groupName,num
    with rollup;
select groupName, sum(price*amount) as '비용'
	from buytbl
    group by groupName
    with rollup;    

create table testtbl1(id int, userName char(3), age int);
insert into testtbl1 values (1,'뽀로로',16);
insert into testtbl1(id, userName) values (2, '크롬');
insert into testtbl1(userName, age, id) values ('루피', 14, 3);
create table testtbl2
	(id int auto_increment primary key,
	userName char(3),
	age int);
insert into testtbl2 values (null, '에디', 15);
insert into testtbl2 values (null, '포비', 12);
insert into testtbl2 values (null, '통통이', 11);
select * from testtbl2;
alter table testtbl2 auto_increment=100;
insert into testtbl2 values(null, '패티', 13);
select * from testtbl2;

create table testtbl3
	(id int auto_increment primary key,
	userName char(3),
	age int);
alter table testtbl3 auto_increment=1000;
-- 3씩 증가
set @@auto_increment_increment=3;
insert into testtbl3 values (null, '우디', 20);
insert into testtbl3 values (null, '버즈', 18);
insert into testtbl3 values (null, '제시', 19);
select * from testtbl3;

insert into testtbl3 values (null, '토이', 17),(null, '스토리', 18),(null, '무비', 19);
select * from testtbl3;

-- 테이블 생성 후 데이터 추가 그리고 테이블 생성 속성이름 그대로 추가
create table testtbl4(id int, Fname varchar(50), Lname varchar(50));
insert into testtbl4 
	select emp_no, first_name, last_name from employees.employees;

-- 테이블 생성하면서 데이터 추가	그리고 속성이름이 기존 그대로 추가
create table testtbl5 
	(select emp_no,first_name, last_name from employees.employees);
select * from testtbl5 limit 5;

-- 테이블 생성하면서 데이터 추가인데 속성 명 변경
create table testtbl6
	(select emp_no as id, first_name as Fname, last_name as Lname from employees.employees);
select * from testtbl6 limit 3;
	
-- update 문
select * from testtbl4 where Fname = 'kyoichi';
update testtbl4 set Lname = '없음' where Fname = 'kyoichi';
select * from buytbl;
update buytbl set price = price * 1.5;

-- delete 문
select count(*) from testtbl4 where Fname= 'Aamer';
delete from testtbl4 where Fname = "Aamer" limit 5;
delete from testtbl4 where Fname = "Aamer";

-- 삭제 속도 확인
-- truncate 문
create table bigTbl1 (select * from employees.employees);
create table bigTbl2 (select * from employees.employees);
create table bigTbl3 (select * from employees.employees);

delete from bigtbl1; -- 테이블 내용만 삭제 
drop table bigtbl2;  -- 테이블 삭제
truncate table bigtbl3; -- 테이블 내용만 삭제 가장 빨리 삭제

-- 실행하지 말것 !! 
-- PK 변경을 통한 ignore 테스트
use cookDB;
create table membertbl (select userID, userName, addr from usertbl limit 3);
alter table membertbl 
	add constraint pk_membertbl primary key (userID);
select * from membertbl;
insert into membertbl values('KHD', '강후덜', '미국');
insert into membertbl values('LSM', '이상민', '서울');
insert into membertbl values('KSJ', '김성주', '경기');    
insert ignore into membertbl values('KHD', '강후덜', '미국');
insert ignore into membertbl values('LSM', '이상민', '서울');
insert ignore into membertbl values('KSJ', '김성주', '경기');    
select * from membertbl;
insert into memebertbl values('KHD', '강후덜', '미국')
	on duplicate key update userName ='강후덜', addr='미국';
insert into memebertbl values('DJM', '동짜몽', '일본')
	on duplicate key update userName ='동짜몽', addr='일본';
select * from membertbl;


/*1번*/
SELECT 
	UT.userID
	,UT.userName
	,BT.prodName
	,UT.addr
	,CONCAT(UT.mobile1, UT.mobile2) AS '연락처'
FROM usertbl UT
INNER JOIN buytbl BT
	ON UT.userID = BT.userID;


/*2번*/
SELECT 
	UT.userID
	,UT.userName
	,BT.prodName
	,UT.addr
FROM usertbl UT
INNER JOIN buytbl BT
	ON UT.userID = BT.userID
WHERE UT.userName = '김용만' 
		AND BT.prodName = '모니터';

/*3번*/
SELECT 
	UT.userID
	,UT.userName
	,BT.prodName
	,UT.addr
	,CONCAT(UT.mobile1, UT.mobile2) AS '연락처'
FROM usertbl UT
INNER JOIN buytbl BT
	ON UT.userID = BT.userID
ORDER BY UT.userID;

/*4번*/
SELECT 
	UT.userID
	,UT.userName
	,UT.addr
FROM usertbl UT
INNER JOIN buytbl BT
	ON UT.userID = BT.userID
GROUP BY UT.userName;


