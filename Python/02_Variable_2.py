# 변수란?
# 메모리 상에서 데이터를 담는 크기와 형식(Type)과 주소지를 가지는 데이터

# list : [val1, val2]
# 배열을 의미, type 상관 없이 모든 데이터(object)를 담을수 있는 공간
# 크기 제한이 없고, 고유 연산 및 함수를 제공함으로 매우 편리하게 사용할수 있다.
# Java에서 Collection List 동등한 기능

# list 선언법

list0 = []  # 빈 리스트 만드는 방법1 , 추천!
list0 = list()  # 리스트 만드는 방법2, casting 문법과 같은 문법 사용
list1 = [1, 2, 3, 4, 5, 6, 7]  # 1차원 배열
list2 = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
list3 = ['a', 'b', 'c']
list4 = ['안녕', '하세요?', '반갑습니다.']
list5 = [1, 2, 3, 'a', 'b', 'c']
list6 = ['홍길동', 31, 178.456, ['야구', '축구', '영화보기']]
list7 = [list1, list2, list3, list4, list5, list6]

print(type(list1))  # <class 'list'>
print(list1)

# index로 접근하는 방법, 양수-음수
# [1, 2, 3, 4, 5, 6, 7,]
print(list1[0])  # 1
print(list1[1])  # 2
print(list1[2])  # 3
print(list1[-1])  # 7, 음수로 접근가능, 뒤부터 접근하는 방법
print(list1[len(list1) -1])  # 7, -1과 동치인 문법

# 2차원 배열 접근하기
# [[1, 2, 3], [4, 5, 6], [7, 8 ,9]]
print(list2[0][0])
print(list2[1][1])

# 인덱스 범위를 벗어나면?
# -> 죽는다. IndexError : list index out of range
# print(list1[100])

# index 접근 및 수정 가능 ? -> 가능하다!
list1[0] = 10
print(list1)

# packing 문법
# packing이란? 변수를 다중 선언하고 list로 변수를 초기화 하는 기법....
hobby = ['축구', '야구', '농구']
a, b, c = hobby
print(a, b, c)
a, b, c = '축구', '야구', '농구'
print(a, b, c)

# packing 수행 시 갯수를 다르게 하면? -> 죽는다!
# hobby = ['축구', '야구']
# a, b, c = hobby  # unpack 문법

# 순회하는 방법
for v in list1:
    print(v, end=', ')
print()

# 2차원 배열 순회하는 방법
for innerList in list7:
    for item in innerList:
        print(item, end=', ')
    print()
print()
print('---------------------------------------------------------------------')

# 리스트 자르기(slice) 문법, ':' 사용하기
list1 = [1, 2, 3, 4, 5, 6, 7, 8, 9]
print(list1)
list1 = [v for v in range(1, 10)]  # 반복문으로 배열 초기화하는 방법
print(list1)
print(list1[0:2])  # 0부터 2까지 index, [1, 2]
print(list1[:2])  # [1, 2]
print(list1[2:])  # [3, 4, 5, 6, 7, 8, 9]
print(list1[2:6])  # [3, 4, 5, 6, 7]
print(list1[:-2])  # [1, 2, 3, 4, 5, 6, 7]
print(list1[4:-2])  # [5, 6, 7]
print('---------------------------------------------------------------------')

# len() : 크기 구하는 내장함수, 왠만한 자료구조가 먹힌다.
print(len(list1))

# 리스트 값 추가, 삭제, 수정
list1 = [1, 2, 3, 4]
list1.append(5)  # 뒤에 값 추가
list1.append(6)
list1.append(7)
list1.append('a')
list1.append('b')
print(list1)

# list에 값 수정
list1[0] = 10
print(list1)

# list에서 값을 삭제하는 방법 - 총 3가지 존재!
# 1. del 연산자를 통해서만 삭제 가능! slice 문법과 결합해서도 활용
del list1[0]  # 0번째 인덱스 값 삭제하기
print(list1)
del list1[4:]  # 4번째 인덱스 이후 모든 값 삭제
print(list1)
del list1[:2]  # 2번째 인덱스 이전까지 모든 값 삭제
print(list1)
print('---------------------------------------------------------------------')

