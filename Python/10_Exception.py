# 예외 처리 문법

# 예외 처리란?
# - 프로그램에서 정상적이지 않은 오류(에러)가 발생 하여도 프로그래밍적으로 컨트롤 가능 하도록 지원 하는 문법
# try :
#       (에러가 발생할 코드)
# except <발생 오류> as <오류 별명> :
#       (예외처리 문장)

# Tip! : 'Exception'으로 error를 잡으면 모든 에러가 잡힘!

try:
    print('에러 발생 이전!')
    5 / 0
    print('에러 발생 이후!')
except Exception as e:
    print(e)
print('정상 루트')

# division by zero만 에러 처리하기 -> ArithmeticError로 받을수 있음
try:
    print('에러 발생 이전!')
    5 / 0
    print('에러 발생 이후!')
except ZeroDivisionError as e:
    print(e)
print('정상 루트')

try:
    print('에러 발생 이전!')
    5 / 0
    print('에러 발생 이후!')
except ArithmeticError as e:
    print(e)
print('정상 루트')


# 파일 관련 예외 처리
try:
    f = open('./error')
    print(f.readlines())
    f.close()
except FileNotFoundError as e:
    print(e)

# 예외를 중첩 시키는 방법
try:
    f = open('./test.txt')
    print(f.name)
    print(f.readlines())
    f.close()
except FileNotFoundError as e:
    print(e)
except Exception as e:
    print(e)

# 사용자 지정 에러 만들기

class MyError(Exception):
    def __str__(self):
        return 'My Error입니다.'


# 사용자 에러 호출하기 = raise
try:
    isError = True
    if isError:
        raise MyError
    print('에러 발생 안함!')
except MyError as e:
    print(e)


# 주요 에러 항목
# ArithmeticError	Raised when an error occurs in numeric calculations
# AssertionError	Raised when an assert statement fails
# AttributeError	Raised when attribute reference or assignment fails
# Exception	Base class for all exceptions
# EOFError	Raised when the input() method hits an "end of file" condition (EOF)
# FloatingPointError	Raised when a floating point calculation fails
# GeneratorExit	Raised when a generator is closed (with the close() method)
# ImportError	Raised when an imported module does not exist
# IndentationError	Raised when indendation is not correct
# IndexError	Raised when an index of a sequence does not exist
# KeyError	Raised when a key does not exist in a dictionary
# KeyboardInterrupt	Raised when the user presses Ctrl+c, Ctrl+z or Delete
# LookupError	Raised when errors raised cant be found
# MemoryError	Raised when a program runs out of memory
# NameError	Raised when a variable does not exist
# NotImplementedError	Raised when an abstract method requires an inherited class to override the method
# OSError	Raised when a system related operation causes an error
# OverflowError	Raised when the result of a numeric calculation is too large
# ReferenceError	Raised when a weak reference object does not exist
# RuntimeError	Raised when an error occurs that do not belong to any specific expections
# StopIteration	Raised when the next() method of an iterator has no further values
# SyntaxError	Raised when a syntax error occurs
# TabError	Raised when indentation consists of tabs or spaces
# SystemError	Raised when a system error occurs
# SystemExit	Raised when the sys.exit() function is called
# TypeError	Raised when two different types are combined
# UnboundLocalError	Raised when a local variable is referenced before assignment
# UnicodeError	Raised when a unicode problem occurs
# UnicodeEncodeError	Raised when a unicode encoding problem occurs
# UnicodeDecodeError	Raised when a unicode decoding problem occurs
# UnicodeTranslateError	Raised when a unicode translation problem occurs
# ValueError	Raised when there is a wrong value in a specified data type
# ZeroDivisionError	Raised when the second operator in a division is zero
