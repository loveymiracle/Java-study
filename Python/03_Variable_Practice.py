# 연습문제

# 1. 주민번호로 남여 성별 구분하기
#  951120-1068234
#  940120-2068234
# id1 = '951120-1068234'

id1 = '951120-1068234'
if int(id1[7]) == 1:
    print('남자입니다.')
else:
    print('여자입니다.')

# 풀이2 - 하드코딩 안하고
if id1[id1.index('-') + 1] == '1':
    print('남자입니다.')
else:
    print('여자입니다.')

# 2. 문자열 "a:b:c:d"에 대해
str1 = 'a:b:c:d'
# 2-1) ':' 를 ',' 로 변경하기
print(str1.replace(':', ','))

# 2-2) ':' 로 데이터를 분리하기
print(str1.split(':'))

# 3. [1, 3, 5, 4, 2] 리스트를 [5, 4, 3, 2, 1]로 만들어 보자.
list1 = [1, 3, 5, 4 ,2]
list1.sort(reverse=True)
print(list1)


# 4. ['Life', 'is', 'too', 'short'] (join) 해보기
list2 = ['Life', 'is', 'too', 'short']
print(' '.join(list2))


# 5. 점수 기준에 따른 딕셔너리 생성하기
# A : 90, B : 80, C: 70
# B 기준을 출력해보기
dict1 = {'A': 90, 'B': 80, 'C': 70}
print(dict1['B'])
print(dict1.get('B'))

# 6.  a = [1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 5] 중복 제거
a = [1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 5]
set1 = list(set(a))
print(set1)