# 2. remove : index가 아닌 특정 값을 지울 때 활용
list1 = [10, 20, 30, 'a', 'b', 'c']
list1.remove(20)
print(list1)
list1.remove('a')
print(list1)
# list1.remove('d')  # 없으면 -> 죽는다!
# print(list1)
# 없는거 안지우는 방법! in 문법을 통해 미리 검사해야 안죽는다!
if 'd' in list1:
    list1.remove('d')

# 3. pop() : 뒤로부터 하나 꺼내서 삭제하는 방법, queue로 활용할 때 사용!
list1 = [1, 2, 3, 4]
list1.pop()
print(list1)

# pop으로 배열 다 비우는 방법
while list1:
    print(list1.pop(), end=',')
print()

# sort : 정렬하는 기능, 기본은 오름차순
list1 = [5, 4, 3, 1, 2]
list2 = ['b', 'c', 'a', 'd']
print(list1)
list1.sort()
list2.sort()
print(list1)
print(list2)

# 내림차순  정렬하는 방법들
list1 = [5, 4, 3, 2, 1]
list2 = ['b', 'c', 'a', 'd']
list1.sort(reverse=True)  # 더 좋은 표현!
list2.sort()
list2.reverse()  # 리버스 메소드 활용법
print(list1)
print(list2)

# reverse : 배열을 역순으로 바꾸는 메소드
list2.reverse()
print(list2)
print('--------------------------------------------------------------')

# insert 활용법 : 값을 추가할 때 index로 추가하는 방법
# -> 만일 Insert + pop을 통해 queue처럼 활용하는 경우 굉장한 성능저하가 발생한다!! 금기!!
list1 = ['b', 'c', 'd']
list1.insert(0, 'a')  # index : 0 , value 'a'
print(list1)
list1.insert(len(list1), 'e')  # 값 끝에 넣는 방법, 이럴 경우 append 추천!
# list1.append('e')  # 위 코드와 동치되는 표현!
print(list1)  # ['a', 'b', 'c', 'd', 'e']
print('--------------------------------------------------------------------------------------')

# list 탐색 하는 방법
print('list 탐색!')
list1 = [1, 2, 3, 3, 3, 4, 4, 4, 4]

# 1. in 연산자를 통해 특정 값이 있는지 확인하는 방법
print(1 in list1)  # True
print(1 not in list1)  # False
print(10 in list1)  # False
print(10 not in list1)  # True
print(3 in list1) # True
# in은 if문과 많이 조합된다!!
if 1 in list1:
    print('1이 list에 있습니다.')
print()

# 2. index를 통해 특정 위치 찾는 방법
list2 = ['d', 'a', 'b', 'c', 'a']
print(list2.index('a'))
# 그다음 a 인덱스 찾는 방법은?
index = list2.index('a')  # index=1
print(list2[index + 1:].index('a') + index + 1)

# 배열에서 특정 값 count 해보기
list1 = [0, 1, 2, 2, 3, 3, 3, 4, 4, 4]

# 3이 배열에서 몇개인가? 세보기!

# 고전 스타일
indexList = []  # index 넣는 list
index = 0
for v in list1:
    if v == 3:
        indexList.append(index)
    index += 1  # index++이 없다!
print(indexList)
print(len(indexList))

# Python에서는 count 메소드로 특정값의 갯수를 세어올 수 있다!
print(list1.count(2))  # 2
print(list1.count(3))  # 3
print(list1.count(4))  # 3
print(list1.count(5))  # 0, 없음!

# pop : 뒤에 있는 값을 하나 가져오고 삭제할 때 사용
print('pop 시작!')
list1 = [1, 2, 3, 4]
print(list1.pop())
print(list1.pop())
print(list1.pop())
print(list1.pop())
# print(list1.pop())  # 에러 발생! IndexError: pop from empty list!
# -> pop을 할 경우에는 비었는지 검사 필수!

# list 비었는지 검사하는 방법1 - 고전스타일, 다른 언어에서 넘어온 사람!!
if len(list1) > 0:
    list1.pop()

# list 비었는지 검사하는 방법2 - 추천 문법! ✭✭✭✭✭
if list1:  # 파이썬 if문에서 특이한 케이스, 컬렉션류에서 값이 있으면 True, 없으면 False
    list1.pop()

# pop + while로 데이터 검사하고 값 비우는 방법
list1 = [1, 2, 3, 4]
while list1:  # while + 컬렉션은 값이 있을때까지 반복되는 문장!
    print('poppop',list1.pop(),'poppop')

