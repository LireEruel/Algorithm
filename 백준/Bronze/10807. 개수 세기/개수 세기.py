N = int(input())
arr = list(map(int, input().split()))
v = int(input())
answer = 0
for i in range(N):
    if v == arr[i]:
        answer += 1
print(answer)