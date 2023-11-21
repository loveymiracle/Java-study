-- ORDER BY 절 ★★★★★ ★★★★★
-- - select문에서 나온 결과값을 정렬하는 기능, 명령어 우선순위가 두번째로 낮음. (LIMIT절이 제일 낮음)
-- ex) SELECT * FROM [Table 이름] ... ORDER BY [컬럼명] or 숫자(컬럼 순서), 별칭 [정렬순서 *ASC or DESC] * : default
-- 정렬 가능한 범위 : 숫자, 문자, 날짜 - 다된다!

select emp_name from employee order by emp_name; -- 이름 순으로 정렬, 순서는 default=오름차순 = ASC
select emp_name from employee order by emp_name asc; -- 오름차순, 명시적 표기 - X
select emp_name from employee order by emp_name desc; -- 내림차순 정렬

-- 숫자
select emp_name, salary from employee order by salary asc;
select emp_name, salary from employee order by salary desc;

-- 날짜
select emp_name, hire_date from employee order by hire_date asc;
select emp_name, hire_date from employee order by hire_date desc;

-- 컬럼명이 아닌 출력 순서로 정렬하는 방법 (index=숫자), ※권장하지 않음! 쓰지 말것
--        1.      2
select emp_id, emp_name from employee order by 1 desc; -- emp_id
select emp_id, emp_name from employee order by 2 desc; -- emp_name

-- 컬럼명이 아닌 별명으로 정렬하기 - 함수나 복잡한 컬럼명을 별명으로 축약 가능
select emp_id, emp_name as 이름 from employee order by 이름;
select emp_name, emp_no, substr(emp_no, 8, 1) from employee order by substr(emp_no, 8, 1);
select emp_name, emp_no, substr(emp_no, 8, 1) as 성별 from employee order by 성별;

-- 다중 정렬도 가능, 순서가 우선순위가 된다. ★★★★★
select * from employee order by dept_code, job_code, sal_level;
select * from employee order by dept_code asc, job_code desc, sal_level desc;

-- LIMIT절 : 조회시 행의 LIMIT(제한)을 두고 값을 자르는 기법 ★★★★★ ★★★★★★
--          페이지를 구성하는 경우 특정 순서로 행을 자를 때 사용한다. ex) TOP 5, 최근 게시글 10개 
-- ※ 주의점 : 정렬이 되지 않은 상태는 page 구성은 무의미 함으로 정렬 사용이 필수!!

select * from employee limit 5; -- 현재 pk 기준으로 정렬 된 상태라 limit만 써도 무관 -> 권장 X
select * from employee order by emp_id limit 5; -- 명시적 표기, 가독성 측면에서 좋다.

-- 월급이 많은 5명
select * from employee order by salary desc limit 5;

-- OFFSET절 : LIMIT절과 결합하여 일정순서를 건너 띄고 조회 가능한 문법 
-- -> 페이징처리 : ORDER BY + LIMIT + OFFSET 결합하여 활용 ★★★★★

-- emp_id 순으로 0개를 건너뛰고 5개의 값을 가져오는 문법 - page 1
select * from employee order by emp_id limit 5 offset 0;

-- emp_id 순으로 5개를 건너뛰고 5개의 값을 가져오는 문법 - page 2
select * from employee order by emp_id limit 5 offset 5;

-- emp_id 순으로 5개를 건너뛰고 5개의 값을 가져오는 문법 - page 3
select * from employee order by emp_id limit 5 offset 10;

-- 월급이 많은 5~10순위
select * from employee order by salary desc limit 5 offset 0; -- 1 ~ 5
select * from employee order by salary desc limit 5 offset 5; -- 5 ~ 10

-- offset 문장이 생략 가능하다. -> 권장하지 않는다. 생각한 순서가 아니라 햇갈린다.
select emp_name, salary from employee order by salary desc limit 5, 5;
select emp_name, salary from employee order by salary desc limit 0, 5; -- 앞이 offset이고 , 뒤가 limit 숫자 ..

-- 그룹 함수 : 결과 값이 N:1로 조합되는 함수, ex) AVG(평균), SUM(총합), COUNT(갯수 세기), MIN(최소값), MAX(최대값)
--           그룹 함수는 DB에서 무거운 기능, 성능적 고려 필요, 느려지는 이유 : 모든 행을 조회해서 해당 열만 가져오기 때문에 full scanning 이 된다.

-- sum : 컬럼의 총합을 구하는 함수
select sum(salary) from employee;

-- avg : 컬럼의 평균을 구하는 함수
select avg(salary) from employee;

-- count : 컬럼의 갯수를 구하는 함수 ★★★★★
select count(*) from employee;
select count(emp_id) from employee;
select count(*) from employee where dept_code = 'D5'; -- D5부서의 인원

-- max : 컬럼의 최대값을 구하는 함수
select max(salary) from employee;

-- min : 컬럼의 최소값을 구하는 함수
select min(salary) from employee;

-- GROUP BY ★★
-- - 그룹함수를 사용할때 그룹핑하여 그룹별로 계산이 가능한 명령어
-- - ex) 직급별 월급 평균, 합, 부서별 월급 평균 합, 가장 많이 받는 사람

-- 부서별, 직위별 월급 평균 계산
select dept_code, avg(salary) from employee; -- 안된다! avg -> N:1로 결과가 나오고, dept_cde : n:n 결과가 나와서
select dept_code, avg(salary) from employee group by dept_code; -- 정렬되진 않는다!
select dept_code, avg(salary) from employee group by dept_code order by dept_code;
select job_code, avg(salary) from employee group by job_code order by job_code;

