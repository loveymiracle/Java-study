# 연산자

# 산술 연산
# + Addition        : x + y
# - Subtraction     : x - y
# * Multiplication  : x * y
# / Division       : x / y
# % Modulus            : x % y
# ** 제곱             : x ** y
# // 소수점 버림(몫 연산): x // y

# 제곱 **
x, y = 2, 3
print(x ** y)  # 2 ^ 3 = 8

# 모듈러 + 소수점 버림 연산
x, y = 10, 3
print(x / y)  # 3.3333333333333335
print(x // y)  # 3
print(int(x / y))  # 3 , int casting 연산
print(x % y)  # 모듈러 연산 : 나머지 값

# 대입 연산자
# =     : x = 5            x = 5
# +=    : x += 3       x = x + 3
# -=    : x -= 3       x = x - 3
# *=    : x *= 3       x = x * 3
# /=    : x /= 3       x = x / 3
# %=    : x %= 3       x = x % 3
# //=   : x //= 3      x = x // 3
# **=   : x **= 3      x = x ** 3
# &=    : x &= 3       x = x & 3
# |=    : x |= 3       x = x | 3
# ^=    : x ^= 3       x = x ^ 3
# >>=   : x >>= 3      x = x >> 3
# <<=   : x <<= 3      x = x << 3

# Python은 ++a, a++ 전위 후위 연산자를 지원하지 않는다!
# -> 대입연산자로 대체해서 사용할 것

# 비교 연산자
# ==    Equal                      x == y
# !=    Not equal                  x != y
# >     Greater than               x > y
# <     Less than                  x < y
# >=    Greater than or equal to   x >= y
# <=    Less than or equal to      x <= y

print('숫자 비교')
print(100 == 100)
print(3 > 10)
print(3< 10)

# Python은 문자 비교 가능!
print('문자간 대소 비교')
print('aaa' < 'bbb')  # True
print('aaa' > 'bbb')  # False
print('홍길동' > '최길동')  # True
print('가나다' > '나다마')  # False
print('-------------------------------------------------------------------------------')

# 논리 연산자
# and   : x < 5 and x < 10
# or    : x < 5 or x < 4
# not   : not(x < 5 and x < 10)
# 주의 && ||가 없다!

print(True and True)  # True
print(True and False)  # False
print(False and True)  # False
print(False and False)  # False

print(True or True)  # True
print(False or True)  # True
print(True or False)  # True
print(False or False)  # False

print(not True)  # False
print(not False)  # True
print('------------------------------------------------------------------------------')

# ※ 주의 비트연산은 논리연산이 아님으로 절대 사용하지 말것!
# - 일반적으로는 맞으나 원하는 결과가 안나올수도 있으니 사용 불가!
#  -> and, or로 대체해서 사용하면 절대 안됨!
print(True & True)
print(False & False)
print(True | True)
print(True | False)
print(False | True)
print(0b101 | 0b10)  # 0b111 -> 10진으로 7
print('------------------------------------------------------------------------------')

# 체인 비교 단순화 (단축된 and 연산) (범위 비교)
# - 일반 자바나 C언어에서는 3개 숫자 비교를 항상 A and B식으로 분류했지만 파이썬은 단축 문법을 제공
x = 5
print(x > 3 and x < 7)  # java에서 사용했던 범위 연산
print(3 < x < 7)  # and 연산 단축
print(3 <= x <= 10)  # and 연산 단축
print(x > 3 or x < 10)  # or는 체인비교 단순화가 필요 없다!
print('------------------------------------------------------------------------------')

# Identity 연산자
# 메모리 주소지를 기준으로 비교하는 연산자
# is : 메모리 주소 기준으로 같은 영역을 지정하는지 확인하는 연산자
# is not : 메모리 주소 기준으로 다른 영역을 지정하는지 확인하는 연산자
# 문자열에서는 사용해도 무관하다!!!

# soft copy - 문자열 버전 :  문제 없음!
str1 = 'abc'
str2 = str1
print(id(str1))
print(id(str2))
print(str1 == str2)
print(str1 is str2)
print(str1 != str2)
print(str1 is not str2)
print('-------------------------------------------')

from copy import copy
# deep copy - 문자열 버전 : 문제 없음!
str1 = 'abc'
str2 = copy(str1)
print(id(str1))
print(id(str2))
print(str1 == str2)
print(str1 is str2)
print(str1 != str2)
print(str1 is not str2)
print('-------------------------------------------')

# deep copy - list 버전 : 문제 발생!!!!
list1 = [1, 2, 3, 4, 5]
list2 = copy(list1)
print(id(list1))
print(id(list2))
print(list1 == list2)
print(list1 is list2)
print(list1 != list2)
print(list1 is not list2)
print('---------------------------------------------')

# 문자열 비교는 is나 ==이 같은 효과를 발생 : String pool 때문에 안전
# 일반적인 비교는 '==' 사용자 의도와 같을 때가 많다. 가급적 '==' 사용 권장

# Membership Operators
# in     : str, list, set, map과 같은 sequence를 가지는 type에서 데이터가 있는지 확인 하는 연산자
# not in : in의 반대

str1 = 'Hello World'
list1 = [1, 2, 3, 4, 5]
map1 = {1:'문자', 2:'숫자'}

print(str1)
# print(str1 in 'H')  # 틀린 문법!
print('H' in str1)
print('Hello' in str1)
print('Z' in str1)
print('Z' not in str1)

print(list1)
print(1 in list1)
print(10 in list1)

# dict를 사용하는 경우는 key 기준으로 in 연산자가 작동 -> value는 values를 가져와서 비교!
print(map1)
print(1 in map1)  # True
print('문자' in map1)  # False -> value에 있는 값
print('문자' in map1.values())  # True, values는 있는 값!
print(map1.items())  # items는 key+value 쌍을 튜플로 반환!
print((1, '문자') in map1.items())  # True
print('----------------------------------------------------------------------------------')

# bit 연산자
# &     AND
# |     OR
# ^     XOR
# ~     NOT
# <<    Zero fill left shift
# >>    Signed right shift

#        8421
bit1 = 0b0110  # 0b : 이진법, 2 + 4 = 6
bit2 = 0b0001  # 1

print(bit1)
print(bit2)

# bit or 연산
val = bit1 | bit2
print(val)  # 7, 0b0111

# bit and 연산 - masking
val = bit1 & bit2
print(val)  # 0

# 비트연산이 아닌 논리 연산으로 처리하는 경우 -> 틀린 값이 나온다! 주의할 것!
# 논리연산은 0이 아닌 값이 True로 취급됨으로 비트연산과 다르다!
val = bit1 and bit2
print(val)  # 1

# ~ 논리 not 연산이 아니다! 가급적 쓰지 말것!
print(~True)
print(not True)
