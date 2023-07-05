T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    firstLen, secondLen = map(int, input().split())
    firstArray = list(map(int, input().split()))
    secondArray = list(map(int, input().split()))
    answer = 0
    Flag = firstLen < secondLen
    for i in range(abs(firstLen - secondLen) + 1):
        count = 0
        if Flag:
            for d in range(firstLen):
                count += firstArray[d] * secondArray[i + d]
        else:
            for d in range(secondLen):
                count += secondArray[d] * firstArray[i + d]

        if answer < count:
            answer = count

    print("#%d %d" % (test_case, answer))
