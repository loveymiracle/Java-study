# Python 기본 문법 및 프로그래밍 요령

# Python의 특징
# 1. 인터프리터 언어 + 대화형 언어
#  : 리눅스나 도스의 명령어 처럼 언어를 사용 할 수 있음 (함수형 언어의 속성)
# 2. OS/플랫폼 독립적인 언어 = JavaScript, Java
#  : Python 인터프리터만 있으면 어떤 환경에서든 실행 가능
# 3. 동적 타이핑(Dynamic typing)과 자동 메모리 관리로 편리한 프로그래밍 가능
#  : Type에 크게 신경 쓰지 않아도 되고, 메모리 관리를 알아서 수행함

# Python 언어(문법)적 특징
# 1. 들여쓰기가 매우 중요하다!
#  : 기존 언어(C계열) '{' '}'를 통해 블록으로 분리하여 처리하였지만, Python은 들
#     -> 파이썬은 들여쓰기 '\t'을 권장하지 않고 ' '(공백) X 4를 권장함 = '    ' 들여쓰기로 블록을 분리
# 2. Type을 크게 신경쓰지 않아도 된다. (Dynamic typing) -> 객체 사용 한다는 의미
#  : Javascript 처럼 바인딩 되는 시점(a = 10)에 type을 결정하고, Type간 변환이 쉽게 가능하다.
# 3. 간결한 문법
#  : 언어 자체가 간결한 문법을 추구하고, 명령어 형식과 단축 표현을 제공한다.
#     -> 초반에 단축 표현에 대한 스트레스가 강한데, 사용하다 보면 편하다.
# 4. 세미클론 사용 vs 사용 안하기(사용 안하기 권장)
#  : 세미클론 사용하여도 문법적으로 문제 되지 않는데, 대세는 안쓰는 것으로 자리 잡는 중.
#    -> PEP8(문법표준) 기준으로 세미클론이 표준이 아님!

# Hello World 출력하기!
print('Hello Python World!')
print("Hello Python World!"); # 구시대적 문법, 올드한 느낌!

# 실행 하는 방법
# 방법 1. 인터프리터를 통해 직접 실행하는 방법
# python --version = 먹히면 python 정상 설치!
# python ./hello.py

# 방법 2. IDE(파이참)을 통해 실행 (1의 방법을 IDE가 대신 실행)
# 단축키 또는 실행 버튼
# 해당 파일에서 우클릭해서 실행하는 것이 가장 일반적!!

# 들여쓰기 문법 연습
if 1 > 0:
    print('1은 0보다 큽니다!')

# 들여쓰기하지 않는 경우? -> 에러가 발생해서 죽는다!
# if 1 > 0:
# print('1은 0보다 큽니다!')

# 들여쓰기는 \t이 아닌 공백을 사용 -> IDE 표준에 따르지 않으면 워닝 발생(표준 = 4칸)
if 1 > 0:
 print('1은 0보다 큽니다.')

if 1 > 0:
                   print('1은 0보다 큽니다.')

# 들여쓰기는 같은 공백크기로 레벨링을 할수 있다.
if 1 > 0:
    print('1은 0보다 큽니다.')
    if 1 > 0:
        print('1은 0보다 큽니다.')
