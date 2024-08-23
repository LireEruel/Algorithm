import sys

input = sys.stdin.readline
dp = []
stair_num = int(input())
stairs = []
for i in range(stair_num):
    stairs.append(int(input()))

for d in range(len(stairs)):
    if d == 0:
        dp.append(stairs[0])
    elif d == 1:
        dp.append(stairs[0] + stairs[1])
    elif d == 2:
        dp.append(max(stairs[0], stairs[1]) + stairs[2])
    else:
        dp.append(max(dp[d - 2] + stairs[d], dp[d - 3] + stairs[d - 1] + stairs[d]))

print(dp[-1])
