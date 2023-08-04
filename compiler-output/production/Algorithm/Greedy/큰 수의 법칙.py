N, M, K = map(int, input().split())

data = list(map(int, input().split()))
data.sort()

first = data[N - 1]
second = data[N - 2]

count = 0
result = 0
for i in range(M):
    print(count, result)
    if count < K:
        result += first
        count += 1
    else:
        result += second
        count = 0

print(result)
