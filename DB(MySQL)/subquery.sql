-- Sub Query란? ★
-- 하나의 Quary안에 또 다른 Quary이 존재하는 문장
-- 형식 : Quary1 WHERE (Quary2) 
-- ( )로 문장을 구분하고 WHERE 절 오른쪽에 위치

-- 전지연 사원의 관리자의 이름을 출력
select manager_id from employee where emp_name = '전지연';
select emp_name from employee where emp_id = 214;

-- join을 통해 한번에 출력하는 방법 = 성능적 우위
select e1.emp_name, e2.emp_name
from employee e1
join employee e2
on e1.manager_id = e2.emp_id
where e1.emp_name = '전지연';

-- sub query로 활용하는 방법
select emp_name from employee 
where emp_id = (select manager_id from employee where emp_name = '전지연');

-- 평균 급여보다 많은 사람 찾기
select avg(salary) from employee;
select emp_id, emp_name, salary from employee where salary > 3047662.6087;
select emp_id, emp_name, salary from employee where salary > (select avg(salary) from employee) order by salary desc;

-- 평균 급여보다 많은 사람의 이름과 부서 이름 까지 출력 (join + sub query)
select 
	e.emp_id, e.emp_name, e.salary, d.dept_title 
from employee e
join department d on e.dept_code = d.dept_id 
where salary > (select avg(salary) from employee)
order by salary desc;

-- 1. 단일행 서브쿼리 : 서브쿼리의 결과가 한개 열에 한개 행을 매칭시킬 때
--   ex) 윤은해 사원과 동일한 급여를 받고 있는 사원 찾기
select emp_name from employee 
where 
	salary = (select salary from employee where emp_name ='윤은해')
    and emp_name != '윤은해';

-- ex) 최대 급여와 최소 급여를 받는 사람을 동시에 찾는 방법
select max(salary) from employee;
select min(salary) from employee;

select emp_name from employee
where salary = (select max(salary) from employee) or salary = (select min(salary) from employee);

-- 2. 다중행 서브쿼리 : 한개의 컬럼에 다수의 행을 조회하는 문구
-- ※ 주의 : 행이 다수임으로 '=' 비교 불가! IN(), NOT IN() 문제를 해결
--          ANY, ALL, EXIST()문 활용 가능

-- 송종기, 박나라와 같은 부서 사람
select dept_code from employee where emp_name = '송종기' or emp_name = '박나라';
select dept_code from employee where emp_name in ('송종기', '박나라');
select emp_name, dept_code from employee
where dept_code = (select dept_code from employee where emp_name in ('송종기', '박나라')); -- 안되는 쿼리! 1행보다 결과가 많아서

select emp_name, dept_code from employee
where dept_code in (select dept_code from employee where emp_name in ('송종기', '박나라'));

-- 송종기, 박나라와 같지 않은 부서 사람
select emp_name, dept_code from employee
where dept_code not in (select dept_code from employee where emp_name in ('송종기', '박나라'));

-- 직급이 '대표', '부사장'이 아닌 사람
select emp_name, job_code from employee
where job_code in (select job_code from job where job_name not in('대표', '부사장'));

-- 직급이 '대표', '부사장'이 아닌 사람들 직급의 이름
select e.emp_name, e.job_code, j.job_name
from employee e
join job j
where j.job_code in (select job_code from job where job_name not in('대표', '부사장'));

-- join으로도 가능하다.
select e.emp_name, e.job_code, j.job_name
from employee e
join job j
where j.job_name not in ('대표', '부사장');

-- ANY = SOME
-- ANY 대소비교, 동등비교, ANY에 있는 값을 OR로 연결 비교

-- 직원 중에 j3 직급 직원들의 최소급여보다 많이 받는 사람
select emp_name, salary from employee
where salary > any(select salary from employee where job_code = 'j3');

select emp_name, salary from employee
where salary > some(select salary from employee where job_code = 'j3');

-- 다중열 쿼리 : 행이 한개이면서 컬럼이 여러개인 서브쿼리
-- ex) 퇴사한 사원과 같은 부서였거나 같은 직급이 었던 사람.

-- 단일 행으로 해결하는 방법, 문제점 : select를 2번 해야 한다.
select dept_code from employee where ent_yn = 'Y';
select job_code from employee where ent_yn = 'Y';

select emp_name, dept_code, job_code from employee
where dept_code = (select dept_code from employee where ent_yn = 'Y')
		or job_code = (select job_code from employee where ent_yn = 'Y');

