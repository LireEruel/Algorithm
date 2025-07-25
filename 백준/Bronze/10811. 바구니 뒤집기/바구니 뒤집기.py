import math

N, M = map(int, input().split())

arr = list(range(0, N + 1))

for m in range(M):
    i, j = map(int, input().split())
    if i == j:
        continue
    for index in range(math.ceil((j - i) / 2)):
        left_index = i + index
        right_index = j - index
        temp = arr[left_index]
        arr[left_index] = arr[right_index]
        arr[right_index] = temp
print(" ".join(map(str, arr[1:])))
