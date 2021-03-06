
-- 신규 테이블 생성
use cookDB;

create table stdTBL
(
	stdName varchar(10) not null primary key,
	addr char(4) not null
);

create table clubTBL
(
	clubName varchar(10) not null primary key,
	roomNo char(4) not null
);

create table stdclubTBL
(
	num int auto_increment not null primary key,
	stdName varchar(10) not null,
	clubName varchar(10) not null,
	foreign key(stdName) references stdTBL(stdName),
	foreign key(clubName) references clubTBL(clubName)
);

insert into stdTBL values('강호동', '경북'), ('김제동', '경남'), ('김용만', '서울'), ('이휘재', '경기'), ('박수홍', '서울');
insert into clubTBL values('수영', '101호'), ('바둑', '102호'), ('축구', '103호'), ('봉사', '104호');
insert into stdclubTBL values(null,'강호동','바둑'), (null,'강호동','바둑'), (null,'김용만','축구') ,(null,'이휘재','축구') 
							,(null,'이휘재','봉사'), (null,'박수홍','봉사');

-- 조인 2개
SELECT 
	S.stdName
    ,S.addr
    ,C.clubName
    ,C.roomNo
FROM STDTBL S
INNER JOIN STDCLUBTBL SC
	ON S.stdName = SC.stdName
INNER JOIN CLUBTBL C
	ON SC.clubName = C.clubName
ORDER BY C.clubName;

SELECT 
	C.clubName
    ,C.roomNo
    ,S.stdName
    ,S.addr
FROM STDTBL S
INNER JOIN STDCLUBTBL SC
	ON S.stdName = SC.stdName
INNER JOIN CLUBTBL C
	ON SC.clubName = C.clubName
ORDER BY C.clubName;
						
-- outer join						
select u.userID, u.userName, b.prodName, u.addr, concat(u.mobile1, u.mobile2) as '연락처'
 from usertbl u
left outer join buytbl b
on u.userID = b.userID
order by u.userID;

select u.userID, u.userName, b.prodName, u.addr, concat(u.mobile1, u.mobile2) as '연락처'
 from usertbl u
right outer join buytbl b
on u.userID = b.userID
order by u.userID;

select u.userID, u.userName, b.prodName, u.addr, concat(u.mobile1, u.mobile2) as '연락처'
 from usertbl u
left outer join buytbl b
	on u.userID = b.userID
where b.prodName is null
order by u.userID;

select s.stdName, s.addr, c.clubName, c.roomNo
from stdtbl s
left outer join stdclubtbl sc
	on s.stdName = sc.stdName
left outer join clubtbl c
	on sc.clubName = c.clubName
order by s.stdName;

select c.clubName,c.roomNo, s.stdName, s.addr
from stdtbl s
left outer join stdclubtbl sc
	on s.stdName = sc.stdName
right outer join clubtbl c
	on sc.clubName = c.clubName
order by c.clubName;						
						
-- UNION						
select s.stdName, s.addr, c.clubName, c.roomNo
from stdtbl s
left outer join stdclubtbl sc
	on s.stdName = sc.stdName
left outer join clubtbl c
	on sc.clubName = c.clubName
union /*합치기왕*/
select s.stdName, s.addr, c.clubName, c.roomNo
from stdtbl s
left outer join stdclubtbl sc
	on s.stdName = sc.stdName
right outer join clubtbl c
	on sc.clubName = c.clubName;
	
	
-- 자체조인	
create table emptbl (emp char(3), manager char(3), emptel varchar(8));

insert into emptbl values ('나사장', null, '0000');
insert into emptbl values ('김재무', '나사장', '2222');
insert into emptbl values ('김부장', '김재무', '2222-1');
insert into emptbl values ('이부장', '김재무', '2222-2');
insert into emptbl values ('우대리', '이부장', '2222-2-1');
insert into emptbl values ('지사원', '이부장', '2222-2-2');
insert into emptbl values ('이영업', '나사장', '1111');
insert into emptbl values ('한과장', '이영업', '1111-1');
insert into emptbl values ('최정보', '나사장', '3333');
insert into emptbl values ('윤차장', '최정보', '3333-1');
insert into emptbl values ('이주임', '윤차장', '3333-1-1');

select a.emp as '부하직원', b.emp as '직속상관', b.emptel as '직속상관연락처'
from emptbl A
inner join emptbl B
	on a.manager = b.emp
where a.emp = '우대리';	

-- union all
select stdName, addr from stdtbl
union all
select clubName, room,No from clubtbl;

select userName, concat(mobile1, '-',mobile2) as '전화번호' from usertbl
where userName not in (select userName from usertbl where mobile1 is null);

select userName, concat(mobile1, '-',mobile2) as '전화번호' from usertbl
where userName in (select userName from usertbl where mobile1 is null);

