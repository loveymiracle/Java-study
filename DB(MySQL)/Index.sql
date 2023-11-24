-- INDEX란? ★★
-- DB에서 데이터 검색의 성능향상을 위해 별도의 INDEX를 활성화 하여 빠르게 검색이 가능하도록 돕는 기능
-- 사전에 색인과 같이 File의 위치, Block의 위치와 같은 실제 물리주소를 저장하는 원리
-- 조회 할 시 Key 값으로 조회하는 경우 일반값을 조회하는 것보다 10배 이상 빠르게 탐색 가능 ★★★★★

-- INDEX 종류
-- 1. 고유 인덱스 (UNIQUE INDEX): 고유한 값으로만 이뤄진 INDEX, ※ PK 선언시 기본적으로 같이 선언됨(DEFAULT) ★★★★★ 
-- 2. 비고유 인덱스 (NOUNIQUE INDEX): 중복값을 허용하고, 일반적으로 사용자가 활용하는 인덱스 ★★★
-- 3. 단일 인덱스 (SINGLE INDEX): INDEX로만 구성된 테이블(한개의 컬럼) -> 순서를 기준으로 탐색할 때 활용
-- 4. 결합 인덱스 (COMPOSITE INDEX) : 두개 이상의 컬럼을 INDEX로 활용 할 때

-- 인덱스 조회 방법
select * from employee;
show index from employee;
desc employee;
-- 인덱스 생성하는 문법
-- CREATE [UNIQUE] INDEX '인덱스명' ON '테이블명' (컬럼명|함수명|함수 계산식);

-- 고유 인덱스 생성하기 (유니크한 값만 가능, PK)
create UNIQUE index idx_emp_no on employee(emp_no);
-- 만일 유니크하지 않은 경우는 생성 안됨!

select * from employee where emp_no = '860508-1342154';
explain select * from employee where emp_no = '860508-1342154'; -- index가 동작했는지 알수 있는 방법
-- idx_emp_no -> index를 활용함

explain select * from employee where phone = '01099546325'; -- Using where, index 동작 안함!!!
-- 현재 체감 불가능하지만 속도는 비약적으로 상승했다고 함.


-- 비고유 인덱스 생성 (값이 고유하지 않아도 생성가능, 일반적으로 활용됨)
create index idx_dept_code on employee(dept_code);
explain select * from employee where dept_code= 'D5'; -- idx_dept_code, Using index condition
explain select * from employee where dept_code like 'D5'; -- Using where, like절은 index 적용 안됨!


-- 결합 인덱스 - 두개 이상의 값을 사용하는 index
create index IDX_NAME_PHONE on employee(emp_name, phone);
explain select * from employee where emp_name = '하이유' and phone = '01036654488'; -- IDX_NAME_PHONE
explain select * from employee where emp_name = '하이유'; -- IDX_NAME_PHONE
explain select * from employee where phone = '01036654488'; -- 동작안함 ! Using where
explain select * from employee where emp_name like '%하이%'; -- like = Using where, like절은 index 적용 안됨!

-- 인덱스 재생성 필요성
-- 사용 이유 : 주기적으로 최적화 할때 사용 --> DB 운영중에는 트리 최적화가 되지 않으므로 주기적 필요.
-- 인덱스 삭제
show index from employee;
ALTER TABLE EMPLOYEE DROP INDEX idx_dept_code;

-- Index 성능 : https://www.elastic.co/kr/blog/announcing-rally-benchmarking-for-elasticsearch
