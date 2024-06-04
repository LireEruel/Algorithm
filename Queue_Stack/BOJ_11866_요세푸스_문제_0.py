# https://www.acmicpc.net/problem/11866
# queue 의 회전을 활용하여 쉽게 풀이

import sys
from collections import deque

n, k = map(int, sys.stdin.readline().split())

d = deque()

for i in range(1, n + 1):
    d.append(i)

answer = []
while len(d) > 0:
    d.rotate(-1 * (k - 1))
    answer.append(str(d.popleft()))

print("<" + ", ".join(answer) + ">")
