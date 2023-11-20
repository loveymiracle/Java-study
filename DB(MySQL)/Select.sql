-- 실습전에 해야 할 일
-- SAMPLE.sql 명령어 스크립트로 실행할것! -> 깨졌으면 다시 실행하면 된다.
USE home;

-- 테이블의 모든 정보를 출력하는 명령어
show tables; -- 현재 home DB에서 
show table status; -- 테이블 상태 조회

 -- 테이블의 컬럼정보를 출력하는 명령
 desc home.employee;
 desc employee;
 
 -- 기본적인 select문 - employee
 select * from employee; -- use home을 사용했을 때 활용 가능한 문법 ★★★
 select * from home.employee; -- home db의 테이블을 조회하는 방법
 -- * : 와일드카드, 모든 컬럼을 가져오는 키워드
 
 select * from home.department;
 select * from home.employee;
 select * from home.job;
 select * from home.location;
 select * from home.national;
 select * from home.sal_grade;
 
 -- 컬럼명을 지정하여 조회하는 방법
 -- -> 일반적으로 DB에서 값을 조회하기 위해선 필요한 컬럼명만 명시하는 것이 정석
 --    이유 : 컬럼의 순서, 불필요한 데이터를 조회하면 메모리, 시간이 낭비됨으로..
 desc employee;
 
select EMP_ID, EMP_NAME, EMP_NO, EMAIL from employee; -- 테이블명 생략하는 것이 일반적이다. ★★★★★
select employee.EMP_ID, employee.EMP_NAME, employee.EMP_NO, employee.EMAIL from employee; -- 테이블명 표기한 문법

-- ※ 주의 : 개발 때는 DB 조회 시에 항상 필요한 컬럼만 선택하여 가져오는 것이 표준적!
--    이유 : 성능(네트워크, HDD 읽기 속도 저하) / 메모리(불필요한 데이터) 측면에서 나쁘다.
--    DB는 성능에 굉장히 민감하다. 이유는 HDD가 RAM보다 100배 느리기 때문에 성능을 고려해야한다.

-- 와일드카드(*) 컬럼명과 결합하는 방법
select emp_name, employee.* from employee;

-- as 문법 : table의 컬럼명의 별칭을 만든느 방법, 향후 java 언어와 연동 시 컬럼명의 별칭을 통해 쉽게 데이터 추출이 가능하다.
-- 컬럼명 as '별칭', as 별칭 -> '' 생략 가능
select emp_name as '이름' from employee;
select emp_name as "이름" from employee;
select emp_name as 이름 from employee; -- 좋아하는 as문✭
select emp_name 이름 from employee;

-- distinct : 중복을 제거하는 방법 ★★★
select dept_code from employee;
select distinct dept_code from employee; -- 중복이 제거

-- 조합하는 응용 문장
select dept_code, job_code from EMPLOYEE;
select distinct dept_code, job_code from employee; -- dept_code와 job_code 두 조합의 모든 중복을 제거한다.

-- 중복되지 않은 갯수를 구하는 방법
select count(dept_code) as '부서 전체 코드 갯수' from employee; -- 모든 부서 코드를 가진 사람을 구하는 방법
select count(distinct dept_code) as '부서 전체 코드 갯수' from employee; -- 중복된 코드를 제거하고 중복되지 않은 갯수만 가져오는 방법

-- 비교연산자(Where절)
-- WHERE [컬럼명|리터럴] [비교연산자 = > < <= >=] [컬럼명|리터럴] {AND OR && ||} {다항식...}
-- ※주의 : 연산자 별로 우선순위가 존재함으로 괄호()사용을 적극 추천!
--  = : 동등연산자(값이 같은가?) (Java에서 ==)
-- !=, <>, ^= : 값이 같지 않음을 비교하는 연산자
-- > < <= >= : 값의 대소, 이상/초과를 표현하는 연산자

-- between : 범위 비교용 연산자
-- ex) where between[범위1] and [범위2]
--     -> where A > B && A < C -> where between B and c

-- LIKE / NOT LIKE : 문자열 일부 또는 완전 일치하는지 확인하는 연산자 _나 %가 와일드 카드로 사용
-- IN / NOT IN : 특정 집합의 값이 포함되어 있는지 확인하는 연산자
--   ex) [VALUE] IN (특정 집합값 n1, n2 ...)  
--   ex) 컬럼명 IN 10, 20, 30, 40 ... 

-- IS NULL, IS NOT NULL : 값이 NULL인지 확인하는 연산자
-- ※주의 NULL은 '='로 비교 불가하다!! 
-- AND, OR : 논리 연산자
-- NOT : 부정연산

