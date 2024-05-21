# Module(모듈)
# - 모듈은 함수나 클래스를 모아 놓은 파이썬의 파일을 의미함
# - 사용시 import 명령을 통해 외부 모듈을 가져올 수 있음
# - 외부 모듈이나 사용자 모듈 import할 때 알아야 하는 문법

# import '모듈 이름'
# - 외부나 사용자 모듈을 가져올때 사용 하는 키워드
# - 스크립트 모드에서는 외부 모듈을 사용 하기 전에 반드시 import 명령이 필요
# - 문서 최상위에 사용 해야 것을 권장 -> 주석 제외 하고..

# mymod 임포트 하는 방법
import mymod  # 가장 기본적인 임포트문, 임포트한 코드를 사용하지 않으면 IDE에서 회색으로 처리됨!
import mymod as m  # mymod를 m으로 단축시켜서 사용하는 문법
from mymod import add, multi  # 모듈 이름을 생략하고, add와 multi 함수로 사용하는 문법
from mymod import *  # 모듈 이름을 생략하고, 모든함수를 가져오는 문법

# import mymod 형태로 사용
print(mymod.add(3, 5))

# import mymod as m 형태로 사용
# as 별칭으로 사용
print(m.add(3, 5))

# from mymod import add, multi, from mymod import * 형태로 사용
print(add(3, 5))
print(multi(3, 5))
print('---------------------------------------------------------------------------')
