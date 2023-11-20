-- from 없는 select문 = 함수 연습용, DB  연산이 필요 시 활용
select length('test');
select length('test') from dual; -- oracle에서 넘어온 문법, dual=빈테이블로 연습용으로 활용하는 문법


-- 문자열 함수

-- length : 문자열의 바이트를 반환 (국문 = 3byte, 영문 = 1byte)
-- char_length : 문자열의 길이를 반환 (국문, 영문 똑같이 취급)

select length('test'); -- 4byte;
select char_length('test'); -- 4글자;
select character_length('test'); -- 4글자;

select length('홍길동'); -- 9byte
select char_length('홍길동'); -- 3글자
select character_length('홍길동'); -- 3글자

-- email의 길이가 17자리 이상인 사람
select * from employee where length(email) >= 17;
select count(*) from employee where length(email) >= 17;

-- locate : 문자열을 찾는 함수, 인자와 index를 지정하여 탐색 가능
-- locate('찾을 문자열', '컬럼이나 text값', 'index');
-- DB index의 시작은 java와 다르게 1이다.
select locate('최길동', '안녕하세요? 저는 홍길동입니다. 홍길동은 19살입니다.'); -- 0, 없으면 나오는 값
select locate('홍길동', '안녕하세요? 저는 홍길동입니다. 홍길동은 19살입니다.'); -- 11, 홍길동 문자열의 첫번째 값
select locate('홍길동', '안녕하세요? 저는 홍길동입니다. 홍길동은 19살입니다.', 12); -- 다음 홍길동 찾는 문법, 19

-- 이메일에서 id만 추출하는 법, 주의 : index 1부터 시작함
select email, locate('@', email), substr(email, 1, locate('@', email) - 1) from employee;

-- LPAD / RPAD : 문자열을 지정한 크기만큼 특수문자로 채워놓는 함수 ★★★
-- 활용 : 가명처리, 마스킹처리할때 자주 사용, 900101-1******

select lpad('홍길동',8,'@'); -- @@@@@홍길동, 8글자이고 오른쪽부터 @으로 채워진 문자열
select lpad('홍길동',3,'@'); -- 최대 크기가 문자열 길이와 같거나 적으면 의미가 없다.
select lpad('hello', 8, '@'); -- @@@hello

select rpad('홍길동',8,'@'); -- 홍길동@@@@@
select rpad('홍길동',3,'@'); -- 최대크기가 문자열 길이와 같거나 적으면 의미가 없다.
select rpad('hello', 8, '@'); -- hello@@@


-- trim : 문자열의 공백이나 지정한 문자열을 제거하는 함수
-- L/RTRIM('문자') -- 공백 제거
-- FROM : 특정문자 제거하는 방법
-- LEADING FROM : 앞에 존재하는 문자열만 제거
-- TRAILING FROM : 뒤에 존재하는 문자열만 제거

select trim('   안녕하세요   '); -- 안녕하세요
select ltrim('   안녕하세요   '); -- 안녕하세요 '   ' -> 뒤에 공백이 남음
select rtrim('   안녕하세요   '); -- '   '안녕하세요 -> 앞에 공백이 남음

-- 특정 문자만 제거하는 방법
select trim('@@!안녕하세요!@@');
select trim('@' from '@@!안녕하세요!@@'); -- from 문법으로 '@'만 삭제하는 방법

-- replace : 특정 문자열을 바꿔주는 함수
-- trim 에서 특정 문자만 바꾸는 기능을 replace로도 구현 가능!

select replace('@@!안녕하세요!@@', '@', ''); -- 없애는 문법
select replace('@@!안녕하세요!@@', '@', '!'); -- !로 바꾸는 문법


-- substr : 문자열을 자르는 함수
-- substr('문자열|컬럼', '시작위치', [길이]) []=option
select substr('1234567890abcde', 1, 5); -- 12345
select substr('123456790abcde', 5); -- 567890abcde
select substr('1234567890abcde', 5, 3); -- 567
select substr('1234567890abcde', -5, 5); -- abcde

-- 주민번호 마스킹 처리하는 방법
select emp_name, emp_no, substr(emp_no, 1, 8), rpad(substr(emp_no, 1, 8),14, '*') as 주민번호 from employee;


-- substr 파생문법
-- left : 왼쪽부터 자르기
-- right : 오른쪽부터 자르는 함수
select left('123456890abcde', 5); -- 12345
select right('1234567890abcde', 5); -- abcde

-- 대소문자 변경하기 
-- lower, upper
-- 아이디나 영문을 강제로 소문자로 매칭시킬 때
select lower('Hello DataBase World!!');
select upper('Hello DataBase World!!');



