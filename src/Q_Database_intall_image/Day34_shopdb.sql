CREATE TABLE `shopdb`.`membertbl` (
  `memberID` CHAR(8) NOT NULL,
  `memberName` CHAR(5) NOT NULL,
  `memberAddress` CHAR(28) NULL);

  ALTER TABLE `shopdb`.`membertbl` 
ADD PRIMARY KEY (`memberID`);
;
  
  CREATE TABLE `shopdb`.`producttbl` (
  `productName` CHAR(4) NOT NULL,
  `cost` INT NULL,
  `makeDate` DATE NULL,
  `company` CHAR(5) NULL,
  `amount` INT NOT NULL,
  PRIMARY KEY (`productName`));

-- 데이터 추가
INSERT INTO `shopdb`.`membertbl` (`memberID`, `memberName`, `memberAddress`) VALUES ('Thomas', '토마스', '인천 연수구');
INSERT INTO `shopdb`.`membertbl` (`memberID`, `memberName`, `memberAddress`) VALUES ('Edword', '애드워드', '인천 남동구');
INSERT INTO `shopdb`.`membertbl` (`memberID`, `memberName`, `memberAddress`) VALUES ('Henry', '헨리', '인천 남동구 주안동');
INSERT INTO `shopdb`.`membertbl` (`memberID`, `memberName`, `memberAddress`) VALUES ('Gorden', '고든', '경기 성남시 분당구');

INSERT INTO `shopdb`.`producttbl` (`productName`, `cost`, `makeDate`, `company`, `amount`) VALUES ('냉장고', '10', '2021-02-23', '삼성', '17');
INSERT INTO `shopdb`.`producttbl` (`productName`, `cost`, `makeDate`, `company`, `amount`) VALUES ('컴퓨터', '20', '2020-03-01', 'LG', '3');
INSERT INTO `shopdb`.`producttbl` (`productName`, `cost`, `makeDate`, `company`, `amount`) VALUES ('모니터', '5', '2021-09-01', '롯데', '22');


SELECT * FROM MEMBERTBL;
SELECT memberName, memberAddress FROM MEMBERTBL;
SELECT * FROM MEMBERTBL WHERE memberName = '토마스';
CREATE TABLE `my testTBL`(id INT);
SELECT * FROM `my testTBL`;
DROP TABLE `my testTBL`;

-- 사용자에게만 오픈하기 위한 테이블
create view uv_memberTBL as 
	select memberName,memberAddress from membertbl;
    
select * from uv_memberTBL;  

create view uv_memberTBL as 
	select memberName,memberAddress from membertbl;
    
select * from uv_memberTBL;    

-- *** 프로시져
-- //는 기존의 세미콜론으로 대신한다는 의미
DELIMITER //
create procedure myProc()
begin 
	select * from membertbl where memberName = '토마스';
	select * from producttbl where productName = '냉장고';
 end //
DELIMITER ;

-- 프로시져 실행
call myProc();   

-- *** 트리거
create table deletedMembertbl
(	
	memberID char(8),
	memberName char(5),
	memberAddess char(20),
	deleteDate date
);

DELIMITER //
create TRIGGER trg_deletedMembertbl -- 트리거 이름 **조건
	after delete -- 삭제후에 작동하제 지정
    on membertbl -- 트리거를 부착할 테이블
    for each row -- 각 행 마다 적용시킴
begin -- old 테이블의 내용을 백업 테이블에 삽입 **실행 
	insert into deleteMemberTBL
		values (old.memberID, old.memberName, old.memberAddress,
        curDate() );
end //
DELIMITER ;
-- 트리거 실행
select * from memberTBL;
insert into membertbl values ('Soccer','흥민','서울시 서대문구 북가좌동');
delete from membertbl where memberName='흥민';
select * from memberTBL;
select * from deletedmembertbl;
