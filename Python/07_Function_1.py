# 함수 문법
# 프로그램의 모듈 단위로 코드 분리 및 재사용을 위한 문법

# 내장 함수
# https://docs.python.org/ko/3/library/functions.html

# def 함수명(매개 변수):
#       <수행할 문장1>
#       <수행할 문장2>
#       <수행할 문장3>
#       return 반환 값


# 가장 기본적인 함수

def add(a, b):
    return a + b


# 함수 사용시에는 아래 문장과 2줄 띄어쓰기 권장!
val = add(3, 4)
print(val)


# 리턴값이 있는 함수
def print_add(a, b):
    print(a + b)


print_add(3, 5)


# 리턴 값만 있는 함수

def get_pi():
    return 3.141592


print(get_pi())


# 인자, 리턴값 모두 없는 함수
def print_hi():
    print('Hi!')


print_hi()


# 리턴값이 2개 이상인 함수, 튜플로 묶어서 반환이 되고 결론은 리턴값은 하나다!
def return_two():
    return 3, 4


print(return_two())
values = return_two()
print(type(values))
print(values)
print(values[0])
print(values[1])

val1, val2 = return_two()  # packing 문법 활용!
print(val1, val2)
print('--------------------------------------------------------------------------------')


# 함수 인자의 default(초기값)을 설정하는 방법
def add2(a=0, b=1):
    return a + b


print(add2())  # 인자 없이 호출
print(add2(1))  # a에 1을 넣고 호출
print(add2(2, 3))  # a는 2, b는 3으로 호출
print(add2(b=5, a=3))  # 인자의 순서를 바꿔 호출
print('a', 'b', 'c', end='\n끝!', sep=', ')  # 여기서 end와 sep가 인자를 지정해서 호출하는 방법


# 매개변수 제한이 없는 함수 (가변인자 함수)
# def 함수이름(*args):
#     ....

def my_sum(*args):
    result = 0
    for v in args:
        result += v
    return result


print('-----------------------------------------------------------------------------')
print(my_sum())
print(my_sum(1))
print(my_sum(1, 2, 3))
print(my_sum(1, 2, 3, 4, 5, 6, 7.121212))
print('------------------------------------------------------------------------------------')


# 가변인자 + 일반인자 섞어서 사용하는 방법
# 정리 : *args를 앞으로 배치하는 것이 일반적이다.
# def print(*args, sep=' ', end='\n', file=None):  # known special case of print
def my_sum2(base=0, *args):
    for v in args:
        base += v
    return base


# my_sum3 처럼 *args 가장 앞에 선언하는 것이 정석이다!
def my_sum3(*args, base=0):
    for v in args:
        base += v
    return base


# base 값을 50, 가변인자로 1, 2, 3, 4, 5를 넣어보자!
print(my_sum2(50, 1, 2, 3, 4, 5))
# print(my_sum2(1, 2, 3, 4, 5, base=50))  # base를 뒤에서 호출 안된다
print(my_sum3(1, 2, 3, 4, 5, base=50))  # 정석적인 호출!
# print(my_sum3(base=50, 1, 2, 3, 4, 5))  # base를 앞에서 호출 안된다!
print()


# 키워드 파라메터 kwargs
# - dict(map)형태로 파라메터를 넘길때 사용한다.
# - 파라메터가 정해지지 않은 상태에서 함수 선언이 가능하다!

def kwargs_print(**kwargs):
    print(type(kwargs))
    print(kwargs)


# 인자를 호출시점에 정해서 호출 한다!
kwargs_print(a=3, b=4)
kwargs_print(name='홍길동', age=21, hobby=['야구', '축구'])


# dict로 파라메터를 받는 함수 kwargs와는 다르게 호출 한다.
def dict_print(dict1):
    print(dict1)


dict1 = {'name': '홍길동', 'age': 21, 'hobby': ['축구', '야구']}
dict_print(dict1)
print('--------------------------------------------------------------------------------')

# Scope (범위)
# 1. 전역 범위(Global area)
# - 명령어가 실행되는 라인에 선언된 변수나 함수의 범위
# 2. 지역 범위(Local area)
# - 함수나 특정 블록에서 사용되는 변수

# 전역 범위 변수 선언
global_value = '글로벌 변수입니다'


# 지역범위 - 함수
def func1():
    # 지역범위!
    local_value = '지역 범위 변수입니다'
    print(global_value)
    print(local_value)


func1()
print(global_value)
# print(local_value)  # NameError: name 'local_value' is not defined. Did you mean: 'global_value'?


# main 영역
# 파이썬 명령으로 실행되는 파일의 경우 main 영역으로 인식됨
# 파이썬에서 권장하는 문법으로 실행시키는 문장은 __main__ 문 이내에 쓰기를 권장함
# 테스트를 위해서도 사용됨

if __name__ == "__main__":
    print(__name__)
    print("main 이다.")

print("--------------------------------")

# 람다식
# - 함수를 간결하게 표현하여 사용하는 문법, 함수형 프로그래밍이 가능한 문법
# - 주로 특정 함수의 인자로 함수가 들어갈때 단축 표현으로 사용된다.

# 람다식 표현
# a++ 함수로 구현
# do not assign a lambda expression, use a def
add_self = lambda x: x + 1
val = add_self(3)
print(val)


# add_self 함수 바꾸기
def add_self2(x) : return x + 1


val = add_self2(3)
print(val)


# 올바른 람다 사용법
def add_custom(func, x):
    return func(x)

# 아래와 같이 함수가 인자로 들어갈 때 인라인으로 선언
val = add_custom(lambda v: v + 5, 10)
print(val)
