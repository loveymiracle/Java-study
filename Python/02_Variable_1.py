# 변수란?
# 메모리 상에서 데이터를 담는 크기와 형식(Type)과 주소지를 가지는 데이터
# 파이썬 변수는 immutable과 mutable 속성으로 분리된다.
# immutable은 기본형(int, float, str)과 immutable 설계된 tuple, frozenset이 대표적
# mutable은 list, dict, set 등 가변 가능한 속성이 주를 이룸

# Numeric Types : int, float, complex(복소수, *교육에서는 제외)
# Text Type : str
# Sequence Types : list, tuple
# Mapping Type : dict
# Set Types : set, frozenset(*교육에서는 제외)
# Boolean Type : bool
# Binary Types : bytes, bytearray, memoryview (*교육에서는 제외)

# 변수 선언법
# - type을 쓰지 않고 이름과 초기 값을 선언하여 작성

a = 10
b = c = 20
x, y, z = 10, 20, 30 # unpack 문법, 대입하는 숫자의 갯수가 다르면 죽는다.
print(a)
print(b, c)
print(x, y, z)
print('----------------------------------------')

# 정수형 (int)
# - 일반적인 숫자 정수를 의미함, 범위가 무제한이라는 특징을 가진다.

intValue1 = 128
intValue2 = -127
intValue3 = 0
intValue4 = 300000000000000000000000 * 40000000000000000000000000
print(type(intValue1)) # type을 출력하는 함수, int
print(intValue1)
print(intValue2)
print(intValue3)
print(intValue4)
print('------------------------------------------')

# 실수(float)
# - 소수점 표현이 가능한 Type(부동소수점)
# - 범위 : 4.9×10^-324~1.8×10^308
# - 특징 : 컴퓨터의 특성상 정확한 실수 계산은 불가능한다!

floatValue1 = 3.14
floatValue2 = 123456789.123456789
floatValue3 = -87.7e100
print(type(floatValue1))  # float
print('floatValue1 : ', floatValue1)
print('floatValue2 : ', floatValue2)
print('floatValue3 : ', floatValue3)

# ※ 포멧팅 출력시의 주의점
# -> 포멧팅 출력시의 소수점이 잘릴 수 있음!
print('포맷팅 출력 예시')
print('floatValue2 : %f' % floatValue2)  # 123456789.123457
print('floatValue2 : %.2f' % floatValue2)  # 소수점 둘째자리 까지 출력하는 방법

# 문자열로 만들어서 출력하는 방법
# print('floatValue2 :' + floatValue2)  # 안되는 문법!
print('floatValue2 : ' + str(floatValue2))  # 잘된다!

# 더 정확하게 사용하기 위해선 별도 함수 추천
# from decimal import Decimal
# from fractions import Fraction
print('--------------------------------------------------')

# 문자열(str)
# 문자를 표현하는 최소 범위, 한 글자를 따로 표현 하는 방법이 없다. -> '' "" 논리적으로 동치한다.
# 대표적으로 immutable 속성을 가지는 Type
# 문자열이 immutable 한 이유는 메모리 공간을 절약하기 위해서 반드시 필요하다.
# 성능 저하가 존재할수도 있다.

strValue1 = 'Hello "World!"'
strValue2 = "Hello 'World!'"
strValue3 = '''Hello's "W"orld!'''  # ''' 로도 가능
strValue4 = """Hellow's "W"orld!"""  # """ 로도 가능

print('type :', type(strValue1))
print('strValue1 :', strValue1)
print('strValue2 :', strValue2)
print('strValue3 :', strValue3)
print('strValue4 :', strValue4)

# 싱글/더블 쿼테이션 표현법
strValue5 = "Python's"
strValue6 = 'Python\'s'  # \'로 쿼테이션 표현 가능
print(strValue5, strValue6)

# 문자열 + 연산 : 문자열을 더하는 연산, 단 문자열간의 결합만 허용!
strValue7 = '문자열' + '\t' + '더하기'
print('strValue7 :', strValue7)

# 문자열 * 연산 : 문자열을 곱하는 연산(반복)
strValue8 = '문자열 반복! ' * 5
print(strValue8)
print('-' * 60)
print('------------------------------------------------------------------------')

# 문자열 주요 함수(메소드)
# 찾는 요령 : '' . + 자동 완성

strVal = 'Hello Python World!!'
print(strVal)

# len() : 문자열 길이 구하기, 빌트인 함수!
print('문자열 길이 :', len(strVal))

# index로 접근하는 방법 : value[index]
print('index 0 :', strVal[0])
print('index 1 :', strVal[1])
print('index 2 :', strVal[2])

# 반복문 for문으로 접근하기
for val in strVal:
    print(val, end='')
print()

# 반복문 + range 함수로 index 접근하기
# for(int i = 0; i < 10; i++) {} - 대체 문법
for i in range(0, len(strVal)):
    print(strVal[i], end='')
print()

# 문자열 index 뒤로 접근하는 방법 (음수-, 활용)
# Hello Python World!!
print('strVal[-1] :', strVal[-1])  # !
print('strVal[-2] :', strVal[-2])  # !
print('strVal[-3] :', strVal[-3])  # d

