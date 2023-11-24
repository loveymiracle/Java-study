-- INSERT 문
-- - 테이블에 한 행(ROW)의 데이터 셋을 추가하는 명령어
-- - 한 번에 한 행을 삽입하는게 일반적

-- 명령어 생성 방법 2가지
-- 1. INTO - VALUES set활용
--  INSERT INTO '테이블명'(컬럼명1,컬럼명1,컬럼명3 ... ) VALUES(값1,값2,값3 ...); 
-- 2. 컬럼을 생략하는 방법
--  INSERT INTO '테이블명' VALUES(값1,값2,값3 ... 컬럼의 끝값 까지); 
-- ※ 주의점 : Table의 생성 순서대로 넣어야하고, 제약사항 검토 필요

select * from department;
desc department;

-- D1 인사관리부    L1
insert into department(dept_id, dept_title, location_id) values('D0', '개발팀', 'L7'); -- 표준적이고, 정석적인 insert문
insert into department values('F0', '운영팀', 'L7'); -- 컬럼을 생략한 문법
insert into department values('F1', 'Devops팀'); -- 컬럼명을 생략할 경우 컬럼 갯수가 일치하지 않으면 에러 발생
insert into department values('F1', 'Devops팀', default); -- null 또는 default 값으로 채우면 insert는 가능할 수 있다(제약사항에 따라..).
insert into department(dept_id, dept_title) values('F1', 'Devops팀'); -- 생략을 할 경우는 default 값이 채워짐

-- insert를 수행하는 경우 DB 완전히 저장하기 위해선 commit이 필요하다.
commit;

-- 직원정보 insert 해보기
select * from employee;
desc employee;

-- 207 하이유 990402-2040612 ha_iy@multi.com 01036654488 D5 J5 S5 2200000 0.1 200 2004-07-07 N
insert into employee
	(emp_id, emp_name, emp_no, email, phone, 
	 dept_code, job_code, sal_level, salary, bonus, 
     manager_id, hire_date, ent_date, ent_yn)
 values
	(223, '민지', '041212-4121222', 'minji@multi.com', '01012345678',
	'D5', 'J5', 'S5', 3000000, 0.1,
	200, '2020-07-01', null, 'N');

-- insert 응용하기 -> 중요하지 않다...

-- 1. 서브쿼리를 통해 TABLE 복사하는 방법

DROP TABLE TBL_INSERT_TEST;

CREATE TABLE TBL_INSERT_TEST
AS SELECT emp_id, emp_name, dept_title
FROM employee JOIN department on dept_code = dept_id;

SELECT * FROM TBL_INSERT_TEST;
INSERT INTO TBL_INSERT_TEST VALUES('245','홍길동','개발부');
SELECT * FROM employee; -- 개발부 홍길동 없음

-- 2. 서브 쿼리를 활용 + INSERT 문으로 복사하는 방법
CREATE TABLE TBL_INSERT_TEST2
AS SELECT emp_id, emp_name, dept_title
FROM employee JOIN department on dept_code = dept_id
WHERE 1=0; -- TABLE만 생성하고 실제 값은 넣어지지 않는 상황

SELECT * FROM TBL_INSERT_TEST2;

INSERT INTO TBL_INSERT_TEST2
(SELECT emp_id, emp_name, dept_title FROM employee JOIN department on dept_code = dept_id);

INSERT INTO TBL_INSERT_TEST2
(SELECT emp_id, emp_name, dept_title FROM employee JOIN department on dept_code = dept_id WHERE dept_code = 'D5'); -- WHERE 절 추가하는 방법

DROP TABLE TBL_INSERT_TEST2;