-- id(pk=유일한 값)조회 하는 방법, 앞으로 우리가 가장 많이 활용하는 where절!
select * from employee where emp_id = 200;

-- 직원 중 월급이 300만원 이상인 사람 
select emp_name, salary, dept_code from employee where salary >= 3000000;
select count(*) from employee where salary >= 3000000;

-- 직원 월급이 300만원이 아닌 사람 표현, 1. not 활용방법
select emp_name, salary, dept_code from employee where not salary >= 3000000;

-- 직원 월급이 300만원이 아닌 사람 표현, 2. 논리식을 반대로 바꾼다.
select emp_name, salary, dept_code from employee where salary < 3000000;

-- 직원 중에 부서가 D1인 사람
select emp_name, salary, dept_code from employee where dept_code = 'D1'; -- 대소문자 가급적 맞출것!, DB 옵션마다 다르게 적용 됨

-- 직원 중에 부서가 D3 보다 문자열이 앞인 사람들 --> DB에서 문자열 비교는 대소비교로 가능하다!! ★★★★★
select emp_name, salary, dept_CODE FROM EMPLoyee where dept_code < 'D5'; -- D1 ~ D4 
select emp_name, salary, dept_CODE FROM EMPLoyee where dept_code >= 'D5'; -- D5 ~ D9

-- 직원 중에 부서가 D1 이면서 월급이 300만원 이상인 사람
select emp_name, salary, dept_code from employee where dept_code = 'D1' and salary > 3000000; -- and로 묶여야 한다. and 추천!!
select emp_name, salary, dept_code from employee where dept_code = 'D1' && salary > 3000000; -- && 통한다 -> 가급적 사용 말것
-- select emp_name, salary, dept_CODE FROM EMPLoyee where dept_code < 'D1' & salary > 3000000; -- 절대 금기!!!
-- & 는 비트연산이라 올바른 결과가 나오지 않음

-- 직원 중에 월급이 200만원 이상 ~ 300만원 이하인 사람 (일반 비교문, between 문법) 두 문법 모두 논리상 동치
select emp_name, salary, dept_code from employee where salary >= 2000000 and salary <= 3000000;
select emp_name, salary, dept_code from employee where salary between 2000000 and 3000000;

-- 직원의 입사일 2015-01-01일 보다 빠르거나 느린 사람 -> 날짜도 대소비교가 가능!! ★★★★★
select emp_name, hire_date from employee where hire_date < '2015-01-01'; -- 2015년 이전
select emp_name, hire_date from employee where hire_date >= '2015-01-01'; -- 2015년 이후

-- LIKE : 문자열 패턴을 조회하는 키워드 ★★★★★
-- 장점 : 검색하기 가장 편하다. ex) 게시글 제목, 내용 검색 기능들
-- 단점 : 성능에는 좋지 않은 문장!

-- 사용법
-- WHERE '컬럼명' LIKE '__문자%' : 앞의 _ 두글자로 시작로 시작하고 가운데 '문자'라는 키워드가 들어있는 아무 문자열 탐색 
-- % : 와일드 카드로 문자열 0개 이상의 모든 문자 대처
  -- '김%' : 김으로 시작하는 모든 문자열 ex) 김길동, 김길순, 김순 김
  -- '%동' : 동으로 끝나는 모든 문자열 ex)홍길동, 박길동, 길동, 동
  -- '%길%' : 중간에 길이 들어가는 모든 문자열 ex) 홍길동, 길동, 홍길, 길 

-- _(언더바) : 한개의 문자를 대처 가능하다.
   -- '홍__' : 홍으로 시작하는 3글자
   -- '_길_' : 길이 중간에 들어가는 3글자
   -- '__동' : 동으로 끝나는 3글자
   
select emp_name from employee where emp_name like '이%'; -- 이씨 성을 가진 사람
select emp_name from employee where emp_name like '이__'; -- 이씨 성을 가진 이름이 3글자인 사람
select emp_name from employee where emp_name like '이_'; -- 이씨 성을 가진 이름이 외자인 사람
select emp_name from employee where emp_name like '이___'; -- 이씨 성을 가진 이름이 4글자인 사람


-- 휴대폰 번호가 011로 시작하는 사람
select emp_name, phone from employee where phone like '011%';

-- 휴대폰 번호가 7자리 인사람
select emp_name, phone from employee where phone like '01_____';
select emp_name, phone from employee where phone like '_______';

-- 이름에 옹이 들어가는 사람
select emp_name from employee where emp_name like '%옹%'; -- 가장 보편적인 검색용 문법
select emp_name from employee where emp_name like '_옹';
select emp_name from employee where emp_name like '_옹%';
select emp_name from employee where emp_name like '%옹_';

