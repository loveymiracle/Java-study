-- DB의 제약조건(Constraints) ★★★★★
-- -> 안쓰는 경우 DB의 무결성을 보장할수 없음 -> 버그나 에러가 발생함 -> 품질 저하. -> 고객클레임 -> 책임이 필요하다.
-- NOT NULL : 특정 컬럼에 NULL을 허용하지 않는 제약 -> 제일 많이 활용되는 제약
-- UNIQUE (U) : 특정 컬럼에 중복값을 허용하지 않는 제약 // NULL은 벤더사 마다 허용할지 규칙 다름, ORACLE은 허용함
-- PRIMARY KEY (PK) : 테이블의 컬럼중 유일하고 최소로 식별 가능한 데이터를 주키로 설정하는 제약
--                    index 자동으로 활성화(성능이 좋아짐), 보통 sequance key를 활용함
--                    없어도 Table은 생성가능, But 필드에서는 PK가 없는 Table 존재하지 않음..
-- FOREIGN KEY (FK) : 외래키, 다른 테이블의 주키를 자신의 테이블의 인자로 활용하여, 
--                    테이블간 관계를 가질때 사용. (종속관계 성립)
-- CHECK : 특정 컬럼의 입력값을 제한하는 제약사항, ※ 주의 : 제약을 잘 알지 못함으로 사용 주의
-- DEFAULT : 해당 컬럼에 입력 되는 값이 없는 경우 설정된 초기값으로 값을 저장
-- AUTO_INCREMENT : 고유 번호를 생성하는 문법으로 특정 값을 1부터 자동으로 1씩 증가 시킴
-- 제약사항 활용하는 방법
-- 1) 컬럼 레벨에서 제약을 거는 방법 (컬럼명으로 제약) 
-- 2) Table 레벨에서 제약을 거는 방법 (Table명으로 제약)

-- 사용자가 가진 제약을 확인하는 방법
select * from Information_schema.table_constraints;
select * from Information_schema.table_constraints where table_schema = 'multi';

-- table 레벨에서 제약을 확인하는 방법
desc employee;


-- 제약이 없는 기본 테이블
drop table TBL_USER;

create table TBL_USER(
	user_no int,           -- 컬럼 레벨 제약을 거는 곳 : not null, unique, auto_increment, primary key
	user_id varchar(20),
	user_pw varchar(20),
    user_name varchar(20),
    user_age int
    -- 테이블 레벨로 제약
    -- unique, primary key, foreign key .. 2개 이상의 컬럼이 필요한 제약
);

insert into TBL_USER values(null, null, null, null, null);
insert into TBL_USER values(1, 'test1', '1234', '홍길동', 31);
insert into TBL_USER values(1, 'test1', '1234', '홍길동', 31);
insert into TBL_USER values(1, 'test1', '4321', '박길동', 31);

select * from TBL_USER;

-- NOT NULL 제약 : 데이터의 값이 null을 허용하지 않는 제약
drop table TBL_CONS_NOT_NULL;

create table TBL_CONS_NOT_NULL(
	user_no int not null,           -- not null은 컬럼으로만 제약이 가능
	user_id varchar(20) not null,
	user_pw varchar(20),
    user_name varchar(20),
    user_age int
    -- 테이블 레벨로는 not null 제약을 선언할 수 없다.
);

insert into TBL_CONS_NOT_NULL values(null, null, null, null, null); -- 안된다!
insert into TBL_CONS_NOT_NULL values(1, null, '1234', '홍길동', 31); -- 안된다!
insert into TBL_CONS_NOT_NULL values(1, 'test1', '1234', '홍길동', 31);
insert into TBL_CONS_NOT_NULL values(1, 'test1', '4321', '박길동', 31);

select * from TBL_CONS_NOT_NULL;


-- unique : 컬럼값 중에서 중복을 허용하지 않는 제약
--          컬럼 레벨, 테이블 레벨 제약 가능

drop table TBL_CONS_UNIQUE;
create table TBL_CONS_UNIQUE(
	user_no int not null unique, -- 제약을 동시에 거는 방법
    user_id varchar(20) unique,
    user_pw varchar(20),
    user_name varchar(20),
    user_age int,
    -- table 레벨에서 unique 제약 선언하는 곳
    unique(user_pw),
	unique(user_name, user_age) -- 이름과 나이가 모두 일치하는 사람은 가입 불가!!
);

