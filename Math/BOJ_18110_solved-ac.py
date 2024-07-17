# https://www.acmicpc.net/problem/18110
EPS = 1e-9
n = int(input())
sum = 0
opinions = []
cut_size = round(EPS + n * 0.15)
if n == 0:
    print(0)
else:
    for i in range(n):
        opinions.append(int(input()))
    index = 0
    opinions.sort()
    for opinion in opinions:
        if index >= cut_size and index < n - cut_size:
            sum += opinion
        index += 1

    print(round(EPS + sum / (n - cut_size * 2)))
