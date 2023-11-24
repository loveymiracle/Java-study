-- DCL : Data Control Language 
--  - 데이터의 제어 명령어, 보안, 무결성, 복원등을 위해 사용되는 명령어 세트
--  1) 권한부여 : GRANT, REVOKE
--  2) 트랜잭션 관리 : COMMIT, ROLLBACK, SAVEPOINT
--  3) 보안(원자성) : LOCK, KILL 

-- id 생성 및 권한 부여
-- root 계정에서 실행해야함
drop user 'com' ;
create user 'com' identified by 'com1';
grant all privileges on *.* to 'com';
FLUSH PRIVILEGES;

------------------------------- 트랜잭션 ----------------------------------------
-- TCL ★★★★★
-- 트랜잭션이란?
--  - DB에서의 작업 단위로 여러 쿼리문을 조합하여 업무의 처리 단위로 만들 때 사용(INSERT, UPDATE, DELETE, SELECT+@)
--  - ACID 원칙 준수가 중요. (ACID(원자성=하나의 단위, 일관성=계속해도 똑같음, 독립성=독립된 단위로 존재, 지속성=영구적 저장))

-- COMMIT : 트랜잭션이 정상적으로 완료 되었을때 사용하는 명령어
-- ROLLBACK : 트랜잭션 도중 실패하였을 경우 마지막으로 실행한 COMMIT으로 복원하는 명령어
-- SAVEPOINT    <save point이름> : 트랜잭션 도중에 복원할 지점을 저장하는 명령어
-- ROLLBACK TO  <save point이름>  : 지정된 Sava point 지점으로 복원하는 명령어

-- 주의 : DDL(CREATE, ALTER, DROP), DCL(권한설정) 명령은 트랜잭션에서 제외된다. (AUTO COMMIT)


DROP TABLE TBL_TRANSACTION_TEST;
CREATE TABLE TBL_TRANSACTION_TEST(  
    user_id   VARCHAR(20),
    user_name VARCHAR(20)    
);

SELECT * FROM TBL_TRANSACTION_TEST;

INSERT INTO TBL_TRANSACTION_TEST VALUES('TEST1','홍길동');
INSERT INTO TBL_TRANSACTION_TEST VALUES('TEST2','김길동');
INSERT INTO TBL_TRANSACTION_TEST VALUES('TEST3','박길동');

COMMIT;
ROLLBACK;
-- 실습 단계1) INSERT -> ROLLBACK -> SELECT : 데이터 없음
-- 실습 단계2) INSERT -> COMMIT -> ROLLBACK -> SELECT : 데이터 살아있음
-- 실습 단계3) INSERT(1개만) -> COMMIT -> INSERT(2개 더) -> ROLLBACK -> SELECT : 데이터 한개만 살아있음


-- SAVE POINT 실습
DROP TABLE TBL_TRANSACTION_TEST;
CREATE TABLE TBL_TRANSACTION_TEST(  
    user_id   VARCHAR(20),
    user_name VARCHAR(20)    
);

SELECT * FROM TBL_TRANSACTION_TEST;

-- 트랜잭션 시작
INSERT INTO TBL_TRANSACTION_TEST VALUES('TEST1','홍길동');
SAVEPOINT sp1;
INSERT INTO TBL_TRANSACTION_TEST VALUES('TEST2','김길동');
SAVEPOINT sp2;
INSERT INTO TBL_TRANSACTION_TEST VALUES('TEST3','박길동');
SAVEPOINT sp3;
-- 트랜잭션 종료

ROLLBACK TO sp1;
ROLLBACK TO sp2;
ROLLBACK TO sp3;

-- 실습1) 트랜잭션 모두 실행 -> sp1 ROLLBACK -> 조회
-- 실습2) 트랜잭션 모두 실행 -> sp2 ROLLBACK -> 조회
-- 실습3) 트랜잭션 모두 실행 -> sp3 ROLLBACK -> 조회
-- 돌린시점 이후에 작업된 SP로는 이동 불가
-- 실습4) 트랜잭션 모두 실행 -> sp1 ROLLBACK -> sp3 ROLLBACK -- 안되는 케이스
