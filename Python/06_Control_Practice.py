# 제어문 연습문제

# 1. 구구단
# 1.1 while문
i = 2
while i <= 9:
    j = 1
    print('---------------', i, '단 시작', '--------------')
    while j <= 9:
        print(i, 'X', j, '=', i * j)
        j += 1
    print('---------------', i, '단 끝', '-------------')
    i += 1
print('다 외웠다!')

# 다른 풀이
i = 2
while i < 10:
    j = 1
    while j < 10:
        print('%d X %d = %d' % (i, j, i*j), end=' | ')
        j += 1
    i += 1
    print()
print()

# 1.2 for + range함수
for i in range(2, 10):
    print('---------------', i, '단 시작!', '--------------')
    for j in range(1, 10):
        print(i, 'X', j, '=', i * j)
    print('---------------', i, '단 끝!!', '--------------')
print('다 외웠다!')

# 다른 풀이
for i in range(2, 10):
    for j in range(1, 10):
        print('%d X %d = %d' % (i, j, i * j), end=' | ')
    print()
print()

# 2. score = [70, 60, 55, 75, 95, 90, 80, 80, 85, 100]
score = [70, 60, 55, 75, 95, 90, 80, 80, 85, 100]
# Math 모듈과 같이 풀이
import math
# 2.1 가장 큰값 구하기
score_max = max(score)
print('가장 큰 값 : ', score_max)
for i in score:
    if i == int(score_max):
        print('for문으로 가장 큰 값 : ', i)
print()

maxValue = -1
for s in score:
    if maxValue < s:
        maxValue = s
print('maxValue : ',maxValue)

# 2.2 가장 작은 값
score_min = min(score)
print('가장 작은 값 : ', score_min)
for i in score:
    if i == int(score_min):
        print('for문으로 가장 작은 값 : ', i)
print()

minValue = 99999
for s in score:
    if minValue > s:
        minValue = s
print('minValue:', minValue)

# 2.3 합계 구하기
score_sum = sum(score)
print('합계 : ', score_sum)
score_sum_for = 0
for i in score:
    score_sum_for += i
print('for문으로 합계 : ', score_sum_for)

sumValue = 0
for s in score:
    sumValue += s
print('sumValue', sumValue)

# 2.4 평균 구하기
score_avg = int(sum(score) / len(score))
print('평균 : ', score_avg)
score_sum_for = 0
count = 0
for i in score:
    score_sum_for += i
    count += 1
score_avg_for = int(score_sum_for / count)
print('for문으로 평균 : ', score_avg_for)

# 3. 아래 * 출력하기
# ***** 5
# ****  4
# ***   3
# **    2
# *     1

for i in range(5, 0, -1):
    print(i * '*', i)
print()

for i in range(0, 5):
    print('*' * (5 - i))
print()