insert into TBL_CONS_UNIQUE values(1, 'test', '1234', '홍길동', '31');
insert into TBL_CONS_UNIQUE values(1, 'test', '1234', '홍길동', '31'); -- user_no가 중복 되서
insert into TBL_CONS_UNIQUE values(2, 'test2', '4321', '홍길동', '32');
insert into TBL_CONS_UNIQUE values(3, 'test3', '43212', '김길동', '32');
insert into TBL_CONS_UNIQUE values(4, 'test4', '41231', '김길동', '32'); -- 안되는 케이스, 김길동-32이 있어서

select * from TBL_CONS_UNIQUE;

-- primary key(주키, 기본키, PK) ★★★★★★★
-- - table의 유일성, 최소성 원칙이 지켜진 id
-- - 중복값이 없고, NULL이 없는 제약이 발생 (unique + not null)
-- - 테이블당 1개만 설정이 가능하고, 테이블, 컬럼 레벨 둘다 제약 가능
-- - MySQL에서는 반드시 PK를 통해 검색 및 삭제, 수정을 진행해야한다. -> 가장 빠르다!

drop table TBL_CONS_PRIMARY_KEY;

create table TBL_CONS_PRIMARY_KEY(
	user_no int primary key, -- 컬럼레벨에서 PK 제약
    user_id varchar(20),
    user_pw varchar(20),
    user_name varchar(20),
    user_age int
    -- 테이블 레벨에서 제약
	-- primary key(user_no) -- 2개 생성하면 안된다!
);
    
insert into TBL_CONS_PRIMARY_KEY values(null, null, null, null, null); -- 안된다!
insert into TBL_CONS_PRIMARY_KEY values(1, 'test1', '1234', '홍길동', 31);
insert into TBL_CONS_PRIMARY_KEY values(1, 'test1', '1234', '홍길동', 31); -- 중복된 데이터라 안된다!
insert into TBL_CONS_PRIMARY_KEY values(2, 'test1', '4321', '박길동', 31);
select * from TBL_CONS_PRIMARY_KEY;

-- user no 1번을 조회해올 때 -> pk로 접근한다.
select * from TBL_CONS_PRIMARY_KEY where user_no = 1;

-- 주키 2개 이상 사용 해보기 -> 일반적인 상황은 아니나 필요할 때가 있다.
-- 주키 2개 설계 하는 패턴 : FK 2개로 table을 구성할 때, ex) 즐겨찾기 (Member PK - Product PK)

drop table TBL_CONS_PRIMARY_KEY;

create table TBL_CONS_PRIMARY_KEY(
	user_no int, -- 여기서는 불가능!
   	user_id varchar(20),
   	user_pw varchar(20),
   	user_name varchar(20),
    user_age int, 
    primary key(user_no, user_id) -- 반드시 table 레벨에서 2개 키 PK 셋팅 가능!
--    primary key(user_no, user_id, user_name) -- 3개 이상도 가능
);

insert into TBL_CONS_PRIMARY_KEY values(null, null, null, null, null); -- 안된다!
insert into TBL_CONS_PRIMARY_KEY values(1, 'test1', '1234', '홍길동', 31);
insert into TBL_CONS_PRIMARY_KEY values(1, 'test1', '1234', '홍길동', 31); -- 중복된 데이터라 안된다!
insert into TBL_CONS_PRIMARY_KEY values(2, 'test1', '4321', '박길동', 31);
select * from TBL_CONS_PRIMARY_KEY;

-- FOREIGN KEY (외래키) ★★★★★
-- 다른 테이블을 참조(join)할때 다른 테이블의 참조값(PK)를 자신의 컬럼값으로 활용할때 사용한다.
-- 참조 무결성을 지킬 수 있다.

drop table TBL_CONS_FOREIGN_KEY_USER; -- 지울 때 2
drop table TBL_CONS_FOREIGN_KEY_ORDER; -- 지울 때 1

-- table 만든느 순서, -> 참조될 테이블 -> 참조할 테이블 순으로 작성

create table TBL_CONS_FOREIGN_KEY_USER(
	user_no 	int unique,
    user_id 	varchar(20) primary key,
    user_pw 	varchar(20) not null,
    user_name 	varchar(20),
    user_age 	varchar(6),
    user_phone 	varchar(20)
);
    
