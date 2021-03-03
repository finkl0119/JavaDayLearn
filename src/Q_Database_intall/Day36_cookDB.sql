
-- 순위 매기기
USE COOKDB;
select row_number() over(order by height desc) "키큰순위", userName, addr, height from userTBL;
select row_number() over(order by height desc, userName asc) "키큰순위", userName, addr, height from userTBL;
-- 지역으로 나눈 호 키 순서로 검색
select addr, row_number() over(partition by addr order by height desc, userName asc) "지역별키큰순위", userName, height from userTBL;
-- 동률값이 나오면 똑같은 등수로 표현을 하구 그다음 등수를 +1 
select dense_rank() over(order by height desc) "키큰순위", userName, addr, height from userTBL;
-- 동률값이 나오면 똑같은 등수로 표현을 하고 그다음 등수를  같은 등수 만큼 더한 값을 부여
select rank() over(order by height desc) "키큰순위", userName, addr, height from userTBL;
-- 키를 그룹화 진행 2개로 한경우 큰사람 작은 사람을 부여해서 1은 큰사람 2는 작은 사람으로 그룹화
select ntile(2) over(order by height desc) "반번호", userName, addr, height from userTBL;
-- 키를 그룹화 진행 4개로 큰사람 작은 사람을 부여 그룹화
select ntile(4) over(order by height desc) "반번호", userName, addr, height from userTBL;

-- ////////////////////////////////////////////////////////////////////

-- CASE WHEN THEN 문 //pivote 방식
CREATE TABLE pivotTest
   (  uName CHAR(3),
      season CHAR(2),
      amount INT);

INSERT  INTO  pivotTest VALUES ('유재석' , '겨울',  10) ;
INSERT  INTO  pivotTest VALUES ('강호동' , '여름',  15) ;
INSERT  INTO  pivotTest VALUES ('유재석' , '가을',  25) ;
INSERT  INTO  pivotTest VALUES ('유재석' , '봄',    3) ;
INSERT  INTO  pivotTest VALUES ('유재석' , '봄',    37) ;
INSERT  INTO  pivotTest VALUES ('강호동' , '겨울',  40) ;
INSERT  INTO  pivotTest VALUES ('유재석' , '여름',  14) ;
INSERT  INTO  pivotTest VALUES ('유재석' , '겨울',  22) ;
INSERT  INTO  pivotTest VALUES ('강호동' , '여름',  64) ;

select * from pivotTest;
select uName,
	sum(case when season="봄" then amount end) as '봄'
    ,sum(case when season="여름" then amount end) as '여름'
    ,sum(case when season="가을" then amount end) as '가을'
    ,sum(case when season="겨울" then amount end) as '겨울'
from pivotTest
group by uName;

-- SET 문
USE cookDB;
set @myVar1 = 5;
set @myVar2 = 3;
set @myVar3 = 4.25;
set @myVar4 = 'MC 이름 ==> ';
SELECT @myVar1 ;
SELECT @myVar1 + @myVar3;
SELECT @myVar4, userName from userTBL where height > 180;

set @myVar1 = 3;
prepare myQuery 
	from 'select userName, height from usertbl order by height limit ?';
execute myQuery using @myVar1;

-- cast, convert
select avg(amount) as '평균 구매 개수' from buytbl;
select cast(avg(amount) as signed integer) as '평균 구매 개수' from  buytbl;
select convert(avg(amount), signed integer) as '평균 구매 개수' from buytbl;

-- ////////////////////////////////////////////////////////////


select if (100>200,'참이다','거짓이다');
select ifnull(null,'널이군요'), ifnull(100,'널이군요');
select nullif(100,100), ifnull(200,100);
/*수식1과 2가 같으면 null 다르면 수식1을 반환*/
select case 10
	   when 1 then '일'
       when 5 then '오'
       when 10 then '십'
       else '모름'
	end;
select ascii('a'), char(65);
select bit_length('abc'), char_length('abc'), length('abc');
select bit_length('가나다'), char_length('가나다'), length('가나다');
    
select concat_ws('/','2020','01','01');
select elt(2, '하나','둘','셋'), field('둘','하나','둘','셋'), find_in_set('둘','하나,둘,셋'), instr('하나둘셋','둘'),locate('둘','하나둘셋');
select format(123456.123456,4);
select bin(31),hex(31),oct(31);
select insert('abcdefghi',3,4,'@@@@'), insert('abcdefghi',3,2,'@@@@');
select left('abcdefghi',3),right('abcdefghi',3);
select lower('abcdEFGH'), upper('abcdEFGH');
select lpad('쿡북',7,'##'), rpad('쿡북',7,'##');
select ltrim('     쿡북'), rtrim('쿡북     ');
select trim('    쿡북    '), trim(both 'ㅋ' from 'ㅋㅋㅋ재미있어요.ㅋㅋㅋ');

select replace('IT 쿡북 MySQL','쿡북','CookBook');
select reverse('MySQL');
select concat('IT',space(10),'CookBook MySQL');
select substring('대한민국만세',3,2);
select substring_index('www.mysql.com','.',2),substring_index('www.mysql.com','.',-2);
select abs(-100);
select ceiling(4.7), floor(4.7), round(4.7);
select conv('AA',16,2), conv(100,10,8);
select degrees(pi()), radians(180);
select mod(157,10),157 % 10,157 mod 10;
select pow(2,3),sqrt(9);

