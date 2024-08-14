# https://www.acmicpc.net/problem/1463
# 아이디어: 위에서 밑이 아니라 밑에서 위로 문제를 해결한다.

dp = [0, 0, 1, 1, 2]
target = int(input())
dp = [0] * (target + 1)

for i in range(2, target + 1):
    dp[i] = dp[i - 1] + 1
    if i % 2 == 0:
        dp[i] = min(dp[i], dp[i // 2] + 1)
    if i % 3 == 0:
        dp[i] = min(dp[i], dp[i // 3] + 1)

print(dp[target])