-- 주문 정보
create table TBL_CONS_FOREIGN_KEY_ORDER(
	order_no 		int primary key,
    product_name 	varchar(20) not null,
    product_price 	int not null,
    user_id 		varchar(20) not null, -- 보통의 외래키는 참조할 테이블의 컬럼명과 일치하는게 정석, 만일 네이밍룰이 안좋다면 바꾼다!
    foreign key(user_id) references TBL_CONS_FOREIGN_KEY_USER(user_id)
);


insert into TBL_CONS_FOREIGN_KEY_USER values(1, 'test1', '1234', '홍길동1', '31', '010-1234-5678');
insert into TBL_CONS_FOREIGN_KEY_USER values(2, 'test2', '1234', '박길동1', '41', '010-6234-5678');
select * from TBL_CONS_FOREIGN_KEY_USER;

insert into TBL_CONS_FOREIGN_KEY_ORDER values(100, '아이폰14', 99, 'test1'); -- 성공, test1 아이디 존재함
insert into TBL_CONS_FOREIGN_KEY_ORDER values(101, '갤럭시z 플립3', 102, 'test3'); -- 실패, 외래키 제약으로 실패, 참조 할 테이블 test3 없음
select * from TBL_CONS_FOREIGN_KEY_ORDER;
select * from TBL_CONS_FOREIGN_KEY_ORDER join TBL_CONS_FOREIGN_KEY_USER using(user_id);

-- 삭제 테스트 
delete from TBL_CONS_FOREIGN_KEY_USER where user_id = 'test1'; -- 외래키 제약으로 삭제 실패! 참조무결성 위배

-- 외래키가 포함 컬럼 삭제 시 옵션 ★
-- ON DELETE RESTRICTED (DEFAULT) : 외래키로 참조된 행 삭제 불가능 -- 제일 안전한 방법!!
-- ON DELETE SET NULL : 외래키가 삭제된 경우 해당 행에 데이터를 NULL 갱신 - 비교적 안전!!
-- ON DELETE CASCADE  : 외래키가 주키로 있는 행이 삭제 되면 참조 된 행도 자동으로 삭제 됨

-- DROP 옵션
-- CASCADE : A개체를 변경/삭제할때, A개체를 참조하고 있는 모든 개체들이 변경/삭제된다.
-- RESTRICT : A개체를 변경/삭제할때, A개체를 참조하고 있는 개체가 존재하면 A개체에 대한 명령(변경/삭제)이 취소된다. 
DROP TABLE TBL_CONS_FOREIGN_KEY_USER RESTRICT;
DROP TABLE TBL_CONS_FOREIGN_KEY_ORDER RESTRICT;

-- delete 제약 실험 시작부
CREATE TABLE TBL_CONS_FOREIGN_KEY_USER( 
    user_no    INT UNIQUE NOT NULL,
    user_id    VARCHAR(20) PRIMARY KEY,   
    user_pw    VARCHAR(20) NOT NULL,
    user_name  VARCHAR(20),
    user_age   VARCHAR(6),
    user_phone VARCHAR(20)
);

CREATE TABLE TBL_CONS_FOREIGN_KEY_ORDER( -- 주문 정보 
    order_no       INT PRIMARY KEY,
    product_name   VARCHAR(20) NOT NULL,
    product_price  INT NOT NULL,
    user_no        INT,
 -- FOREIGN KEY(user_no) REFERENCES TBL_CONS_FOREIGN_KEY_USER(user_no) 
    FOREIGN KEY(user_no) REFERENCES TBL_CONS_FOREIGN_KEY_USER(user_no) ON DELETE SET NULL
 -- FOREIGN KEY(user_no) REFERENCES TBL_CONS_FOREIGN_KEY_USER(user_no) ON DELETE CASCADE 
);
INSERT INTO TBL_CONS_FOREIGN_KEY_USER VALUES(1,'test11','1234','김길동','23','010-5633-3121');
INSERT INTO TBL_CONS_FOREIGN_KEY_USER VALUES(2,'test22','1234','박길동','33','010-2233-3121');

INSERT INTO TBL_CONS_FOREIGN_KEY_ORDER VALUES(100, '아이폰13', '999', 1);
INSERT INTO TBL_CONS_FOREIGN_KEY_ORDER VALUES(101, '아이폰13 프로', '1330', 2);

SELECT * FROM TBL_CONS_FOREIGN_KEY_USER;
SELECT * FROM TBL_CONS_FOREIGN_KEY_ORDER;

