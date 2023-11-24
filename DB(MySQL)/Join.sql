-- JOIN문 ★★★★★
-- - 두 테이블 간에 결측(Null)이 없는 값만 테이블로 통합하는 방법 (Inner join)
-- - 두 테이블 간에 결측(Null)이 있어도 통합이 가능한 방법 (Ouuter join) 
-- - 자기 자신과도 Join이 가능하다. (Self join)

-- 오라클식 Join(Mysql가능, 수업에서는 권장하진 않음!)
select * from employee;
select * from department;

-- 조인하는 가장 간단한 방법, 컬럼명이 모두 다를 때
select emp_name, dept_code, dept_id, dept_title
from employee, department
where dept_code = dept_id;

-- Join중 테이블 컬럼명(키값)이 겹칠 때 해결 방법
-- 1. table 이름으로 컬럼명을 분리
select emp_name, employee.job_code, job_name
from employee, job
where employee.job_code = job.job_code;

-- 2. table 별칭으로 컬럼명을 분리하는 방법 ★★★★★(권장)
-- 네이밍 하는 방법 : table의 첫글자로 별칭을 만들고 만일 겹치면 e1, e2 숫자로 분리한다.
select emp_name, j.job_code, job_name
from employee e, job j
where e.job_code = j.job_code;

-- 보통 table의 as 키워드는 생략을 많이 함
-- 와일드 카드로 테이블 모든 값을 출력하는 방법
select e.*, j.*
from employee e, job j
where e.job_code = j.job_code;

-- ANSI식 (American National Standards Institute) 권장(수업) ★★★★★★
select emp_name, dept_title
from employee
join department on dept_id = dept_code;

-- on의 괄호를 사용하는 스타일도 존재 -> using은 괄호가 무조건 필요한데, on활용하는 것으로 추정
select emp_name, dept_title
from employee
join department on (dept_id = dept_code);

-- 추천하는 문법 ✭✭✭✭✭
-- 좋은 이유 ; 별칭을 활용하는 문법, using도 같은 스타일로 처리가 가능
select emp_name, dept_title
from employee e
join department d on e.dept_code = d.dept_id;

-- using 문법 : join이 되는 키값의 이름이 같을 때, 주의점 : 괄호가 반드시 필요!!!
select emp_name, job_name
from employee join job
using (job_code);

-- 추천 문법을 활용하면 기계적으로 join이 되어 on/using 구별하지 않아도 된다. ✭✭✭✭✭
select emp_name, j.job_name
from employee e join job j
on e.job_code = j.job_code;

-- 연습 하기
desc employee;
desc sal_grade;

-- 답
select e.emp_name, s.sal_level, s.min_sal, s.max_sal
from employee e
join sal_grade s
on e.sal_level = s.sal_level;

desc location;
desc national;

select l.local_code, l.local_code, l.national_code, n.national_code, n.national_name
from location l
join national n
on l.national_code = n.national_code;

-- 풀어 보기
select emp_name, s.sal_level
from employee e join sal_grade s
on e.sal_level = s.sal_level;

select local_code, national_code
from location l join national n
on l.national_code = n.national_code;

-- Inner JOIN : 일반적인 Join문 특별한 키워드가 없는 Join 문장  
--              외래키를 사용하는데 null을 허용하지 않고 외래키와 주키가 완벽하게 일치하면 사용하면 된다.
--              -> 반대로 null이 허용되는 경우에 null이 포함된 값을 조회하는 경우는 Outer JOIN을 사용해야 한다.
--              ex) 게시글의 글쓴 사람, 결제 시의 물품 번호 

-- Outer JOIN : LEFT, RIGHT 키워드가 포함된 JOIN 문으로 키가 서로 일치 않는 경우에도 조회 가능하다.
--              한쪽 테이블 기준으로 결측 값(null)이 있어도 join이 가능함 
-- 			ex) 주문테이블과 카드결제 테이블을 같이 조회할때, 카드결제가 아니어도 같이 조회할 때
-- 		            게시글과 댓글을 같이 조회할때 댓글이 없어도 같이 조회할때
--              ※ 주로 잘못된 설계나 결측(null)값을 비정상적으로 조회할때 사용된다. 
--                -> Inner join 대비 성능 저하가 크게 발생하나 어쩔수 없이 사용해야한다.

