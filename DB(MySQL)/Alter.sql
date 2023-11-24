-- ALTER : 테이블이나 각종 제약사항들 등의 Object를 수정하는 명령어 ★★
-- 테이블 수정(컬럼명 수정, 컬럼 추가, 컬럼 삭제) 제약사항 추가,수정,삭제, 기타 객체들도 변경 가능

DROP TABLE TBL_ALTER_TEST;

CREATE TABLE TBL_ALTER_TEST(
    user_no INT PRIMARY KEY,
    user_id VARCHAR(20),
    user_name VARCHAR(20)
);

SELECT * FROM TBL_ALTER_TEST;
desc TBL_ALTER_TEST;

INSERT INTO TBL_ALTER_TEST VALUES('1','test_id1','홍길동'); 
INSERT INTO TBL_ALTER_TEST VALUES('2','test_id2','김길동');
INSERT INTO TBL_ALTER_TEST VALUES('3','test_id3','최길동');

-- 컬럼 추가하기 (주소 정보)
alter table TBL_ALTER_TEST add(user_addr varchar(100)); 
-- alter는 commit이 없어도 바로 동작이 가능함! -> 적용하면 rollback 불가
INSERT INTO TBL_ALTER_TEST VALUES('4','test_id4','최길동','서울시 강남구');

-- 컬럼 추가하기 (제약사항 + default 값)
alter table TBL_ALTER_TEST add(user_pw varchar(50) default 1234 not null);

-- 제약사항 추가하기
alter table TBL_ALTER_TEST add constraint UQ_USER_ID unique(user_id);
-- 만일 이미 unique하지 않은 경우는 실패!

-- 제약사항 삭제하기 
alter table TBL_ALTER_TEST drop constraint UQ_USER_ID;

-- 제약 확인하는 방법 2가지
-- 1. desc
desc TBL_ALTER_TEST;

-- 2. table_constraints에서 찾기 -- 이름 확인 가능!
select * from information_schema.table_constraints where table_name = 'TBL_ALTER_TEST';

-- 제약 삭제 추가 - PK
-- alter table TBL_ALTER_TEST drop constraint PRIMARY; -- 안된다!!
alter table TBL_ALTER_TEST drop primary key;
-- alter table TBL_ALTER_TEST drop foreign key ~~ ;

-- 컬럼명 수정하기 ☆☆☆
alter table TBL_ALTER_TEST rename column user_addr to user_address;
desc TBL_ALTER_TEST;

-- 컬럼 타입 수정하기
alter table TBL_ALTER_TEST modify user_name varchar(100);

-- 컬럼을 한번에 수정하기, 이름, 제약, 타입 한번에 수정 가능
alter table TBL_ALTER_TEST change user_name user_name2 varchar(1000) not null default '홍길동';

-- 테이블 이름 변경하기
RENAME TABLE TBL_ALTER_TEST TO TBL_ALTER_TEST222;
RENAME TABLE TBL_ALTER_TEST222 TO TBL_ALTER_TEST;

-- drop 명령어
-- - table과 제약사항 등 모든 객체를 제거하는 명령
drop table TBL_ALTER_TEST;