-- concat : 문자열 합치기 ★★★★★, 인자를 여러개로 활용할 수 있다.
select concat('Hello', 'World');
select concat(emp_name, ' 님', ' 환영합니다.') from employee;

-- reverse : 문자열을 역순으로 바꾸는 함수
select reverse('ABCDE');
select reverse('가나다');

-- format : 숫자의 포멧팅 출력(금액, 소수점), 소수점 자리까지 반올림
-- 향후 front단에서 처리하는 것을 권장함으로 DB format하여 값을 가져오지 말 것
select format(123456789.123456, 4); -- 소수점 4번째 자리까지 반올림하는 포맷팅,
-- 결과 -> 123,456,789.1235 = 문자열 형식

-- 공백으로 채우는 방법
select space(10); -- '          '

-- 문자열 함수 끝


-- ■ Math 관련 함수 
-- ABS : 절대값
-- MOD : 모듈러 연산 %
-- ROUND : 반올림
-- FLOOR : 버림
-- CEIL : 올림
-- truncate : 사용자가 지정한 소수점 자르기
-- rand : 랜덤값 발생

select abs(+10);
select abs(-10);

select mod(10, 3); -- 1

select round(10.44, 1); -- 10.4, 1=출력할 자리수
select round(10.46, 1); -- 10.5
select round(15.46, -1); -- -1=양수자리 1번째 자리 반올림림

select floor(10.9); -- 10, 버림
select floor(10.2); -- 10, 버림

select ceil(10.9); -- 11, 올림
select ceil(10.2); -- 11, 올림

select truncate(10.5); -- 반드시 2개의 인자가 필요
select truncate(10.6, 0); -- 10, 소수점 자르기!! -> 문자열 기준으로 자른다.
select truncate(10.12345, 3); -- 10.123, 3번쨰 자리까지 자르기
select truncate(12345.12345, -2); -- 10.123, 양수 자리의 2번째 자리까지 자르기

-- rand : 랜덤한 값, 1.0 ~ 0 무작위 난수를 가져옴
select rand();
select rand(1); -- seed값인데 고정하면 같은 값 나옴
select rand(now());
select floor(rand(now())*100); -- 1 ~ 100 까지

-- 숫자 관련 함수 끝! 

-- 날짜 함수 시작!! ★★★★★	
select now(); -- 2023-11-14 14:47:11
select sysdate(); -- 2023-11-14 14:47:38
select curdate(); -- 2023-11-14
select current_date(); -- 2023-11-14
select curtime(); -- 14:48:20
select current_time(); -- 14:48:43




-- timestamp : 시스템이나 log에서 시간을 빠르게 표기하고자 나온 type, 날짜 표기가 아닌! 시간을 빠르게 저장하기 위한 방법
--             정수형으로 저장되며, 소수점 6번째까지 저장, 1970~2038년까지만 시간이 저장된다.
select current_timestamp(); -- 2023-11-14 14:48:56

select localtimestamp(); -- 2023-11-14 15:06:45


-- datediff : 인자로 받은 날짜간의 간격 차이 계산 ✭✭
select datediff(now(), '2023-10-30');
select datediff(now(), '2022-10-30');
select datediff('2024-04-15', now()); -- 전역일까지 153일 남음


-- adddate : 인자로 전달받은 날짜와 지정한 일수를 더해주는 함수 (+- 가능) ✭✭✭
-- date_add, date_sub 거의 비슷한 기능

-- 날짜 더하기
select adddate(now(), interval + 7 day);
select adddate(now(), interval -7 day);

-- 월 더하기
select adddate(now(), interval +5 month);
select adddate(now(), interval -5 month);

-- 연으로 더하기
select adddate(now(), interval +5 year);
select adddate(now(), interval -5 year);

-- adddate, date_add, date_sub 차이점
select adddate(now(), interval +5 day); -- 2023-11-19 15:16:18
select date_add(now(), interval +5 day); -- 2023-11-19 15:16:11
select date_sub(now(), interval 5 day); -- 2023-1109 15:16:01, +를 -로 바꿔서 계산


-- 직원 테이블에서 사원의 이름, 입사일 , 입사후 6개월이 된 날짜 조회
select emp_name, hire_date, adddate(hire_date, interval +6 month) as '입사 6개월' from employee;


-- EXTRACT : 날짜의 연, 월, 일, 시, 분, 초를 추출 할 수 있는 함수, 표준적인 함수
-- 모든 TIME 속성들 추출 가능하다.
select extract(year from now());
select extract(month from now());
select extract(day from now());

-- '2023-11-14 extract를 통해 조합하는 방법'
select concat(extract(year from now()), '년 ',
                 extract(month from now()), '월 ',
                 extract(day from now()), '일 ') as 날짜;
                 