-- left join(ANSI) - 왼쪽 기준으로 오른쪽 null 값이 조회 되는 경우
-- 키워드 : left outer join or left join
select emp_name, dept_title
from employee e
join department d
on e.dept_code = d.dept_id;

select emp_name, e.dept_code, dept_title
from employee e left outer join department d
on e.dept_code = d.dept_id;

-- right join(ANSI) - 오른쪽 기준으로 왼쪽 null 값이 조회 되는 경우
-- 키워드 : right outer join or right join
select emp_name, e.dept_code, dept_title
from employee e right outer join department d
on e.dept_code = d.dept_id;

-- join문 where절 결합 ★★★★★

-- oracle 문법 -> 기본적으로 where절이 하나 들어감으로 논리절 조심!
-- 총무부 이거나 기술지원부인 사람을 찾아라
select emp_name, dept_code, dept_title
from employee e, department d
where e.dept_code = d.dept_id and (d.dept_title = '총무부' or d.dept_title = '기술지원부');

-- ansi 표준 ★★★★★
select 
	e.emp_name, e.dept_code, d.dept_title
from employee e
join department d on e.dept_code = d.dept_id
where d.dept_title = '총무부' or d.dept_title = '기술지원부';

-- CROSS JOIN : Cartesian(카테시안) 곱, ROW간 결합될수 있는 전체 경우수를 출력
select emp_name, dept_title
from employee
cross join department;
-- 사용하는 경우 매우 드물다.

-- self join : 테이블 하나로 join을 활용하는 경우, 자기 자신을 참조할 일이 생긴다.(자신이 트리구조로 구성 될 때)
-- 자신의 id, 이름, 관리자의 id, 이름을 출력
select e1.emp_id, e1.emp_name, e1.manager_id, e2.emp_name 
from employee e1
join employee e2
on e1.manager_id = e2.emp_id;

-- 다중 join : 3개 이상의 테이블을 결합할때 사용 ★★★★★

-- employee, job, department, location
-- 직원 id, 이름, 직위이름, 부서이름, 부서의 국가 위치, 국가 이름, local 이름
-- 주의점 : join 순서가 존재한다!

select * from employee;
select * from job;
select * from department;
select * from location;

select
	e.emp_id, e.emp_name, j.job_name, d.dept_title, d.location_id, l.local_name, l.national_code
from employee e
join job j on e.job_code = j.job_code
join department d on e.dept_code = d.dept_id
join location l on d.location_id = l.local_code;

-- oracle문법 다중 조인
select e.emp_id, e.emp_name, j.job_code, d.dept_title, l.local_name, l.national_code
from employee e, job j, department d, location l
where e.job_code = j.job_code 
and e.dept_code = d.dept_id 
and d.location_id = l.local_code;

-- NON_EQU JOIN : 비등가조인 일치하는 범위에 값을 가져오는 기능
SELECT EMP_NAME, SALARY, E.SAL_LEVEL
FROM EMPLOYEE E
JOIN SAL_GRADE S ON (SALARY BETWEEN 3000000 AND 3500000);

-- DB에서 성능적으로 고려 할 순서 (연산이 오래 걸리는 시간)
-- 1. 네트워크 전송시간 -> 여러 네트워크를 통해 DB 사용함으로써 전송시간에 딜레이 생긴다.
-- 2. HDD(하드디스크, SSD)에서 읽어오는 시간 -> 캐시를 통해 빠르게 접근하기는 하지만 느리다!
-- 3. 쿼리 처리 시간 (복잡한 함수나 로직으로 인해 처리가 지연되는 시간)

-- JOIN문을 사용할때 주의 해야할 점 = 이유? 잘못 사용하면 과도한 JOIN으로 인해 성능저하 발생!
-- 1. index 생성된 값을 키값으로 사용 할 것 (PK는 index를 자동 생성함으로 PK로 join 권장) /PK = primary key
-- 2. 결합하는 값은 주로 외래키 = 주키로 사용할 것 ★★★★★
--    -> DB 설계할때 sequance number 통해 주키를 할당하고 해당 키로 Join을 하면 속도 측면에서 문제가 거의 없다.
-- 3. Outter join은 성능저하 유발한다. 다중으로 중복해서 사용하지 말길 권장
-- ※ Join을 통해 성능 저하가 발생하는 경우 꼬인 코드를 풀어 성능 개선을 하거나 적절한 반정규화를 실행해야한다.