-- 프로시져
DROP PROCEDURE IF EXISTS ifProc;	-- 기존에 만든적 있다면 삭제
DELIMITER $$
CREATE PROCEDURE ifProc()
BEGIN 
	DECLARE var1 INT;	-- var1 변수선언
    SET var1 = 100;		-- 변수에 값 대입
    
    IF var1 = 100 THEN	-- 만약 @var1 이 100이라면,
		SELECT '100 입니다.';
	ELSE
		SELECT '100이 아닙니다.';
	END IF;
END$$
DELIMITER ;
CALL ifProc();
-------------------
DELIMITER $$
CREATE PROCEDURE ifProc2()
BEGIN 
	DECLARE hireDate Date; -- 입사일
    DECLARE curDate Date; -- 오늘
    DECLARE days Int; -- 근무한 일수
    
    select hire_date into hireDate -- hire_date 열의 결과를 hireDate에 대입
    from employees.employees
    where emp_no = 10001;
    
    set curDate = current_date(); -- 현재날짜
    set days =  datediff(curDate, hireDate);	-- 날짜의 차이, 일단위
    
    if (days/365) >= 5 then -- 5년이 지났다면
		select concat('입사한지 ', days, '일 이나 지났습니다. 축하합니다!') as '메시지';
	else 
		select '입사한지 '+ days + '일밖에 안되었네요. 열심히 일하세요.' as '메시지';
    end if;
END $$
DELIMITER ;

CALL ifProc2();
-------------------
drop procedure if exists caseProc;
DELIMITER $$
CREATE PROCEDURE caseProc()
BEGIN
	DECLARE point INT;
    DECLARE credit CHAR(1);
    SET point = 77;
    
    CASE 
		WHEN point >= 90 THEN 
			SET credit = 'A';
		WHEN point >= 80 THEN 
			SET credit = 'B';
		WHEN point >= 70 THEN 
			SET credit = 'C';
		WHEN point >= 60 THEN 
			SET credit = 'D';
		ELSE
			SET credit = 'F';
	END CASE;
    SELECT CONCAT('취득점수 ==>' , point) AS '취득점수', concat('학점 ==> ', credit) AS '학점';
END $$
DELIMITER ;
CALL caseProc();
-------------------
-- 프로시져 반복문_1
DROP PROCEDURE IF EXISTS whileProc;
DELIMITER $$
CREATE PROCEDURE whileProc()
BEGIN
	DECLARE i INT;	-- 1에서 100까지 증가할 변수
    DECLARE hap INT;	-- 더한 값을 누적할 변수
    SET i = 1;
    SET hap = 0;
   
    WHILE (i <= 100) DO
    	SET hap = hap + i;	-- hap의 원래의 값에 i를 더해서 다시 hap에 넣으라는 의미
        SET i = i + 1;	-- 1의 원래의 값에 1을 더해서 다시 i에 넣으라는 의미
    END WHILE;
   
 	SELECT hap;
END $$
DELIMITER ;
CALL whileProc();
-------------------
-- 프로시져 반복문_1
DROP PROCEDURE IF EXISTS whileProc2;
DELIMITER $$
CREATE PROCEDURE whileProc2()
BEGIN
    DECLARE i INT;
    DECLARE hap INT;
    SET i = 1;
    SET hap = 0;
    myWhile: WHILE (i <= 100) DO -- While문에 label을 지정
    IF (i%7 = 0) THEN
         SET i = i + 1;
         ITERATE myWhile; -- 지정한 label문으로 가서 계속 진행
	END IF;
		SET hap = hap + i;
        IF (hap > 1000) THEN
        LEAVE myWhile;	-- 지정한 label문을 떠남, while 종료.
        END IF;
        SET i = i + 1;
    END WHILE;
 
    SELECT hap;
END $$
DELIMITER ;
CALL whileProc2();


-- CASE 문 문제
SELECT 
	U.userID
	, U.userName
	, SUM(B.price * B.amount) AS '총구매액'
	, CASE
	   WHEN (SUM(B.price * B.amount) >= 1500) THEN '최우수고객'
	   WHEN (SUM(B.price * B.amount) >= 500) THEN '우수고객'
	   WHEN (SUM(B.price * B.amount) >= 1) THEN '일반고객'
	   ELSE '유령고객'
	END AS '고객등급'
FROM buyTbl B
RIGHT OUTER JOIN userTbl U
      ON B.userID = U.userID
GROUP BY U.userID, U.userName
ORDER BY SUM(B.price * B.amount) DESC;  


-- 제약 조건(PK)
USE cookdb;

DROP TABLE IF EXISTS buytbl, usertbl;
CREATE TABLE usertbl
(
	userID 		CHAR(8) NOT NULL PRIMARY KEY,
	userName  	VARBINARY(10) NOT NULL,
	birthYear	INT NOT NULL
);
DESCRIBE usertbl;

