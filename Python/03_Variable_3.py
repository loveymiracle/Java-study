# 기본형 외의 Python에서 자주 사용되는 자료구조 소개

# deque : 보통 큐(queue)는 선입선출(FIFO) 방식으로 작동한다. 반면, 양방향 큐가 있는 자료구조
# heapq : heapq 모듈에는 파이썬의 보통 리스트를 최소 힙 탐색처럼 도와주는 자료구조, 자바의 PriorityQueue 클래스처럼 리스트와 별개의 자료구조가 아닌 점에 유의해야 합니다.
# permutation(순열) : 서로 다른 n개 중 r 개를 골라 순서를 고려해 나열한 경우의 수. (조합 할 때 순서가 중요할때! 사용)
# combination(조합) : 서로 다른 n개 중에서 r개(n≥r) 취하여 집합를 만들 때 순서 상관 없이 경우의 수를 나열 (중복 없이 조합 할 때)
# Counter 객체 : 편리하고 빠르게 개수를 세도록 지원하는 계수기 도구가 제공
# zip : 동일한 개수로 이루어진 iterable한 객체들을 인수로 받아 묶어서 iterator로 반환
# defaultdict : 사용자가 원하는 value, type을 지정하여 dict를 사용할때 활용, ex) dict + list를 사용할때 편하게 문법 구현이 가능
# -----------------------------------------------------------------------------------------------

# deque : 보통 큐(queue)는 선입선출(FIFO) 방식으로 작동한다. 반면, 양방향 큐가 있는데 그것이 바로 데크(deque)다.
# 즉, 앞, 뒤 양쪽 방향에서 엘리먼트(element)를 추가하거나 제거할 수 있다.
# deque.append(item): item을 데크의 오른쪽 끝에 삽입한다.
# deque.appendleft(item): item을 데크의 왼쪽 끝에 삽입한다.
# deque.pop(): 데크의 오른쪽 끝 엘리먼트를 가져오는 동시에 데크에서 삭제한다.
# deque.popleft(): 데크의 왼쪽 끝 엘리먼트를 가져오는 동시에 데크에서 삭제한다.
# deque.extend(array): 주어진 배열(array)을 순환하면서 데크의 오른쪽에 추가한다.
# deque.extendleft(array): 주어진 배열(array)을 순환하면서 데크의 왼쪽에 추가한다.
# deque.remove(item): item을 데크에서 찾아 삭제한다.
# deque.rotate(num): 데크를 num만큼 회전한다(양수면 오른쪽, 음수면 왼쪽).
# 사용법은 list와 동일, list1[0], in 문법 먹힌다. iterable - for문으로 접근 가능

import collections
from collections import deque

deq = deque()

deq.append(1)  # append right!!
deq.append(2)
deq.append(3)
print(deq)  # deq([1, 2, 3])
deq.appendleft(0)
deq.appendleft(-1)
print(deq)  # deq([-1, 0, 1, 2, 3])
print(deq[0])
print(deq[1])
print(deq[2])

# 회전시키기
deq.rotate(1)
print(deq)  # deque([3, -1, 0, 1, 2])

deq.rotate(1)  # 회전, 오른쪽으로 회전
print('rotate(+1) :', deq)  # rotate(+1) : deque([3, 5, 4, 1, 2])
deq.rotate(-3)  # 회전, 음수면 왼쪽으로 회전
print('rotate(-3) :', deq)  # rotate(-3) : deque([1, 2, 3, 5, 4])

print('pop :', deq.pop())  # 오른쪽에서 pop
print('popleft :', deq.popleft())  # 왼쪽에서 pop
print('결과 :', deq)  # 왼쪽에서 pop
print('-----------------------------------------------------')

# heapq : heapq 모듈에은 파이썬의 보통 리스트를 마치 최소 힙처럼 다룰 수 있도록 도와줍니다. 자바의 PriorityQueue 클래스처럼 리스트와 별개의 자료구조가 아닌 점에 유의해야 합니다.
# https://docs.python.org/ko/3/library/heapq.html

# heapq.heappush(heap, item) : 힙 불변성을 유지하면서, item 값을 heap으로 푸시합니다.
# heapq.heappop(heap)
# 힙 불변성을 유지하면서, heap에서 가장 작은 항목을 팝하고 반환합니다.
# 힙이 비어 있으면, IndexError가 발생합니다. 팝 하지 않고 가장 작은 항목에 액세스하려면, heap[0]을 사용하십시오.

# heapq.heappushpop(heap, item)
# 힙에 item을 푸시한 다음, heap에서 가장 작은 항목을 팝하고 반환합니다. 결합한 액션은 heappush()한 다음 heappop()을 별도로 호출하는 것보다 더 효율적으로 실행합니다.

# heapq.heapify(x)
# 리스트 x를 선형 시간으로 제자리에서 힙으로 변환합니다.