# 문자열 index로 접근해서 수정 -> 불가능!
# strVal[0] = 'J'
# TypeError: 'str' object does not support item assignment
# 원인 : immutable 속성으로 문자열 직접 수정이 불가능하다!!
# 방법 1. list로 변환한 이후 변환하고 다시 문자열로 바꾸기
# 방법 2. replace를 활용하여 원하는 문자열 변경

# 1. 문자열을 list로 변환하여 수정하기
list1 = list(strVal)
list1[0] = 'J'
print(list1)
print(''.join(list1))

# 문자열이 있는지 검색 하는 방법1 (in 연산자)
print('Hello' in strVal)  # True
print('Jello' in strVal)  # False

# 문자열이 있는지 검색 하는 방법2 (index 메소드)
print(strVal.index('Hello'))  # 0번째 인덱스에 존재!
print(strVal.index('Hello') >= 0)  # 있는지 확인하는 방법

# 문자열(배열) 자르기(splice) 문법 ':'
print(strVal)  # Hello Python World!!
print(strVal[2:])  # 문자열 index 2부터 끝까지 자르는 문법, llo Python World!!
print(strVal[:5])  # 시작부터 5번째 인덱스까지 자르는 문법, Hello
print(strVal[6:12])  # 6번째 부터 12번째 까지, Python
print(strVal[-5:])  # 뒤에서 5글자 자르기, rld!!
print(strVal[-5:-2])  # 뒤에서 2글자부터 5글자 자르기 rld
print('----------------------------------------------------------------')

# 문자열 변환 메소드들

# 대소 문자 바꾸기
print(strVal.upper())
print(strVal.lower())

# 공백(white space) 제거
strVal2 = ' \nHello Python World!!\t\n '
print(strVal2.strip())

# 일부 문자열 바꾸기
print(strVal.replace('H','J'))  # Jello Python World!!
print(strVal.replace('Hello', ''))  # Python World!!
print(strVal.replace('Hello', 'Hell'))  # Hell Python World!!

# 문자열 분리
print(strVal.split())  # 기본적으로 공백으로 분리된다.
print(strVal.split(' '))  # 공백으로 분리
for val in strVal.split():
    print(val)

# 문자열 합치기(join) ★★★★★
# - 문법이 좀 이상하다. 외워야한다!
# - '+' 연산보다 메모리 효율 및 성능이 우월해서 반드시 사용해야한다.
list1 = list(strVal)  # 문자열이 완전 분리외서 list로 변환하는 문법
list2 = list(strVal.split())  # 공백으로 분리하기
print(list1)
print(list2)
print(''.join(list1))  # 배열을 문자열로 합치는 방법
print(' '.join(list2))  # 문자열간 다시 공백으로 분리되어 합쳐진다.

# 문자열 포멧팅
# 가장 old한 방식 : % 포멧팅, 가장 강력한 방법
# 다음 주류 : text.format()
# 가장 최신 : f'{name}'

age = 26
text = '홍길동의 나이는 {}살이다'
print(text)
print(text.format(age))

name = '홍길동'
age = 26
height = 175.123456789
text = '{}의 나이는 {}살이고 키는 {}이다.'
print(text.format(name, age, height))  # 키의 경우 소수점이 다 나온다.
# 홍길동의 나이는 26살이고 키는 175.123456789이다.

# f 포맷팅 문법
text2 = f'{name}의 나이는 {age}살이고 키는 {height}이다.'
print(text2)

# % 포맷팅 ★★★★★, 추천! 소수점 자리수까지 포맷팅 가능
text3 = '%s의 나이는 %d살이고 키는 %.2f입니다.'
print(text3 % (name, age, height))

txt4 = '{2}님의 나이는 {1}살이고 키는 {0} 입니다.'
print(txt4.format(height, age, name))  # 비추천!

# 정규 표현식
# import re 가 필요하다!
import re
str1 = 'test2@email.com'
str2 = 'www.email.com'
match1 = re.search(r'[a-z|0-9]+@[a-z|0-9]+\.[a-z|0-9]+', str1)  # email 형식 검사
match2 = re.search(r'[a-z|0-9]+@[a-z|0-9]+\.[a-z|0-9]+', str2)
print(match1)
print(match2)

# 문자열 비교
# == 으로 해결 가능! equals가 필요하지 않다.
# 생성 방법이 달라도 java처럼 뒤죽박죽 생성 되지 않는 특성을 가진다.
# String str1 = new String("") # heap에 객체가 생성이 되고 String pool 위치를 객체가 가지고 있음
# String str2 = "" # spring pool에 객체가 생성되는 원리

str1 = 'abc'
str2 = 'abc'
str3 = '' + str1
str4 = 'abcd'

# id() : 객체의 식별코드=해시코드(주소지)를 출력하는 방법
print(id(str1))  # abc주소
print(id(str2))  # abc주소
print(id(str3))  # abc주소
print(id(str4))  # abcd주소

print(str1 == str2)  # == : 비교 연산자, True
print(str1 is str2)  # is : id 비교 연산자, id 기반으로 비교한다., True
print(str1 == str4)  # False
print(str1 is str4)  # False

# 더 많은 문자열 함수
# https://www.w3schools.com/python/python_strings_methods.asp

# 기본형간 Casting 문법
intVal = int('10') + int('5')  # 문자열 -> int wjsghks
print(intVal)

floatVal = float('3.15') + 12.34
print(floatVal)

strVal = 'intVal : ' + str(intVal) + '\n'
strVal += 'floatVal :' + str(floatVal)
print(strVal)