DROP TABLE IF EXISTS usertbl;
CREATE TABLE usertbl
(
	userID 		CHAR(8) NOT NULL,
	userName  	VARBINARY(10) NOT NULL,
	birthYear	INT NOT NULL,
	CONSTRAINT PRIMARY KEY PK_usertbl_userID(userID)
);

DROP TABLE IF EXISTS usertbl;
CREATE TABLE usertbl
(
	userID 		CHAR(8) NOT NULL,
	userName  	VARBINARY(10) NOT NULL,
	birthYear	INT NOT NULL,
	CONSTRAINT PRIMARY KEY PK_usertbl_userID(userID)
);

DROP TABLE IF EXISTS usertbl;
CREATE TABLE usertbl
(
	userID 		CHAR(8) NOT NULL,
	userName  	VARBINARY(10) NOT NULL,
	birthYear	INT NOT NULL
);
ALTER TABLE usertbl
	ADD CONSTRAINT PK_usertbl_userID
		PRIMARY KEY (userID);

		
-- 제약조건(다중PK)		
DROP TABLE IF EXISTS prodtbl;
CREATE TABLE prodtbl
(
	prodCode 	CHAR(3) NOT NULL,
	prodID 		CHAR(4) NOT NULL,
	prodDate		DATETIME NOT NULL,
	prodState	CHAR(10) NULL,
	CONSTRAINT PK_prodtbl_prodCode_prodID
		PRIMARY KEY (prodCode, prodID));	

		
-- 외래키 제거 및 변경 (FK)
DROP TABLE IF EXISTS buytbl;
CREATE TABLE buytbl
(
	num INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	userID CHAR(8) NOT NULL,
	prodName CHAR(6) NOT NULL,
	CONSTRAINT FK_usertbl_buytbl FOREIGN KEY(userID) REFERENCES usertbl(userID)	
);
DROP TABLE IF EXISTS buytbl;
CREATE TABLE buytbl
(
	num INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	userID CHAR(8) NOT NULL,
	prodName CHAR(6) NOT NULL
);
ALTER TABLE buytbl
	ADD CONSTRAINT FK_userTBL_BUYTBL
	FOREIGN KEY(userID) 
	REFERENCES usertbl(userID);
ALTER TABLE buytbl
	DROP FOREIGN KEY FK_userTBL_BUYTBL; -- 외래키 제거
ALTER TABLE buytbl
	ADD CONSTRAINT FK_userTBL_BUYTBL
	FOREIGN KEY(userID) 
	REFERENCES usertbl(userID)
	ON UPDATE CASCADE;

-- UNIQUE 사용
DROP TABLE IF EXISTS buytbl, usertbl;
CREATE TABLE usertbl
(
	userID CHAR(8) NOT NULL PRIMARY KEY,
	userName VARCHAR(10) NOT NULL,
	birthYear INT NOT NULL,
	email  CHAR(8) NULL UNIQUE
);	
	
DROP TABLE IF EXISTS usertbl;
CREATE TABLE usertbl
(
	userID CHAR(8) NOT NULL PRIMARY KEY,
	userName VARCHAR(10) NOT NULL,
	birthYear INT NOT NULL,
	email  CHAR(8) NULL,
	CONSTRAINT AK_email UNIQUE (email)
);		

-- NOT NULL 인 경우 DEFAULT 
DROP TABLE IF EXISTS usertbl;
CREATE TABLE usertbl
(
	userID CHAR(8) NOT NULL PRIMARY KEY,
	userName VARCHAR(10) NOT NULL,
	birthYear INT NOT NULL DEFAULT -1,
	addr CHAR(2) NOT NULL DEFAULT '서울',
	mobile1 CHAR(3) NULL,
	mobile2 CHAR(8) NULL,
	height SMALLINT NULL DEFAULT 170,
	mDate DATE NULL
);	
		
DROP TABLE IF EXISTS usertbl;
CREATE TABLE usertbl
(
	userID CHAR(8) NOT NULL PRIMARY KEY,
	userName VARCHAR(10) NOT NULL,
	birthYear INT NOT NULL,
	addr CHAR(2) NOT NULL,
	mobile1 CHAR(3) NULL,
	mobile2 CHAR(8) NULL,
	height SMALLINT NULL,
	mDate DATE NULL
);	
ALTER TABLE usertbl
	ALTER COLUMN birthYear SET DEFAULT -1;
ALTER TABLE usertbl
	ALTER COLUMN addr SET DEFAULT '서울';
ALTER TABLE usertbl
	ALTER COLUMN height SET DEFAULT 170;		

