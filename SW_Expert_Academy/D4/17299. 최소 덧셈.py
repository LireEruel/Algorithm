T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    result = 0
    inputNum = input()
    halfIndex = len(inputNum) // 2
    if len(inputNum) % 2 == 0:
        result = int(inputNum[:halfIndex]) + int(inputNum[halfIndex :])
    else :
        first = int(inputNum[:halfIndex]) + int(inputNum[halfIndex :])
        second = int(inputNum[:halfIndex+1]) + int(inputNum[halfIndex+1 :])
        result = first if first < second else second
    print('#%d %d'%(test_case, result))