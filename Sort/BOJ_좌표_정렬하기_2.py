# https://www.acmicpc.net/problem/11651

N = int(input())
points = []

for i in range(N):
    x, y = map(int, input().split())
    points.append([x, y])

points = sorted(points, key=lambda x: (x[1], x[0]))

for point in points:
    print(point[0], point[1])
