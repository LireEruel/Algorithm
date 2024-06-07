# https://www.acmicpc.net/problem/1654
# 아이디어: 최대값 찾은 후 이분탐색하기.
import sys

K, N = map(int, input().split())
lines = list(map(int, sys.stdin.readlines()))


def checklines(unit):
    total_line = 0
    for line in lines:
        total_line += line // unit
    return total_line


left = 0
right = max(lines) + 1
mid = right
while left + 1 < right:
    mid = left + (right - left) // 2
    count = checklines(mid)
    print(left, mid, right, count)
    if count < N:
        right = mid
    elif count > N:
        left = mid + 1
    else:
        if checklines(mid + 1) < N:
            break
        else:
            left = mid
# print(left, mid, right, count)
# print("answer : ", mid)
print(mid)
