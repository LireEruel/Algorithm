# https://www.acmicpc.net/problem/8958
# 아이디어 : 이번엔 정말 시키는대로 심플하게 구현했다.


def test(inputString):
    result = 0
    count = 0
    for i in inputString:
        if i == "O":
            count = count + 1
            result = result + count
        else:
            count = 0
    print(result)


def solution():
    testCaseCount = int(input())

    for testCase in range(testCaseCount):
        test(input())


solution()