select rand(),floor(1+(rand()*(6-1)));
select sign(100),sign(0),sign(-100.123);
select truncate(12345.12345,2), truncate(12345.12345,-2);
select adddate('220-01-01',interval 31 day), adddate('2020-01-01',interval 1 month);
select subdate('2020-01-01',interval 31 day), subdate('2020-01-01',interval 1 month);
select addtime('2020-01-01 23:59:59','1:1:1'), addtime('15:00:00','2:10:10');
select subtime('2020-01-01 23:59:59','1:1:1'), subtime('15:00:00','2:10:10');
select year(curdate()),month(curdate()),dayofmonth(current_date);
select hour(curtime()),minute(current_time()),second(current_time),microsecond(current_time);
select date(now()),time(now());
select datediff('2023-01-01',now()),timediff('23:23:59','12:11:10');

select dayofweek(curdate()),monthname(curdate()),dayofyear(curdate());
select last_day('2020-02-01');
select makedate(2020,32);
select maketime(12,11,10);
select period_add(202001,11), period_diff(202001,201812);
select quarter('2020-07-07');
select time_to_sec('12:11:10');

select current_user(),database();
use cookdb;
select * from usertbl;
select found_rows();
use cookdb;
update buytbl set price=price*2;
select row_count();
select sleep(5);
select '5초후에 이게 보여요';

-- ////////////////////////////////////////////////////////////
-- json 형식
select json_object('name', userName, 'height', height) as 'json 값'
from usertbl where height >= 180;

set @Json=
'{
	"usertbl" :[	
		{"name":"강호동", "height":"182"}
		,{"name":"이휘재", "height":"180"}
		,{"name":"남희석", "height":"180"}
		,{"name":"박수홍", "height":"183"}
	]
}';

-- json 형식이면 1반환 아니면 0반환
select json_valid(@Json) as json_valid;
-- 세번째 파라미터에 주어진 문자열의 위치를 ㅂ ㅏㄴ환한다. 두번째 파라미터는 one 또는 all중 하나가 올수 있다.
-- one은 처음으로 매치되는 하나만 반환 / all은 모두 반환 
select json_search(@Json, 'one', '남희석') as json_search;
-- search와 반대로 지정된 위치의 값을 반환
select json_extract(@Json, '$.usertbl[2].name') as json_extract;
-- 새로운 값을 추가
select json_insert(@Json, '$.usertbl[0].mDate','2019-09-09') as json_insert;
-- 값을 변경
select json_replace(@Json, '$.usertbl[0].name','토마스') as json_replace;
-- 지정된 항목을 삭제한다.
select json_remove(@Json, '$.usertbl[0]') as json_remove;


-- DB에서 파일 관리
create database movieDB;

use movieDB;
create table movieTBL
	(movie_id	int
    ,movie_title 	varchar(30)
    ,movie_director 	varchar(20)
    ,movie_star 	varchar(20)
    ,movie_script longtext
    ,movie_film longblob
    )default charset=utf8mb4;
    
insert into movietbl values(1, '쉰들러 리스트', '스필버그', '리암리슨',
load_file('G:/99. Mysql_Work/Movies/Schindler.txt'), load_file('G:/99. Mysql_Work/Movies/Schindler.mp4'));
select * from movietbl;
SHOW variables LIKE 'MAX_ALLOWED_PACKET';
SHOW variables LIKE 'SECURE_FILE_PRIV';

-- my.ini 파일에서 'MAX_ALLOWED_PACKET' 해당 용량 1024M 으로 수정
-- my.ini 파일에서 'SECURE_FILE_PRIV' 위 G드라이브 G:/99. Mysql_Work/Movies 이거 경로로 수정

use movieDB;
truncate movietbl;
insert into movietbl values(1, '쉰들러 리스트', '스필버그', '리암리슨',
load_file('G:/99. Mysql_Work/Movies/Schindler.txt'), load_file('G:/99. Mysql_Work/Movies/Schindler.mp4'));
insert into movietbl values(2, '쇼생크 탈출', '프랭크 다라본트', '팀 로빈스',
load_file('G:/99. Mysql_Work/Movies/Shawshank.txt'), load_file('G:/99. Mysql_Work/Movies/Shawshank.mp4'));
insert into movietbl values(3, '라스트 모히칸', '마이클 민', '다니엘 데이 루이스',
load_file('G:/99. Mysql_Work/Movies/Mohican.txt'), load_file('G:/99. Mysql_Work/Movies/Mohican.mp4'));
select * from movietbl;

select movie_script from movietbl where movie_id=1
	into outfile 'G:/99. Mysql_Work/Movies/Schindler_out.txt'
	lines terminated by '\\n';
    
select movie_film from movietbl where movie_id=3
		into dumpfile 'G:/99. Mysql_Work/Movies/Mohican_out.txt';

		
-- 조인
use cookDB;
select * from buytbl inner join usertbl on buytbl.userID = usertbl.userID
where buytbl.userID = 'KYM';

SELECT userID, userName, prodName, addr, concat(mobile1, mobile2) as '연락처'
from buytbl inner join usertbl on buytbl.userID = usertbl.userID;

select buytbl.userID, userName, prodName, addr, concat(mobile1, mobile2) as '연락처'
from buytbl inner join usertbl on buytbl.userID = usertbl.userID;
 
		
		
		
		