-- where절 결합 - group 함수가 실행되기 전에 먼저 실행되어 필터링을 해주는 역활을 한다.
-- 부서 코드가 없는 사람을 제외한 부서 별 월급의 평균
SELECT dept_code, AVG(salary) FROM employee
where dept_code is not null
GROUP BY dept_code
ORDER BY dept_code;
 
-- 부서 코드가 없는 사람의 월급 평균
SELECT dept_code, AVG(salary) FROM employee
where dept_code is null
GROUP BY dept_code
ORDER BY dept_code;

-- 부서 별 인원
select dept_code, count(*) from employee group by dept_code order by dept_code;

-- goup by절 다중으로 활용하기
-- 부서별 - 부서내 직급별 인원 세기
select dept_code, job_code, count(*)
from employee
where dept_code is not null
group by dept_code, job_code
order by dept_code, job_code;

-- 정렬을 count로 하고 싶을 때 ?
select dept_code, job_code, count(*)
from employee
where dept_code is not null
group by dept_code, job_code
order by count(*) desc;

-- HAVING 절 ★★
-- - 그룹함수의 결과가 나오고 그 결과에서 조건절을 찾을때 사용하는 방법 (그룹연산시 후행 연산)
-- - WHERE절은 그룹함수가 계산되기 전에 반영됨으로 선행연산이 되고 HAVING절은 그룹함수 이후에 실행
-- - 실행 순서 : where(값 필터링) - 그룹 함수 - having(결과를 다시 조건 반영)

-- 부서별 월급 평균
select dept_code, round(avg(salary)) as 평균 from employee group by dept_code order by 평균 desc;

-- 부서별 월급 평균이 300만원 이상인 부서만 출력
-- 1. where 절로 시도해보기 (?) -> 틀린 답!
-- - 월급이 300만원 이상인 직원을 찾고 부서별 평균 구하기 
select dept_code, round(avg(salary)) from employee
where salary >= 3000000
group by dept_code;

-- 2. having 절로 시도해보기 -> 정답!!!
select dept_code, round(avg(salary)) from employee
group by dept_code
having round(avg(salary)) >= 3000000;

-- as문 처리
select dept_code, round(avg(salary)) as 월급평균 from employee
group by dept_code
having 월급평균 >= 3000000;

-- 부서원이 3명 이상인 부서만 출력
select dept_code, count(*) from employee 
group by dept_code having count(*) >= 3 order by dept_code;

-- ROLLUP : 두개의 컬럼 이상을 그룹핑하여 표현할때 사용 가능, ROLLUP에 선언된 왼쪽 순으로 소계나 총계를 구해오는 기능

-- 부서, 직급별 인원을 세오는 쿼리
select dept_code, job_code, count(*)
from employee group by dept_code, job_code
with rollup;

-- GROUPING 
--  - GROUP BY에 산출된 ROW인 경우에는 0을 반환
--  - ROLLUP를 이용해서 산출되는 ROW 1 이상으로 반환

SELECT DEPT_CODE, JOB_CODE, SUM(SALARY),
	CASE WHEN GROUPING(DEPT_CODE) = 0 AND GROUPING(JOB_CODE) = 1 		
	       THEN '부서별 합계'
	       WHEN GROUPING(DEPT_CODE) = 1 AND GROUPING(JOB_CODE) = 1 		
	       THEN '총 합계'
	       ELSE '그룹별 합계'
	END AS 구분
FROM EMPLOYEE
GROUP BY DEPT_CODE, JOB_CODE WITH ROLLUP;

-- 집합 연산자 (UNION, ALL UNION 나머지가 있었는데 Mysql은 지원하지 않음)
-- - 여러개의 select문을 합칠때 사용하는 연산, select절의 table이 달라도 컬럼 갯수만 맞추면 결합이 가능
-- - 서로 다른 테이블간의 결합을 할때 사용된다 ★★★★★
-- - 제약 : table이 달라도 되지만 컬럼 갯수와 type은 일치해야한다.
-- - 사용처 : 서로 다르게 설계한 table간의 결합이 필요할때 사용된다. (대부분이 설계 미스인 경우다. 권장하진 않지만 빈도는 높은 명령어)
-- - 장점 : 다르게 설계된 테이블도 결합이 가능하다.
-- - 단점 : 연산이 느리다. 다단 UNION은 성능적으로 금기인 명령어!!

-- 직원 테이블과 부서 테이블을 결합 (의미는 없고 훈련용도!)

-- 아래 문장 안된다! 필드 갯수가 일치하지 않아서 !
select emp_id, emp_name, dept_code from employee
union
select dept_id, dept_title from department;

-- 컬럼의 갯수만 맞추면 결합이 가능하다.
select emp_id, emp_name from employee
union
select dept_id, dept_title from department;

-- 다른 테이블 연습
select local_code, local_name from location
union
select job_code, job_name from job;

-- 부서가 D5이거나 월급이 300만 이상인 사람
select emp_name, salary, dept_code from employee where dept_code = 'D5'
union
select emp_name, salary, dept_code from employee where salary > 3000000;

-- or 절로 같은 결과가 나온다!!
select emp_name, salary, dept_code from employee where dept_code = 'D5' or salary > 3000000;

-- union all, 겹치는 영역이 필터링 되지 않을 때
select emp_name, salary, dept_code from employee where dept_code = 'D5'
union all
select emp_name, salary, dept_code from employee where salary > 3000000;
