N, M = map(int, input().split())
arr = [0] * N
for _ in range(M):
    i, d, k = map(int, input().split())
    for index in range(i, d+1):
        arr[index-1] = k
answer = " ".join(map(str, arr))
print(answer)