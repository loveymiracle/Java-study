-- VIEW란?
-- - 논리 or 가상 테이블로써 실제 물리적으로 존재하지 않은 Table
-- - 주로 편의성 또는 보안을 위해 생성되어 활용됨.
--  - 장점 : 편리성(복잡한 쿼리문을 줄일수 있음), 보안성(일부 데이터를 보이지 않게함)
--          설계상 이점(물리 Table이 변경하여도 프로그램의 영향을 최소화 할수 있음) -> 이상적            
--  - 단점 : 입력에 제약이 많음, 성능을 가늠할수 없음(최적화 관점에서 어려움 겪음)
--          개발자가 개발하기 어려움 
--  - 활용방안 : 읽기전용으로 생성하여 사용은 빈번함 -> 운영이 잘 되는 곳에서는.

-- 문법
-- CREATE [OR REPLACE] VIEW '뷰 이름' AS SELECT 문; -- 테이블 명칭에 V를 붙여주는게 일반적

SELECT EMP_ID, EMP_NAME, DEPT_CODE FROM employee;

create or replace view V_EMP_TABLE as select EMP_ID, EMP_NAME, DEPT_CODE FROM employee;

select * from V_EMP_TABLE;

-- 구조 확인
desc V_EMP_TABLE;
desc employee;

-- insert 해보기 - 제약이 있으면 insert 불가능
insert into V_EMP_TABLE values(400,'홍길동', 'D2');


-- 여러테이블을 활용한 view 생성
-- 사번, 이름, 부서명, 근무지역이 들어간 view
select emp_id, emp_name, dept_title, local_name
from employee 
join department on dept_code = dept_id
join location on location_id = local_code;

create or replace view V_EMP_TABLE_2 as
select emp_id, emp_name, dept_title, local_name
from employee 
join department on dept_code = dept_id
join location on location_id = local_code;

select * from V_EMP_TABLE_2;

-- view 삭제하기
drop view V_EMP_TABLE;
drop view V_EMP_TABLE_2;

-- VIEW DML(INSERT, UPDATE, DELETE)이 불가능한 경우
/*
    1. 뷰 정의에 포함되지 않은 컬럼을 조작하는 경우
    2. 뷰에 포함되지 않은 컬럼 중에, 베이스가 되는 테이블의 컬럼이 NOT NULL 제약조건이 지정된 경우
    3. 산술 표현식으로 정의된 경우
    4. JOIN을 이용해서 여러 테이블을 연결한 경우
    5. DISTINCT 를 포함한 경우
    6. 그룹함수나 GROUP BY 절을 포함한 경우
*/