# extends() : 확장, list를 합칠 때 활용
list1 = [1, 2, 3]
list2 = [4, 5, 6]
list3 = list1 + list2  # list1과 list2가 메모리에 유지되고 합쳐 지는 문법1
print(list3)
# list1에 list2의 내용을 추가하고 싶을 때는 extends를 통해 배열을 합칠 수 있다.
# list1 += list2  # 이것도 가능!
# print(list1)
list1.extend(list2)
print(list1)

# + 연산으로도 합쳐진다.
list1 = [1, 2, 3]
list2 = [4, 5, 6]
# list1 + list1 + list2
list1 += list2
print(list1)

# ※주의 append로 list를 합치면 안된다!! -> list가 하나의 인자로 취급됨!
list1 = [1, 2, 3]
list2 = [4, 5, 6]
list1.append(list2)
print(list1)

# list 비우는 방법
list1.clear()
# list1 = []  # 이 방법 추천
print(list1)
print('----------------------------------------------------------------------------')

# tuple : (val1, val2 ... )
# 읽기 전용 리스트!
# sequence type 중 하나로 list와 유사하지만, 원소(값)을 추가, 수정, 삭제 하지 못함.
# str과 유사한 속성을 가지는 list의 읽기 전용 버전으로 이해 하면 편함
# list와 호환이 가능함으로 값의 변경이 있을 때는 list로 변환하여 사용하길 권장
# list <-> tuple 이동시 메모리가 많이 소비됨으로 프로그래밍에 주의 필요

tuple0 = tuple()  # 빈 튜플 초기화 방법, 이렇게 쓸일이 없다..
tuple0 = ()  # 빈 튜플 초기화 방법, 이렇게 쓸일 없다..
tuple1 = (1, 2, 3)
tuple2 = (4, 5, 6)
tuple3 = tuple(['a', 'b', 'c', 'd'])  # 리스트로부터 형변환하여 tuple 만드는 방법
list4 = list(tuple3)  # tuple -> list로 형변환 하는 방법

print(type(tuple0))
print(tuple1)
print(tuple2)
print(tuple3)
print(list4)

# tuple append 지원하지 않는다. -> 단순 추가 불가능!
# tuple1.append(4)

# 값 수정 및 삭제도 불가능하다!
# tuple[0] = 10  # 'tuple' object does not support item assignment
# del tuple1[0]  # TypeError: 'tuple' object doesn't support item deletion

# 접근은 가능하다!! -> 읽기 전용
print(tuple1[0])
print(tuple1[1])
print(tuple1[2])

# 반복문으로 접근 가능!
for v in tuple1:
    print(v, end=', ')
print()

# 탐색가능! in키워드 활용
print(3 in tuple1)
print(0 in tuple1)

# 고유 연산 지원

# 합연산 가능! -> 새로운 튜플을 만들어 합치는 방법
print(tuple1 + tuple2)  # (1, 2, 3, 4, 5, 6)

# 곱연산
print(tuple1 * 5)

# 자르기
print(tuple1[1:])

# 길이 구하기
print(len(tuple1))
print('-----------------------------------------------------------')

# dict : {key:value, key:value}
# - dictionary(사전)으로 흔히 map 으로도 불리는 type
# - key, Value 쌍으로 이뤄진 자료 구조로 key를 통해 value를 불러옴
# - java에서 HashMap과 동일한 기능, 성능

# 선언법
dict0 = {}  # dict로 초기화 된다.
print(type(dict0))  # <class 'dict'>
dict0 = dict()
dict1 = {'name': '홍길동', 'age': 27, 'height': 175.3, 'hobby': ['축구', '야구', '농구']}
dict2 = {1: '홍길동', 2: 27, 3: 175.3, 4: ['축구', '야구', '농구']}  # 숫자 키

# 접근하는 방법
print(dict1)
print(dict1['name'])
print(dict1['age'])
print(dict1['hobby'])
# 만일 값이 없으면?
# print(dict1['address'])  # KeyError: 'address'
# 만일 위 문법으로 접근하기 위해선 in과 같이 활용 필요
# -> 추천하지 않는 문법!
if 'address' in dict1:
    print(dict1['address'])
print()
# javascript처럼 .으로 접근 가능?
# print(dict1.name)  # 안된다!
print(dict2[1])
print(dict2[2])
print(dict2[3])

