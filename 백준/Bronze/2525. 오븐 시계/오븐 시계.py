h, m = map(int, input().split())
c = int(input())

current = h * 60 + m + c
h = current // 60 % 24
m = current % 60

print(h, m)
