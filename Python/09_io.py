# Input / Output

# 콘솔로 입력 받기
print('내용을 입력하세요!')
# str1 = input()
# print(str1)

# 콘솔(파일) 출력하는 방법
print('콘솔', '출력하는', '방법입니다')
print('콘솔 ' + '출력하는 ' + '방법입니다')
print('%s %s %s' % ('콘솔', '출력하는', '방법입니다'))
print('{} {} {}'.format('콘솔', '출력하는', '방법입니다'))
str1 = '콘솔 출력하는 방법입니다'
print(f'{str1}')


# 파일 입출력
# - Python에서 File 입출력을 위한 기능
# - Python은 인터프리터는 c/c++ 구성되어 있음으로 해당 언어의 방법을 그대로 채용
#   -> Java 대비 file 다루기가 훨씬 쉽다.

# file = open(path, mode, encoding ...)
# - path : 파일의 경로, 절대/상대 경로 모두 사용 가능
# - mode : 파일을 open 할 때 사용할 모드 (읽기/쓰기/수정 모드를 조합 가능!!, Default=r)
# - encoding : 파일의 인코딩(문자열의 formatting, ★UTF-8, EUC-KR, MS-949)

# 주요 모드
# r - Read - Default value. Opens a file for reading, error if the file does not exist
# a - Append - Opens a file for appending, creates the file if it does not exist
# w - Write - Opens a file for writing, creates the file if it does not exist
# x - Create - Creates the specified file, returns an error if the file exists

# 특수 모드
# t - Text - Default value. Text mode
# b - Binary - Binary mode (e.g. images)

# 파일 주요 라이브러리
# https://www.w3schools.com/python/python_ref_file.asp


# 파일 읽기

# 주요 에러
# FileNotFoundError : 파일이 경로에 없을때
# UnicodeDecodeError : 인코딩 이슈, 인코딩 세팅이 필요함

# 방법 1. read()로 읽어오기
# - 1~2 byte씩 읽어 오는 방법, binary 파일과 일반 text 파일 둘다 사용이 가능하다.
# - 가장 고전적이나 속도 저하가 있을수 있음
#    -> 파이썬 어차피 느림으로 큰 영향은 없음.....

print('파일 읽기 방법1')
# f = open('./test.txt', 'r') # UnicodeDecodeError: 'cp949' codec can't decode byte 0xec in position 17: illegal multibyte sequence
# 에러발생! 이유 : 인코딩을 지정하지 않은 경우 system 인코딩을 따라서 파일 읽기 실패!

# 인코딩까지 셋팅하는 방법
f = open('./test.txt', 'r', encoding='utf-8')
while True:
    char = f.read()
    if not char:
        break
    print(char, end='')
f.close()
print()


# 방법2. readLine으로 읽어오기 ★추천
# - 한줄 씩 읽어 오는 방법
# - read보다는 속도가 빠르고 한줄씩 읽어옴으로 적절한 메모리 절약도 가능
# - 문자열 파일을 읽어 올때 가장 많이 사용하는 방법
print('파일 읽기 방법2')
f = open('./test.txt', 'r', encoding='utf-8')
while True:
    line = f.readline()
    if not line:
        break
    print(line, end='')
f.close()
print()

# 방법3. readlines로 읽어오기
# - 모든 라인을 한번에 읽어 오는 방법
# - 100 Mb 미만 정도 되는 파일은 해당 방법으로 간편하게 읽어도 괜찮음
print('파일 읽는 방법3')
f = open('./test.txt', 'r', encoding='utf-8')
list1 = f.readlines()
f.close()
print(list1)

for line in list1:
    print(line, end='')
print()



# 파일 쓰기
# close가 필수라고 했는데.. 안해도 되네..? -> 무조건 필요!!
# 파일이 너무 길어지는 경우 flush를 통해 중간에 file 쓰기가 필요!
# write나 writelines나 별다른 차이점이 없음...


# writeLines 쓰기
f = open('./writeTest.txt', 'w', encoding='utf-8')
f.writelines('파일 쓰기 테스트\n쓰기 테스트입니다.\n')
f.flush()  # 중간에 파일 쓰게하는 기능 -> 무의미한 코드
f.writelines('파일 쓰기 테스트\n쓰기 테스트입니다.222\n')
f.close()  # 필수적인 문법!


# write 작성하기, line 끝에 \n를 안 붙여서 생성
f = open('./writeTest2.txt', 'w', encoding='utf-8')
f.write('파일 쓰기 테스트\n')
f.write('쓰기 테스트입니다.\n')
f.close()  # 필수적인 문법!


# 파일 추가 모드(Append)
# - "a"로 읽어 오면 기존 파일에 문자열 추가가 가능!
f = open('./writeTest.txt', 'a', encoding='utf-8')
f.writelines('AppendTest!!\n추가 쓰기 테스트 입니다!\n12141413@!#$%')
f.close()

# 파일 지우기
import os
os.remove('./writeTest2.txt')

# 파일이 있는지 확인하고 삭제
if os.path.exists('./testFile3'):
    os.remove('./testFile3')
else:
    print('파일이 없습니다.')

# 폴더 생성하기
# os.makedirs("myfoler")

# 폴더 삭제하기
# os.rmdir("myfoler")

# with 구문
# -> Close를 자동으로 추가해주는 기능.
# -> 예외처리가 안됨!
with open("test.txt", "r", encoding="utf-8") as file:
    list1 = file.readlines()
    print(list1)
