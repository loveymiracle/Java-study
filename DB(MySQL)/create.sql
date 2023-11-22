-- 문자형 : CHAR, VARCHAR★★★★★, TEXT, MEDIUMTEXT, LONGTEXT ★★★★★
-- CHAR(길이) : 길이 고정형 문자열로 지정한 수만 크기를 지정하여 공간을 확보하는 변수, 최대 256 글자
-- VARCHAR(길이) : 가변형 문자열로 선언한 크기만큼 공간이 늘어 날수 있다. (실제는 사용한 크기만큼 할당) 최대 65,535글자
-- TEXT : VARCHAR와 같은 크기의 문자열 저장 Type (65,535 byte) 
-- MEDIUMTEXT : VARCHAR보다 더 많은 문자열이 저장 가능 (16,777,215 byte, 16MB)
-- LONGTEXT : VARCHAR보다 더 많은 문자열이 저장 가능 (4,294,967,295 byte, 4GB)
--  ※ 주의 : TEXT류는 데이터를 disk 저장하여 느려지고, 크기 제한이 되지 않음. VARCHAR를 최우선 사용하고 가급적 선언하지 말것!
-- 숫자형 : INT★, BIGINT, DOUBLE, DECIMAL, BOOL
-- INT : 정수형으로 사용하는 일반 Type (4byte, +-21억)
-- BIGINT : long type 정수형으로 사용하는 일반 Type (8byte)
-- DOUBLE : 실수를 사용할때 사용하는 표준 Type
-- DECIMAL : 고정소수점을 정교하게 활용할때 사용하는 방법
-- BOOL : true / false

-- 날짜형 : DATE, TIME, DATETIME, TIMESTAMP
-- DATE : 날짜만 저장하는 Type
-- TIME : 시간만 저장하는 Type
-- DATETIME : 날짜 시간 모두 저장하는 Type
-- TIMESTAMP : 날짜 시간 모두 저장하고, 실제 정수형으로 저장되어 데이터 저장 및 insert가 빠름 -> log성 데이터는 해당 Type으로 저장

-- 데이터형 : BLOB, MEDIUMBLOB, LONGBLOB
-- 바이너리 데이터 저장가능(사진, 동영상, 기타 등등의 확장자)
-- ※ File은 웬만하면 DB에 저장하지 않고, 경로만 저장하는게 일반적

-- ■ Table 생성하는 방법

-- table 삭제 명령어
drop table TBL_STR_DATA;

-- 문자열 type 사용하는 테이블
create table TBL_STR_DATA( -- TABLE_~~~, TBL_~~~, MEMBER,
	a char(3),        -- 고정길이 문자열 type
    b varchar(3),     -- 가별길이 문자열 type ★★★★★
    c text(3),        -- 문자열, disk 텍스를 저장할 때 사용, varchar 상위호환, 길이제한 의미 없다.
    d mediumtext      -- 16MB 텍스트 저장가능, varchar를 확장하고 싶을 때 사용
);

select * from TBL_STR_DATA;
insert into TBL_STR_DATA values('ABC', 'ABC', 'ABC', 'ABC'); -- 영문 3글자
insert into TBL_STR_DATA values('가나다', '가나다', '가나다', '가나다'); -- 한글 3글자
insert into TBL_STR_DATA values('가나다마바', '가나다마바', '가나다마바', '가나다마바'); -- too long, 길이 범위 벗어남
insert into TBL_STR_DATA values('가나다', '가나다', '가나다마바사', '가나다마바사'); -- text는 길이 제한문법 의미 없음

-- 데이터 길이 검사
-- length : byte를 검사하는 함수
-- char_length : 글자수 세는거
select length(A), length(B), length(C), length(D) from TBL_STR_DATA; -- 한글은 3byte
select char_length(A), char_length(B), char_length(C), char_length(D) from TBL_STR_DATA; -- 

commit; -- insert를 하고 실제 DB에서 물리적으로 저장하는 명령어
rollback; -- commit 명령어 들리는 명령어

-- table 초기화 drop -> create -> insert -> 

-- 숫자 Type Table 생성
drop table TBL_NUMBER_DATA;

create table TBL_NUMBER_DATA(
	a int,     -- 정수 +-21억!
    b bigint,  -- 정수, long type과 같은 범위
    c double,  -- 실수, 소수점 59? 
    d decimal(5, 2)  -- 실수, 소수점이나 양수에서 길이제한이 가능, 첫번째 : 총 5자리이고, 두번째 인자 ; 소수점 2째 자리까지
);

insert into TBL_NUMBER_DATA values(123.45, 123.45, 123.45, 123.45); -- 정수형에서 소수점은 짤림
insert into TBL_NUMBER_DATA values(-123, -123, 123.456789, 123.456789); -- warning! , d decimal 지정범위를 벗어남!
insert into TBL_NUMBER_DATA values(12345678901234567890.456,12345678901234567890.456,
										12345678901234567890.456,12345678901234567890.456); -- 에러, int형 범위를 벗어남!
insert into TBL_NUMBER_DATA values(210000,123456782000,
										12345678901234567890.456,12.45); -- 에러, int형 범위를 벗어남!
select * from TBL_NUMBER_DATA;

-- date type table 생성
drop table TBL_DATE_DATA;
create table TBL_DATE_DATA(
	date1 date,	     -- 날짜만
    time1 time,      -- 시간만
    datetime1 datetime,  -- 날짜시간 둘다
    timestamp11 timestamp  -- 정수형으로 날짜시간 저장
);

select now();
insert into TBL_DATE_DATA values(now(),now(),now(),now());
insert into TBL_DATE_DATA values('2021-11-16','14:37',now(),now());
select * from TBL_DATE_DATA;
