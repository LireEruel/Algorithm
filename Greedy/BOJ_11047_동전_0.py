# https://www.acmicpc.net/problem/11047
# 아이디어 : 무조건 큰 단위의 동전을 쓰는 것이 이득이고, 무조건 1원 동전이 있으니 그리디로 푼다.

import sys

n, k = map(int, input().split())

values = []
for i in range(n):
    values.append(int(sys.stdin.readline()))

max_index = n - 1
count = 0
while k > 0:
    count += k // values[max_index]
    k -= k // values[max_index] * values[max_index]
    max_index -= 1
print(count)
