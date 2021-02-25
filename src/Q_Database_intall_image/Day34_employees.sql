CREATE TABLE indexTBL(first_name varchar(14),
last_name varchar(16), hire_date date);

--employees 안에 있는 500개 데이터를 indexTBL 안에 
insert into indexTBL
	select first_name,last_name,hire_date
	from employees limit 500;
	
select * from indexTBL;
select * from indexTBL where first_name='Mary';
-- 인덱스 key 설정
create index idex_indexTBL_firstname on indexTBL(first_name);




    
