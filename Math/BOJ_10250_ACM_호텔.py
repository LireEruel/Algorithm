# https://www.acmicpc.net/problem/10250
# 처음엔 그냥 Map? 이런걸로 for문 돌릴까? 하다가 그냥 수학적 계산이 가능함을 알고 공식을 만듦

tc = int(input())
for i in range(tc):
    H, W, N = map(int, input().split())
    Y = (N % H if N % H else H) * 100
    X = (N - 1) // H + 1
    print(Y + X)
