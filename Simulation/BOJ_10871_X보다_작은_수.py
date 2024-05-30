N, X = map(int, input().split())
num_list = list(map(int, input().split()))
answer = []
for num in num_list:
    if num < X:
        answer.append(str(num))

print(" ".join(answer))
