# https://www.acmicpc.net/problem/30802
# 아이디어 : 문제를 잘 이해하고 문제대로 계산하기.

import sys
import math

input = sys.stdin.readline

n = int(input())

sizes = map(int, input().split())

t, p = map(int, input().split())

shirts_set_count = 0

for size in sizes:
    if size > 0:
        shirts_set_count += math.ceil(size / t)

print(shirts_set_count)
print(n // p, n % p)