# get : [] 문법과 같이 key를 통해 value를 가져오는 방법, 추천하는 문장 ✭✭✭✭✭
#       -> 만일 key에 해당하는 값이 없는 경우 죽지 않고 None을 반환하여 검사 가능
#       None : python에서는 Null 키워드, python은 null이라는 키워드가 없다
print(dict1.get('name'))
print(dict1.get('age'))
print(dict1.get('address'))  # 없는 key는 None으로 반환
# None 체크법
print(dict1.get('address') == None)  # Comparison with NOne performed with equality operators
print(dict1.get('address') is None)  # None은 is로 바꿔야 한다.
print(type(None))  # <class 'NoneType'>

# 없는 값을 조회하는 방법 1. 'in'과 if를 조합하여 활용하는 문법
if 'address' in dict1:  # in 키워드는 key를 조회하는 문법
    print(dict1['address'])
else:
    print('값이 없습니다!')

# 없는 값을 조회하는 방법 2. get을 통해 None으로 확인하여 구별하는 방법
if dict1.get('address') is None:
    print('값이 없습니다!')

# 없는 값을 조회하는 방법 3. Python 삼항연산자(?) 문법으로 조회하는 방법, 비추...
print('값이 없습니다.') if dict1.get('address') is None else print('값이 있습니다.')

# 없는 값을 가져올 때 None이 아닌 default 값 설정하는 방법
print(dict1.get('address', 'default 값'))

# 삽입 / 수정 문법 (사실상 같은 문법)
# - key 값이 없으면 삽입, 있으면 수정
dict1['address'] = '서울시 강남구 역삼동'
print(dict1)
dict1['address'] = '서울시 강남구 삼성동'
print(dict1)

# value가 list 일 때 list를 삽입/수정하는 방법
# dict1['hobby'] = ['맛집탐방', '오픈런']  # list 수정이 아닌 새로운 list 추가하는 방법! -> 틀린 방법!
# print(dict1)
dict1['hobby'].append('맛집탐방')
dict1['hobby'].append('오픈런')
print(dict1)

# 만일 list가 없을 때 list로 초기화하는 방법
if dict1.get('hobby2') is None:
    dict1['hobby2'] = []
dict1['hobby2'].append('오픈런')
print(dict1)

# 값이 list일 때 list로 추가하는 방법(extend 활용법)
hobby2 = ['사진찍기', '나무심기']
dict1['hobby'].extend(hobby2)
print(dict1['hobby'])

# 특정값 key-value 삭제하는 방법, del 연산자
del dict1['age']
print(dict1)

# pop : 삭제하면서 값을 가져오는 메소드
value = dict1.pop('address')
print(value)
print(dict1)
# value = dict1.pop('address2')  # 만일 키값이 없으면 죽는다!
# print(value)

# 리스트에서 특정값 삭제하는 방법들
dict1['hobby'].remove('축구')
dict1['hobby'].remove('야구')
dict1['hobby'].pop()  # list에서 pop이 된다!
del dict1['hobby'][0]
print(dict1)

# keys : 키값들 가져 오기
print(dict1.keys())

# key로 순회 하기
for key in dict1.keys():
    print(key,':',dict1[key])

# values : 값들 가져 오기
print(dict1.values())

# key-value 쌍으로 가져 오기
print(type(dict1.items()))
print(dict1.items())
for item in dict1.items():
    print(item)
    print(item[0], ':', item[1])
print('--------------------------------------------------------------------------------------')

# set : {Value, Value, Value ...}
# 중복을 허용 하지 않는 자료구조, Java의 set과 기능적으로 동치함
# 순서가 없다(Unordered)
# 집합에 관련된 연산자가 존재함

set0 = {}  # dict 초기화법으로 이렇게 초기화 금지!!
print(type(set0))
set0 = set()
print(type(set0))  # <class 'set'>
set1 = {4, 3, 2, 2, 1, 3, 4, 3, 2, 1, 5}
set2 = {'apple', 'banana', 'cherry', 'banana', 'apple'}
set3 = set('hello')  # 문자열이 분리되어 들어간다

print(set1)  # {1, 2, 3, 4, 5} 숫자가 정렬이 되는 것처럼 보인다. -> 항상 정렬될지는 모른다.
print(set2)  # {'apple', 'banana', 'cherry'}
print(set3)  # {'e', 'h', 'l', 'o'}

