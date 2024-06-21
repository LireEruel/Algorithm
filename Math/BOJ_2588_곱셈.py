# https://www.acmicpc.net/problem/2588
# 아이디어 : 자릿수에 맞게 자름
a = int(input())
b = int(input())
print(a * (b % 10))
print(a * (b // 10 % 10))
print(a * (b // 100))
print(a * b)
