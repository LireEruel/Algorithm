N, M = map(int, input().split())
arr = []
for n in range(N):
    arr.append(f"{n+1}")
for m in range(M):
    i, j = map(int, input().split())
    i -= 1
    j -= 1
    temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
print(" ".join(arr))