-- email에서 '_' 앞에 글자가 3글자인 사람 -> '-' escape문으로 대체해서 활용 가능
select emp_name, email from employee where email like '___%'; -- 실패, 4글자 이상인 모든 사람
select emp_name, email from employee where email like '___#_%' escape '#';
-- escape로 정한 '#' 뒤에 1글자는 진짜 '_' 로 인식하는 방법, %도 같은 방법으로 활용 가능

-- NULL : 데이터가 없는 상태, 0 과는 다른 개념 -> 0이라는 값이 존재, 존재와 없음을 비교하는 개념
-- NULL 관련 명령어 ★★★★★
-- WHERE '컬럼명' IS NULL; -- 컬럼이 널인가? 체크하는 문법
-- WEHRE '컬럼명' IS NOT NULL;
-- WHERE '컬럼명' = NULL (X); -- 안되는 문법

select emp_name, bonus from employee where bonus = null; -- 문법적으로 허용하지만, 원하는 결과값 안나옴!!!
select emp_name, bonus from employee where bonus is null;
select emp_name, bonus from employee where bonus is not null;

-- 값에 null이 포함 되어 있을 떄의 연산 주의점
select emp_name, salary as '월급' from employee;
select emp_name, salary + bonus * salary as '월급' from employee; -- 보너스가 존재하는 달일 때 문제 발생!! -> 계산 값이 null로 나옴!
-- -> null 체크를 하지 않아서 발생하는 빈번한 이슈 케이스
-- null 값으로 연산을 하는 경우 null 오염 된다고 생각하면 편하다.

-- null 체크를 수행하는 문법이 필요 -> DB마다 조금씩 다르다.
-- ifnull, coalesce라는 함수를 제공하여 확인 가능하다.
-- ifnull(널 값 체크할 컬럼명, null일 경우 초기화 할 값) = coalesce() 
select emp_name, salary + bonus * salary as '월급' from employee; -- 문제가 되는 문장!!
select emp_name, salary + ifnull(bonus, 0) * salary as '월급' from employee; -- 표준적인 문법, 보너스가 null인 경우 0으로 계산
select emp_name, salary + coalesce(bonus, 0) * salary as '월급' from employee; -- coalesce, ANSI 표준 문법


-- 다중값(집합)을 비교하는 방법
-- in, not in : 다중값을 비교하는 키워드
-- where '컬럼명' in (값1, 값2, 값3, .... 값n)
-- -> 향후 괄호자리가 sub query로 대체되거나 프로그래밍의 반복문으로 대체되서 활용 된다.

-- 부서 D5, D6, D7, D8인 사람을 검색하는 방법
-- -> 4개 정도 되면 or 절로 가능하긴 하나 문법이 너무 길어져서 회피가 필요
select emp_name, dept_code from employee where dept_code = 'D5' or dept_code = 'D6' or dept_code = 'D7' or dept_code = 'D8';

-- in을 활용한 단축 문법 1. hard 코딩 -> 나쁜 문법 아니다. 나중에 유용하게 쓰인다.
select emp_name, dept_code from employee where dept_code in ('D5', 'D6', 'D7', 'D8') order by 2; -- db index(1로 시작) 기준으로 2번째 컬럼으로 정렬
select emp_name, dept_code from employee where dept_code in ('D5', 'D6', 'D7', 'D*') order by dept_code;

-- in을 활용한 단축 문법 2. sub query로 활용 가능
select dept_id from department where dept_id >= 'D5' and dept_id < 'D9'; -- 이 쿼리문을 (괄호)에 넣어준다.
SELECT emp_name, dept_code
FROM employee
WHERE dept_code IN (SELECT dept_id FROM department WHERE dept_id >= 'D5' AND dept_id < 'D9');

-- 연산자 우선 순위 ★★★★★
-- ※ 연산자 우선순위 외우면 좋지만, 중요한건 (괄호) 사용!

-- 연산자 우선순위로 문제가 되는 예시
-- 부서가 D5, D6, D7, D8 이면서 정이나 전씨로 시작하는 사람 찾기

select emp_name, dept_code from employee 
where dept_code in ('D5', 'D6', 'D7', 'D8') and emp_name like '정%' or emp_name like '전%';
-- 틀린 값!! and, or 우선 순위로 잘못된 D1 부서의 전지연 검색 됨

select emp_name, dept_code from employee
where dept_code in ('D5', 'D6', 'D7', 'D8') and (emp_name like '정%' or emp_name like '전%');
-- 정답! or 절의 괄호가 필요하다. -> 추천하는 and or 패턴 중 하나.
