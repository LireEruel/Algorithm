# https://www.acmicpc.net/problem/2292
# 아이디어 : 벌집의 규칙을 찾아서 풀이

N = int(input())

result = 0
level = 1
while N > 0:
    N -= level
    result += 1
    level = 6 * result
print(result)