DELETE FROM TBL_CONS_FOREIGN_KEY_USER WHERE user_no = 1;
-- on delete restricted(없을 때) : 제약으로 인해 child record가 삭제 되지 않음
-- on delete set null : user_no가 null로 채워진다.
-- on delete cascade : 참조된 id가 있었던 주문정보가 같이 삭제된다.

-- check 제약 : 정해진 범위의 값을 확인하는 제약  ★★★★
drop table TBL_USER_CHECK;
create table TBL_USER_CHECK(
	user_name varchar(30), -- 컬럼레벨 제약
    age int check(age > 19 and age < 40), -- MZ	세대만 ..
    gender varchar(2),
    -- table 레벨에서의 제약
    check(gender in('남', '여')),  -- 반드시 남, 여 로만 데이터를 받고 싶을 때
	check(user_name not in('홍길동')) -- 포함하면 안되는 키워드
);

insert into TBL_USER_CHECK values ('홍길동', 30, '남'); -- 이름이 홍길동이라서 chk_3 
insert into TBL_USER_CHECK values ('박길동', 8, '남'); -- 나이 제한 chk_1
insert into TBL_USER_CHECK values ('박길동', 30, '남자'); -- 안됨 남, 여가 아니어서 chk_2
insert into TBL_USER_CHECK values ('박길동', 30, '남'); -- 된다
insert into TBL_USER_CHECK values ('박길순', 31, '여'); -- 된다

select * from TBL_USER_CHECK;

-- DEFAULT : 해당 컬럼에 입력 되는 값이 없는 경우 설정된 초기값으로 값을 저장 ★★★★★
--           NULL로 초기화하는 경우 NULL이 입력됨으로 주의 필요

drop table USER_DEFAULT;
CREATE TABLE USER_DEFAULT(	
	USER_NO INT PRIMARY KEY,	
	USER_ID VARCHAR(20) DEFAULT 'TEST',	
	USER_PWD VARCHAR(30),	
	USER_NAME VARCHAR(30) DEFAULT '홍길동',   
	CREATE_DATE datetime DEFAULT now()
    );
    
insert into USER_DEFAULT (user_no) values(0); -- insert 문인데, 칼럼명을 명시한 문법, 여기서 표현 되지 않은 값은 default 값이 적용!
insert into USER_DEFAULT values(1, null, null, null, null); -- default옵션 되있어도 null로 값을 넣으면 null이 된다.
insert into USER_DEFAULT values(2, default, null, default, default); -- 명시적으로 default를 적용하는 방법
select * from USER_DEFAULT;

-- AUTO_INCREMENT : 고유 번호를 생성하는 문법으로 특정 값을 1부터 자동으로 1씩 증가 시킴  ★★★★★
-- PK 설정시 'XXX_NO INT PRIMARY KEY AUTO_INCREMENT'가 숙어처럼 활용됨
--          -> DB 만병통치약!
--          -> 성능, 편리성, 동시성, 용량, 순번유지 등등

DROP TABLE USER_AUTO_INCREMENT;
CREATE TABLE USER_AUTO_INCREMENT(
	USER_NO INT PRIMARY KEY AUTO_INCREMENT, -- ★★★★★
	USER_ID VARCHAR(20) DEFAULT 'TEST',
	USER_PWD VARCHAR(30),
	USER_NAME VARCHAR(30) DEFAULT '-'
);

insert into USER_AUTO_INCREMENT values(null, default, default, default); -- 된다 -> 자동증감!
insert into USER_AUTO_INCREMENT values(0, default, default, default); -- 된다 -> 자동증감!
insert into USER_AUTO_INCREMENT values(default, default, default, default); -- 된다 -> 자동증감!
ALTER TABLE USER_AUTO_INCREMENT AUTO_INCREMENT = 100; 
insert into USER_AUTO_INCREMENT (user_no) values(default);
insert into USER_AUTO_INCREMENT (user_no) values(default);
insert into USER_AUTO_INCREMENT (user_no) values(default);

select * from USER_AUTO_INCREMENT;

-- table 생성시 초기화 문법
CREATE TABLE EMPLOYEE_COPY
AS SELECT EMP_ID, EMP_NAME, SALARY, DEPT_TITLE, JOB_NAME
     FROM EMPLOYEE
     LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
     LEFT JOIN JOB USING(JOB_CODE);
     
select * from EMPLOYEE_COPY;
