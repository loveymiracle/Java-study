# Class(객체 지향 프로그램)
# - 객체 설계 시에 사용 되는 문법
# - 메소드, 멤버 변수, 생성자, 상속 문법은 지원
# - 접근제한자, get/setter 자동생성, interface가 없고, 설계 제약하기 어려움!
# - Python 설계는 대부분이 모듈기반(모듈 + 함수) 설계로 구성됨
# - 객체 지향으로 하든 절차 지향으로 하든 큰영향이 없음!!
#   -> 분석용 코드나 일반적인 코드는 절차 지향으로 작성됨

# 기본 class 설계 법

# 클래스는 카멜로 작성하길 권장
class MyClass:
    # 멤버변수 자리
    x = 10
    y = 5

    # 멤버 메소드
    # 여기서의 self 객체 데이터가 저장되어 있는 메모리 주소값
    def print(self):  # self는 사용자가 인자를 넣을 수 없는 값! 무시,
        print('x : ', self.x, 'y : ', self.y)


# myClass = MyClass()
myClass = MyClass()  # MyClass의 생성자를 호출하여 객체를 생성하는 문법
myClass.x = 20  # 멤버변수 접근하기
myClass.print()
print(myClass.x)
print(myClass.y)


# Python 객체 설계 가이드
# 멤버 변수 : 생성자에 내에 선언 하고, 'self.name'으로 호출 되면 등록됨 << 파이썬 코딩 패턴
# 생성자 : 단 하나의 생성자만 가질수 있음.
#         -> 오버 로딩 설계가 되지 않음으로 default 값을 채워서 없어도 생성 가능 하도록 설계
# 메소드 : getter, setter가 자동 완성이 없음. 특별하게 만들 일이 아니면 만들지 말것!

# (self)의 정체
# - 객체가 생성된 주소지를 지정하며, 자바나 c++ 문법에서는 this 숨켜 주는데, Python은 노출됨!


class Member:
    # 멤버변수나 멤버 메소드 선언이 가능한 자리, 이곳에 멤버변수를 쓰지 않는데 Python Class 생성 패턴!
    # name = ''
    # age = 30

    # 생성자 선언, 반드시 self가 필요함!
    def __init__(self, name='', age=0):
        self.name = name
        self.age = age

    # 인자 없는 메소드

    def to_string(self):
        return '이름 : ' + self.name + ', 나이 : ' + str(self.age)

    # getter/setter
    def set_name(self, name):
        self.name = name

    def get_name(self):
        return self.name + '님'

# 객체 생성하기
m1 = Member('홍길동', 27)
print(m1)  # <__main__.Member object at 0x1030097f0> 0x1030097f0 : self 정체
print(m1.name)
print(m1.age)
print(m1.to_string())

m1.set_name('최길동')
print(m1.get_name())


# 생성자에서 선언된 인자의 갯수가 동일하지 않게 생성 할 때
# ex) 생성자 인자가 3개인데, 0개인 생성자를 호출할때
#  -> default 값으로 값이 초기화되어 있으면 에러 발생하지 않음!
# 만일 default값이 없으면 에러 발생 TypeError: __init__() missing 2 required positional arguments: 'name' and 'age'

# 디폴트 값이 채워져서 생성되는 방법
m1 = Member()
print(m1.to_string())
m2 = Member(name='박길동', age=31)
del m2.age
# print(m2.to_zstring())

# 상속
# - class 본인 이름(부모 Class 이름)
# - 생성자, 메소드 오버 라이딩 가능 하고, 부모의 변수나 기능 그대로 사용할 수 있다!

class AdminMember(Member):
    def __init__(self, name, age, address):
        super().__init__(name, age)  # 부모의 생성자 호출
        self.address = address  # 자신만 갖는 멤버 변수

    def set_address(self, address):
        self.address = address

    # 오버 라이딩, 재정의
    def to_string(self):
        name2 = self.name  # 부모의 값이지만 자신의 값으로 호출할수 있음
        return super().to_string() + ', address : ' + self.address


admin = AdminMember('운영자', 21, '서울시 강남구 역삼동')
print(admin.to_string())

admin.set_address('서울시 강남구 삼성동')
print(admin.to_string())