INSERT INTO usertbl VALUES ('YBJ', '유병재', DEFAULT, DEFAULT, '010', '12345678', DEFAULT, '2019.12.12');
INSERT INTO usertbl(userID, userName) VALUES ('PNR', '박나래');
INSERT INTO usertbl VALUES ('WB', '원빈',1982, '대전', '010', '98765432', 176, '2020.5.5');

-- 테이블 생성 후 데이터 추가
DROP TABLE IF EXISTS buytbl, usertbl;
CREATE TABLE usertbl
(
	userID CHAR(8),
	userName VARCHAR(10),
	birthYear INT,
	addr CHAR(2),
	mobile1 CHAR(3),
	mobile2 CHAR(8),
	height SMALLINT,
	mDate DATE
);	
CREATE TABLE buytbl
(
	num INT AUTO_INCREMENT PRIMARY KEY,
	userID CHAR(8),
	prodName CHAR(6),
	groupName CHAR(4),
	price INT,
	amount SMALLINT
);	

INSERT INTO usertbl VALUES ('YJS', '유재석',1972, '서울', '010', '11111111', 178, '2008-8-8');
INSERT INTO usertbl VALUES ('KHD', '강호동', null, '경북', '010', '22222222', 182, '2007-7-7');
INSERT INTO usertbl VALUES ('KKJ', '김국진',1965, '서울', '010', '33333333', 171, '2006-6-6');
INSERT INTO usertbl VALUES ('KYM', '김용만',1967, '서울', '010', '44444444', 177, '2005-5-5');
INSERT INTO buytbl VALUES (NULL, 'KHD','운동화', NULL, 30, 2);
INSERT INTO buytbl VALUES (NULL, 'KHD','노트북', '전자', 1000, 1);
INSERT INTO buytbl VALUES (NULL, 'KYM','모니터', '전자', 200, 1);
INSERT INTO buytbl VALUES (NULL, 'PSH','모니터', '전자', 200, 5);

ALTER TABLE usertbl
	ADD CONSTRAINT PK_usertbl_userID
	PRIMARY KEY (userID);
ALTER TABLE buytbl
	ADD CONSTRAINT FK_usertbl_buytbl
	FOREIGN KEY (userID)
	REFERENCES usertbl (userID);
	
DELETE FROM buytbl WHERE userID = 'PSH';
ALTER TABLE buytbl
	ADD CONSTRAINT FK_usertbl_buytbl
	FOREIGN KEY(userID)
	REFERENCES usertbl(userID);
	
INSERT INTO buytbl VALUES (NULL, 'PSH','모니터', '전자', 200, 5);

-- 모든 FK 허용
SET FOREIGN_key_checks = 0;
INSERT INTO buytbl VALUES(NULL, 'PSH', '모니터', '전자', 200, 5);
INSERT INTO buytbl VALUES(NULL, 'KHD', '청바지', '의류', 50, 3);
INSERT INTO buytbl VALUES(NULL, 'PSH', '메모리', '전자', 80, 10);
INSERT INTO buytbl VALUES(NULL, 'KJD', '책', '서적', 15, 5);
INSERT INTO buytbl VALUES(NULL, 'LHJ', '책', '서적', 15, 2);
INSERT INTO buytbl VALUES(NULL, 'LHJ', '청바지', '의류', 50, 1);
INSERT INTO buytbl VALUES(NULL, 'PSH', '운동화', NULL, 30, 2);
INSERT INTO buytbl VALUES(NULL, 'LHJ', '책', '서적', 15, 1);
INSERT INTO buytbl VALUES(NULL, 'PSH', '운동화', NULL, 30, 2);
SET FOREIGN_key_checks = 1;


ALTER TABLE usertbl
	ADD CONSTRAINT CK_birthYear
	CHECK (birthYear >=1900 AND birthYear <= 2021);

INSERT INTO usertbl VALUES ('KJD', '김제동', 1974, '경남', NULL, NULL, 173, '2013-3-3');
INSERT INTO usertbl VALUES ('NHS', '남희석', 1971, '충남', '016', '66666666', 180, '2017-4-4');
INSERT INTO usertbl VALUES ('SDY', '신동엽', 1971, '경기', NULL, NULL, 176, '2008-10-10');
INSERT INTO usertbl VALUES ('LHJ', '이휘재', 1972, '경기', '011', '88888888', 180, '2006-4-4');
INSERT INTO usertbl VALUES ('LKK', '이경규', 1960, '경남', '018', '99999999', 170, '2004-12-12');
INSERT INTO usertbl VALUES ('PSH', '박수홍', 1970, '서울', '010', '00000000', 183, '2012-5-5');	

ALTER TABLE buytbl
	DROP FOREIGN KEY FK_usertbl_buytbl;
ALTER TABLE buytbl
	ADD CONSTRAINT FK_usertbl_buytbl
		FOREIGN KEY(userID)
		REFERENCES usertbl(userID)
		ON UPDATE CASCADE
		ON DELETE CASCADE;

		



	