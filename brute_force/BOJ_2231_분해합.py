# https://www.acmicpc.net/problem/2231
# 아이디어 : 시간을 조금이라도 줄이기 위해 1부터 돌리는 것이 아닌 10 나눈 뒤부터 계산했다.


def calc_number(val):
    result = val
    while val > 0:
        result += val % 10
        val //= 10
    return result


N = int(input())

result = 0
for curt in range(N // 10, N):
    if calc_number(curt) == N:
        result = curt
        break

print(result)
