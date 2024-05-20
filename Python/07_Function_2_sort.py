
# Python Custom 정렬 하는 방법

# 1. 기본적으로 list 정렬하는 방법
nums1 = [4, 2, 5, 3, 1]
nums1.sort()  # 오름차순 정렬
print(nums1)
nums1.reverse()  # 내림차순이 되나 알고리즘적으로 효율이 떨어짐으로 절대 금지!
print(nums1)
nums1.sort(reverse=True)  # 내림차순으로 제대로 정렬하는 방법! 추천!!
print(nums1)

# 2. sorted 함수를 통해 기본 정렬하는 방법
nums1 = [4, 2, 5, 3, 1]
nums2 = sorted(nums1)  # 기존 정렬이 되지 않은 list를 보존하고 새로운 list를 만들어 반환!
# nums2 = sorted(nums1, reverse=True)  # 내림차순 정렬!
print('nums1 : ', nums1)
print('nums2 : ', nums2)

# 3. 2개 이상의 데이터를 정렬하는 방법
# 데이터 순 : id, 이름, 나이
list1 = [(1, '홍길동', 27), (4, '박길', 25), (3, '김길동이', 25), (5, '홍길동', 26), (2, '최길동', 26)]
print(list1)
list1.sort()  # 정렬을 시키면 첫번째 데이터 기준으로 정렬이 된다!
print(list1)


# 4. 2개 이상의 데이터셋에서 특정 인자(이름)순으로 정렬하는 방법
# 1) lambda식을 활용하는 방법
# - 한계 : 복잡한 정렬은 람다식으로 표현하기 어렵고, 삼항연산자가 없어서 1개 이상을 정렬하는 알고리즘 구현이 어렵다.
list1 = [(1, '홍길동', 27), (4, '박길', 25), (3, '김길동이', 25), (5, '홍길동', 26), (2, '최길동', 26)]
list1.sort(key=lambda x: x[1])  # item index 1에 해당하는 이름을 기준으로 정렬 시킬 때
print('이름 오름차순 : ', list1)
list1.sort(key=lambda x: x[1], reverse=True)
print('이름 내림차순 : ', list1)


# 2) 함수형으로 작성하는 방법
# - 복잡한 경우에는 함수형으로 작성하는 것이 유리하다.
# - 아주 복잡한 정렬 조건은 해당 방법으로 구현 불가능

def custom_sort(x):
    return x[1]


# 이름의 길이로 정렬!
def custom_sort2(x):
    return len(x[1])


list1 = [(1, '홍길동', 27), (4, '박길', 25), (3, '김길동이', 25), (5, '홍길동', 26), (2, '최길동', 26)]
list1.sort(key=custom_sort)
print('이름순 :', list1)
list1.sort(key=custom_sort2)
print('이름 길이순 :', list1)

# 5. itemgetter 사용, 2번째 데이터 (이름순)으로 정렬 하는데! 더 복잡한 방법으로 정렬하는 방법, ex) 나이-이름 순
# - 데이터의 순서대로 정렬시킬수 있다. 아주 복잡한 정렬은 아직도 부족하다.
from operator import itemgetter
list1 = [(1, '홍길동', 27), (4, '박길', 25), (3, '김길동이', 25), (5, '홍길동', 26), (2, '최길동', 26)]
list1.sort(key=itemgetter(0))  # 0번째 인덱스 기준으로 정렬
print('itemgetter(0)', list1)
list1.sort(key=itemgetter(1))  # 1번째 인덱스 기준으로 정렬
print('itemgetter(1)', list1)
list1.sort(key=itemgetter(2))  # 2번째 인덱스 기준으로 정렬
print('itemgetter(2)', list1)
list1.sort(key=itemgetter(1, 2))  # 1-2순으로 정렬
print('itemgetter(1,2)', list1)
list1.sort(key=itemgetter(2, 1, 0))  #2-1-0 순으로 정렬
print('itemgetter(2,1,0)', list1)


# 6. cmp_to_key 사용, 2번째 데이터 (이름순)으로 정렬 하는데! 더 복잡한 방법으로 정렬하는 방법, ex) 나이-이름 순
# - 기존 정렬 방식은 복잡한 알고리즘 구현에 한계가 존재함으로 functools.cmp_to_key를 사용하여 완전한 커스텀 정렬이 가능하다.
# - cmp_to_key(x, y) 두개의 인자를 비교 가능한 방법
from functools import cmp_to_key


# 정렬 기준을 작성하는 함수
# - 리턴값은 1, 0, -1로 반환해야함
# - 이름(오름차순), 나이(내림차순)으로 정렬시킬 예정

def my_cmp_key(x, y):
    if x[1] == y[1] :  # 이름이 같으면
        return y[2] - x[2]  # 나이순으로 내림차순 정렬
    elif x[1] > y[1] :  # 문자열 대소비교!
        return 1
    else:
        return -1


list1 = [(1, '홍길동', 27), (4, '박길', 25), (3, '김길동이', 25), (5, '홍길동', 26), (2, '최길동', 26)]
list1.sort(key=cmp_to_key(my_cmp_key))
print('커스텀2 :', list1)
