use employees;
select * from employees;
select * from titles;
select first_name from employees;

-- limit 절
use employees;
select emp_no, hire_date from employees order by hire_date asc;
select emp_no, hire_date from employees order by hire_date asc limit 5;
select emp_no, hire_date from employees order by hire_date asc limit 0, 5;