-- 다중열 서브쿼리 (= 사용 문법, 다중열로만 조회하면 = 사용 가능!)
select emp_name, dept_code, job_code from employee
where (dept_code, job_code) = (select dept_code, job_code from employee where ent_yn = 'Y');

-- 다중열 서브쿼리 (in 사용 문법, 다중열, 다중행 모두 사용 할 수 있다.!) ★★★★★
select emp_name, dept_code, job_code from employee
where (dept_code, job_code) in (select dept_code, job_code from employee where ent_yn = 'Y');

-- 다중행 다중열 서브쿼리 : 행도 여러개, 열도 여러개
-- ex) 부서별 최소 급여인 사람 구하는 법, 이름을 출력하는 쿼리
-- 부서별 최소급여를 받는 사람 찾는 법
select dept_code, min(salary) from employee group by dept_code;

select emp_name, dept_code, salary from employee 
where (dept_code, salary) in (select dept_code, min(salary) from employee group by dept_code)
order by dept_code;

-- 상관 서브쿼리 (상호 연관)
-- 서브쿼리를 구성할때 메인쿼리에 있는 값을 가지고와서 작성할때 사용

-- EXISTS : ROW 1개 이상이 있다면 무조건 TRUE, ROW가 0이면 FALSE; 
SELECT * FROM employee WHERE EXISTS(select dept_code from employee WHERE dept_code = 'D9');
SELECT * FROM employee WHERE EXISTS(select dept_code from employee WHERE dept_code = 'D11');

-- 서브쿼리 사용시 주의점
-- 1. 서브쿼리 사용시 항상 성능적으로 많은 자원을 활용함으로 cost 확인 필요
--  -- 다중행, 다중열을 조회 할때보다 알고리즘을 해결할때가 빠를수 있다.
-- 2. INDEX를 적극 활용 하고, JOIN문으로 웬만하면 해결 할 것 -> 그나마 빠르다.

-- 매니저 아이디를 출력해라
-- 스칼라 서브쿼리 = join문을 대체할 수 있는 sub query, 상호서브쿼리=메인쿼리의 결과를 서브쿼리에 반영
select emp_id, emp_name, manager_id, (
	select emp_name from employee where e1.manager_id = emp_id
) from employee e1;

select e1.emp_id, e1.emp_name, e1.manager_id, e2.emp_name
from employee e1
join employee e2 on e1.manager_id = e2.emp_id;

-- 기존 방식 JOIN 활용 ★★★ 추천
select e.emp_id, e.emp_name, e.manager_id, m.emp_name
FROM employee e JOIN employee m ON e.manager_id = m.emp_id;

-- TON-N 분석 = RANKING : ROW에 순위를 매기는 문법 ★★★★★
-- ex) 급여를 많이 받는 3명, 댓글이 제일 많은 글, 추천수 or 좋아요가 많은 게시물
--     최근 글 중에 10개를 달라 -> 페이징 처리 ★★★★★

-- 1. RANK() OVER(정렬기준) : 정렬시 행의 숫자대로 랭크 부여
-- 동일 순위가 있을때 다음 순위는 동일 순위 인원 만큼 카운팅
SELECT emp_name, salary, RANK() OVER(ORDER BY salary DESC, job_code) AS 순위 FROM employee;

-- 2. DENSE_RANK() OVER(정렬기준) : 중복된 순위가 있는 경우, 사람수에서 제외하고 Count
-- 동일 순위가 있을때 다음 순위는 1명으로만 카운팅
SELECT emp_name, salary, DENSE_RANK() OVER(ORDER BY salary DESC) AS 순위 FROM employee;

-- 3. row_number() over(정렬기준) : 중복이 있어도 순서대로 카운팅하는 기능
SELECT EMP_NAME, SALARY, row_number() over(order by SALARY desc) as 순위 FROM EMPLOYEE;

-- with절 : 임시 테이블 또는 가상 테이블 별칭으로 임시값을 저장하고, 활용할수 있는 sub쿼리(함수화)
with sum_sal as (select sum(salary) from employee),
	 avg_sal as (select avg(salary) from employee),
	 count_sal as (select count(salary) from employee)
select * from sum_sal, avg_sal, count_sal;

with sum_sal as (select sum(salary) from employee),
	 avg_sal as (select avg(salary) from employee),
	 count_sal as (select count(salary) from employee)
select * from sum_sal
union 
select * from avg_sal
union 
select * from count_sal;

-- DB 고수들의 머리속 생각 -> 쿼리를 최대한 한번에 묶어서 요청하고 한번에 받아오기 위한 머리를 쓴다.
-- -> 하수일때는 여러번 요청해서 기능을 최대한 빠르게 만드는게 좋은것 같다.
