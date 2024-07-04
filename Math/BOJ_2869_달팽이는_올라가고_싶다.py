import math

A, B, V = map(int, input().split())

day_len = A - B
answer = math.ceil((V - A) / day_len) + 1

print(answer)
