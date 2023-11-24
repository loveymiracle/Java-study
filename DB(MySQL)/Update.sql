-- UPDATE
--  - 행의 한개 또는 다수의 데이터를 수정하는 명령어
--  - UPDATE '테이블명' SET '컬럼명1'='업데이트 값', '컬럼명2'='업데이트 값' WHERE user_id = 'test01'; 
--  - SET 절 없으면 문법 오류 발생, WHERE 절이 없으면 모든 데이터가 업데이트

DROP TABLE TBL_DEPT_TEST;
CREATE TABLE TBL_DEPT_TEST AS SELECT * FROM DEPARTMENT;

DESC TBL_DEPT_TEST;
SELECT * FROM TBL_DEPT_TEST;

-- 광범위한 업데이트를 해제하는 명령어 
set sql_safe_updates = 0;
set sql_safe_updates = 1; -- -> 다시 설정

-- where 절이 없는 경우 모든 데이터가 업데이트 된다. -> 쓸일 없을 예정
-- 모든 행 수정문
update TBL_DEPT_TEST set location_id = 'L7';

-- 정상적인 update문
-- 단일 행 수정
update TBL_DEPT_TEEST set location_id = 'L7' where dept_id = 'D6'; -- PK로 업데이트문을 완성하는 것이 일반적
update TBL_DEPT_TEEST set location_id = 'L7' where dept_id = '총무부'; -- 만일 총무부 여러개일 경우 동시에 업데이트 됨

-- 다중 행 수정
update TBL_DEPT_TEST set location_id = '국내영업부' where dept_title like '%영업%';

-- update + sub query
-- 국내영업부의 로케이션을 총무부의 로케이션으로 변경 구문
select location_id from TBL_DEPT_TEST where dept_title = '총무부';

-- 주의점 : sub query문을 한번 더 감싸야 가능하다.
update TBL_DEPT_TEST 
set location_id = (select * from (select location_id from TBL_DEPT_TEST where dept_title = '총무부') as a)
where dept_title like '%국내영업부%';