import heapq
heap = []  # heap을 유지할 기본 list 필수!
heapq.heappush(heap, 50)
heapq.heappush(heap, 10)
heapq.heappush(heap, 30)
heapq.heappush(heap, 20)
heapq.heappush(heap, 40)
print(heap)  # [10, 20, 30, 50, 40], 최소 힙이 만들어짐!, 순서대로는 정렬되어 있지 않음!

# 실제 사용법, heappop을 통해 값을 가져오면 최소값부터 순차적으로 값을 가져온다!
while heap:
    print(heap)
    print(heapq.heappop(heap))

heap = [50, 10, 30, 20, 40]
print('heap(이전) : ', heap)
heapq.heapify(heap)  # 일반 배열을 heap 자료구조로 변환하는 함수
print('heap(이후) : ', heap)

# ※ 주의점, index로 접근 금지!! index로 접근하면 heap으로 간주되지 않아 알고리즘 문제가 발생한다!
print('heap[0] :', heap[0])
print('heap[-1] :', heap[-1]) # 최대값(?) 40이 나오는데 틀렸다!!
print('heap[len(heap) - 1] :', heap[len(heap) - 1])

# 최소, 최대값 빠르게 찾는 방법
print(heap)
print(min(heap))  # 최소값 찾는 방법
print(max(heap))  # 최대값 찾는 방법
print('---------------------------------------------------------------------------------')

# permutation(순열) : 서로 다른 n개 중 r 개를 골라 순서를 고려해 나열한 경우의 수. (조합 할 때 순서가 중요할때! 사용)
# combination(조합) : 서로 다른 n개 중에서 r개(n≥r) 취하여 집합를 만들 때 순서 상관 없이 경우의 수를 나열 (중복 없이 조합 할 때)

import itertools

list1 = ['A', 'B', 'C']
nPr = itertools.permutations(list1, 2)  # 첫번째 인자는 조합에 사용할 list, 두번째는 조합할 갯수!
print('permutation :', list(nPr))
# 결과 : [('A', 'B'), ('A', 'C'), ('B', 'A'), ('B', 'C'), ('C', 'A'), ('C', 'B')]
# 앞뒤 순서가 중요할때, permutation을 사용하면 된다!

nCr = itertools.combinations(list1, 2)
print('combinations :', list(nCr))
# 결과 : [('A', 'B'), ('A', 'C'), ('B', 'C')]
# 순서가 중요하지 않고, 조합만 볼때 활용된다. ex) 로또 당첨!

# 로또 조합 갯수를 쉽게 구하는 방법
lotto = itertools.combinations(range(1, 46), 6)
# print(list(lotto))
# print('로또의 경우의 수 (순서x) : ', len(list(lotto)))

# 예시문제, 특정 문자열의 조합에서 특정 문자가 만들어 질수 있는 지 확인하는 문제
# 'ntsrig' -> 'string'이 완성될수 있는지?
# 문자열의 조합
list1 = list('ntsrig')
# 찾을 문자열
str1 = 'string'

print(list1)
# print(list(itertools.permutations(list1, len(list1))))

for item in itertools.permutations(list1, len(list1)):
    str2 = ''.join(item)
    if str2 == str1:
        print('찾았습니다!')
        break
else:
    print('찾지 못하였습니다.')

print('---------------------------------------------------------------------------------')

# Counter 객체 : 편리하고 빠르게 개수를 세도록 지원하는 계수기 도구가 제공됩니다.
from collections import Counter
counter = Counter(['red', 'blue', 'red', 'green', 'blue', 'blue'])
print(counter)
print(counter['blue'])  # 3
print(counter['red'])  # 2
print(counter['green'])  # 1
print(counter['yellow'])  # 0, 없다!
print(dict(counter))
print('-----------------------------------------------------------------')

# zip() : 동일한 개수로 이루어진 iterable한 객체들을 인수로 받아 묶어서 iterator로 반환
z = zip([1, 2, 3], ('a', 'b', 'c'))
print(type(z))  # iterator 형식이 된다!, 일회용이라는거 주의!!
for item in z:
    print(item)
# (1, 'a')
# (2, 'b')
# (3, 'c')

z = zip([1, 2, 3], ('a', 'b', 'c'))
print(type(z))  # iterator 형식이 된다!, 일회용이라는거 주의!!
for number, string in z:
    print(number, string)

z = zip([1, 2, 3], ('a', 'b', 'c'))
print(next(z))
print(next(z))
print(next(z))
print('-----------------------------------------------------------------')

# defaultdict : 사용자가 원하는 value, type을 지정하여 dict를 사용할때 활용, ex) dict + list를 사용할때 편하게 문법 구현이 가능
from collections import defaultdict
# 옷의 색깔, 옷의 ID
s = [('yellow', 1), ('blue', 2), ('blue', 2), ('yellow', 3), ('blue', 4), ('red', 1)]
d1 = defaultdict(list)  # python 제네릭 문법, 기본형을 list로 지정해서 초기화 하는 명령
d2 = defaultdict(set)  # python 제네릭 문법, 기본형을 set 지정해서 초기화 하는 명령

for k, v in s:
    d1[k].append(v)
    d2[k].add(v)

print(d1)
print(d2)
