-- DELETE : 조건에 맞는 행을 삭제하는 명령
-- DELETE FROM '테이블명' WHERE dept_id = 'D1';  
-- ※ 주의 DELETE 시 WHERE 없으면 데이터 전체 삭제

DROP TABLE TBL_DEPT_TEST;
CREATE TABLE TBL_DEPT_TEST AS SELECT * FROM DEPARTMENT;
SELECT * FROM TBL_DEPT_TEST;

-- 전체 행을 삭제하는 명령어 -> drop을 사용해도 된다.
delete from TBL_DEPT_TEST; -- where 절 생략 

-- 단일 행 삭제
delete from TBL_DEPT_TEST where dept_ID = 'D1';

-- 다중 행 삭제
delete from TBL_DEPT_TEST where dept_title like '%영업%';

-- 삭제시에 외래키에 대한 제약을 무시하는 명령어
SET foreign_key_checks = 0; -- 제약 풀고
DELETE FROM TBL_DEPT_TEST WHERE dept_id LIKE 'D%';
SET foreign_key_checks =1; -- 외래키 제약 다시 설정

-- TRUNCATE : DELETE 보다 빠른 삭제 명령어, 단 복원이 되지 않는 명령어
DROP TABLE TBL_DEPT_TEST;
CREATE TABLE TBL_DEPT_TEST AS SELECT * FROM DEPARTMENT;
SELECT * FROM TBL_DEPT_TEST;

truncate table TBL_DEPT_TEST;
rollback;
