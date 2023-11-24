-- 트리거란?
 -- 데이터베이스 트리거는 테이블에 대한 이벤트에 반응해 자동으로 실행되는 작업을 의미한다. 
 -- 트리거는 INSERT, DELETE, UPDATE 같은 DML(데이터 조작 언어)의 데이터 상태 관리를 자동화하는데 사용된다.
 -- 백업, 삭제 -> 다른 테이블 이관

drop table  TRIGGER_USER;
CREATE TABLE TRIGGER_USER ( -- 회원 테이블
	id varchar(20) primary key,
    name varchar(20),
    address varchar(20)
);

drop table  TRIGGER_REMOVED_USER;
CREATE TABLE TRIGGER_REMOVED_USER ( -- 탈퇴된 회원의 테이블
	id varchar(20) primary key,
    name varchar(20),
    address varchar(20),
    deletedDate timestamp
);

INSERT INTO TRIGGER_USER VALUES ('test1', '홍길동', '서울시 강남구');
INSERT INTO TRIGGER_USER VALUES ('test2', '최길동', '서울시 관악구');

SELECT * FROM TRIGGER_USER;


-- 프로시저(DB 함수)
DELIMITER //
create trigger CHECK_DELETE_USER
	after delete 		-- 명령어 동작시기
    on TRIGGER_USER		-- 동작할 table 이름 
	for each row		-- 각 row마다 적용
begin
	-- 명령어 실행
    insert into TRIGGER_REMOVED_USER values(old.id, old.name, old.address, now());
end
// DELIMITER ;

set sql_safe_updates = 0; -- 광범위한 삭제나 update를 풀어주는 명령어.
DELETE FROM TRIGGER_USER WHERE id = 'test2'; -- 회원탈퇴

SELECT * FROM TRIGGER_REMOVED_USER;
SELECT * FROM TRIGGER_USER;