# set 데이터 추가하기 - add
set1.add(6)
print(set1)

# update - 다수의 값을 추가하는 경우
set1.update([7, 8, 9, 9])
print(set1)

# 삭제 - remove
set1.remove(1)
set1.remove(2)
print(set1)

# del로는 삭제 안된다!
# DEL SET1[3]  # TypeError: 'set' object doesn't support item deletion

# in을 통한 데이터 탐색 가능
print(1 in set1)
print(3 in set1)

# 집합연산자 가능!
# 합, 교, 차집합 연산자 존재

print('set - 집합연산자')
set1 = {1, 2, 3, 4, 5}
set2 = {3, 4, 5, 6, 7}

# 합집합 연산 = |, union
print(set1 | set2)
print(set1.union(set2))

# 교집합 연산 = &, intersection
print(set1 & set2)
print(set1.intersection(set2))

# 차집합 연산 = -, difference
print(set1 - set2)
print(set1.difference(set2))

# bool(논리형)
# - 논리값을 처리할수 있는 type, Python에서는 0값 외의 다른 값은 True로 인지됨!
# - True, False의 앞글자는 대문자이다!!

boolValue1 = True
boolValue2 = False
boolValue3 = not True
boolValue4 = 10 > 5

print(type(boolValue1))
print(boolValue1)
print(boolValue2)
print(boolValue3)
print(boolValue4)
print('--------------------------------------------------------------------------------------')

# bool 추가 설명
# 값이 0이 아니면 true로 인지하는데, 이는 bit 연산의 결과로 c언어 문법과 일치 한다.
# 문자열, list, set, map이 비어 있으면 false 값으로 인지함

print(type(True))
print(True + 1)  # True 메모리 값으로 1
print(False + 1)  # False는 메모리값으로 0
if False + 1:
    print('if문 동작함!')

print(bool(0))  # False
print(bool(1))  # True
print(bool(-1))  # True, 음수도 True로 취급
print(bool(9999))  # True
print(bool('test')) # True
print(bool(''))  # False - 빈문자열일 경우 False
if not '':
    print('문자열이 없습니다.')
print(bool([]))  # False - 빈리스트
print(bool([1, 2, 3]))  # True
print(bool({}))  # False - 빈 Dict
print(bool({1:'Test'}))  # True

# bool 관련 응용 문법
list1 = [1, 2, 3, 4, 5]
if list1:
    print('값이 있음')

if []:
    print('값이 있음')
else:
    print('값이 없음')

while list1:
    print(list1.pop())
print()
print('--------------------------------------------------------------------------------------')

# 추가 프로그래밍 스킬 - set, list
# set을 list로 변환하는 방법
set1 = {'a', 'b', 'c'}
print(set1)
list1 = list(set1)
list1.sort()
# list1.sort(reverse=True)
print(list1)


# list -> set으로 변환하기
list1 = ['a','b','c','d']
set1 = set(list1)
print(set1)
print('-------------------------------------------------------')

# 주소 이슈(복사)
# 변수(객체)의 주소지 확인 방법 및 복사 방법

# soft copy : 주소만 복사, 물리적인 공간은 공유, list1과 list2가 있을때 동시에 변경되는 현상 발생
list1 = ['a', 'b', 'c']
list2 = list1  # soft copy
print(id(list1))
print(id(list2))
print(list1 is list2)

# hard copy (deep copy)하는 방법 1
# - copy 함수(내장 함수)를 활용하는 방법
# - 리스트 뿐만 아니라 모든 객체에서 활용하는 방법
# - from copy import copy 헤더 추가

from copy import copy
list1 = [1, 2, 3, 4]
list2 = copy(list1)
print(id(list1))
print(id(list2))
print(list1 is list2)
print('-------------------------------------------------------')

# hard copy (deep copy)하는 방법 2
# - ':'을 통해 hard copy시도
list1 = [1, 2, 3, 4]
list2 = list1[:]  # list1을 hard copy하는 문법
print(id(list1))
print(id(list2))
print(list1 is list2)
print('-------------------------------------------------------')

# hard copy (deep copy)하는 방법 3
# - 그냥 빈리스트를 만들어서 초기화한다
list1 = ['a', 'b', 'c']
list2 = [] + list1
list2 = [].extend(list1)
list2 = list1.copy()

print(id(list1))
print(id(list2))
print(list1 is list2)
