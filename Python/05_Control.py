# 제어문
# 논리적으로 흐름을 제어하거나 반복하는 문장
# 문법적으로 들여쓰기가 매우 중요하다.
# 'in', 'not in'이 문법적으로 허용됨으로 간결하게 작성이 가능하다.

# if문(조건문) : if 1 > 0:
# - 일반적인 프로그래밍 언어의 조건문과 동일 기능을 제공한다.
# - if, else, elif 키워드를 통해 조건문을 작성한다.
# - 파이썬의 switch문이 없는데, 대처 하는 문법이다.

a = 5
b = 10

if a > b:
    print('a는 b보다 큽니다')
else:
    print('a는 b보다 작습니다.')

a = b = 5
if a == b:
    print('a와 b는 같습니다.')
elif a > b:
    print('a는 b보다 큽니다')
else:  # a < b
    print('a는 b보다 작습니다.')
    pass # 빈 조건절을 만들기 위해 사용 된다.

# 범위 확인하는 문법, 인자가 100 이상, 200미만 값인지 확인
x = 150
if x >= 100 and x < 200:
    print('x는 100이상, 200미만입니다.')

# chain 단순화 문법
if 100 <= x < 200:
    print('x는 100이상, 200미만입니다.')

# 중첩된 if 문
if x >= 100:
    print('x는 100보다 큽니다')
    if x < 200:
        print('x는 200보다 작습니다.')
    else:
        print('x는 200보다 큽니다.')
print('----------------------------------------------------------------------------------')

# 반복문
# while문 : while <조건식>:
# - 반복문 중에 가장 기본적인 문장이고, 가장 old한 형식이 유지 되는 문법
# - 'in'이나 list가 인자로 들어 오는 고유 문법도 존재한다.

# 무한 반복문
# x = 0
# while True:
#     print(x)
#     x += 1

# 0 부터 9 까지 돌기
i = 0
while i < 10:
    print(i, end=' ')
    i += 1
print()

# 1 ~ 10 까지 짝수만 출력하기
i = 1
while True:
    if i % 2 == 0:
        print(i, '는 짝수입니다.')
    else :
        print(i, '는 홀수입니다.')
    i += 1
    if i == 11:
        break # break문 존재!
    else:
        continue

# 숫자를 입력 받아서 값이 맞으면 통과 하는 게임
# break : 반복문을 빠져나가는 문법
# continue : 반복문 최상위로 이동하는 문법

n = 5 # 정답!
while True:
    print('1 ~ 10 이내의 숫자를 입력해주세요!')
    value = input() # 입력값 받아오는 방법!, 주의할점 문자열로 받아온다
    if n == int(value):
        print('값이 맞습니다')
        break
    else:
        print('값이 틀립니다!')
        continue
print('----------------------------------------------------------------------------------')

# for문 : for item in list :
# - 다른 언어의 for문과 달리 Sequence type 탐색에 적합한 문법
# - 전통적인 for문처럼 활용하기 위해선 range 함수를 결합하여 사용

# 기본 예제
list1 = [1, 2, 3, 4, 5]
for v in list1:
    print(v, end=' ')
print()

# 2차원 배열 순회하기, 인자가 2개만 있을 때 순회하기
list2 = [(1, 2), (3, 4), (5, 6)]
for t in list2:
    print(t, end=' ')
print()

# 인자 2개를 각자 다른 인자로 넣는 방법
for first, second in list2:
    print(first, second, end=' ')
print()

# 2차원 배열 순회하기
for innerList in list2:
    for v in innerList:
        print(v, end=' ')
    print()
print()

# 점수 합격/불합격 내기, 기준 = 60점
marks = [90, 25, 67, 45, 80]
i = 0
for mark in marks:
    i += 1
    if mark >= 60:
        print('%d번 학생은 %d점으로 합격입니다!' % (i, mark))
    else:
        print('%d번 학생은 %d점으로 불합격입니다!!' % (i, mark))

# 합격자만 출력하기!
marks = [90, 25, 67, 45, 80]
i = 0
for mark in marks:
    i += 1
    if mark < 60:
        continue
    print('%d번 학생은 %d점으로 합격입니다!' % (i, mark))

print('---------------------------------------------------------------')

# range : range(시작 값, 종료 값, 증감할 값)
# 반복문 전용 파라미터를 설정 할 수 있는 함수

# 1. range(종료값) : 0 ~ 종료값 이전 가지 1씩 증감하는 반복문
for i in range(10):  # 0 ~ 9
    print(i, end=' ')
print()

# 2. range(시작값, 종료값) : 시작값 ~ 종료값 이전 까지 1씩 증감하는 반복문
for i in range(1, 11):  # 1 ~ 10
    print(i, end=' ')
print()

# 3. range(시작값, 종료값, 증감값) : 시작값 ~ 종료값 이전 까지 증감값씩 증감하는 반복문
for i in range(1, 11, 2):  # 1 3 5 7 9
    print(i, end=' ')
print()

# for + range 결합하여 list 순회하는 방법 < 추천 안함!!
marks = [90, 25, 67, 45, 80]
for i in range(len(marks)):
    if marks[i] >= 60:
        print(i + 1, '번 학생은 합격입니다.')
    else:
        print(i - 1, '번 학생은 불합격입니다.')

# for 예제 - 기존 list 값을 10을 곱해서 새로운 list에 넣는 방법
list1 = [1, 2, 3, 4, 5]
list2 = []  # 10, 20, 30, 40, 50

for v in list1:
    list2.append(v * 10)
print(list2)

# 1. 기본값에 10을 곱하여 초기화하는 연산 - list활용
list1 = [1, 2, 3, 4, 5, 6]
list2 = [v * 10 for v in list1]
print(list2)

# 2. 기본값에 10을 곱하여 초기화하는 연산 - range를 결합하는 방법
list1 = [v * 10 for v in range(1, 6)]
print(list1)

# 3. 1 ~ 100 까지의 3의 배수 list 만들기
list1 = [v for v in range(3, 101, 3)]
print(list1)

# 4. 특정 list에서 짝수만 골라내는 방법 - 필터링 문법
list1 = [1, 2, 3, 4, 5, 6]
list2 = [v for v in list1 if v % 2 == 0]
print(list2)

# pass : for문이나 if문에서 내용이 없어도 조건절을 유지하기 위해 쓴느 문법 (아무일도 하지 않음!)
for i in range(10):
    pass
# Python에서 sleep 대신 사용하는 문법, 일부로 대기시간 줄때!

# for ~ else / while ~ else
# - 반복문의 논리값에 해당되지 않을 경우 실행되는 else문
# - 실행 후에도 마지막 한번은 논리값을 판정할수 있음!

i = 1
while i < 5:
    print(i, '는 5보다 작습니다.')
    i += 1
else:
    print(i, '는 5와 같거나 큽니다.')  # 마지막에 한번 더 도는 문장으로 쓰거나 아예 안돌 때 작동하는 문장

list1 = []
for item in list1:
    print(item, end='')
else:
    print('for문이 끝났습니다.')

# for문 내포문법 (List comprehension)
# - list로 초기화하는 경우 단축시킬수 있는 for문
# [(사용자 연산 값) for <Val> in <SequenceType>]
# for comprehension 문법
list1 = [1, 2, 3, 4, 5]
list2 = [v * 10 for v in list1]  # 반복문을 []안에서 작동시킬 수 있다.
print(list2)

# for comprehension 문법 + range 결합!
list1 = [v * 10 for v in range(1, 6)]  # 10, 20, 30, 40, 50
print(list1)