select extract(hour from now());
select extract(minute from now());
select extract(second from now());

-- year, month, day, hour, minute, second 함수
select year(now()), month(now()), day(now()), hour(now()), minute(now()), second(now());

-- microsecond = 소수점까지 출력하는 옵션을 걸어줘야 한다!!
select microsecond(now(6));


-- 날짜 함수 끝!!
-- 형변환 함수 ★★★★★
-- 문자 : char, varchar 들 호환해서 사용 가능
-- 숫자 : 정수, 실수 호환 사용 가능
-- Date : 날짜 관련 모든 Type 호환

-- cast : 모든 type을 원하는 type으로 변경 가능

-- 날짜 -> 문자, 숫자 ✭✭✭
select now();
select cast(now() as char); -- date type -> string 
select cast(now() as signed); -- date type -> long
select cast(now() as json); -- javascript에서 객체로 받을 수 있다.


-- 문자열을 숫자로 변환할 때
select cast('12345' as dec) + 1; -- 문자 -> 숫자로 변환 뒤 +1을 함
select cast('12345.1234' as dec) + 1; -- 정수형
select cast('12345.1234' as double) + 1; -- 실수형
select cast('12345.1234' as decimal(10,2)) + 1; -- 총 문자열 10개에서 소수점 2자리 허용

-- 숫자를 문자로 바꾸는 것은 의미가 없다!! -> 문자는 숫자든 숫자형태면 사칙연산 및 산술 연산 지원
select '123' + '456'; -- 579, 숫자는 숫자로 받아들인다.
select cast(123 as char) + '456'; -- 의미 없는 cast, 579

-- DATE_FORMAT : 날짜를 특정 포멧의 문자열로 바꾸는 함수 
select date_format(now(), '%Y-%m-%d %W %H:%i:%s'); 
select date_format(now(), '%D %M, %Y %W %H:%i:%s'); 
select date_format(now(), '%y/%m/%d %H:%i:%s'); 
select date_format(now(), '%y/%m/%d');


-- 논리 함수
-- if : 논리절을 구성 가능
select if(10 > 5, '참', '거짓');

-- 성별 출력하기 2000년 대생이 포함된 경우, 1,3 남자 /. 2,4 여자
SELECT 
    emp_name, emp_no, substr(emp_no,8,1) as 성별기호,
    if(substr(emp_no,8,1) = 1 or substr(emp_no,8,1) = 3, '남','여') as 성별
FROM
    employee;

-- ifnull() : null 값을 다른 값으로 바꿔주는 함수 (NVL) ★★★
select ifnull(null, 0);
select ifnull(null, '-');
select ifnull(null, ''); -- ''을 null로 바꾸지 말것!!! ※ 금기
select emp_name, bonus from employee;
select emp_name, ifnull(bonus,0) from employee;

-- if로도 null 처리가 가능하다
select if(null, '참', '거짓'); -- null, false, 0 = 거짓 자리에 들어온다!
select if(10,'참','거짓'); -- 양수나 문자 등 값이 있을 때는 참이 된다.
select if('문자', '참', '거짓'); -- ※ 거짓 나온다.
 
select emp_name, if(bonus,bonus,0) from employee;

-- isnull : null 인지를 확인하여 1=null,0=null이 아닐 때 결과가 나옴
select isnull(null); -- 1
select isnull(10); -- 0
select isnull('문자'); -- 0

-- 최대값을 찾아오는 방법
select greatest(1,2,3,4,5);

-- 최소값을 찾아오는 방법
select least(1,2,3,4,5);



-- CASE 문 : IF와 활용 비슷함
-- CASE 
--    WHEN 조건1 THEN 결과1
--    WHEN 조건2 THEN 결과2
--    WHEN 조건n THEN 결과n
--    ELSE 결과
--  END

-- 주민번호로 남여구별 case 문으로 구성
SELECT 
    emp_name, emp_no,
    case
		when substr(emp_no, 8, 1) = 1 then '남'
        when substr(emp_no, 8, 1) = 2 then '여'
        when substr(emp_no, 8, 1) = 3 then '남'
        when substr(emp_no, 8, 1) = 4 then '여'
		else '-'
    end as 성별
FROM employee;

SELECT 
    emp_name, emp_no,
    case
		when substr(emp_no, 8, 1) = 1 
			or substr(emp_no, 8, 1) = 3 then '남' 
		else '여'
    end as 성별
FROM employee;


SELECT EMP_NAME, SALARY,
	   CASE 
			WHEN SALARY > 5000000 THEN '1등급'
			WHEN SALARY > 3500000 THEN '2등급'
			WHEN SALARY > 2000000 THEN '3등급'
			ELSE '4등급'
	   END 등급
FROM EMPLOYEE;
