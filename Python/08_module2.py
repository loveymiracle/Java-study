
# 주요 내장(Built-in) 모듈
# - Python에서 자주 사용 모듈을 Python 인터프리터와 함게 배포한 기능
# - https://www.w3schools.com/ 에서 주요 내장모듈 사용법을 추가로 공부하시기 바람

# 주요 내장모듈
import random
import time
# import datetime
from datetime import datetime
import calendar
import webbrowser
import threading


# random 모듈 + (time 모듈 조합 필요)
# - 임의값(랜덤값)에 관련된 기능을 모아 놓은 모듈

# seed 값 설정하기
# - 의사 값을 가지고 올때 최초에 결정이 필요한 수
print(time.time())  # 현재시간을 ms 단위로 가져오는 내장함수
random.seed(time.time())

# 0 ~ 1 내에 랜덤값 가져오기
print(random.random())

# 범위 지정하는 방법
print(random.randrange(0, 10))
print(random.randrange(0, 1000))

# list에서 랜덤픽 하는 방법
list1 = ['a', 'b', 'c', 'd']
print(random.choice(list1))

# list에서 랜덤으로 섞는 방법
list1 = ['a', 'b', 'c', 'd']
random.shuffle(list1)
print(list1)

# 로또 프로그램1
list1 = [v for v in range(1, 46)]  # 1 ~ 45 list로 초기화
random.shuffle(list1)
print(list1[:6])

# 로또 프로그램2 - 더 단축하는 문법
list1 = random.sample(range(1, 46), 6)
list1.sort()
print(list1)

# 날짜 / 시간 관련

# time (시간 + Thread 모듈)
# - 현재 시간이나 sleep을 호출하기 위해 사용되는 모듈
print(time.time())  # 17122899974.7073436

# 1초마다 증감하는 반복문
# x = 0
# while True:
#     time.sleep(1)  # sec
#     print(x)
#     x += 1

# dateTime
# - 날짜나 포맷팅에 관련된 기능

# 오늘 날짜
print(datetime.today())

# 오늘 날짜 및 년월일시 출력하는 법
today = datetime.today()
print(today)
print(today.time())
print(today.month)
print(today.day)
print(today.hour)
print(today.minute)
print(today.second)

# 사용자 포멧팅 변환 함수
print(today.strftime('%Y-%m-%d %H:%M:%S'))  # YYYY/mm/dd HH:MM:SS 형태의 시간 출력

# 특정 날짜 설정하기
day = datetime(2018, 6, 1)
print(day)
print(day.strftime('%c'))

# calendar
print(calendar.calendar(2024))
print(calendar.prmonth(2024, 4))

# 웹 브라우저 열기
# webbrowser.open('http://google.com')


# Thread
# - 프로그램의 sub 흐름으로써, main 흐름과 동시에 실행 가능한 sub 흐름


# 1초에 한번씩 출력 하는 함수
def long_task():
    for j in range(5):
        time.sleep(1)
        print("working:%s\n" % j)


print('start')

threads = []
for i in range(5):
    t = threading.Thread(target=long_task)  # 스레드 생성부
    threads.append(t)

for t in threads:
    t.start()

print('end')


# join
# thread의 종료 시점을 모아 주는(join) 함수

def long_task():
    for j in range(5):
        time.sleep(1)
        print("working:%s\n" % j)

print("Start")

threads = []
for i in range(5):
    t = threading.Thread(target=long_task)
    threads.append(t)

for t in threads:
    t.start()

for t in threads:
    t.join()  # join으로 스레드가 종료될때까지 기다린다.

print("End")
